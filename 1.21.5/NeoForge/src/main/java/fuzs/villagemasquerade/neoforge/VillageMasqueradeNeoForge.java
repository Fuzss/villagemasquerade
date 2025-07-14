package fuzs.villagemasquerade.neoforge;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.data.loot.ModBlockLootProvider;
import fuzs.villagemasquerade.data.loot.ModChestLootProvider;
import fuzs.villagemasquerade.data.loot.ModEntityLootProvider;
import fuzs.villagemasquerade.data.tags.ModItemTagsProvider;
import fuzs.villagemasquerade.data.tags.ModMobEffectTagsProvider;
import net.neoforged.fml.common.Mod;

@Mod(VillageMasquerade.MOD_ID)
public class VillageMasqueradeNeoForge {

    public VillageMasqueradeNeoForge() {
        ModConstructor.construct(VillageMasquerade.MOD_ID, VillageMasquerade::new);
        DataProviderHelper.registerDataProviders(VillageMasquerade.MOD_ID,
                ModBlockLootProvider::new,
                ModChestLootProvider::new,
                ModEntityLootProvider::new,
                ModItemTagsProvider::new,
                ModMobEffectTagsProvider::new);
    }
}
