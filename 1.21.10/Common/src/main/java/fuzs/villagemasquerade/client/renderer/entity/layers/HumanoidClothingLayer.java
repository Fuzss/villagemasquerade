package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

public abstract class HumanoidClothingLayer<S extends HumanoidRenderState, M extends HumanoidModel<S>, A extends HumanoidModel<S>> extends HumanoidArmorLayer<S, M, A> {

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, ArmorModelSet<A> modelSet, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, modelSet, modelSet, equipmentRenderer);
    }

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, ArmorModelSet<A> modelSet, ArmorModelSet<A> babyModelSet, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, modelSet, babyModelSet, equipmentRenderer);
    }

    /**
     * @see HumanoidArmorLayer#renderArmorPiece(PoseStack, SubmitNodeCollector, ItemStack, EquipmentSlot, int,
     *         HumanoidRenderState)
     */
    @Override
    protected void renderArmorPiece(PoseStack poseStack, SubmitNodeCollector nodeCollector, ItemStack item, EquipmentSlot slot, int packedLight, S renderState) {
        Equippable equippable = item.get(DataComponents.EQUIPPABLE);
        if (equippable != null && shouldRender(equippable, slot)) {
            EquipmentClientInfo.LayerType layerType = this.getLayerType(slot);
            A model = this.getArmorModel(renderState, slot);
            this.equipmentRenderer.renderLayers(layerType,
                    equippable.assetId().orElseThrow(),
                    model,
                    renderState,
                    item,
                    poseStack,
                    nodeCollector,
                    packedLight,
                    renderState.outlineColor);
        }
    }

    protected abstract EquipmentClientInfo.LayerType getLayerType(EquipmentSlot slot);
}
