package fuzs.villagemasquerade.init;

import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;

public class ModItems {
    public static final Holder.Reference<Item> ARMORER_GOGGLES_ITEM = ModRegistry.REGISTRIES.registerItem(
            "armorer_goggles",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.ARMORER_EQUIPMENT_ASSET,
                    VillagerProfession.ARMORER));
    public static final Holder.Reference<Item> ARMORER_APRON_ITEM = ModRegistry.REGISTRIES.registerItem("armorer_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.ARMORER_EQUIPMENT_ASSET,
                    VillagerProfession.ARMORER));
    public static final Holder.Reference<Item> BUTCHER_HEADBAND_ITEM = ModRegistry.REGISTRIES.registerItem(
            "butcher_headband",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.BUTCHER_EQUIPMENT_ASSET,
                    VillagerProfession.BUTCHER));
    public static final Holder.Reference<Item> BUTCHER_APRON_ITEM = ModRegistry.REGISTRIES.registerItem("butcher_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.BUTCHER_EQUIPMENT_ASSET,
                    VillagerProfession.BUTCHER));
    public static final Holder.Reference<Item> CARTOGRAPHER_MONOCLE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "cartographer_monocle",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.CARTOGRAPHER_EQUIPMENT_ASSET,
                    VillagerProfession.CARTOGRAPHER));
    public static final Holder.Reference<Item> CARTOGRAPHER_HARNESS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "cartographer_harness",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.CARTOGRAPHER_EQUIPMENT_ASSET,
                    VillagerProfession.CARTOGRAPHER));
    public static final Holder.Reference<Item> CLERIC_COLLAR_ITEM = ModRegistry.REGISTRIES.registerItem("cleric_collar",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.CLERIC_EQUIPMENT_ASSET,
                    VillagerProfession.CLERIC));
    public static final Holder.Reference<Item> CLERIC_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem("cleric_robe",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.CLERIC_EQUIPMENT_ASSET,
                    VillagerProfession.CLERIC));
    public static final Holder.Reference<Item> FARMER_HAT_ITEM = ModRegistry.REGISTRIES.registerItem("farmer_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.FARMER_EQUIPMENT_ASSET,
                    VillagerProfession.FARMER));
    public static final Holder.Reference<Item> FARMER_BELT_ITEM = ModRegistry.REGISTRIES.registerItem("farmer_belt",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.FARMER_EQUIPMENT_ASSET,
                    VillagerProfession.FARMER));
    public static final Holder.Reference<Item> FISHERMAN_HAT_ITEM = ModRegistry.REGISTRIES.registerItem("fisherman_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.FISHERMAN_EQUIPMENT_ASSET,
                    VillagerProfession.FISHERMAN));
    public static final Holder.Reference<Item> FISHERMAN_VEST_ITEM = ModRegistry.REGISTRIES.registerItem(
            "fisherman_vest",
            () -> villagerClothingProperties(EquipmentSlot.BODY,
                    ModEquipmentAssets.FISHERMAN_EQUIPMENT_ASSET,
                    VillagerProfession.FISHERMAN));
    public static final Holder.Reference<Item> FISHERMAN_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "fisherman_leggings",
            () -> villagerClothingProperties(EquipmentSlot.LEGS,
                    ModEquipmentAssets.FISHERMAN_EQUIPMENT_ASSET,
                    VillagerProfession.FISHERMAN));
    public static final Holder.Reference<Item> FLETCHER_HAT_ITEM = ModRegistry.REGISTRIES.registerItem("fletcher_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.FLETCHER_EQUIPMENT_ASSET,
                    VillagerProfession.FLETCHER));
    public static final Holder.Reference<Item> FLETCHER_BELT_ITEM = ModRegistry.REGISTRIES.registerItem("fletcher_belt",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.FLETCHER_EQUIPMENT_ASSET,
                    VillagerProfession.FLETCHER));
    public static final Holder.Reference<Item> LEATHERWORKER_APRON_ITEM = ModRegistry.REGISTRIES.registerItem(
            "leatherworker_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.LEATHERWORKER_EQUIPMENT_ASSET,
                    VillagerProfession.LEATHERWORKER));
    public static final Holder.Reference<Item> LIBRARIAN_HEADWEAR_ITEM = ModRegistry.REGISTRIES.registerItem(
            "librarian_headwear",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.LIBRARIAN_EQUIPMENT_ASSET,
                    VillagerProfession.LIBRARIAN));
    public static final Holder.Reference<Item> LIBRARIAN_TOGA_ITEM = ModRegistry.REGISTRIES.registerItem(
            "librarian_toga",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.LIBRARIAN_EQUIPMENT_ASSET,
                    VillagerProfession.LIBRARIAN));
    public static final Holder.Reference<Item> MASON_APRON_ITEM = ModRegistry.REGISTRIES.registerItem("mason_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.MASON_EQUIPMENT_ASSET,
                    VillagerProfession.MASON));
    public static final Holder.Reference<Item> NITWIT_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem("nitwit_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.NITWIT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> NITWIT_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "nitwit_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.NITWIT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SHEPHERD_HAT_ITEM = ModRegistry.REGISTRIES.registerItem("shepherd_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.SHEPHERD_EQUIPMENT_ASSET,
                    VillagerProfession.SHEPHERD));
    public static final Holder.Reference<Item> SHEPHERD_VEST_ITEM = ModRegistry.REGISTRIES.registerItem("shepherd_vest",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.SHEPHERD_EQUIPMENT_ASSET,
                    VillagerProfession.SHEPHERD));
    public static final Holder.Reference<Item> TOOLSMITH_APRON_ITEM = ModRegistry.REGISTRIES.registerItem(
            "toolsmith_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.TOOLSMITH_EQUIPMENT_ASSET,
                    VillagerProfession.TOOLSMITH));
    public static final Holder.Reference<Item> WEAPONSMITH_EYEPATCH_ITEM = ModRegistry.REGISTRIES.registerItem(
            "weaponsmith_eyepatch",
            () -> villagerClothingProperties(EquipmentSlot.HEAD,
                    ModEquipmentAssets.WEAPONSMITH_EQUIPMENT_ASSET,
                    VillagerProfession.WEAPONSMITH));
    public static final Holder.Reference<Item> WEAPONSMITH_APRON_ITEM = ModRegistry.REGISTRIES.registerItem(
            "weaponsmith_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST,
                    ModEquipmentAssets.WEAPONSMITH_EQUIPMENT_ASSET,
                    VillagerProfession.WEAPONSMITH));
    public static final Holder.Reference<Item> VILLAGER_HEAD_ITEM = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.VILLAGER_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    ModBlocks.VILLAGER_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().stacksTo(1)
                    .equippable(EquipmentSlot.HEAD)
                    .component(DataComponents.NOTE_BLOCK_SOUND, SoundEvents.VILLAGER_AMBIENT.location()));
    public static final Holder.Reference<Item> LEGACY_FARMER_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_farmer_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.LEGACY_FARMER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_FARMER_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_farmer_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.LEGACY_FARMER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_LIBRARIAN_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_librarian_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.LEGACY_LIBRARIAN_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_LIBRARIAN_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_librarian_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.LEGACY_LIBRARIAN_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_NITWIT_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_nitwit_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.LEGACY_NITWIT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_NITWIT_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_nitwit_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.LEGACY_NITWIT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_PRIEST_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_priest_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.LEGACY_PRIEST_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_PRIEST_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "legacy_priest_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.LEGACY_PRIEST_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WANDERING_TRADER_HOOD_ITEM = ModRegistry.REGISTRIES.registerItem(
            "wandering_trader_hood",
            () -> clothingProperties(EquipmentSlot.HEAD, ModEquipmentAssets.WANDERING_TRADER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WANDERING_TRADER_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "wandering_trader_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.WANDERING_TRADER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WANDERING_TRADER_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "wandering_trader_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.WANDERING_TRADER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> IRON_GOLEM_HEAD_ITEM = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.IRON_GOLEM_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    ModBlocks.IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().stacksTo(1)
                    .equippable(EquipmentSlot.HEAD)
                    .attributes(createIronGolemAttributes(ArmorType.HELMET)));
    public static final Holder.Reference<Item> IRON_GOLEM_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem(
            "iron_golem_chestplate",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.IRON_GOLEM_EQUIPMENT_ASSET).attributes(
                    createIronGolemAttributes(ArmorType.CHESTPLATE)));
    public static final Holder.Reference<Item> IRON_GOLEM_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "iron_golem_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.IRON_GOLEM_EQUIPMENT_ASSET).attributes(
                    createIronGolemAttributes(ArmorType.LEGGINGS)));
    public static final Holder.Reference<Item> ILLAGER_HEAD_ITEM = ModRegistry.REGISTRIES.registerBlockItem(ModBlocks.ILLAGER_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    ModBlocks.ILLAGER_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().stacksTo(1)
                    .equippable(EquipmentSlot.HEAD)
                    .component(DataComponents.NOTE_BLOCK_SOUND, SoundEvents.PILLAGER_AMBIENT.location()));
    public static final Holder.Reference<Item> EVOKER_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem("evoker_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.EVOKER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> EVOKER_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "evoker_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.EVOKER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> PILLAGER_JACKET_ITEM = ModRegistry.REGISTRIES.registerItem(
            "pillager_jacket",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.PILLAGER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> PILLAGER_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "pillager_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.PILLAGER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> VINDICATOR_JACKET_ITEM = ModRegistry.REGISTRIES.registerItem(
            "vindicator_jacket",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.VINDICATOR_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> VINDICATOR_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "vindicator_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.VINDICATOR_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WITCH_HAT_ITEM = ModRegistry.REGISTRIES.registerItem("witch_hat",
            () -> clothingProperties(EquipmentSlot.HEAD, ModEquipmentAssets.WITCH_HAT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WITCH_ROBE_ITEM = ModRegistry.REGISTRIES.registerItem("witch_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.WITCH_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WITCH_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "witch_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.WITCH_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SANTA_HAT_ITEM = ModRegistry.REGISTRIES.registerItem("santa_hat",
            () -> clothingProperties(EquipmentSlot.HEAD, ModEquipmentAssets.SANTA_HAT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SANTA_COAT_ITEM = ModRegistry.REGISTRIES.registerItem("santa_coat",
            () -> clothingProperties(EquipmentSlot.CHEST, ModEquipmentAssets.SANTA_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SANTA_LEGGINGS_ITEM = ModRegistry.REGISTRIES.registerItem(
            "santa_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, ModEquipmentAssets.SANTA_EQUIPMENT_ASSET));


    public static void bootstrap() {
        // NO-OP
    }

    private static Item.Properties villagerClothingProperties(EquipmentSlot equipmentSlot, ResourceKey<EquipmentAsset> resourceKey, ResourceKey<VillagerProfession> villagerProfession) {
        return clothingProperties(equipmentSlot,
                resourceKey).component(ModRegistry.VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value(), villagerProfession);
    }

    private static Item.Properties clothingProperties(EquipmentSlot equipmentSlot, ResourceKey<EquipmentAsset> resourceKey) {
        return new Item.Properties().stacksTo(1)
                .component(DataComponents.EQUIPPABLE, Equippable.builder(equipmentSlot).setAsset(resourceKey).build());
    }

    private static ItemAttributeModifiers createIronGolemAttributes(ArmorType armorType) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(armorType.getSlot());
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace("clothing." + armorType.getName());
        builder.add(Attributes.ATTACK_DAMAGE,
                new AttributeModifier(resourceLocation, 1.0, AttributeModifier.Operation.ADD_VALUE),
                equipmentSlotGroup);
        builder.add(Attributes.KNOCKBACK_RESISTANCE,
                new AttributeModifier(resourceLocation, 0.3, AttributeModifier.Operation.ADD_VALUE),
                equipmentSlotGroup);
        return builder.build();
    }
}
