package fuzs.villagemasquerade.util;

import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.villager.VillagerData;
import net.minecraft.world.entity.npc.villager.VillagerProfession;
import net.minecraft.world.entity.npc.villager.VillagerTrades;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.trading.MerchantOffer;

public class VillagerTradingHelper {

    public static VillagerTrades.ItemListing createVillagerItemListing(Item item) {
        return createItemListing(item, 30, 0.2F);
    }

    public static VillagerTrades.ItemListing createWanderingItemListing(Holder<Item> item) {
        return createItemListing(item.value(), 1, 0.05F);
    }

    private static VillagerTrades.ItemListing createItemListing(Item item, int villagerXp, float priceMultiplier) {
        int priceForPiece = getPriceForPiece(getArmorEquipmentSlot(item));
        return new VillagerTrades.ItemsForEmeralds(new ItemStack(item),
                priceForPiece,
                1,
                1,
                villagerXp,
                priceMultiplier);
    }

    private static EquipmentSlot getArmorEquipmentSlot(Item item) {
        if (item.components().has(DataComponents.EQUIPPABLE)) {
            EquipmentSlot equipmentSlot = item.components().get(DataComponents.EQUIPPABLE).slot();
            if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                return equipmentSlot;
            }
        }

        throw new IllegalArgumentException("No armor: " + item);
    }

    private static int getPriceForPiece(EquipmentSlot equipmentSlot) {
        return switch (equipmentSlot) {
            case FEET, HEAD -> 8;
            case CHEST -> 16;
            case LEGS -> 12;
            default -> throw new IllegalArgumentException();
        };
    }

    public static void updateSpecialPrices(Villager villager, Player player) {
        int equippedArmorForProfession = getEquippedArmorForProfession(player, villager.getVillagerData());
        if (equippedArmorForProfession > 0) {
            // same as hero of the village effect, but does stack with it
            for (MerchantOffer merchantOffer : villager.getOffers()) {
                double priceMultiplier = 0.3 + 0.0625 * equippedArmorForProfession;
                int newPriceInItems = (int) Math.floor(priceMultiplier * merchantOffer.getBaseCostA().getCount());
                merchantOffer.addToSpecialPriceDiff(-Math.max(newPriceInItems, 1));
            }
        }
    }

    private static int getEquippedArmorForProfession(Player player, VillagerData villagerData) {
        int equippedArmorForProfession = 0;
        for (EquipmentSlot equipmentSlot : EquipmentSlotGroup.ARMOR) {
            if (equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
                ItemStack itemStack = player.getItemBySlot(equipmentSlot);
                ResourceKey<VillagerProfession> resourceKey = itemStack.get(ModRegistry.VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value());
                if (resourceKey != null && villagerData.profession().is(resourceKey)) {
                    equippedArmorForProfession++;
                }
            }
        }

        return equippedArmorForProfession;
    }
}
