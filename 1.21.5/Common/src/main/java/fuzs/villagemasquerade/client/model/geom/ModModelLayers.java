package fuzs.villagemasquerade.client.model.geom;

import fuzs.puzzleslib.api.client.init.v1.ModelLayerFactory;
import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceLocation;

import java.util.Locale;
import java.util.function.Function;

public class ModModelLayers {
    public static final ResourceLocation CLOTHING_LOCATION = VillageMasquerade.id("clothing");
    public static final ResourceLocation CLOTHING_HAT_LOCATION = VillageMasquerade.id("clothing_hat");
    public static final EquipmentClientInfo.LayerType CLOTHING_LAYER_TYPE = getEnumConstant(CLOTHING_LOCATION,
            EquipmentClientInfo.LayerType::valueOf);
    public static final EquipmentClientInfo.LayerType CLOTHING_HAT_LAYER_TYPE = getEnumConstant(CLOTHING_HAT_LOCATION,
            EquipmentClientInfo.LayerType::valueOf);
    public static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(VillageMasquerade.MOD_ID);
    public static final ModelLayerLocation PLAYER_CLOTHING = MODEL_LAYERS.registerModelLayer("player", "clothing");
    public static final ModelLayerLocation PLAYER_BABY_CLOTHING = MODEL_LAYERS.registerModelLayer("player_baby",
            "clothing");
    public static final ModelLayerLocation PLAYER_HAT = MODEL_LAYERS.registerModelLayer("player", "hat");
    public static final ModelLayerLocation PLAYER_SANTA_HAT = MODEL_LAYERS.registerModelLayer("player", "santa_hat");
    public static final ModelLayerLocation VILLAGER_HEAD = MODEL_LAYERS.registerModelLayer("villager_head");
    public static final ModelLayerLocation IRON_GOLEM_HEAD = MODEL_LAYERS.registerModelLayer("iron_golem_head");

    public static void bootstrap() {
        // NO-OP
    }

    static <E extends Enum<E>> E getEnumConstant(ResourceLocation resourceLocation, Function<String, E> valueOfInvoker) {
        return valueOfInvoker.apply(resourceLocation.toDebugFileName().toUpperCase(Locale.ROOT));
    }
}
