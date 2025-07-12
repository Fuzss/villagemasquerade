package fuzs.villagemasquerade.neoforge.data.client;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.neoforge.api.client.data.v2.AbstractEquipmentProvider;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModEquipmentProvider extends AbstractEquipmentProvider {

    public ModEquipmentProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addEquipment() {
        this.addVillagerProfession(VillagerProfession.ARMORER);
        this.addVillagerProfession(VillagerProfession.BUTCHER);
        this.addVillagerProfession(VillagerProfession.CARTOGRAPHER);
        this.addVillagerProfession(VillagerProfession.CLERIC);
        this.addAllClothingLayers(ModRegistry.createEquipmentAssetKey(VillagerProfession.FARMER));
        this.addAllClothingLayers(ModRegistry.createEquipmentAssetKey(VillagerProfession.FISHERMAN));
        this.addVillagerProfession(VillagerProfession.FLETCHER);
        this.addVillagerProfession(VillagerProfession.LEATHERWORKER);
        this.addVillagerProfession(VillagerProfession.LIBRARIAN);
        this.addVillagerProfession(VillagerProfession.MASON);
        this.addVillagerProfession(VillagerProfession.NITWIT);
        this.addAllClothingLayers(ModRegistry.createEquipmentAssetKey(VillagerProfession.SHEPHERD));
        this.addVillagerProfession(VillagerProfession.TOOLSMITH);
        this.addVillagerProfession(VillagerProfession.WEAPONSMITH);
    }

    public final void addVillagerProfession(ResourceKey<VillagerProfession> resourceKey) {
        this.addClothingLayer(ModRegistry.createEquipmentAssetKey(resourceKey));
    }

    public final void addClothingLayer(ResourceKey<EquipmentAsset> resourceKey) {
        ResourceLocation resourceLocation = resourceKey.location();
        this.unconditional(resourceLocation,
                EquipmentClientInfo.builder()
                        .addLayers(ModModelLayers.CLOTHING_LAYER_TYPE, new EquipmentClientInfo.Layer(resourceLocation))
                        .build());
    }

    public final void addAllClothingLayers(ResourceKey<EquipmentAsset> resourceKey) {
        ResourceLocation resourceLocation = resourceKey.location();
        this.unconditional(resourceLocation,
                EquipmentClientInfo.builder()
                        .addLayers(ModModelLayers.CLOTHING_LAYER_TYPE, new EquipmentClientInfo.Layer(resourceLocation))
                        .addLayers(ModModelLayers.CLOTHING_HAT_LAYER_TYPE,
                                new EquipmentClientInfo.Layer(resourceLocation))
                        .build());
    }
}
