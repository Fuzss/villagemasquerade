package fuzs.villagemasquerade.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractModelProvider;
import fuzs.puzzleslib.api.client.data.v2.models.ItemModelGenerationHelper;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.model.ModelTemplates;

public class ModModelProvider extends AbstractModelProvider {

    public ModModelProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addBlockModels(BlockModelGenerators blockModelGenerators) {
        ItemModelGenerationHelper.createHead(ModRegistry.VILLAGER_HEAD_BLOCK.value(),
                ModRegistry.VILLAGER_WALL_HEAD_BLOCK.value(),
                ModRegistry.VILLAGER_SKULL_TYPE,
                blockModelGenerators);
        ItemModelGenerationHelper.createHead(ModRegistry.IRON_GOLEM_HEAD_BLOCK.value(),
                ModRegistry.IRON_GOLEM_WALL_HEAD_BLOCK.value(),
                ModRegistry.IRON_GOLEM_SKULL_TYPE,
                blockModelGenerators);
    }

    @Override
    public void addItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModRegistry.ARMORER_GOGGLES_ITEM.value(), ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(ModRegistry.ARMORER_APRON_ITEM.value(), ModelTemplates.FLAT_ITEM);
    }
}
