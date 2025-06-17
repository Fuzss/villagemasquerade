package fuzs.villagemasquerade.client;

import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.core.v1.context.LayerDefinitionsContext;
import fuzs.puzzleslib.api.client.core.v1.context.LivingEntityRenderLayersContext;
import fuzs.puzzleslib.api.client.core.v1.context.SkullRenderersContext;
import fuzs.puzzleslib.api.client.core.v1.context.SpecialBlockModelRenderersContext;
import fuzs.villagemasquerade.client.model.PlayerClothingModel;
import fuzs.villagemasquerade.client.model.SantaHatModel;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.client.renderer.entity.layers.PlayerHatLayer;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.model.IronGolemModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.VillagerModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.state.PlayerRenderState;
import net.minecraft.client.renderer.special.SkullSpecialRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;

public class VillageMasqueradeClient implements ClientModConstructor {
    private static final ResourceLocation VILLAGER_BASE_SKIN = ResourceLocation.withDefaultNamespace(
            "textures/entity/villager/villager.png");
    private static final ResourceLocation GOLEM_LOCATION = ResourceLocation.withDefaultNamespace(
            "textures/entity/iron_golem/iron_golem.png");

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(ModModelLayers.PLAYER_SANTA_HAT, SantaHatModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.PLAYER_CLOTHING, PlayerClothingModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.VILLAGER_HEAD, () -> {
            return createBodyLayer(VillagerModel.createBodyModel(), 64, 64);
        });
        context.registerLayerDefinition(ModModelLayers.IRON_GOLEM_HEAD, () -> {
            return createBodyLayer(IronGolemModel.createBodyLayer().mesh, 128, 128);
        });
    }

    static LayerDefinition createBodyLayer(MeshDefinition meshDefinition, int texWidth, int texHeight) {
        MeshDefinition newMeshDefinition = new MeshDefinition();
        PartDefinition partDefinition = newMeshDefinition.getRoot();
        partDefinition.addOrReplaceChild("head", meshDefinition.getRoot().getChild("head"));
        return LayerDefinition.create(newMeshDefinition, texWidth, texHeight);
    }

    @Override
    public void onRegisterLivingEntityRenderLayers(LivingEntityRenderLayersContext context) {
        context.registerRenderLayer(EntityType.PLAYER,
                (RenderLayerParent<PlayerRenderState, PlayerModel> entityModelRenderLayerParent, EntityRendererProvider.Context context1) -> {
                    return new PlayerHatLayer<>(entityModelRenderLayerParent, context1);
                });
    }

    @Override
    public void onRegisterSkullRenderers(SkullRenderersContext context) {
        context.registerSkullRenderer(ModRegistry.VILLAGER_SKULL_TYPE,
                VILLAGER_BASE_SKIN,
                (EntityModelSet entityModelSet) -> {
                    return new SkullModel(entityModelSet.bakeLayer(ModModelLayers.VILLAGER_HEAD));
                });
        context.registerSkullRenderer(ModRegistry.IRON_GOLEM_SKULL_TYPE,
                GOLEM_LOCATION,
                (EntityModelSet entityModelSet) -> {
                    return new SkullModel(entityModelSet.bakeLayer(ModModelLayers.IRON_GOLEM_HEAD));
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
    }
}
