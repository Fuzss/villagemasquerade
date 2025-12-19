package fuzs.villagemasquerade.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractEquipmentProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.model.geom.ModModelLayers;
import fuzs.villagemasquerade.init.ModEquipmentAssets;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.EquipmentAsset;

import java.util.function.BiConsumer;

public class ModEquipmentProvider extends AbstractEquipmentProvider {

    public ModEquipmentProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addEquipmentAssets(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssetConsumer) {
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.ARMORER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.BUTCHER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.CARTOGRAPHER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.CLERIC_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.FARMER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.FISHERMAN_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.FLETCHER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.LEATHERWORKER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.LIBRARIAN_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.MASON_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.NITWIT_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.SHEPHERD_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.TOOLSMITH_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.WEAPONSMITH_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.LEGACY_FARMER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.LEGACY_LIBRARIAN_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.LEGACY_NITWIT_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.LEGACY_PRIEST_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.WANDERING_TRADER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.IRON_GOLEM_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.EVOKER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.PILLAGER_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.VINDICATOR_EQUIPMENT_ASSET);
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.WITCH_EQUIPMENT_ASSET);
        equipmentAssetConsumer.accept(ModEquipmentAssets.WITCH_HAT_EQUIPMENT_ASSET,
                simple(ModModelLayers.WITCH_HAT_LAYER_TYPE, VillageMasquerade.id("hat")));
        this.addClothingLayer(equipmentAssetConsumer, ModEquipmentAssets.SANTA_EQUIPMENT_ASSET);
        equipmentAssetConsumer.accept(ModEquipmentAssets.SANTA_HAT_EQUIPMENT_ASSET,
                simple(ModModelLayers.SANTA_HAT_LAYER_TYPE, VillageMasquerade.id("hat")));
    }

    public final void addClothingLayer(BiConsumer<ResourceKey<EquipmentAsset>, EquipmentClientInfo> equipmentAssetConsumer, ResourceKey<EquipmentAsset> resourceKey) {
        equipmentAssetConsumer.accept(resourceKey,
                simple(ModModelLayers.CLOTHING_LAYER_TYPE, VillageMasquerade.id(resourceKey.identifier().getPath())));
    }
}
