package fuzs.villagemasquerade.neoforge;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.data.ModBlockLootProvider;
import fuzs.villagemasquerade.data.ModItemTagsProvider;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.village.VillagerTradesEvent;

import java.util.List;

@Mod(VillageMasquerade.MOD_ID)
public class VillageMasqueradeNeoForge {

    public VillageMasqueradeNeoForge() {
        ModConstructor.construct(VillageMasquerade.MOD_ID, VillageMasquerade::new);
        registerEventHandlers(NeoForge.EVENT_BUS);
        DataProviderHelper.registerDataProviders(VillageMasquerade.MOD_ID,
                ModBlockLootProvider::new,
                ModItemTagsProvider::new);
    }

    private static void registerEventHandlers(IEventBus eventBus) {
        eventBus.addListener((final VillagerTradesEvent evt) -> {
            if (evt.getType().equals(VillagerProfession.ARMORER)) {
                List<VillagerTrades.ItemListing> itemListings = evt.getTrades().get(5);
                itemListings.add(ModRegistry.createItemListing(ModRegistry.ARMORER_GOGGLES_ITEM));
                itemListings.add(ModRegistry.createItemListing(ModRegistry.ARMORER_APRON_ITEM));
            }
        });
    }
}
