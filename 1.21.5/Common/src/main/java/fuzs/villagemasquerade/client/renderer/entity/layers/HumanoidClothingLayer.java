package fuzs.villagemasquerade.client.renderer.entity.layers;

import com.mojang.blaze3d.vertex.PoseStack;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.EquipmentLayerRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;

public class HumanoidClothingLayer<S extends HumanoidRenderState, M extends HumanoidModel<S>, A extends HumanoidModel<S>> extends HumanoidArmorLayer<S, M, A> {

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, A model, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, model, model, equipmentRenderer);
    }

    public HumanoidClothingLayer(RenderLayerParent<S, M> renderer, A model, A modelBaby, EquipmentLayerRenderer equipmentRenderer) {
        super(renderer, model, model, modelBaby, modelBaby, equipmentRenderer);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(new CubeDeformation(0.25F), 0.0F);
        return LayerDefinition.create(meshDefinition, 64, 32);
    }

    @Override
    protected void renderArmorPiece(PoseStack poseStack, MultiBufferSource bufferSource, ItemStack armorItem, EquipmentSlot slot, int packedLight, A model) {
        Equippable equippable = armorItem.get(DataComponents.EQUIPPABLE);
        if (equippable != null && shouldRender(equippable, slot)) {
            this.getParentModel().copyPropertiesTo(model);
            this.setPartVisibility(model, slot);
            this.equipmentRenderer.renderLayers(ModModelLayers.CLOTHING_LAYER_TYPE,
                    equippable.assetId().orElseThrow(),
                    model,
                    armorItem,
                    poseStack,
                    bufferSource,
                    packedLight);
        }
    }

    @Override
    protected void setPartVisibility(A model, EquipmentSlot slot) {
        model.setAllVisible(false);
        switch (slot) {
            case HEAD -> {
//                model.head.visible = true;
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
}
