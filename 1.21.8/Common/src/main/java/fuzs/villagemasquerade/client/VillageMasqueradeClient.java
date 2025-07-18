package fuzs.villagemasquerade.client;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.puzzleslib.api.client.core.v1.ClientModConstructor;
import fuzs.puzzleslib.api.client.core.v1.context.LayerDefinitionsContext;
import fuzs.puzzleslib.api.client.core.v1.context.SkullRenderersContext;
import fuzs.puzzleslib.api.client.core.v1.context.SpecialBlockModelRenderersContext;
import fuzs.puzzleslib.api.client.event.v1.renderer.AddLivingEntityRenderLayersCallback;
import fuzs.puzzleslib.api.client.gui.v2.tooltip.ItemTooltipRegistry;
import fuzs.puzzleslib.api.init.v3.registry.ResourceKeyHelper;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.model.ClothingModel;
import fuzs.villagemasquerade.client.model.HatModel;
import fuzs.villagemasquerade.client.model.VillagerHeadModel;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.client.renderer.entity.layers.HumanoidClothingLayer;
import fuzs.villagemasquerade.client.renderer.entity.layers.HumanoidHatLayer;
import fuzs.villagemasquerade.init.ModBlocks;
import fuzs.villagemasquerade.init.ModRegistry;
import fuzs.villagemasquerade.init.ModTags;
import net.minecraft.ChatFormatting;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.SkullModel;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshTransformer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HuskRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.WitherSkeletonRenderer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.special.SkullSpecialRenderer;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.jetbrains.annotations.Nullable;

import java.util.function.Consumer;

public class VillageMasqueradeClient implements ClientModConstructor {
    public static final String VILLAGER_CLOTHING_DESCRIPTION_KEY = ResourceKeyHelper.getTranslationKey(Registries.ITEM,
            VillageMasquerade.id("villager_clothing.description"));
    public static final String ENEMY_CLOTHING_DESCRIPTION_KEY = ResourceKeyHelper.getTranslationKey(Registries.ITEM,
            VillageMasquerade.id("enemy_clothing.description"));
    public static final String WANDERING_TRADER_CLOTHING_DESCRIPTION_KEY = ResourceKeyHelper.getTranslationKey(
            Registries.ITEM,
            VillageMasquerade.id("wandering_trader_clothing.description"));

    @Override
    public void onConstructMod() {
        ModModelLayers.bootstrap();
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        AddLivingEntityRenderLayersCallback.EVENT.register((EntityType<?> entityType, LivingEntityRenderer<?, ?, ?> entityRenderer, EntityRendererProvider.Context context) -> {
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
        });
    }

