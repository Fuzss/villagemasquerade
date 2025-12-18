package fuzs.villagemasquerade.neoforge.client;

import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.neoforge.api.data.v2.core.DataProviderHelper;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.VillageMasqueradeClient;
import fuzs.villagemasquerade.data.client.ModLanguageProvider;
import fuzs.villagemasquerade.data.client.ModModelProvider;
import fuzs.villagemasquerade.data.client.ModEquipmentProvider;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;

@Mod(value = VillageMasquerade.MOD_ID, dist = Dist.CLIENT)
public class VillageMasqueradeNeoForgeClient {

    public VillageMasqueradeNeoForgeClient() {
        ClientModConstructor.construct(VillageMasquerade.MOD_ID, VillageMasqueradeClient::new);
        DataProviderHelper.registerDataProviders(VillageMasquerade.MOD_ID,
                ModLanguageProvider::new,
                ModModelProvider::new,
                ModEquipmentProvider::new);
    }
}
