package fuzs.villagemasquerade.fabric.client;

import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.VillageMasqueradeClient;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import net.fabricmc.api.ClientModInitializer;

public class VillageMasqueradeFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientModConstructor.construct(VillageMasquerade.MOD_ID, VillageMasqueradeClient::new);
    }
}
