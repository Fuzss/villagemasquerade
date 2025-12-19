package fuzs.villagemasquerade.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.gen.Invoker;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Locale;

@Mixin(EquipmentClientInfo.LayerType.class)
abstract class EquipmentClientInfo$LayerTypeMixin {
    @Nullable
    @Unique
    private static EquipmentClientInfo.LayerType villagemasquerade$clothing;
    @Nullable
    @Unique
    private static EquipmentClientInfo.LayerType villagemasquerade$witchHat;
    @Nullable
    @Unique
    private static EquipmentClientInfo.LayerType villagemasquerade$santaHat;

    @Invoker("<init>")
    private static EquipmentClientInfo.LayerType villagemasquerade$init(String name, int ordinal, String id) {
        throw new RuntimeException();
    }

    @ModifyReturnValue(
            method = "$values()[Lnet/minecraft/client/resources/model/EquipmentClientInfo$LayerType;", at = @At("TAIL")
    )
    private static EquipmentClientInfo.LayerType[] values(EquipmentClientInfo.LayerType[] values) {
        // this can be chained for adding multiple values
        values = villagemasquerade$appendValue(values, villagemasquerade$clothing, "clothing");
        villagemasquerade$clothing = values[values.length - 1];
        values = villagemasquerade$appendValue(values, villagemasquerade$witchHat, "witch_hat");
        villagemasquerade$witchHat = values[values.length - 1];
        values = villagemasquerade$appendValue(values, villagemasquerade$santaHat, "santa_hat");
        villagemasquerade$santaHat = values[values.length - 1];
        return values;
    }

    @Unique
    private static EquipmentClientInfo.LayerType[] villagemasquerade$appendValue(EquipmentClientInfo.LayerType[] values, @Nullable EquipmentClientInfo.LayerType layerType, String name) {
        EquipmentClientInfo.LayerType[] newValues = new EquipmentClientInfo.LayerType[values.length + 1];
        System.arraycopy(values, 0, newValues, 0, values.length);
        newValues[values.length] = layerType != null ? layerType :
                villagemasquerade$init("VILLAGEMASQUERADE_" + name.toUpperCase(Locale.ROOT),
                        values.length,
                        "villagemasquerade/" + name);
        return newValues;
    }
}
