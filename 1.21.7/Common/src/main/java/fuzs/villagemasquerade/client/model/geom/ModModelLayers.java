package fuzs.villagemasquerade.client.model.geom;

import fuzs.puzzleslib.api.client.init.v1.ModelLayerFactory;
import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;
import java.util.function.Function;

public class ModModelLayers {
    static final ResourceLocation CLOTHING_LOCATION = VillageMasquerade.id("clothing");
    static final ResourceLocation WITCH_HAT_LOCATION = VillageMasquerade.id("witch_hat");
    static final ResourceLocation SANTA_HAT_LOCATION = VillageMasquerade.id("santa_hat");
    public static final EquipmentClientInfo.LayerType CLOTHING_LAYER_TYPE = getEnumConstant(CLOTHING_LOCATION,
            EquipmentClientInfo.LayerType::valueOf);
    public static final EquipmentClientInfo.LayerType WITCH_HAT_LAYER_TYPE = getEnumConstant(WITCH_HAT_LOCATION,
            EquipmentClientInfo.LayerType::valueOf);
    public static final EquipmentClientInfo.LayerType SANTA_HAT_LAYER_TYPE = getEnumConstant(SANTA_HAT_LOCATION,
            EquipmentClientInfo.LayerType::valueOf);
    public static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(VillageMasquerade.MOD_ID);
    public static final ModelLayerLocation HUMANOID_CLOTHING = MODEL_LAYERS.registerModelLayer("humanoid", "clothing");
    public static final ModelLayerLocation HUMANOID_BABY_CLOTHING = MODEL_LAYERS.registerModelLayer("humanoid_baby",
            "clothing");
    public static final ModelLayerLocation HUMANOID_WITCH_HAT = MODEL_LAYERS.registerModelLayer("humanoid",
            "witch_hat");
    public static final ModelLayerLocation HUMANOID_BABY_WITCH_HAT = MODEL_LAYERS.registerModelLayer("humanoid_baby",
            "witch_hat");
    public static final ModelLayerLocation HUMANOID_SANTA_HAT = MODEL_LAYERS.registerModelLayer("humanoid",
            "santa_hat");
    public static final ModelLayerLocation HUMANOID_BABY_SANTA_HAT = MODEL_LAYERS.registerModelLayer("humanoid_baby",
            "santa_hat");
    public static final ModelLayerLocation VILLAGER_HEAD = MODEL_LAYERS.registerModelLayer("villager_head");
    public static final ModelLayerLocation IRON_GOLEM_HEAD = MODEL_LAYERS.registerModelLayer("iron_golem_head");
    public static final ModelLayerLocation ILLAGER_HEAD = MODEL_LAYERS.registerModelLayer("illager_head");

    public static void bootstrap() {
        // NO-OP
    }

    static <E extends Enum<E>> E getEnumConstant(ResourceLocation resourceLocation, Function<String, E> valueOfInvoker) {
        return valueOfInvoker.apply(resourceLocation.toDebugFileName().toUpperCase(Locale.ROOT));
    }
}
