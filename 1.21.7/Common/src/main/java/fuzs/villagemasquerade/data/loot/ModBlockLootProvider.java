package fuzs.villagemasquerade.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModBlocks;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyComponentsFunction;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModBlockLootProvider extends AbstractLootProvider.Blocks {

    public ModBlockLootProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addLootTables() {
        // explosion condition is not applied on purpose; all vanilla heads are explosion-resistant
        this.add(ModBlocks.VILLAGER_HEAD_BLOCK.value(),
                (Block block) -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                .include(DataComponents.NOTE_BLOCK_SOUND)))
                                .unwrap()));
        this.add(ModBlocks.IRON_GOLEM_HEAD_BLOCK.value(),
                (Block block) -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block))
                                .unwrap()));
        this.add(ModBlocks.ILLAGER_HEAD_BLOCK.value(),
                (Block block) -> LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(block)
                                        .apply(CopyComponentsFunction.copyComponents(CopyComponentsFunction.Source.BLOCK_ENTITY)
                                                .include(DataComponents.NOTE_BLOCK_SOUND)))
                                .unwrap()));
    }
}
