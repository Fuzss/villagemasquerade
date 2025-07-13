package fuzs.villagemasquerade.mixin;

import fuzs.villagemasquerade.util.VillagerTradingHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.AbstractVillager;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.npc.VillagerDataHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
abstract class VillagerMixin extends AbstractVillager implements VillagerDataHolder {

    public VillagerMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "updateSpecialPrices", at = @At("TAIL"))
    private void updateSpecialPrices(Player player, CallbackInfo callback) {
        int equippedArmorForProfession = VillagerTradingHelper.getEquippedArmorForProfession(player,
                this.getVillagerData());
        if (equippedArmorForProfession > 0) {
            // same as hero of the village effect, but does stack with it
            for (MerchantOffer merchantOffer : this.getOffers()) {
                double priceMultiplier = 0.3 + 0.0625 * equippedArmorForProfession;
                int newPriceInItems = (int) Math.floor(priceMultiplier * merchantOffer.getBaseCostA().getCount());
                merchantOffer.addToSpecialPriceDiff(-Math.max(newPriceInItems, 1));
            }
        }
    }
}
