package fuzs.villagemasquerade.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.api.client.data.v2.models.ModelLocationHelper;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SkullBlock;

public class ModModelProvider extends AbstractModelProvider {

    public ModModelProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBlockModels(BlockModelGenerators blockModelGenerators) {
        this.createHead(ModRegistry.VILLAGER_HEAD_BLOCK.value(),
                ModRegistry.VILLAGER_WALL_HEAD_BLOCK.value(),
                ModRegistry.VILLAGER_SKULL_TYPE,
                blockModelGenerators);
        this.createHead(ModRegistry.IRON_GOLEM_HEAD_BLOCK.value(),
                ModRegistry.IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                ModRegistry.IRON_GOLEM_SKULL_TYPE,
                blockModelGenerators);
    }

    public final void createHead(Block headBlock, Block wallHeadBlock, SkullBlock.Type type, BlockModelGenerators blockModelGenerators) {
        MultiVariant multiVariant = BlockModelGenerators.plainVariant(ModelLocationHelper.getBlockModel(
                ResourceLocationHelper.withDefaultNamespace("skull")));
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(headBlock, multiVariant));
        blockModelGenerators.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(wallHeadBlock,
                multiVariant));
        blockModelGenerators.registerSimpleFlatItemModel(headBlock.asItem());
    }

    @Override
    public void addItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModRegistry.ARMORER_GOGGLES_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.ARMORER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FARMER_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FARMER_BELT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SHEPHERD_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SHEPHERD_VEST_ITEM.value(), ModelTemplates.FLAT_ITEM);
    }
}
