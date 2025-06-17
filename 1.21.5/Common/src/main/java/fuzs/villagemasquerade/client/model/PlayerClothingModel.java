package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public class PlayerClothingModel<S extends HumanoidRenderState> extends HumanoidModel<S> {

    public PlayerClothingModel(ModelPart modelPart) {
        super(modelPart);
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition partDefinition1 = partDefinition.getChild("body");
        partDefinition1.addOrReplaceChild("jacket",
                CubeListBuilder.create()
                        .texOffs(0, 32)
                        .addBox(-4.0F, 0.0F, -2.0F, 8.0F, 20.0F, 4.0F, new CubeDeformation(0.5F)),
                PartPose.ZERO);
        return LayerDefinition.create(meshDefinition, 64, 64);
    }
}
