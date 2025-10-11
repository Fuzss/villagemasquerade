package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.WitchModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;

public class HatModel<S extends HumanoidRenderState> extends EntityModel<S> implements HeadedModel {
    private final ModelPart hat;

    public HatModel(ModelPart root) {
        super(root);
        this.hat = root.getChild("hat");
    }

    /**
     * @see WitchModel#createBodyLayer()
     */
    public static LayerDefinition createWitchHatLayer() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("hat",
                CubeListBuilder.create(),
                PartPose.ZERO);
        PartDefinition partDefinition2 = partDefinition1.addOrReplaceChild("hat0",
                CubeListBuilder.create(),
                PartPose.offset(0.0F, 2.0F, 0.0F));
        PartDefinition partDefinition3 = partDefinition2.addOrReplaceChild("hat1",
                CubeListBuilder.create().texOffs(0, 0).addBox(0.0F, 0.0F, 0.0F, 10.0F, 2.0F, 10.0F),
                PartPose.offset(-5.0F, -10.03125F, -5.0F));
        PartDefinition partDefinition4 = partDefinition3.addOrReplaceChild("hat2",
                CubeListBuilder.create().texOffs(0, 12).addBox(0.0F, 0.0F, 0.0F, 7.0F, 4.0F, 7.0F),
                PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.05235988F, 0.0F, 0.02617994F));
        PartDefinition partDefinition5 = partDefinition4.addOrReplaceChild("hat3",
                CubeListBuilder.create().texOffs(0, 23).addBox(0.0F, 0.0F, 0.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(1.75F, -4.0F, 2.0F, -0.10471976F, 0.0F, 0.05235988F));
        partDefinition5.addOrReplaceChild("hat4",
                CubeListBuilder.create()
                        .texOffs(0, 31)
                        .addBox(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(1.75F, -2.0F, 2.0F, (float) (-Math.PI / 15), 0.0F, 0.10471976F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    public static LayerDefinition createSantaHatLayer() {
        return createSantaHatLayer(false);
    }

    public static LayerDefinition createSantaHatLayer(boolean includeBeard) {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        PartDefinition partDefinition1 = partDefinition.addOrReplaceChild("hat",
                CubeListBuilder.create(),
                PartPose.ZERO);
        if (includeBeard) {
            partDefinition1.addOrReplaceChild("beard",
                    CubeListBuilder.create()
                            .texOffs(36, 37)
                            .addBox(-4.0F, -8.0F, -4.0F, 8.0F, 10.0F, 6.0F, new CubeDeformation(0.6F)),
                    PartPose.ZERO);
        }

        PartDefinition partDefinition2 = partDefinition1.addOrReplaceChild("hat1",
                CubeListBuilder.create()
                        .texOffs(0, 55)
                        .addBox(-4.0F, -0.5F, -4.0F, 8.0F, 1.0F, 8.0F, new CubeDeformation(0.85F)),
                PartPose.offsetAndRotation(0.0F, -7.18F, 0.0F, -0.1309F, 0.0F, 0.0F));
        PartDefinition partDefinition3 = partDefinition2.addOrReplaceChild("hat2",
                CubeListBuilder.create()
                        .texOffs(32, 53)
                        .addBox(-3.5F, -2.98F, -3.5957F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.25F)),
                PartPose.offsetAndRotation(0.0F, 0.0F, 0.0F, -0.3927F, 0.0F, 0.0F));
        PartDefinition partDefinition4 = partDefinition3.addOrReplaceChild("hat3",
                CubeListBuilder.create().texOffs(0, 46).addBox(-1.5F, -3.1768F, -3.6768F, 5.0F, 4.0F, 5.0F),
                PartPose.offsetAndRotation(-1.0F, -2.0F, 0.5F, -0.3927F, 0.0F, 0.0F));
        PartDefinition partDefinition5 = partDefinition4.addOrReplaceChild("hat4",
                CubeListBuilder.create().texOffs(24, 53).addBox(0.5F, -3.0957F, -3.731F, 3.0F, 4.0F, 3.0F),
                PartPose.offsetAndRotation(-1.0F, -2.25F, 0.75F, -0.3927F, 0.0F, 0.0F));
        partDefinition5.addOrReplaceChild("hat5",
                CubeListBuilder.create().texOffs(20, 45).addBox(-2.2441F, -4.0541F, -2.0F, 4.0F, 4.0F, 4.0F),
                PartPose.offsetAndRotation(2.0F, -1.0F, -2.0F, -1.5708F, -1.3963F, 1.5708F));
        return LayerDefinition.create(meshDefinition, 64, 64);
    }

    @Override
    public ModelPart getHead() {
        return this.hat;
    }
}
