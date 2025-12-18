package fuzs.villagemasquerade;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.context.VillagerTradesContext;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.event.v1.AddBlockEntityTypeBlocksCallback;
import fuzs.puzzleslib.api.event.v1.entity.ServerEntityLevelEvents;
import fuzs.puzzleslib.api.event.v1.entity.living.CalculateLivingVisibilityCallback;
import fuzs.puzzleslib.api.event.v1.entity.living.LivingDropsCallback;
import fuzs.puzzleslib.api.event.v1.entity.living.MobEffectEvents;
import fuzs.puzzleslib.api.event.v1.server.LootTableLoadCallback;
import fuzs.villagemasquerade.handler.ClothingEquipmentHandler;
import fuzs.villagemasquerade.init.ModBlocks;
import fuzs.villagemasquerade.init.ModItems;
import fuzs.villagemasquerade.init.ModLootTables;
import fuzs.villagemasquerade.init.ModRegistry;
import fuzs.villagemasquerade.util.VillagerTradingHelper;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class VillageMasquerade implements ModConstructor {
    public static final String MOD_ID = "villagemasquerade";
    public static final String MOD_NAME = "Village Masquerade";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        AddBlockEntityTypeBlocksCallback.EVENT.register(ModBlocks::onAddBlockEntityTypeBlocks);
        LivingDropsCallback.EVENT.register(ClothingEquipmentHandler::onLivingDrops);
        LootTableLoadCallback.EVENT.register(ModLootTables::onLootTableLoad);
        ServerEntityLevelEvents.LOAD.register(ClothingEquipmentHandler::onEntityLoad);
        MobEffectEvents.AFFECTS.register(ClothingEquipmentHandler::onMobEffectAffects);
        CalculateLivingVisibilityCallback.EVENT.register(ClothingEquipmentHandler::onCalculateLivingVisibility);
    }

    @Override
    public void onRegisterVillagerTrades(VillagerTradesContext context) {
        BuiltInRegistries.ITEM.listElements()
                .filter((Holder.Reference<Item> holder) -> holder.key().location().getNamespace().equals(MOD_ID))
                .map(Holder.Reference::value)
                .forEach((Item item) -> {
                    ResourceKey<VillagerProfession> resourceKey = item.components()
                            .getOrDefault(ModRegistry.VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value(),
                                    VillagerProfession.NONE);
                    if (resourceKey != VillagerProfession.NONE) {
                        context.registerVillagerTrades(resourceKey,
                                VillagerTradesContext.VillagerLevel.MASTER,
                                (List<VillagerTrades.ItemListing> itemListings) -> {
                                    itemListings.add(VillagerTradingHelper.createVillagerItemListing(item));
                                });
                    }
                });
        context.registerWanderingTrades(VillagerTradesContext.WanderingTradesPool.SPECIAL_SALES,
                VillagerTradingHelper.createWanderingItemListing(ModItems.WANDERING_TRADER_HOOD_ITEM),
                VillagerTradingHelper.createWanderingItemListing(ModItems.WANDERING_TRADER_ROBE_ITEM),
                VillagerTradingHelper.createWanderingItemListing(ModItems.WANDERING_TRADER_LEGGINGS_ITEM));
    }

    public static ResourceLocation id(String path) {
        return ResourceLocationHelper.fromNamespaceAndPath(MOD_ID, path);
    }
}