    private static <S extends HumanoidRenderState, M extends HumanoidModel<S>> void addHumanoidLayers(EntityType<?> entityType, LivingEntityRenderer<?, S, M> entityRenderer, ModelLayerLocation clothingLocation, ModelLayerLocation clothingBabyLocation, ModelLayerLocation witchHatLocation, ModelLayerLocation witchHatBabyLocation, ModelLayerLocation santaHatLocation, ModelLayerLocation santaHatBabyLocation, EntityRendererProvider.Context context) {
        entityRenderer.addLayer(new HumanoidClothingLayer<>(entityRenderer,
                new ClothingModel<>(context.bakeLayer(clothingLocation)),
                new ClothingModel<>(context.bakeLayer(clothingBabyLocation)),
                context.getEquipmentRenderer()) {
            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState, float yRot, float xRot) {
                if (entityType.is(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)) {
                    super.render(poseStack, bufferSource, packedLight, renderState, yRot, xRot);
                }
            }
        });
        entityRenderer.addLayer(new HumanoidHatLayer<>(entityRenderer,
                new HatModel<>(context.bakeLayer(witchHatLocation)),
                new HatModel<>(context.bakeLayer(witchHatBabyLocation)),
                ModModelLayers.WITCH_HAT_LAYER_TYPE,
                context.getEquipmentRenderer()) {
            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState, float yRot, float xRot) {
                if (entityType.is(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)) {
                    super.render(poseStack, bufferSource, packedLight, renderState, yRot, xRot);
                }
            }
        });
        entityRenderer.addLayer(new HumanoidHatLayer<>(entityRenderer,
                new HatModel<>(context.bakeLayer(santaHatLocation)),
                new HatModel<>(context.bakeLayer(santaHatBabyLocation)),
                ModModelLayers.SANTA_HAT_LAYER_TYPE,
                context.getEquipmentRenderer()) {
            @Override
            public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState, float yRot, float xRot) {
                if (entityType.is(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)) {
                    super.render(poseStack, bufferSource, packedLight, renderState, yRot, xRot);
                }
            }
        });
    }

    @Override
    public void onClientSetup() {
        ItemTooltipRegistry.registerItemTooltip((ItemStack itemStack) -> itemStack.has(ModRegistry.VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value()),
                (ItemStack itemStack, Item.TooltipContext tooltipContext, TooltipFlag tooltipFlag, @Nullable Player player, Consumer<Component> tooltipLineConsumer) -> {
                    ResourceKey<VillagerProfession> resourceKey = itemStack.get(ModRegistry.VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value());
                    Holder.Reference<VillagerProfession> holder = tooltipContext.registries()
                            .lookupOrThrow(Registries.VILLAGER_PROFESSION)
                            .getOrThrow(resourceKey);
                    tooltipLineConsumer.accept(Component.translatable(VILLAGER_CLOTHING_DESCRIPTION_KEY,
                            holder.value().name()).withStyle(ChatFormatting.GOLD));
                });
        ItemTooltipRegistry.ITEM.registerItemTooltip(ModTags.ENEMY_CLOTHING_ITEM_TAG,
                Component.translatable(ENEMY_CLOTHING_DESCRIPTION_KEY).withStyle(ChatFormatting.GOLD));
        ItemTooltipRegistry.ITEM.registerItemTooltip(ModTags.WANDERING_TRADER_CLOTHING_ITEM_TAG,
                Component.translatable(WANDERING_TRADER_CLOTHING_DESCRIPTION_KEY).withStyle(ChatFormatting.GOLD));
    }

    @Override
    public void onRegisterLayerDefinitions(LayerDefinitionsContext context) {
        context.registerLayerDefinition(ModModelLayers.VILLAGER_HEAD,
                () -> LayerDefinition.create(VillagerHeadModel.createVillagerHeadModel(), 64, 64));
        context.registerLayerDefinition(ModModelLayers.IRON_GOLEM_HEAD,
                () -> LayerDefinition.create(VillagerHeadModel.createVillagerHeadModel(), 128, 128));
        context.registerLayerDefinition(ModModelLayers.ILLAGER_HEAD,
                () -> LayerDefinition.create(VillagerHeadModel.createVillagerHeadModel(), 64, 64));
        context.registerLayerDefinition(ModModelLayers.HUMANOID_CLOTHING, ClothingModel::createBodyLayer);
        context.registerLayerDefinition(ModModelLayers.HUMANOID_BABY_CLOTHING,
                () -> ClothingModel.createBodyLayer().apply(HumanoidModel.BABY_TRANSFORMER));
        context.registerLayerDefinition(ModModelLayers.HUMANOID_WITCH_HAT, HatModel::createWitchHatLayer);
        context.registerLayerDefinition(ModModelLayers.HUMANOID_BABY_WITCH_HAT,
                () -> HatModel.createWitchHatLayer().apply(HumanoidModel.BABY_TRANSFORMER));
        context.registerLayerDefinition(ModModelLayers.HUMANOID_SANTA_HAT, HatModel::createSantaHatLayer);
        context.registerLayerDefinition(ModModelLayers.HUMANOID_BABY_SANTA_HAT,
                () -> HatModel.createSantaHatLayer().apply(HumanoidModel.BABY_TRANSFORMER));
        MeshTransformer huskTransformer = MeshTransformer.scaling(1.0625F);
        context.registerLayerDefinition(ModModelLayers.HUSK_CLOTHING,
                () -> ClothingModel.createBodyLayer().apply(huskTransformer));
        context.registerLayerDefinition(ModModelLayers.HUSK_BABY_CLOTHING,
                () -> ClothingModel.createBodyLayer().apply(HumanoidModel.BABY_TRANSFORMER).apply(huskTransformer));
        context.registerLayerDefinition(ModModelLayers.HUSK_WITCH_HAT,
                () -> HatModel.createWitchHatLayer().apply(huskTransformer));
        context.registerLayerDefinition(ModModelLayers.HUSK_BABY_WITCH_HAT,
                () -> HatModel.createWitchHatLayer().apply(HumanoidModel.BABY_TRANSFORMER).apply(huskTransformer));
        context.registerLayerDefinition(ModModelLayers.HUSK_SANTA_HAT,
                () -> HatModel.createSantaHatLayer().apply(huskTransformer));
        context.registerLayerDefinition(ModModelLayers.HUSK_BABY_SANTA_HAT,
                () -> HatModel.createSantaHatLayer().apply(HumanoidModel.BABY_TRANSFORMER).apply(huskTransformer));
        MeshTransformer witherSkeletonTransformer = MeshTransformer.scaling(1.2F);
        context.registerLayerDefinition(ModModelLayers.WITHER_SKELETON_CLOTHING,
                () -> ClothingModel.createBodyLayer().apply(witherSkeletonTransformer));
        context.registerLayerDefinition(ModModelLayers.WITHER_SKELETON_BABY_CLOTHING,
                () -> ClothingModel.createBodyLayer()
                        .apply(HumanoidModel.BABY_TRANSFORMER)
                        .apply(witherSkeletonTransformer));
        context.registerLayerDefinition(ModModelLayers.WITHER_SKELETON_WITCH_HAT,
                () -> HatModel.createWitchHatLayer().apply(witherSkeletonTransformer));
        context.registerLayerDefinition(ModModelLayers.WITHER_SKELETON_BABY_WITCH_HAT,
                () -> HatModel.createWitchHatLayer()
                        .apply(HumanoidModel.BABY_TRANSFORMER)
                        .apply(witherSkeletonTransformer));
        context.registerLayerDefinition(ModModelLayers.WITHER_SKELETON_SANTA_HAT,
                () -> HatModel.createSantaHatLayer().apply(witherSkeletonTransformer));
        context.registerLayerDefinition(ModModelLayers.WITHER_SKELETON_BABY_SANTA_HAT,
                () -> HatModel.createSantaHatLayer()
                        .apply(HumanoidModel.BABY_TRANSFORMER)
                        .apply(witherSkeletonTransformer));
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
        context.registerSpecialBlockModelRenderer(ModBlocks.VILLAGER_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.VILLAGER_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModBlocks.VILLAGER_WALL_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.VILLAGER_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModBlocks.IRON_GOLEM_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.IRON_GOLEM_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModBlocks.IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.IRON_GOLEM_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModBlocks.ILLAGER_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.ILLAGER_SKULL_TYPE));
        context.registerSpecialBlockModelRenderer(ModBlocks.ILLAGER_WALL_HEAD_BLOCK.value(),
                new SkullSpecialRenderer.Unbaked(ModRegistry.ILLAGER_SKULL_TYPE));
    }
}
