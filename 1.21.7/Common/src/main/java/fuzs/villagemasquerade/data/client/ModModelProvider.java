package fuzs.villagemasquerade.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.api.client.data.v2.models.ModelLocationHelper;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModBlocks;
import fuzs.villagemasquerade.init.ModItems;
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
        this.createHead(ModBlocks.VILLAGER_HEAD_BLOCK.value(),
                ModBlocks.VILLAGER_WALL_HEAD_BLOCK.value(),
                ModRegistry.VILLAGER_SKULL_TYPE,
                blockModelGenerators);
        this.createHead(ModBlocks.IRON_GOLEM_HEAD_BLOCK.value(),
                ModBlocks.IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                ModRegistry.IRON_GOLEM_SKULL_TYPE,
                blockModelGenerators);
        this.createHead(ModBlocks.ILLAGER_HEAD_BLOCK.value(),
                ModBlocks.ILLAGER_WALL_HEAD_BLOCK.value(),
                ModRegistry.ILLAGER_SKULL_TYPE,
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
        itemModelGenerators.generateFlatItem(ModItems.ARMORER_GOGGLES_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.ARMORER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BUTCHER_HEADBAND_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.BUTCHER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CARTOGRAPHER_MONOCLE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CARTOGRAPHER_HARNESS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CLERIC_COLLAR_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.CLERIC_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FARMER_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FARMER_BELT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FISHERMAN_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FISHERMAN_VEST_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FISHERMAN_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLETCHER_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.FLETCHER_BELT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEATHERWORKER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LIBRARIAN_HEADWEAR_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LIBRARIAN_TOGA_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.MASON_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NITWIT_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.NITWIT_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHEPHERD_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SHEPHERD_VEST_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.TOOLSMITH_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WEAPONSMITH_EYEPATCH_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WEAPONSMITH_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_FARMER_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_FARMER_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_LIBRARIAN_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_LIBRARIAN_LEGGINGS_ITEM.value(),
                ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_NITWIT_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_NITWIT_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_PRIEST_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.LEGACY_PRIEST_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WANDERING_TRADER_HOOD_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WANDERING_TRADER_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WANDERING_TRADER_LEGGINGS_ITEM.value(),
                ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_GOLEM_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.IRON_GOLEM_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EVOKER_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.EVOKER_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PILLAGER_JACKET_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.PILLAGER_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VINDICATOR_JACKET_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.VINDICATOR_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WITCH_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WITCH_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.WITCH_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SANTA_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SANTA_COAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModItems.SANTA_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
    }
}
