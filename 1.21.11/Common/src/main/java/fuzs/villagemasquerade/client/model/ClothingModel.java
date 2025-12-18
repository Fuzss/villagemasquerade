package fuzs.villagemasquerade.client.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.client.renderer.entity.ArmorModelSet;
import net.minecraft.util.Mth;

import java.util.Set;
import java.util.function.Function;

public class ClothingModel {

    public static ArmorModelSet<LayerDefinition> createArmorLayerSet() {
        return createArmorMeshSet(new CubeDeformation(0.25F)).map((MeshDefinition meshDefinition) -> {
            return LayerDefinition.create(meshDefinition, 64, 64);
        });
    }

    public static ArmorModelSet<MeshDefinition> createArmorMeshSet(CubeDeformation cubeDeformation) {
        return createArmorMeshSet(ClothingModel::createMesh, cubeDeformation);
    }

    public static MeshDefinition createMesh(CubeDeformation cubeDeformation) {
        MeshDefinition meshDefinition = HumanoidModel.createMesh(cubeDeformation, 0.0F);
        PartDefinition partDefinition = meshDefinition.getRoot();
        partDefinition.getChild("head")
                .addOrReplaceChild("hat_rim",
                        CubeListBuilder.create()
                                .texOffs(0, 32)
                                .addBox(-8.0F, -8.0F, -5.0F, 16.0F, 16.0F, 0.0F, CubeDeformation.NONE),
                        PartPose.rotation(-Mth.HALF_PI, 0.0F, 0.0F));
        return meshDefinition;
    }

    /**
     * @see HumanoidModel#createArmorMeshSet(Function, CubeDeformation, CubeDeformation)
     */
    private static ArmorModelSet<MeshDefinition> createArmorMeshSet(Function<CubeDeformation, MeshDefinition> meshCreator, CubeDeformation cubeDeformation) {
        MeshDefinition meshDefinition = meshCreator.apply(cubeDeformation);
        meshDefinition.getRoot().retainPartsAndChildren(Set.of("head"));
        MeshDefinition meshDefinition2 = meshCreator.apply(cubeDeformation);
        meshDefinition2.getRoot().retainExactParts(Set.of("body", "left_arm", "right_arm"));
        MeshDefinition meshDefinition3 = meshCreator.apply(cubeDeformation);
        meshDefinition3.getRoot().retainExactParts(Set.of("left_leg", "right_leg"));
        MeshDefinition meshDefinition4 = meshCreator.apply(cubeDeformation);
        meshDefinition4.getRoot().clearRecursively();
        return new ArmorModelSet<>(meshDefinition, meshDefinition2, meshDefinition3, meshDefinition4);
    }
}
