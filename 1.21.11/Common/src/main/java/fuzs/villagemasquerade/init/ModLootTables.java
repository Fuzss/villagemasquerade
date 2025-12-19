package fuzs.villagemasquerade.init;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.NestedLootTable;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;

import java.util.HashMap;
import java.util.Map;

public class ModLootTables {
    static final Map<Identifier, ResourceKey<LootTable>> LOOT_TABLE_INJECTIONS = new HashMap<>();
    public static final ResourceKey<LootTable> IGLOO_CHEST_INJECTION = registerLootTableInjection(BuiltInLootTables.IGLOO_CHEST);
    public static final ResourceKey<LootTable> VILLAGE_PLAINS_HOUSE_INJECTION = registerLootTableInjection(
            BuiltInLootTables.VILLAGE_PLAINS_HOUSE);
    public static final ResourceKey<LootTable> VILLAGE_DESERT_HOUSE_INJECTION = registerLootTableInjection(
            BuiltInLootTables.VILLAGE_DESERT_HOUSE);
    public static final ResourceKey<LootTable> VILLAGE_SNOWY_HOUSE_INJECTION = registerLootTableInjection(
            BuiltInLootTables.VILLAGE_SNOWY_HOUSE);
    public static final ResourceKey<LootTable> VILLAGE_TAIGA_HOUSE_INJECTION = registerLootTableInjection(
            BuiltInLootTables.VILLAGE_TAIGA_HOUSE);
    public static final ResourceKey<LootTable> VILLAGE_SAVANNA_HOUSE_INJECTION = registerLootTableInjection(
            BuiltInLootTables.VILLAGE_SAVANNA_HOUSE);
    public static final ResourceKey<LootTable> EVOKER_INJECTION = registerLootTableInjection(EntityType.EVOKER.getDefaultLootTable()
            .orElseThrow());
    public static final ResourceKey<LootTable> VINDICATOR_INJECTION = registerLootTableInjection(EntityType.VINDICATOR.getDefaultLootTable()
            .orElseThrow());
    public static final ResourceKey<LootTable> PILLAGER_INJECTION = registerLootTableInjection(EntityType.PILLAGER.getDefaultLootTable()
            .orElseThrow());
    public static final ResourceKey<LootTable> WITCH_INJECTION = registerLootTableInjection(EntityType.WITCH.getDefaultLootTable()
            .orElseThrow());
    public static final ResourceKey<LootTable> IRON_GOLEM_INJECTION = registerLootTableInjection(EntityType.IRON_GOLEM.getDefaultLootTable()
            .orElseThrow());

    public static void bootstrap() {
        // NO-OP
    }

    static ResourceKey<LootTable> registerLootTableInjection(ResourceKey<LootTable> resourceKey) {
        ResourceKey<LootTable> newResourceKey = ModRegistry.REGISTRIES.makeResourceKey(Registries.LOOT_TABLE,
                "inject/" + resourceKey.identifier().getPath());
        LOOT_TABLE_INJECTIONS.put(resourceKey.identifier(), newResourceKey);
        return newResourceKey;
    }

    public static void onLootTableLoad(Identifier identifier, LootTable.Builder lootTable, HolderLookup.Provider registries) {
        if (LOOT_TABLE_INJECTIONS.containsKey(identifier)) {
            lootTable.withPool(LootPool.lootPool()
                    .setRolls(ConstantValue.exactly(1.0F))
                    .add(NestedLootTable.lootTableReference(LOOT_TABLE_INJECTIONS.get(identifier))));
        }
    }
}
