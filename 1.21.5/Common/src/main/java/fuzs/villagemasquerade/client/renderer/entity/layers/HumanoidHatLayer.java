package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.villagemasquerade.client.model.HatModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

public class HumanoidHatLayer<S extends HumanoidRenderState, M extends HumanoidModel<S> & HeadedModel, A extends HatModel<S>> extends RenderLayer<S, M> {
    private final A model;
    private final A modelBaby;
    private final EquipmentClientInfo.LayerType layerType;
    private final EquipmentLayerRenderer equipmentRenderer;

    public HumanoidHatLayer(RenderLayerParent<S, M> renderer, A model, A modelBaby, EquipmentClientInfo.LayerType layerType, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer);
        this.model = model;
        this.modelBaby = modelBaby;
        this.layerType = layerType;
        this.equipmentRenderer = equipmentRenderer;
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, S renderState, float yRot, float xRot) {
        this.renderHat(poseStack, bufferSource, packedLight, renderState.headEquipment, this.getModel(renderState));
    }

    protected void renderHat(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, ItemStack itemStack, A model) {
        Equippable equippable = itemStack.get(DataComponents.EQUIPPABLE);
        if (equippable != null && HumanoidArmorLayer.shouldRender(equippable, EquipmentSlot.HEAD)) {
            model.getHead().copyFrom(this.getParentModel().getHead());
            this.equipmentRenderer.renderLayers(this.layerType,
                    equippable.assetId().orElseThrow(),
                    model,
                    itemStack,
                    poseStack,
                    bufferSource,
                    packedLight);
        }
    }

    protected A getModel(S renderState) {
        return renderState.isBaby ? this.modelBaby : this.model;
    }
}
