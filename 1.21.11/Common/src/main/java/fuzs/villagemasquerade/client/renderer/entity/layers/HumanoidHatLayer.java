package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
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

/**
 * @see HumanoidArmorLayer
 */
public abstract class HumanoidHatLayer<S extends HumanoidRenderState, M extends HumanoidModel<S> & HeadedModel, A extends EntityModel<S> & HeadedModel> extends RenderLayer<S, M> {
    private final A model;
    private final A modelBaby;
    private final EquipmentLayerRenderer equipmentRenderer;

    public HumanoidHatLayer(RenderLayerParent<S, M> renderer, A model, A modelBaby, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer);
        this.model = model;
        this.modelBaby = modelBaby;
        this.equipmentRenderer = equipmentRenderer;
    }

    @Override
    public void submit(PoseStack poseStack, SubmitNodeCollector nodeCollector, int packedLight, S renderState, float yRot, float xRot) {
        this.renderHat(poseStack,
                nodeCollector,
                renderState.headEquipment,
                EquipmentSlot.HEAD,
                packedLight,
                renderState);
    }

    protected void renderHat(PoseStack poseStack, SubmitNodeCollector nodeCollector, ItemStack item, EquipmentSlot slot, int packedLight, S renderState) {
        Equippable equippable = item.get(DataComponents.EQUIPPABLE);
        if (equippable != null && HumanoidArmorLayer.shouldRender(equippable, slot)) {
            poseStack.pushPose();
            EquipmentClientInfo.LayerType layerType = this.getLayerType(slot);
            A model = this.getModel(renderState);
            this.getParentModel().translateToHead(poseStack);
            this.equipmentRenderer.renderLayers(layerType,
                    equippable.assetId().orElseThrow(),
                    model,
                    renderState,
                    item,
                    poseStack,
                    nodeCollector,
                    packedLight,
                    renderState.outlineColor);
            poseStack.popPose();
        }
    }

    public final A getModel(S renderState) {
        return renderState.isBaby ? this.modelBaby : this.model;
    }

    protected abstract EquipmentClientInfo.LayerType getLayerType(EquipmentSlot slot);
}
