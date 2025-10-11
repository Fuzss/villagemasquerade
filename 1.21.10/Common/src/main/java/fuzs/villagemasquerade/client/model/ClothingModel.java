package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.util.Mth;

public class ClothingModel<S extends HumanoidRenderState> extends HumanoidModel<S> {
    public final ModelPart hatRim;

    public ClothingModel(ModelPart root) {
        super(root);
        this.hatRim = this.getHead().getChild("hat_rim");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshDefinition = createMesh(new CubeDeformation(0.25F), 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.getChild("head")
                .addOrReplaceChild("hat_rim",
                        CubeListBuilder.create()
                                .texOffs(0, 32)
                                .addBox(-8.0F, -8.0F, -5.0F, 16.0F, 16.0F, 0.0F, CubeDeformation.NONE),
                        PartPose.rotation(-Mth.HALF_PI, 0.0F, 0.0F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public void setAllVisible(boolean visible) {
        super.setAllVisible(visible);
        this.hatRim.visible = visible;
    }
}
