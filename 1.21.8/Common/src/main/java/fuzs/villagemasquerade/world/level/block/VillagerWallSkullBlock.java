package fuzs.villagemasquerade.world.level.block;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;
import net.minecraft.world.level.block.WallSkullBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Map;

public class VillagerWallSkullBlock extends WallSkullBlock {
    public static final MapCodec<VillagerWallSkullBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
            SkullBlock.Type.CODEC.fieldOf("kind").forGetter(AbstractSkullBlock::getType),
            propertiesCodec()).apply(instance, VillagerWallSkullBlock::new));
    private static final Map<Direction, VoxelShape> SHAPES = Shapes.rotateHorizontal(Block.boxZ(8.0,
            4.0,
            14.0,
            8.0,
            16.0));

    public VillagerWallSkullBlock(SkullBlock.Type type, BlockBehaviour.Properties properties) {
        super(type, properties);
    }

    @Override
    public MapCodec<? extends WallSkullBlock> codec() {
        return CODEC;
    }

    @Override
    protected VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES.get(state.getValue(FACING));
    }
}
