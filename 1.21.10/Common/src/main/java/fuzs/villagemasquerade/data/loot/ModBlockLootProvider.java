package fuzs.villagemasquerade.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModBlocks;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        this.add(ModBlocks.VILLAGER_HEAD_BLOCK.value(), this::createHeadDrop);
        this.add(ModBlocks.IRON_GOLEM_HEAD_BLOCK.value(), this::createHeadDrop);
        this.add(ModBlocks.ILLAGER_HEAD_BLOCK.value(), this::createHeadDrop);
    }
}
