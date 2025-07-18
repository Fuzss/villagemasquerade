package fuzs.villagemasquerade.init;

import fuzs.villagemasquerade.world.level.block.VillagerSkullBlock;
import fuzs.villagemasquerade.world.level.block.VillagerWallSkullBlock;
import net.minecraft.core.Holder;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.BiConsumer;

public class ModBlocks {
    public static final Holder.Reference<Block> VILLAGER_HEAD_BLOCK = ModRegistry.REGISTRIES.registerBlock("villager_head",
            properties -> new VillagerSkullBlock(ModRegistry.VILLAGER_SKULL_TYPE, properties),
            () -> BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.CUSTOM_HEAD)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> VILLAGER_WALL_HEAD_BLOCK = ModRegistry.REGISTRIES.registerBlock("villager_wall_head",
            properties -> new VillagerWallSkullBlock(ModRegistry.VILLAGER_SKULL_TYPE, properties),
            () -> Blocks.wallVariant(VILLAGER_HEAD_BLOCK.value(), true)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> IRON_GOLEM_HEAD_BLOCK = ModRegistry.REGISTRIES.registerBlock("iron_golem_head",
            properties -> new VillagerSkullBlock(ModRegistry.IRON_GOLEM_SKULL_TYPE, properties),
            () -> BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.CUSTOM_HEAD)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> IRON_GOLEM_WALL_HEAD_BLOCK = ModRegistry.REGISTRIES.registerBlock(
            "iron_golem_wall_head",
            properties -> new VillagerWallSkullBlock(ModRegistry.IRON_GOLEM_SKULL_TYPE, properties),
            () -> Blocks.wallVariant(IRON_GOLEM_HEAD_BLOCK.value(), true)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> ILLAGER_HEAD_BLOCK = ModRegistry.REGISTRIES.registerBlock("illager_head",
            properties -> new VillagerSkullBlock(ModRegistry.ILLAGER_SKULL_TYPE, properties),
            () -> BlockBehaviour.Properties.of()
                    .instrument(NoteBlockInstrument.CUSTOM_HEAD)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));
    public static final Holder.Reference<Block> ILLAGER_WALL_HEAD_BLOCK = ModRegistry.REGISTRIES.registerBlock("illager_wall_head",
            properties -> new VillagerWallSkullBlock(ModRegistry.ILLAGER_SKULL_TYPE, properties),
            () -> Blocks.wallVariant(ILLAGER_HEAD_BLOCK.value(), true)
                    .strength(1.0F)
                    .pushReaction(PushReaction.DESTROY));

    public static void bootstrap() {
        // NO-OP
    }

    public static void onAddBlockEntityTypeBlocks(BiConsumer<BlockEntityType<?>, Block> consumer) {
        consumer.accept(BlockEntityType.SKULL, VILLAGER_HEAD_BLOCK.value());
        consumer.accept(BlockEntityType.SKULL, VILLAGER_WALL_HEAD_BLOCK.value());
        consumer.accept(BlockEntityType.SKULL, IRON_GOLEM_HEAD_BLOCK.value());
        consumer.accept(BlockEntityType.SKULL, IRON_GOLEM_WALL_HEAD_BLOCK.value());
        consumer.accept(BlockEntityType.SKULL, ILLAGER_HEAD_BLOCK.value());
        consumer.accept(BlockEntityType.SKULL, ILLAGER_WALL_HEAD_BLOCK.value());
    }
}
