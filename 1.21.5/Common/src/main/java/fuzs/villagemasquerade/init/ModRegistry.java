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
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.*;
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
    static final RegistryManager REGISTRIES = RegistryManager.from(VillageMasquerade.MOD_ID);
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
    public static final Holder.Reference<Item> VILLAGER_HEAD_ITEM = REGISTRIES.registerBlockItem(VILLAGER_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    VILLAGER_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().rarity(Rarity.UNCOMMON)
                    .equippableUnswappable(EquipmentSlot.HEAD)
                    .component(DataComponents.NOTE_BLOCK_SOUND, SoundEvents.VILLAGER_AMBIENT.location()));
    public static final Holder.Reference<Item> IRON_GOLEM_HEAD_ITEM = REGISTRIES.registerBlockItem(IRON_GOLEM_HEAD_BLOCK,
            (Block block, Item.Properties properties) -> new StandingAndWallBlockItem(block,
                    IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                    Direction.DOWN,
                    properties),
            () -> new Item.Properties().rarity(Rarity.UNCOMMON).equippableUnswappable(EquipmentSlot.HEAD));
    public static final Holder.Reference<Item> ARMORER_GOGGLES_ITEM = REGISTRIES.registerItem("armorer_goggles",
            () -> villagerClothingProperties(EquipmentSlot.HEAD, VillagerProfession.ARMORER));
    public static final Holder.Reference<Item> ARMORER_APRON_ITEM = REGISTRIES.registerItem("armorer_apron",
            () -> villagerClothingProperties(EquipmentSlot.CHEST, VillagerProfession.ARMORER));
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(
            ARMORER_GOGGLES_ITEM);

    static final TagFactory TAGS = TagFactory.make(VillageMasquerade.MOD_ID);
    public static final TagKey<Item> CLOTHING_ITEM_TAG = TAGS.registerItemTag("clothing");

    public static void bootstrap() {
        // NO-OP
    }

    static Item.Properties villagerClothingProperties(EquipmentSlot equipmentSlot, ResourceKey<VillagerProfession> resourceKey) {
        ResourceKey<EquipmentAsset> equipmentAssetKey = createEquipmentAssetKey(resourceKey);
        return new Item.Properties().stacksTo(1)
                .component(DataComponents.EQUIPPABLE,
                        Equippable.builder(equipmentSlot).setAsset(equipmentAssetKey).build())
                .component(VILLAGER_PROFESSION_DATA_COMPONENT_TYPE.value(), resourceKey);
    }

    public static ResourceKey<EquipmentAsset> createEquipmentAssetKey(ResourceKey<VillagerProfession> resourceKey) {
        return REGISTRIES.makeResourceKey(EquipmentAssets.ROOT_ID, resourceKey.location().getPath());
    }

    public static VillagerTrades.ItemListing createItemListing(Holder<Item> item) {
        EquipmentSlot equipmentSlot;
        if (item.value().components().has(DataComponents.EQUIPPABLE)) {
            equipmentSlot = item.value().components().get(DataComponents.EQUIPPABLE).slot();
        } else {
            equipmentSlot = null;
        }
        if (equipmentSlot != null && equipmentSlot.getType() == EquipmentSlot.Type.HUMANOID_ARMOR) {
            return new VillagerTrades.ItemsForEmeralds(new ItemStack(item),
                    getPriceForPiece(equipmentSlot),
                    1,
                    1,
                    30,
                    0.2F);
        } else {
            throw new IllegalArgumentException("No armor: " + item);
        }
    }

    static int getPriceForPiece(EquipmentSlot equipmentSlot) {
        return switch (equipmentSlot) {
            case FEET, HEAD -> 8;
            case CHEST -> 16;
            case LEGS -> 12;
            default -> throw new IllegalArgumentException();
        };
    }
}
