package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.resources.Identifier;

public class VillagerHeadModel {
    public static final Identifier VILLAGER_LOCATION = Identifier.withDefaultNamespace(
            "textures/entity/villager/villager.png");
    public static final Identifier IRON_GOLEM_LOCATION = Identifier.withDefaultNamespace(
            "textures/entity/iron_golem/iron_golem.png");
    public static final Identifier PILLAGER_LOCATION = Identifier.withDefaultNamespace(
            "textures/entity/illager/pillager.png");

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
