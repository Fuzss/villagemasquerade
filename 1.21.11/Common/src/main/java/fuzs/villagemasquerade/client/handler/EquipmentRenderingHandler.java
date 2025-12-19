package fuzs.villagemasquerade.client.handler;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.villagemasquerade.client.init.ModEnumConstants;
import fuzs.villagemasquerade.client.model.HatModel;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.client.renderer.entity.layers.HumanoidClothingLayer;
import fuzs.villagemasquerade.client.renderer.entity.layers.HumanoidHatLayer;
import fuzs.villagemasquerade.init.ModTags;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.object.armorstand.ArmorStandArmorModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EquipmentSlot;

import java.util.function.Function;

public class EquipmentRenderingHandler {

    public static void addLivingEntityRenderLayers(EntityType<?> entityType, LivingEntityRenderer<?, ?, ?> entityRenderer, EntityRendererProvider.Context context) {
        if (entityRenderer instanceof HuskRenderer huskRenderer) {
            addHumanoidLayers(entityType,
                    huskRenderer,
                    ModModelLayers.HUSK_CLOTHING,
                    ModModelLayers.HUSK_BABY_CLOTHING,
                    ModModelLayers.HUSK_WITCH_HAT,
                    ModModelLayers.HUSK_BABY_WITCH_HAT,
                    ModModelLayers.HUSK_SANTA_HAT,
                    ModModelLayers.HUSK_BABY_SANTA_HAT,
                    context);
        } else if (entityRenderer instanceof WitherSkeletonRenderer witherSkeletonRenderer) {
            addHumanoidLayers(entityType,
                    witherSkeletonRenderer,
                    ModModelLayers.WITHER_SKELETON_CLOTHING,
                    ModModelLayers.WITHER_SKELETON_BABY_CLOTHING,
                    ModModelLayers.WITHER_SKELETON_WITCH_HAT,
                    ModModelLayers.WITHER_SKELETON_BABY_WITCH_HAT,
                    ModModelLayers.WITHER_SKELETON_SANTA_HAT,
                    ModModelLayers.WITHER_SKELETON_BABY_SANTA_HAT,
                    context);
        } else if (entityRenderer instanceof ArmorStandRenderer armorStandRenderer) {
            addHumanoidLayers(entityType,
                    armorStandRenderer,
                    ModModelLayers.ARMOR_STAND_CLOTHING,
                    ModModelLayers.ARMOR_STAND_SMALL_CLOTHING,
                    ModModelLayers.HUMANOID_WITCH_HAT,
                    ModModelLayers.HUMANOID_BABY_WITCH_HAT,
                    ModModelLayers.HUMANOID_SANTA_HAT,
                    ModModelLayers.HUMANOID_BABY_SANTA_HAT,
                    ArmorStandArmorModel::new,
                    context);
        } else if (entityRenderer.getModel() instanceof HumanoidModel<?>) {
            addHumanoidLayers(entityType,
                    (LivingEntityRenderer<?, HumanoidRenderState, HumanoidModel<HumanoidRenderState>>) entityRenderer,
                    ModModelLayers.HUMANOID_CLOTHING,
                    ModModelLayers.HUMANOID_BABY_CLOTHING,
                    ModModelLayers.HUMANOID_WITCH_HAT,
                    ModModelLayers.HUMANOID_BABY_WITCH_HAT,
                    ModModelLayers.HUMANOID_SANTA_HAT,
                    ModModelLayers.HUMANOID_BABY_SANTA_HAT,
                    context);
        }
    }

    private static <S extends HumanoidRenderState, M extends HumanoidModel<S>> void addHumanoidLayers(EntityType<?> entityType, LivingEntityRenderer<?, S, M> entityRenderer, ArmorModelSet<ModelLayerLocation> clothingLocation, ArmorModelSet<ModelLayerLocation> clothingBabyLocation, ModelLayerLocation witchHatLocation, ModelLayerLocation witchHatBabyLocation, ModelLayerLocation santaHatLocation, ModelLayerLocation santaHatBabyLocation, EntityRendererProvider.Context context) {
        addHumanoidLayers(entityType,
                entityRenderer,
                clothingLocation,
                clothingBabyLocation,
                witchHatLocation,
                witchHatBabyLocation,
                santaHatLocation,
                santaHatBabyLocation,
                HumanoidModel::new,
                context);
    }

    private static <S extends HumanoidRenderState, M extends HumanoidModel<S>> void addHumanoidLayers(EntityType<?> entityType, LivingEntityRenderer<?, S, M> entityRenderer, ArmorModelSet<ModelLayerLocation> clothingLocation, ArmorModelSet<ModelLayerLocation> clothingBabyLocation, ModelLayerLocation witchHatLocation, ModelLayerLocation witchHatBabyLocation, ModelLayerLocation santaHatLocation, ModelLayerLocation santaHatBabyLocation, Function<ModelPart, HumanoidModel<S>> baker, EntityRendererProvider.Context context) {
        entityRenderer.addLayer(new HumanoidClothingLayer<>(entityRenderer,
                ArmorModelSet.bake(clothingLocation, context.getModelSet(), baker),
                ArmorModelSet.bake(clothingBabyLocation, context.getModelSet(), baker),
                context.getEquipmentRenderer()) {
            @Override
            public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, S renderState, float yRot, float xRot) {
                if (entityType.is(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)) {
                    super.submit(poseStack, nodeCollector, packedLight, renderState, yRot, xRot);
                }
            }

            @Override
            protected EquipmentClientInfo.LayerType getLayerType(EquipmentSlot slot) {
                return ModEnumConstants.CLOTHING_LAYER_TYPE;
            }
        });
        entityRenderer.addLayer(new HumanoidHatLayer<>(entityRenderer,
                new HatModel<>(context.bakeLayer(witchHatLocation)),
                new HatModel<>(context.bakeLayer(witchHatBabyLocation)),
                context.getEquipmentRenderer()) {
            @Override
            public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, S renderState, float yRot, float xRot) {
                if (entityType.is(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)) {
                    super.submit(poseStack, nodeCollector, packedLight, renderState, yRot, xRot);
                }
            }

            @Override
            protected EquipmentClientInfo.LayerType getLayerType(EquipmentSlot slot) {
                return ModEnumConstants.WITCH_HAT_LAYER_TYPE;
            }
        });
        entityRenderer.addLayer(new HumanoidHatLayer<>(entityRenderer,
                new HatModel<>(context.bakeLayer(santaHatLocation)),
                new HatModel<>(context.bakeLayer(santaHatBabyLocation)),
                context.getEquipmentRenderer()) {
            @Override
            public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, S renderState, float yRot, float xRot) {
                if (entityType.is(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)) {
                    super.submit(poseStack, nodeCollector, packedLight, renderState, yRot, xRot);
                }
            }

            @Override
            protected EquipmentClientInfo.LayerType getLayerType(EquipmentSlot slot) {
                return ModEnumConstants.SANTA_HAT_LAYER_TYPE;
            }
        });
    }
}
