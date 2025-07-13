package fuzs.villagemasquerade.data.loot;

import fuzs.puzzleslib.api.data.v2.AbstractLootProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.init.ModLootTables;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

public class ModChestLootProvider extends AbstractLootProvider.Simple {

    public ModChestLootProvider(DataProviderContext context) {
        super(LootContextParamSets.CHEST, context);
    }

    @Override
    public void addLootTables() {
        this.add(ModLootTables.VILLAGE_PLAINS_HOUSE_INJECTION, this.villageHouse());
        this.add(ModLootTables.VILLAGE_DESERT_HOUSE_INJECTION, this.villageHouse());
        this.add(ModLootTables.VILLAGE_SNOWY_HOUSE_INJECTION, this.villageHouse());
        this.add(ModLootTables.VILLAGE_TAIGA_HOUSE_INJECTION, this.villageHouse());
        this.add(ModLootTables.VILLAGE_SAVANNA_HOUSE_INJECTION, this.villageHouse());
        this.add(ModLootTables.IGLOO_CHEST_INJECTION,
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .setRolls(ConstantValue.exactly(1.0F))
                                .add(LootItem.lootTableItem(ModRegistry.SANTA_HAT_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.SANTA_COAT_ITEM.value()))
                                .add(LootItem.lootTableItem(ModRegistry.SANTA_LEGGINGS_ITEM.value()))
                                .add(EmptyLootItem.emptyItem().setWeight(3))));
    }

    public final LootTable.Builder villageHouse() {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_FARMER_ROBE_ITEM.value()))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_LIBRARIAN_ROBE_ITEM.value()))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_PRIEST_ROBE_ITEM.value()))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_NITWIT_ROBE_ITEM.value()))
                        .add(EmptyLootItem.emptyItem().setWeight(4)))
                .withPool(LootPool.lootPool()
                        .setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_FARMER_LEGGINGS_ITEM.value()))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_LIBRARIAN_LEGGINGS_ITEM.value()))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_PRIEST_LEGGINGS_ITEM.value()))
                        .add(LootItem.lootTableItem(ModRegistry.LEGACY_NITWIT_LEGGINGS_ITEM.value()))
                        .add(EmptyLootItem.emptyItem().setWeight(4)));
    }
}
