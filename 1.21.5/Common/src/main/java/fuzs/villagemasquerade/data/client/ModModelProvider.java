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
        this.createHead(ModRegistry.ILLAGER_HEAD_BLOCK.value(),
                ModRegistry.ILLAGER_WALL_HEAD_BLOCK.value(),
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
        itemModelGenerators.generateFlatItem(ModRegistry.ARMORER_GOGGLES_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.ARMORER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.BUTCHER_HEADBAND_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.BUTCHER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.CARTOGRAPHER_MONOCLE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.CARTOGRAPHER_HARNESS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.CLERIC_COLLAR_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.CLERIC_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FARMER_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FARMER_BELT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FISHERMAN_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FISHERMAN_VEST_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FISHERMAN_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FLETCHER_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.FLETCHER_BELT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEATHERWORKER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LIBRARIAN_HEADWEAR_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LIBRARIAN_TOGA_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.MASON_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.NITWIT_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.NITWIT_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SHEPHERD_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SHEPHERD_VEST_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.TOOLSMITH_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WEAPONSMITH_EYEPATCH_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WEAPONSMITH_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_FARMER_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_FARMER_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_LIBRARIAN_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_LIBRARIAN_LEGGINGS_ITEM.value(),
                ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_NITWIT_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_NITWIT_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_PRIEST_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.LEGACY_PRIEST_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WANDERING_TRADER_HOOD_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WANDERING_TRADER_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WANDERING_TRADER_LEGGINGS_ITEM.value(),
                ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.IRON_GOLEM_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.IRON_GOLEM_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.EVOKER_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.EVOKER_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.PILLAGER_JACKET_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.PILLAGER_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.VINDICATOR_JACKET_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.VINDICATOR_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WITCH_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WITCH_ROBE_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.WITCH_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SANTA_HAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SANTA_COAT_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.SANTA_LEGGINGS_ITEM.value(), ModelTemplates.FLAT_ITEM);
    }
}
