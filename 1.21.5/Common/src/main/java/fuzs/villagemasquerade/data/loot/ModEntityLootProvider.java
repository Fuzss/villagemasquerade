package fuzs.villagemasquerade.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModLootTables;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.predicates.LootItemKilledByPlayerCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceWithEnchantedBonusCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModEntityLootProvider extends AbstractLootProvider.Simple {

    public ModEntityLootProvider(DataProviderContext context) {
        super(LootContextParamSets.ENTITY, context);
    }

    @Override
    public void addLootTables() {
        this.add(ModLootTables.EVOKER_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModRegistry.EVOKER_ROBE_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.EVOKER_LEGGINGS_ITEM.value()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries(),
                                        0.025F,
                                        0.01F))));
        this.add(ModLootTables.VINDICATOR_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModRegistry.VINDICATOR_JACKET_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.VINDICATOR_LEGGINGS_ITEM.value()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries(),
                                        0.025F,
                                        0.01F))));
        this.add(ModLootTables.PILLAGER_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModRegistry.PILLAGER_JACKET_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.PILLAGER_LEGGINGS_ITEM.value()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries(),
                                        0.025F,
                                        0.01F))));
        this.add(ModLootTables.WITCH_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModRegistry.WITCH_HAT_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.WITCH_ROBE_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.WITCH_LEGGINGS_ITEM.value()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries(),
                                        0.025F,
                                        0.01F))));
        this.add(ModLootTables.IRON_GOLEM_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModRegistry.IRON_GOLEM_ROBE_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.IRON_GOLEM_LEGGINGS_ITEM.value()))
                                .when(LootItemKilledByPlayerCondition.killedByPlayer())
                                .when(LootItemRandomChanceWithEnchantedBonusCondition.randomChanceAndLootingBoost(this.registries(),
                                        0.025F,
                                        0.01F))));
    }
}
