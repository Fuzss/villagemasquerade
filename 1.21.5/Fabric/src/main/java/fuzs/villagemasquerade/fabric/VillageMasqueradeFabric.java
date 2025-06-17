package fuzs.villagemasquerade.fabric;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.init.ModRegistry;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;

import java.util.List;

public class VillageMasqueradeFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(VillageMasquerade.MOD_ID, VillageMasquerade::new);
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.ARMORER,
                5,
                (List<VillagerTrades.ItemListing> itemListings) -> {
                    itemListings.add(ModRegistry.createItemListing(ModRegistry.ARMORER_GOGGLES_ITEM));
                    itemListings.add(ModRegistry.createItemListing(ModRegistry.ARMORER_APRON_ITEM));
                });
    }
}
