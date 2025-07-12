package fuzs.villagemasquerade.client;

import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.core.v1.context.LayerDefinitionsContext;
import fuzs.puzzleslib.api.client.core.v1.context.LivingEntityRenderLayersContext;
import fuzs.puzzleslib.api.client.core.v1.context.SkullRenderersContext;
import fuzs.puzzleslib.api.client.core.v1.context.SpecialBlockModelRenderersContext;
import fuzs.villagemasquerade.client.model.ClothingModel;
import fuzs.villagemasquerade.client.model.SantaHatModel;
import fuzs.villagemasquerade.client.model.VillagerHeadModel;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.client.renderer.entity.layers.HumanoidClothingLayer;
import fuzs.villagemasquerade.client.renderer.entity.layers.PlayerHatLayer;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.special.SkullSpecialRenderer;
import net.minecraft.world.entity.EntityType;

public class VillageMasqueradeClient implements ClientModConstructor {

    @Override
    public void onConstructMod() {
        ModModelLayers.bootstrap();
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(ModModelLayers.PLAYER_SANTA_HAT, SantaHatModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PLAYER_CLOTHING, ClothingModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PLAYER_BABY_CLOTHING,
                () -> ClothingModel.createBodyLayer().apply(HumanoidModel.BABY_TRANSFORMER));
        context.registerLayerDefinition(ModModelLayers.VILLAGER_HEAD, () -> {
            return LayerDefinition.create(VillagerHeadModel.createVillagerHeadModel(), 64, 64);
        });
        context.registerLayerDefinition(ModModelLayers.IRON_GOLEM_HEAD, () -> {
            return LayerDefinition.create(VillagerHeadModel.createVillagerHeadModel(), 128, 128);
        });
        context.registerLayerDefinition(ModModelLayers.ILLAGER_HEAD, () -> {
            return LayerDefinition.create(VillagerHeadModel.createVillagerHeadModel(), 64, 64);
        });
    }

    @Override
    public void onRegisterLivingEntityRenderLayers(LivingEntityRenderLayersContext context) {
        context.registerRenderLayer(EntityType.PLAYER,
                (RenderLayerParent<PlayerRenderState, PlayerModel> renderer, EntityRendererProvider.Context contextX) -> {
                    return new HumanoidClothingLayer<>(renderer,
                            new ClothingModel<>(contextX.bakeLayer(ModModelLayers.PLAYER_CLOTHING)),
                            new ClothingModel<>(contextX.bakeLayer(ModModelLayers.PLAYER_BABY_CLOTHING)),
                            contextX.getEquipmentRenderer());
                });
        context.registerRenderLayer(EntityType.PLAYER,
                (RenderLayerParent<PlayerRenderState, PlayerModel> renderer, EntityRendererProvider.Context contextX) -> {
                    return new PlayerHatLayer<>(renderer, contextX);
                });
    }

    @Override
    public void onRegisterSkullRenderers(SkullRenderersContext context) {
        context.registerSkullRenderer(ModRegistry.VILLAGER_SKULL_TYPE,
                VillagerHeadModel.VILLAGER_LOCATION,
                (EntityModelSet entityModelSet) -> {
                    return new SkullModel(entityModelSet.bakeLayer(ModModelLayers.VILLAGER_HEAD));
                });
        context.registerSkullRenderer(ModRegistry.IRON_GOLEM_SKULL_TYPE,
                VillagerHeadModel.IRON_GOLEM_LOCATION,
                (EntityModelSet entityModelSet) -> {
                    return new SkullModel(entityModelSet.bakeLayer(ModModelLayers.IRON_GOLEM_HEAD));
                });
        context.registerSkullRenderer(ModRegistry.ILLAGER_SKULL_TYPE,
                VillagerHeadModel.PILLAGER_LOCATION,
                (EntityModelSet entityModelSet) -> {
                    return new SkullModel(entityModelSet.bakeLayer(ModModelLayers.ILLAGER_HEAD));
                });
    }

    @Override
    public void onRegisterSpecialBlockModelRenderers(SpecialBlockModelRenderersContext context) {
        context.registerSpecialBlockModelRenderer(ModRegistry.VILLAGER_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.VILLAGER_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModRegistry.VILLAGER_WALL_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.VILLAGER_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModRegistry.IRON_GOLEM_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.IRON_GOLEM_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModRegistry.IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.IRON_GOLEM_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModRegistry.ILLAGER_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.ILLAGER_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModRegistry.ILLAGER_WALL_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.ILLAGER_SKULL_TYPE));
    }
}
