package fuzs.villagemasquerade.client.init;

import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.Identifier;

import java.util.Locale;
import java.util.function.Function;

public class ModEnumConstants {
    private static final Identifier CLOTHING_ID = VillageMasquerade.id("clothing");
    public static final EquipmentClientInfo.LayerType CLOTHING_LAYER_TYPE = getEnumConstant(CLOTHING_ID,
            EquipmentClientInfo.LayerType::valueOf);
    private static final Identifier WITCH_HAT_ID = VillageMasquerade.id("witch_hat");
    public static final EquipmentClientInfo.LayerType WITCH_HAT_LAYER_TYPE = getEnumConstant(WITCH_HAT_ID,
            EquipmentClientInfo.LayerType::valueOf);
    private static final Identifier SANTA_HAT_ID = VillageMasquerade.id("santa_hat");
    public static final EquipmentClientInfo.LayerType SANTA_HAT_LAYER_TYPE = getEnumConstant(SANTA_HAT_ID,
            EquipmentClientInfo.LayerType::valueOf);

    public static void bootstrap() {
        // NO-OP
    }

    private static <E extends Enum<E>> E getEnumConstant(Identifier identifier, Function<String, E> valueOfInvoker) {
        return valueOfInvoker.apply(identifier.toDebugFileName().toUpperCase(Locale.ROOT));
    }
}
