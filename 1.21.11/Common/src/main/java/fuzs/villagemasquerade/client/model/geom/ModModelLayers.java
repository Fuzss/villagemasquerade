package fuzs.villagemasquerade.client.model.geom;

import fuzs.puzzleslib.api.client.init.v1.ModelLayerFactory;
import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.ArmorModelSet;

public class ModModelLayers {
    static final ModelLayerFactory MODEL_LAYERS = ModelLayerFactory.from(VillageMasquerade.MOD_ID);
    public static final ModelLayerLocation VILLAGER_HEAD = MODEL_LAYERS.registerModelLayer("villager_head");
    public static final ModelLayerLocation IRON_GOLEM_HEAD = MODEL_LAYERS.registerModelLayer("iron_golem_head");
    public static final ModelLayerLocation ILLAGER_HEAD = MODEL_LAYERS.registerModelLayer("illager_head");
    public static final ArmorModelSet<ModelLayerLocation> HUMANOID_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "humanoid/clothing");
    public static final ArmorModelSet<ModelLayerLocation> HUMANOID_BABY_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "humanoid_baby/clothing");
    public static final ModelLayerLocation HUMANOID_WITCH_HAT = MODEL_LAYERS.registerModelLayer("humanoid/witch_hat");
    public static final ModelLayerLocation HUMANOID_BABY_WITCH_HAT = MODEL_LAYERS.registerModelLayer(
            "humanoid_baby/witch_hat");
    public static final ModelLayerLocation HUMANOID_SANTA_HAT = MODEL_LAYERS.registerModelLayer("humanoid/santa_hat");
    public static final ModelLayerLocation HUMANOID_BABY_SANTA_HAT = MODEL_LAYERS.registerModelLayer(
            "humanoid_baby/santa_hat");
    public static final ArmorModelSet<ModelLayerLocation> ARMOR_STAND_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "armor_stand/clothing");
    public static final ArmorModelSet<ModelLayerLocation> ARMOR_STAND_SMALL_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "armor_stand_small/clothing");
    public static final ArmorModelSet<ModelLayerLocation> HUSK_CLOTHING = MODEL_LAYERS.registerArmorSet("husk/clothing");
    public static final ArmorModelSet<ModelLayerLocation> HUSK_BABY_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "husk_baby/clothing");
    public static final ModelLayerLocation HUSK_WITCH_HAT = MODEL_LAYERS.registerModelLayer("husk/witch_hat");
    public static final ModelLayerLocation HUSK_BABY_WITCH_HAT = MODEL_LAYERS.registerModelLayer("husk_baby/witch_hat");
    public static final ModelLayerLocation HUSK_SANTA_HAT = MODEL_LAYERS.registerModelLayer("husk/santa_hat");
    public static final ModelLayerLocation HUSK_BABY_SANTA_HAT = MODEL_LAYERS.registerModelLayer("husk_baby/santa_hat");
    public static final ArmorModelSet<ModelLayerLocation> WITHER_SKELETON_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "wither_skeleton/clothing");
    public static final ArmorModelSet<ModelLayerLocation> WITHER_SKELETON_BABY_CLOTHING = MODEL_LAYERS.registerArmorSet(
            "wither_skeleton_baby/clothing");
    public static final ModelLayerLocation WITHER_SKELETON_WITCH_HAT = MODEL_LAYERS.registerModelLayer(
            "wither_skeleton/witch_hat");
    public static final ModelLayerLocation WITHER_SKELETON_BABY_WITCH_HAT = MODEL_LAYERS.registerModelLayer(
            "wither_skeleton_baby/witch_hat");
    public static final ModelLayerLocation WITHER_SKELETON_SANTA_HAT = MODEL_LAYERS.registerModelLayer(
            "wither_skeleton/santa_hat");
    public static final ModelLayerLocation WITHER_SKELETON_BABY_SANTA_HAT = MODEL_LAYERS.registerModelLayer(
            "wither_skeleton_baby/santa_hat");
}
