package fuzs.villagemasquerade.neoforge.data.client;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.neoforge.api.client.data.v2.AbstractEquipmentProvider;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.init.ModEquipmentAssets;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModEquipmentProvider extends AbstractEquipmentProvider {

    public ModEquipmentProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addEquipment() {
        this.addClothingLayer(ModEquipmentAssets.ARMORER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.BUTCHER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.CARTOGRAPHER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.CLERIC_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.FARMER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.FISHERMAN_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.FLETCHER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.LEATHERWORKER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.LIBRARIAN_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.MASON_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.NITWIT_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.SHEPHERD_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.TOOLSMITH_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.WEAPONSMITH_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.LEGACY_FARMER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.LEGACY_LIBRARIAN_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.LEGACY_NITWIT_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.LEGACY_PRIEST_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.WANDERING_TRADER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.IRON_GOLEM_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.EVOKER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.PILLAGER_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.VINDICATOR_EQUIPMENT_ASSET);
        this.addClothingLayer(ModEquipmentAssets.WITCH_EQUIPMENT_ASSET);
        this.addHatLayer(ModEquipmentAssets.WITCH_HAT_EQUIPMENT_ASSET, ModModelLayers.WITCH_HAT_LAYER_TYPE);
        this.addClothingLayer(ModEquipmentAssets.SANTA_EQUIPMENT_ASSET);
        this.addHatLayer(ModEquipmentAssets.SANTA_HAT_EQUIPMENT_ASSET, ModModelLayers.SANTA_HAT_LAYER_TYPE);
    }

    public final void addClothingLayer(ResourceKey<EquipmentAsset> resourceKey) {
        ResourceLocation resourceLocation = resourceKey.location();
        this.unconditional(resourceLocation,
                EquipmentClientInfo.builder()
                        .addLayers(ModModelLayers.CLOTHING_LAYER_TYPE,
                                new EquipmentClientInfo.Layer(VillageMasquerade.id(resourceLocation.getPath())))
                        .build());
    }

    public final void addHatLayer(ResourceKey<EquipmentAsset> resourceKey, EquipmentClientInfo.LayerType layerType) {
        this.unconditional(resourceKey.location(),
                EquipmentClientInfo.builder()
                        .addLayers(layerType, new EquipmentClientInfo.Layer(VillageMasquerade.id("hat")))
                        .build());
    }
}
