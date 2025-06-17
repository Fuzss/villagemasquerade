package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public class SantaHatModel extends EntityModel<HumanoidRenderState> implements HeadedModel {
    private final ModelPart hat;

    public SantaHatModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
    }

    public static LayerDefinition createBodyLayer() {
        MeshDefinition meshdefinition = new MeshDefinition();
        PartDefinition partdefinition = meshdefinition.getRoot();
        PartDefinition Head = partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);
        PartDefinition bone4 = Head.addOrReplaceChild("rim",
                CubeListBuilder.create()
                        .texOffs(0, 55)
                        .addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.85F)),
                PartPose.offsetAndRotation(0.0F, -6.75F, 0.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition bone = bone4.addOrReplaceChild("bone",
                CubeListBuilder.create()
                        .texOffs(32, 53)
                        .addBox(-3.5F, -2.98F, -3.5957F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition bone2 = bone.addOrReplaceChild("bone2",
                CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, -3.1768F, -3.6768F, 5.0F, 4.0F, 5.0F),
                PartPose.offsetAndRotation(-1.0F, -2.0F, 0.5F, -0.3927F, 0.0F, 0.0F));
        PartDefinition bone3 = bone2.addOrReplaceChild("bone3",
                CubeListBuilder.create().texOffs(24, 53).addBox(0.5F, -3.0957F, -3.731F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-1.0F, -2.25F, 0.75F, -0.3927F, 0.0F, 0.0F));
        bone3.addOrReplaceChild("bone5",
                CubeListBuilder.create().texOffs(20, 45).addBox(-2.2441F, -4.0541F, -2.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, -1.5708F, -1.3963F, 1.5708F));
        return LayerDefinition.create(meshdefinition, 64, 64);
    }

    @Override
    public ModelPart getHead() {
        return this.hat;
    }
}
