package fuzs.villagemasquerade.init;

import fuzs.puzzleslib.api.init.v3.registry.ContentRegistrationHelper;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.world.level.block.VillagerSkullBlock;
import fuzs.villagemasquerade.world.level.block.VillagerWallSkullBlock;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.Equippable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

public class ModRegistry {
    public static final SkullBlock.Type VILLAGER_SKULL_TYPE = ContentRegistrationHelper.registerSkullBlockType(
            VillageMasquerade.id("villager"));
    public static final SkullBlock.Type IRON_GOLEM_SKULL_TYPE = ContentRegistrationHelper.registerSkullBlockType(
            VillageMasquerade.id("iron_golem"));
    public static final SkullBlock.Type ILLAGER_SKULL_TYPE = ContentRegistrationHelper.registerSkullBlockType(
            VillageMasquerade.id("illager_golem"));
    static final RegistryManager REGISTRIES = RegistryManager.from(VillageMasquerade.MOD_ID);
    public static final ResourceKey<EquipmentAsset> LEGACY_FARMER_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_farmer");
    public static final ResourceKey<EquipmentAsset> LEGACY_LIBRARIAN_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_librarian");
    public static final ResourceKey<EquipmentAsset> LEGACY_NITWIT_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_nitwit");
    public static final ResourceKey<EquipmentAsset> LEGACY_PRIEST_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "legacy_priest");
    public static final ResourceKey<EquipmentAsset> WANDERING_TRADER_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "wandering_trader");
    public static final ResourceKey<EquipmentAsset> IRON_GOLEM_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "iron_golem");
    public static final ResourceKey<EquipmentAsset> EVOKER_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(EquipmentAssets.ROOT_ID,
            "evoker");
    public static final ResourceKey<EquipmentAsset> PILLAGER_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "pillager");
    public static final ResourceKey<EquipmentAsset> VINDICATOR_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(
            EquipmentAssets.ROOT_ID,
            "vindicator");
    public static final ResourceKey<EquipmentAsset> WITCH_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(EquipmentAssets.ROOT_ID,
            "witch");
    public static final ResourceKey<EquipmentAsset> SANTA_EQUIPMENT_ASSET = REGISTRIES.makeResourceKey(EquipmentAssets.ROOT_ID,
            "santa");
    public static final Holder.Reference<DataComponentType<ResourceKey<VillagerProfession>>> VILLAGER_PROFESSION_DATA_COMPONENT_TYPE = REGISTRIES.registerDataComponentType(
            "villager/profession",
            (DataComponentType.Builder<ResourceKey<VillagerProfession>> builder) -> builder.persistent(ResourceKey.codec(
                            Registries.VILLAGER_PROFESSION))
                    .networkSynchronized(ResourceKey.streamCodec(Registries.VILLAGER_PROFESSION)));
    public static final Holder.Reference<Block> VILLAGER_HEAD_BLOCK = REGISTRIES.registerBlock("villager_head",
            properties -> new VillagerSkullBlock(VILLAGER_SKULL_TYPE, properties),
            () -> BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.CUSTOM_HEAD)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> VILLAGER_WALL_HEAD_BLOCK = REGISTRIES.registerBlock("villager_wall_head",
            properties -> new VillagerWallSkullBlock(VILLAGER_SKULL_TYPE, properties),
            () -> Blocks.wallVariant(VILLAGER_HEAD_BLOCK.value(), true)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> IRON_GOLEM_HEAD_BLOCK = REGISTRIES.registerBlock("iron_golem_head",
            properties -> new VillagerSkullBlock(IRON_GOLEM_SKULL_TYPE, properties),
            () -> BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.CUSTOM_HEAD)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> IRON_GOLEM_WALL_HEAD_BLOCK = REGISTRIES.registerBlock(
            "iron_golem_wall_head",
            properties -> new VillagerWallSkullBlock(IRON_GOLEM_SKULL_TYPE, properties),
            () -> Blocks.wallVariant(IRON_GOLEM_HEAD_BLOCK.value(), true)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> ILLAGER_HEAD_BLOCK = REGISTRIES.registerBlock("illager_head",
            properties -> new VillagerSkullBlock(ILLAGER_SKULL_TYPE, properties),
            () -> BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.CUSTOM_HEAD)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> ILLAGER_WALL_HEAD_BLOCK = REGISTRIES.registerBlock("illager_wall_head",
            properties -> new VillagerWallSkullBlock(ILLAGER_SKULL_TYPE, properties),
            () -> Blocks.wallVariant(ILLAGER_HEAD_BLOCK.value(), true)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Item> ARMORER_GOGGLES_ITEM = REGISTRIES.registerItem("armorer_goggles",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.ARMORER));
    public static final Holder.Reference<Item> ARMORER_APRON_ITEM = REGISTRIES.registerItem("armorer_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.ARMORER));
    public static final Holder.Reference<Item> BUTCHER_HEADBAND_ITEM = REGISTRIES.registerItem("butcher_headband",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.BUTCHER));
    public static final Holder.Reference<Item> BUTCHER_APRON_ITEM = REGISTRIES.registerItem("butcher_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.BUTCHER));
    public static final Holder.Reference<Item> CARTOGRAPHER_MONOCLE_ITEM = REGISTRIES.registerItem(
            "cartographer_monocle",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.CARTOGRAPHER));
    public static final Holder.Reference<Item> CARTOGRAPHER_HARNESS_ITEM = REGISTRIES.registerItem(
            "cartographer_harness",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.CARTOGRAPHER));
    public static final Holder.Reference<Item> CLERIC_COLLAR_ITEM = REGISTRIES.registerItem("cleric_collar",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.BUTCHER));
    public static final Holder.Reference<Item> CLERIC_ROBE_ITEM = REGISTRIES.registerItem("cleric_robe",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.BUTCHER));
    public static final Holder.Reference<Item> FARMER_HAT_ITEM = REGISTRIES.registerItem("farmer_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.FARMER));
    public static final Holder.Reference<Item> FARMER_BELT_ITEM = REGISTRIES.registerItem("farmer_belt",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.FARMER));
    public static final Holder.Reference<Item> FISHERMAN_HAT_ITEM = REGISTRIES.registerItem("fisherman_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.FISHERMAN));
    public static final Holder.Reference<Item> FISHERMAN_VEST_ITEM = REGISTRIES.registerItem("fisherman_vest",
            () -> villagerClothingProperties(EquipmentSlot.BODY, VillagerProfession.FISHERMAN));
    public static final Holder.Reference<Item> FISHERMAN_LEGGINGS_ITEM = REGISTRIES.registerItem("fisherman_leggings",
            () -> villagerClothingProperties(EquipmentSlot.LEGS, VillagerProfession.FISHERMAN));
    public static final Holder.Reference<Item> FLETCHER_HAT_ITEM = REGISTRIES.registerItem("fletcher_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.FLETCHER));
    public static final Holder.Reference<Item> FLETCHER_BELT_ITEM = REGISTRIES.registerItem("fletcher_belt",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.FLETCHER));
    public static final Holder.Reference<Item> LEATHERWORKER_APRON_ITEM = REGISTRIES.registerItem("leatherworker_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.LEATHERWORKER));
    public static final Holder.Reference<Item> LIBRARIAN_HEADWEAR_ITEM = REGISTRIES.registerItem("librarian_headwear",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.LIBRARIAN));
    public static final Holder.Reference<Item> LIBRARIAN_TOGA_ITEM = REGISTRIES.registerItem("librarian_toga",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.LIBRARIAN));
    public static final Holder.Reference<Item> MASON_APRON_ITEM = REGISTRIES.registerItem("mason_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.MASON));
    public static final Holder.Reference<Item> NITWIT_ROBE_ITEM = REGISTRIES.registerItem("nitwit_robe",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.NITWIT));
    public static final Holder.Reference<Item> NITWIT_LEGGINGS_ITEM = REGISTRIES.registerItem("nitwit_leggings",
            () -> villagerClothingProperties(EquipmentSlot.LEGS, VillagerProfession.NITWIT));
    public static final Holder.Reference<Item> SHEPHERD_HAT_ITEM = REGISTRIES.registerItem("shepherd_hat",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.SHEPHERD));
    public static final Holder.Reference<Item> SHEPHERD_VEST_ITEM = REGISTRIES.registerItem("shepherd_vest",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.SHEPHERD));
    public static final Holder.Reference<Item> TOOLSMITH_APRON_ITEM = REGISTRIES.registerItem("toolsmith_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.TOOLSMITH));
    public static final Holder.Reference<Item> WEAPONSMITH_EYEPATCH_ITEM = REGISTRIES.registerItem(
            "weaponsmith_eyepatch",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.WEAPONSMITH));
    public static final Holder.Reference<Item> WEAPONSMITH_APRON_ITEM = REGISTRIES.registerItem("weaponsmith_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.WEAPONSMITH));
    public static final Holder.Reference<Item> VILLAGER_HEAD_ITEM = REGISTRIES.registerBlockItem(VILLAGER_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    VILLAGER_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .equippableUnswappable(EquipmentSlot.HEAD)
                    .component(DataComponents.NOTE_BLOCK_SOUND, SoundEvents.VILLAGER_AMBIENT.location()));
    public static final Holder.Reference<Item> LEGACY_FARMER_ROBE_ITEM = REGISTRIES.registerItem("legacy_farmer_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, LEGACY_FARMER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_FARMER_LEGGINGS_ITEM = REGISTRIES.registerItem(
            "legacy_farmer_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, LEGACY_FARMER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_LIBRARIAN_ROBE_ITEM = REGISTRIES.registerItem(
            "legacy_librarian_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, LEGACY_LIBRARIAN_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_LIBRARIAN_LEGGINGS_ITEM = REGISTRIES.registerItem(
            "legacy_librarian_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, LEGACY_LIBRARIAN_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_NITWIT_ROBE_ITEM = REGISTRIES.registerItem("legacy_nitwit_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, LEGACY_NITWIT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_NITWIT_LEGGINGS_ITEM = REGISTRIES.registerItem(
            "legacy_nitwit_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, LEGACY_NITWIT_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_PRIEST_ROBE_ITEM = REGISTRIES.registerItem("legacy_priest_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, LEGACY_PRIEST_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> LEGACY_PRIEST_LEGGINGS_ITEM = REGISTRIES.registerItem(
            "legacy_priest_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, LEGACY_PRIEST_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WANDERING_TRADER_HOOD_ITEM = REGISTRIES.registerItem(
            "wandering_trader_hood",
            () -> clothingProperties(EquipmentSlot.HEAD, WANDERING_TRADER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WANDERING_TRADER_ROBE_ITEM = REGISTRIES.registerItem(
            "wandering_trader_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, WANDERING_TRADER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WANDERING_TRADER_LEGGINGS_ITEM = REGISTRIES.registerItem(
            "wandering_trader_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, WANDERING_TRADER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> IRON_GOLEM_HEAD_ITEM = REGISTRIES.registerBlockItem(IRON_GOLEM_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .equippableUnswappable(EquipmentSlot.HEAD)
                    .attributes(createAttributes(ArmorType.HELMET,
                            Attributes.KNOCKBACK_RESISTANCE,
                            0.3,
                            AttributeModifier.Operation.ADD_VALUE)));
    public static final Holder.Reference<Item> IRON_GOLEM_ROBE_ITEM = REGISTRIES.registerItem("iron_golem_chestplate",
            () -> clothingProperties(EquipmentSlot.CHEST, IRON_GOLEM_EQUIPMENT_ASSET).attributes(createAttributes(
                    ArmorType.CHESTPLATE,
                    Attributes.KNOCKBACK_RESISTANCE,
                    0.3,
                    AttributeModifier.Operation.ADD_VALUE)));
    public static final Holder.Reference<Item> IRON_GOLEM_LEGGINGS_ITEM = REGISTRIES.registerItem("iron_golem_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, IRON_GOLEM_EQUIPMENT_ASSET).attributes(createAttributes(
                    ArmorType.LEGGINGS,
                    Attributes.KNOCKBACK_RESISTANCE,
                    0.3,
                    AttributeModifier.Operation.ADD_VALUE)));
    public static final Holder.Reference<Item> ILLAGER_HEAD_ITEM = REGISTRIES.registerBlockItem(ILLAGER_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    ILLAGER_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().stacksTo(1)
                    .rarity(Rarity.UNCOMMON)
                    .equippableUnswappable(EquipmentSlot.HEAD)
                    .component(DataComponents.NOTE_BLOCK_SOUND, SoundEvents.PILLAGER_AMBIENT.location()));
    public static final Holder.Reference<Item> EVOKER_ROBE_ITEM = REGISTRIES.registerItem("evoker_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, EVOKER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> EVOKER_LEGGINGS_ITEM = REGISTRIES.registerItem("evoker_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, EVOKER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> PILLAGER_JACKET_ITEM = REGISTRIES.registerItem("pillager_jacket",
            () -> clothingProperties(EquipmentSlot.CHEST, PILLAGER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> PILLAGER_LEGGINGS_ITEM = REGISTRIES.registerItem("pillager_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, PILLAGER_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> VINDICATOR_JACKET_ITEM = REGISTRIES.registerItem("vindicator_jacket",
            () -> clothingProperties(EquipmentSlot.CHEST, VINDICATOR_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> VINDICATOR_LEGGINGS_ITEM = REGISTRIES.registerItem("vindicator_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, VINDICATOR_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WITCH_HAT_ITEM = REGISTRIES.registerItem("witch_hat",
            () -> clothingProperties(EquipmentSlot.HEAD, WITCH_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WITCH_ROBE_ITEM = REGISTRIES.registerItem("witch_robe",
            () -> clothingProperties(EquipmentSlot.CHEST, WITCH_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> WITCH_LEGGINGS_ITEM = REGISTRIES.registerItem("witch_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, WITCH_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SANTA_HAT_ITEM = REGISTRIES.registerItem("santa_hat",
            () -> clothingProperties(EquipmentSlot.HEAD, SANTA_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SANTA_COAT_ITEM = REGISTRIES.registerItem("santa_coat",
            () -> clothingProperties(EquipmentSlot.CHEST, SANTA_EQUIPMENT_ASSET));
    public static final Holder.Reference<Item> SANTA_LEGGINGS_ITEM = REGISTRIES.registerItem("santa_leggings",
            () -> clothingProperties(EquipmentSlot.LEGS, SANTA_EQUIPMENT_ASSET));
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(
            ARMORER_GOGGLES_ITEM);

    static final TagFactory TAGS = TagFactory.make(VillageMasquerade.MOD_ID);
    public static final TagKey<Item> HEAD_CLOTHING_ITEM_TAG = TAGS.registerItemTag("head_clothing");
    public static final TagKey<Item> CHEST_CLOTHING_ITEM_TAG = TAGS.registerItemTag("chest_clothing");
    public static final TagKey<Item> LEG_CLOTHING_ITEM_TAG = TAGS.registerItemTag("leg_clothing");

    public static void bootstrap() {
        // NO-OP
    }

    static Item.Properties villagerClothingProperties(EquipmentSlot equipmentSlot, ResourceKey<VillagerProfession> resourceKey) {
        return clothingProperties(equipmentSlot, createEquipmentAssetKey(resourceKey)).component(
                VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value(),
                resourceKey);
    }

    static Item.Properties clothingProperties(EquipmentSlot equipmentSlot, ResourceKey<EquipmentAsset> resourceKey) {
        return new Item.Properties().stacksTo(1)
                .component(DataComponents.EQUIPPABLE, Equippable.builder(equipmentSlot).setAsset(resourceKey).build());
    }

    public static ResourceKey<EquipmentAsset> createEquipmentAssetKey(ResourceKey<VillagerProfession> resourceKey) {
        return REGISTRIES.makeResourceKey(EquipmentAssets.ROOT_ID, resourceKey.location().getPath());
    }

    static ItemAttributeModifiers createAttributes(ArmorType armorType, Holder<Attribute> holder, double amount, AttributeModifier.Operation operation) {
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup equipmentSlotGroup = EquipmentSlotGroup.bySlot(armorType.getSlot());
        ResourceLocation resourceLocation = ResourceLocation.withDefaultNamespace("clothing." + armorType.getName());
        builder.add(holder, new AttributeModifier(resourceLocation, amount, operation), equipmentSlotGroup);
        return builder.build();
    }
}
