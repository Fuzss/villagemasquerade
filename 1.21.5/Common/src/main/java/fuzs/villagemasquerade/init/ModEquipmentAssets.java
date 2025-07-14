package fuzs.villagemasquerade.init;

import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;

public class ModEquipmentAssets {
    public static final ResourceKey<EquipmentAsset> ARMORER_EQUIPMENT_ASSET = createEquipmentAssetKey(VillagerProfession.ARMORER);
    public static final ResourceKey<EquipmentAsset> BUTCHER_EQUIPMENT_ASSET = createEquipmentAssetKey(VillagerProfession.BUTCHER);
    public static final ResourceKey<EquipmentAsset> CARTOGRAPHER_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.CARTOGRAPHER);
    public static final ResourceKey<EquipmentAsset> CLERIC_EQUIPMENT_ASSET = createEquipmentAssetKey(VillagerProfession.CLERIC);
    public static final ResourceKey<EquipmentAsset> FARMER_EQUIPMENT_ASSET = createEquipmentAssetKey(VillagerProfession.FARMER);
    public static final ResourceKey<EquipmentAsset> FISHERMAN_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.FISHERMAN);
    public static final ResourceKey<EquipmentAsset> FLETCHER_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.FLETCHER);
    public static final ResourceKey<EquipmentAsset> LEATHERWORKER_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.LEATHERWORKER);
    public static final ResourceKey<EquipmentAsset> LIBRARIAN_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.LIBRARIAN);
    public static final ResourceKey<EquipmentAsset> MASON_EQUIPMENT_ASSET = createEquipmentAssetKey(VillagerProfession.MASON);
    public static final ResourceKey<EquipmentAsset> NITWIT_EQUIPMENT_ASSET = createEquipmentAssetKey(VillagerProfession.NITWIT);
    public static final ResourceKey<EquipmentAsset> SHEPHERD_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.SHEPHERD);
    public static final ResourceKey<EquipmentAsset> TOOLSMITH_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.TOOLSMITH);
    public static final ResourceKey<EquipmentAsset> WEAPONSMITH_EQUIPMENT_ASSET = createEquipmentAssetKey(
            VillagerProfession.WEAPONSMITH);
    public static final ResourceKey<EquipmentAsset> LEGACY_FARMER_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_farmer");
    public static final ResourceKey<EquipmentAsset> LEGACY_LIBRARIAN_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_librarian");
    public static final ResourceKey<EquipmentAsset> LEGACY_NITWIT_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_nitwit");
    public static final ResourceKey<EquipmentAsset> LEGACY_PRIEST_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_priest");
    public static final ResourceKey<EquipmentAsset> WANDERING_TRADER_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "wandering_trader");
    public static final ResourceKey<EquipmentAsset> IRON_GOLEM_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "iron_golem");
    public static final ResourceKey<EquipmentAsset> EVOKER_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "evoker");
    public static final ResourceKey<EquipmentAsset> PILLAGER_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "pillager");
    public static final ResourceKey<EquipmentAsset> VINDICATOR_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "vindicator");
    public static final ResourceKey<EquipmentAsset> WITCH_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "witch");
    public static final ResourceKey<EquipmentAsset> WITCH_HAT_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "witch_hat");
    public static final ResourceKey<EquipmentAsset> SANTA_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "santa");
    public static final ResourceKey<EquipmentAsset> SANTA_HAT_EQUIPMENT_ASSET = ModRegistry.REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "santa_hat");

    public static void bootstrap() {
        // NO-OP
    }

    private static ResourceKey<EquipmentAsset> createEquipmentAssetKey(ResourceKey<VillagerProfession> resourceKey) {
        return ModRegistry.REGISTRIES.makeResourceKey(EquipmentAssets.ROOT_ID, resourceKey.location().getPath());
    }
}
