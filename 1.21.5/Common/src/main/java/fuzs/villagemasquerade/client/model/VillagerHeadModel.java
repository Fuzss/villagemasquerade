package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.ResourceLocation;

public class VillagerHeadModel {
    public static final ResourceLocation VILLAGER_LOCATION = ResourceLocation.withDefaultNamespace(
            "textures/entity/villager/villager.png");
    public static final ResourceLocation IRON_GOLEM_LOCATION = ResourceLocation.withDefaultNamespace(
            "textures/entity/iron_golem/iron_golem.png");

    public static MeshDefinition createVillagerHeadModel() {
        MeshDefinition meshDefinition = new MeshDefinition();
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.addOrReplaceChild("head",
                CubeListBuilder.create()
                        .texOffs(0, 0)
                        .addBox(-4.0F, -10.0F, -4.0F, 8.0F, 10.0F, 8.0F)
                        .texOffs(24, 0)
                        .addBox(-1.0F, -3.0F, -6.0F, 2.0F, 4.0F, 2.0F),
                PartPose.ZERO);
        return meshDefinition;
    }
}
