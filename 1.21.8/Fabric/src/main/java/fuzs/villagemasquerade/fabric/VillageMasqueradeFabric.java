package fuzs.villagemasquerade.fabric;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.villagemasquerade.VillageMasquerade;
import net.fabricmc.api.ModInitializer;

public class VillageMasqueradeFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ModConstructor.construct(VillageMasquerade.MOD_ID, VillageMasquerade::new);
    }
}
