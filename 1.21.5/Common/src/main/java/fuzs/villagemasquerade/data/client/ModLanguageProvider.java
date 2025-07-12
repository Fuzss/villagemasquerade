package fuzs.villagemasquerade.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractLanguageProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.init.ModRegistry;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.addCreativeModeTab(ModRegistry.CREATIVE_MODE_TAB, VillageMasquerade.MOD_NAME);
        translationBuilder.addBlock(ModRegistry.VILLAGER_HEAD_BLOCK, "Villager Head");
        translationBuilder.addBlock(ModRegistry.IRON_GOLEM_HEAD_BLOCK, "Iron Golem Head");
        translationBuilder.addBlock(ModRegistry.ILLAGER_HEAD_BLOCK, "Illager Head");
        translationBuilder.addItem(ModRegistry.ARMORER_GOGGLES_ITEM, "Armorer Goggles");
        translationBuilder.addItem(ModRegistry.ARMORER_APRON_ITEM, "Armorer Apron");
        translationBuilder.addItem(ModRegistry.BUTCHER_HEADBAND_ITEM, "Butcher Headband");
        translationBuilder.addItem(ModRegistry.BUTCHER_APRON_ITEM, "Butcher Apron");
        translationBuilder.addItem(ModRegistry.CARTOGRAPHER_MONOCLE_ITEM, "Cartographer Monocle");
        translationBuilder.addItem(ModRegistry.CARTOGRAPHER_HARNESS_ITEM, "Cartographer Harness");
        translationBuilder.addItem(ModRegistry.CLERIC_COLLAR_ITEM, "Cleric Collar");
        translationBuilder.addItem(ModRegistry.CLERIC_ROBE_ITEM, "Cleric Robe");
        translationBuilder.addItem(ModRegistry.FARMER_HAT_ITEM, "Farmer Hat");
        translationBuilder.addItem(ModRegistry.FARMER_BELT_ITEM, "Farmer Belt");
        translationBuilder.addItem(ModRegistry.FISHERMAN_HAT_ITEM, "Fisherman Hat");
        translationBuilder.addItem(ModRegistry.FISHERMAN_VEST_ITEM, "Fisherman Vest");
        translationBuilder.addItem(ModRegistry.FISHERMAN_LEGGINGS_ITEM, "Fisherman Leggings");
        translationBuilder.addItem(ModRegistry.FLETCHER_HAT_ITEM, "Fletcher Hat");
        translationBuilder.addItem(ModRegistry.FLETCHER_BELT_ITEM, "Fletcher Belt");
        translationBuilder.addItem(ModRegistry.LEATHERWORKER_APRON_ITEM, "Leatherworker Apron");
        translationBuilder.addItem(ModRegistry.LIBRARIAN_HEADWEAR_ITEM, "Librarian Headwear");
        translationBuilder.addItem(ModRegistry.LIBRARIAN_TOGA_ITEM, "Librarian Toga");
        translationBuilder.addItem(ModRegistry.MASON_APRON_ITEM, "Mason Apron");
        translationBuilder.addItem(ModRegistry.NITWIT_ROBE_ITEM, "Nitwit Robe");
        translationBuilder.addItem(ModRegistry.NITWIT_LEGGINGS_ITEM, "Nitwit Leggings");
        translationBuilder.addItem(ModRegistry.SHEPHERD_HAT_ITEM, "Shepherd Hat");
        translationBuilder.addItem(ModRegistry.SHEPHERD_VEST_ITEM, "Shepherd Vest");
        translationBuilder.addItem(ModRegistry.TOOLSMITH_APRON_ITEM, "Toolsmith Apron");
        translationBuilder.addItem(ModRegistry.WEAPONSMITH_EYEPATCH_ITEM, "Weaponsmith Eyepatch");
        translationBuilder.addItem(ModRegistry.WEAPONSMITH_APRON_ITEM, "Weaponsmith Apron");
        translationBuilder.addItem(ModRegistry.LEGACY_FARMER_ROBE_ITEM, "Legacy Farmer Robe");
        translationBuilder.addItem(ModRegistry.LEGACY_FARMER_LEGGINGS_ITEM, "Legacy Farmer Leggings");
        translationBuilder.addItem(ModRegistry.LEGACY_LIBRARIAN_ROBE_ITEM, "Legacy Librarian Robe");
        translationBuilder.addItem(ModRegistry.LEGACY_LIBRARIAN_LEGGINGS_ITEM, "Legacy Librarian Leggings");
        translationBuilder.addItem(ModRegistry.LEGACY_NITWIT_ROBE_ITEM, "Legacy Nitwit Robe");
        translationBuilder.addItem(ModRegistry.LEGACY_NITWIT_LEGGINGS_ITEM, "Legacy Nitwit Leggings");
        translationBuilder.addItem(ModRegistry.LEGACY_PRIEST_ROBE_ITEM, "Legacy Priest Robe");
        translationBuilder.addItem(ModRegistry.LEGACY_PRIEST_LEGGINGS_ITEM, "Legacy Priest Leggings");
        translationBuilder.addItem(ModRegistry.WANDERING_TRADER_HOOD_ITEM, "Wandering Trader Hood");
        translationBuilder.addItem(ModRegistry.WANDERING_TRADER_ROBE_ITEM, "Wandering Trader Robe");
        translationBuilder.addItem(ModRegistry.WANDERING_TRADER_LEGGINGS_ITEM, "Wandering Trader Leggings");
        translationBuilder.addItem(ModRegistry.IRON_GOLEM_ROBE_ITEM, "Iron Golem Chestplate");
        translationBuilder.addItem(ModRegistry.IRON_GOLEM_LEGGINGS_ITEM, "Iron Golem Leggings");
        translationBuilder.addItem(ModRegistry.EVOKER_ROBE_ITEM, "Evoker Robe");
        translationBuilder.addItem(ModRegistry.EVOKER_LEGGINGS_ITEM, "Evoker Leggings");
        translationBuilder.addItem(ModRegistry.PILLAGER_JACKET_ITEM, "Pillager Jacket");
        translationBuilder.addItem(ModRegistry.PILLAGER_LEGGINGS_ITEM, "Pillager Leggings");
        translationBuilder.addItem(ModRegistry.VINDICATOR_JACKET_ITEM, "Vindicator Jacket");
        translationBuilder.addItem(ModRegistry.VINDICATOR_LEGGINGS_ITEM, "Vindicator Leggings");
        translationBuilder.addItem(ModRegistry.WITCH_HAT_ITEM, "Witch Hat");
        translationBuilder.addItem(ModRegistry.WITCH_ROBE_ITEM, "Witch Robe");
        translationBuilder.addItem(ModRegistry.WITCH_LEGGINGS_ITEM, "Witch Leggings");
        translationBuilder.addItem(ModRegistry.SANTA_HAT_ITEM, "Santa Hat");
        translationBuilder.addItem(ModRegistry.SANTA_COAT_ITEM, "Santa Coat");
        translationBuilder.addItem(ModRegistry.SANTA_LEGGINGS_ITEM, "Santa Leggings");
    }
}
