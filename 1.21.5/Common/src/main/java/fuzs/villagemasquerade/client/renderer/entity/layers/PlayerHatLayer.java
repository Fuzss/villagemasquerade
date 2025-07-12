package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.model.PlayerHatModel;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;

public class PlayerHatLayer<S extends HumanoidRenderState, M extends HumanoidModel<S> & HeadedModel> extends RenderLayer<S, M> {
    public static final ResourceLocation TEXTURE_LOCATION = VillageMasquerade.id("textures/santa_hat.png");

    private final PlayerHatModel model;

    public PlayerHatLayer(RenderLayerParent<S, M> renderer, EntityRendererProvider.Context context) {
        super(renderer);
        this.model = new PlayerHatModel(context.bakeLayer(ModModelLayers.PLAYER_SANTA_HAT));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState, float yRot, float xRot) {
        if (!renderState.headItem.isEmpty()) {
            this.model.getHead().copyFrom(this.getParentModel().getHead());
            renderColoredCutoutModel(this.model,
                    TEXTURE_LOCATION,
                    poseStack,
                    bufferSource,
                    packedLight,
                    renderState,
                    -1);
        }
    }
}
