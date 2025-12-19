package fuzs.villagemasquerade.fabric.asm;

import com.chocohead.mm.api.ClassTinkerers;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.MappingResolver;

public class VillageMasqueradeFabricCore implements Runnable {

    @Override
    public void run() {
        MappingResolver mappingResolver = FabricLoader.getInstance().getMappingResolver();
        // net.minecraft.client.resources.model.EquipmentClientInfo$LayerType
        String enumType = mappingResolver.mapClassName("intermediary", "net.minecraft.class_10186$class_10190");
        ClassTinkerers.enumBuilder(enumType, String.class)
                .addEnum("VILLAGEMASQUERADE_CLOTHING", "villagemasquerade/clothing")
                .addEnum("VILLAGEMASQUERADE_WITCH_HAT", "villagemasquerade/witch_hat")
                .addEnum("VILLAGEMASQUERADE_SANTA_HAT", "villagemasquerade/santa_hat")
                .build();
    }
}
