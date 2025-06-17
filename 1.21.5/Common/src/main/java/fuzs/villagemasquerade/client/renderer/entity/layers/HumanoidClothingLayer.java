package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

public class HumanoidClothingLayer<S extends HumanoidRenderState, M extends HumanoidModel<S>, A extends HumanoidModel<S>> extends HumanoidArmorLayer<S, M, A> {

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, A innerModel, A outerModel, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, innerModel, outerModel, equipmentRenderer);
    }

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, A innerModel, A outerModel, A innerModelBaby, A outerModelBaby, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, innerModel, outerModel, innerModelBaby, outerModelBaby, equipmentRenderer);
    }

    @Override
    protected void renderArmorPiece(PoseStack poseStack, MultiBufferSource bufferSource, ItemStack armorItem, EquipmentSlot slot, int packedLight, A model) {
        if (armorItem.is(ModRegistry.CLOTHING_ITEM_TAG)) {
            Equippable equippable = armorItem.get(DataComponents.EQUIPPABLE);
            if (equippable != null && shouldRender(equippable, slot)) {
                this.getParentModel().copyPropertiesTo(model);
                this.setPartVisibility(model, slot);
                EquipmentClientInfo.LayerType layerType =
                        this.usesInnerModel(slot) ? EquipmentClientInfo.LayerType.HUMANOID_LEGGINGS :
                                EquipmentClientInfo.LayerType.HUMANOID;
                this.equipmentRenderer.renderLayers(layerType,
                        equippable.assetId().orElseThrow(),
                        model,
                        armorItem,
                        poseStack,
                        bufferSource,
                        packedLight);
            }
        }
    }
}
