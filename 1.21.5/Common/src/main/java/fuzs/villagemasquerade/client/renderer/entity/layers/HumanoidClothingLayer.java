package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.villagemasquerade.client.model.ClothingModel;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

public class HumanoidClothingLayer<S extends HumanoidRenderState, M extends HumanoidModel<S>, A extends ClothingModel<S>> extends HumanoidArmorLayer<S, M, A> {

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, A model, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, model, model, equipmentRenderer);
    }

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, A model, A modelBaby, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, model, model, modelBaby, modelBaby, equipmentRenderer);
    }

    @Override
    protected void renderArmorPiece(PoseStack poseStack, MultiBufferSource bufferSource, ItemStack armorItem, EquipmentSlot slot, int packedLight, A model) {
        Equippable equippable = armorItem.get(DataComponents.EQUIPPABLE);
        if (equippable != null && shouldRender(equippable, slot)) {
            this.getParentModel().copyPropertiesTo(model);
            this.setPartVisibility(model, slot, false);
            this.equipmentRenderer.renderLayers(ModModelLayers.CLOTHING_LAYER_TYPE,
                    equippable.assetId().orElseThrow(),
                    model,
                    armorItem,
                    poseStack,
                    bufferSource,
                    packedLight);
            if (this.usesHatModel(slot)) {
                this.setPartVisibility(model, slot, true);
                this.equipmentRenderer.renderLayers(ModModelLayers.CLOTHING_HAT_LAYER_TYPE,
                        equippable.assetId().orElseThrow(),
                        model,
                        armorItem,
                        poseStack,
                        bufferSource,
                        packedLight);
            }
        }
    }

    private void setPartVisibility(A model, EquipmentSlot slot, boolean renderHatRim) {
        model.setAllVisible(false);
        switch (slot) {
            case HEAD -> {
                model.head.visible = true;
                model.hat.visible = !renderHatRim;
                model.hatRim.visible = renderHatRim;
            }
            case CHEST -> {
                model.body.visible = true;
                model.rightArm.visible = true;
                model.leftArm.visible = true;
            }
            case LEGS, FEET -> {
                model.rightLeg.visible = true;
                model.leftLeg.visible = true;
            }
        }
    }

    private boolean usesHatModel(EquipmentSlot slot) {
        return slot == EquipmentSlot.HEAD;
    }
}
