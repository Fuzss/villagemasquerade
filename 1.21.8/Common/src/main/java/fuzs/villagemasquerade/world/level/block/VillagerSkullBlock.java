package fuzs.villagemasquerade.world.level.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class VillagerSkullBlock extends SkullBlock {
    public static final MapCodec<VillagerSkullBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            SkullBlock.Type.CODEC.fieldOf("kind").forGetter(AbstractSkullBlock::getType),
            propertiesCodec()).apply(instance, VillagerSkullBlock::new));
    private static final VoxelShape SHAPE = Block.column(8.0, 0.0, 10.0);

    public VillagerSkullBlock(Type type, Properties properties) {
        super(type, properties);
    }

    @Override
    public MapCodec<? extends SkullBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
