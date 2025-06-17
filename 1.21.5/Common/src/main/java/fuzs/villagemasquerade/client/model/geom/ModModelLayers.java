package fuzs.villagemasquerade.client.model.geom;

import fuzs.puzzleslib.api.client.init.v1.ModelLayerFactory;
import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.client.model.geom.ModelLayerLocation;

public class ModModelLayers {
    public static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(VillageMasquerade.MOD_ID);
    public static final ModelLayerLocation PLAYER_CLOTHING = MODEL_LAYERS.registerModelLayer("player", "clothing");
    public static final ModelLayerLocation PLAYER_HAT = MODEL_LAYERS.registerModelLayer("player", "hat");
    public static final ModelLayerLocation PLAYER_SANTA_HAT = MODEL_LAYERS.registerModelLayer("player", "santa_hat");
    public static final ModelLayerLocation VILLAGER_HEAD = MODEL_LAYERS.registerModelLayer("villager_head");
    public static final ModelLayerLocation IRON_GOLEM_HEAD = MODEL_LAYERS.registerModelLayer("iron_golem_head");
}
