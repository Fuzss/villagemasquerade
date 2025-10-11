package fuzs.villagemasquerade.data.client;

import fuzs.puzzleslib.api.client.data.v2.AbstractLanguageProvider;
import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.villagemasquerade.VillageMasquerade;
import fuzs.villagemasquerade.client.VillageMasqueradeClient;
import fuzs.villagemasquerade.init.ModBlocks;
import fuzs.villagemasquerade.init.ModItems;
import fuzs.villagemasquerade.init.ModRegistry;

public class ModLanguageProvider extends AbstractLanguageProvider {

    public ModLanguageProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addTranslations(TranslationBuilder translationBuilder) {
        translationBuilder.addCreativeModeTab(ModRegistry.CREATIVE_MODE_TAB, VillageMasquerade.MOD_NAME);
        translationBuilder.add(VillageMasqueradeClient.VILLAGER_CLOTHING_DESCRIPTION_KEY,
                "Get discounts for trading with: %s");
        translationBuilder.add(VillageMasqueradeClient.ENEMY_CLOTHING_DESCRIPTION_KEY,
                "Become friends with illagers, but watch out for iron golems.");
        translationBuilder.add(VillageMasqueradeClient.WANDERING_TRADER_CLOTHING_DESCRIPTION_KEY,
                "Easily hide from enemies during the night.");
        translationBuilder.addBlock(ModBlocks.VILLAGER_HEAD_BLOCK, "Villager Head");
        translationBuilder.addBlock(ModBlocks.IRON_GOLEM_HEAD_BLOCK, "Iron Golem Head");
        translationBuilder.addBlock(ModBlocks.ILLAGER_HEAD_BLOCK, "Illager Head");
        translationBuilder.addItem(ModItems.ARMORER_GOGGLES_ITEM, "Armorer Goggles");
        translationBuilder.addItem(ModItems.ARMORER_APRON_ITEM, "Armorer Apron");
        translationBuilder.addItem(ModItems.BUTCHER_HEADBAND_ITEM, "Butcher Headband");
        translationBuilder.addItem(ModItems.BUTCHER_APRON_ITEM, "Butcher Apron");
        translationBuilder.addItem(ModItems.CARTOGRAPHER_MONOCLE_ITEM, "Cartographer Monocle");
        translationBuilder.addItem(ModItems.CARTOGRAPHER_HARNESS_ITEM, "Cartographer Harness");
        translationBuilder.addItem(ModItems.CLERIC_COLLAR_ITEM, "Cleric Collar");
        translationBuilder.addItem(ModItems.CLERIC_ROBE_ITEM, "Cleric Robe");
        translationBuilder.addItem(ModItems.FARMER_HAT_ITEM, "Farmer Hat");
        translationBuilder.addItem(ModItems.FARMER_BELT_ITEM, "Farmer Belt");
        translationBuilder.addItem(ModItems.FISHERMAN_HAT_ITEM, "Fisherman Hat");
        translationBuilder.addItem(ModItems.FISHERMAN_VEST_ITEM, "Fisherman Vest");
        translationBuilder.addItem(ModItems.FISHERMAN_LEGGINGS_ITEM, "Fisherman Leggings");
        translationBuilder.addItem(ModItems.FLETCHER_HAT_ITEM, "Fletcher Hat");
        translationBuilder.addItem(ModItems.FLETCHER_BELT_ITEM, "Fletcher Belt");
        translationBuilder.addItem(ModItems.LEATHERWORKER_APRON_ITEM, "Leatherworker Apron");
        translationBuilder.addItem(ModItems.LIBRARIAN_HEADWEAR_ITEM, "Librarian Headwear");
        translationBuilder.addItem(ModItems.LIBRARIAN_TOGA_ITEM, "Librarian Toga");
        translationBuilder.addItem(ModItems.MASON_APRON_ITEM, "Mason Apron");
        translationBuilder.addItem(ModItems.NITWIT_ROBE_ITEM, "Nitwit Robe");
        translationBuilder.addItem(ModItems.NITWIT_LEGGINGS_ITEM, "Nitwit Leggings");
        translationBuilder.addItem(ModItems.SHEPHERD_HAT_ITEM, "Shepherd Hat");
        translationBuilder.addItem(ModItems.SHEPHERD_VEST_ITEM, "Shepherd Vest");
        translationBuilder.addItem(ModItems.TOOLSMITH_APRON_ITEM, "Toolsmith Apron");
        translationBuilder.addItem(ModItems.WEAPONSMITH_EYEPATCH_ITEM, "Weaponsmith Eyepatch");
        translationBuilder.addItem(ModItems.WEAPONSMITH_APRON_ITEM, "Weaponsmith Apron");
        translationBuilder.addItem(ModItems.LEGACY_FARMER_ROBE_ITEM, "Legacy Farmer Robe");
        translationBuilder.addItem(ModItems.LEGACY_FARMER_LEGGINGS_ITEM, "Legacy Farmer Leggings");
        translationBuilder.addItem(ModItems.LEGACY_LIBRARIAN_ROBE_ITEM, "Legacy Librarian Robe");
        translationBuilder.addItem(ModItems.LEGACY_LIBRARIAN_LEGGINGS_ITEM, "Legacy Librarian Leggings");
        translationBuilder.addItem(ModItems.LEGACY_NITWIT_ROBE_ITEM, "Legacy Nitwit Robe");
        translationBuilder.addItem(ModItems.LEGACY_NITWIT_LEGGINGS_ITEM, "Legacy Nitwit Leggings");
        translationBuilder.addItem(ModItems.LEGACY_PRIEST_ROBE_ITEM, "Legacy Priest Robe");
        translationBuilder.addItem(ModItems.LEGACY_PRIEST_LEGGINGS_ITEM, "Legacy Priest Leggings");
        translationBuilder.addItem(ModItems.WANDERING_TRADER_HOOD_ITEM, "Wandering Trader Hood");
        translationBuilder.addItem(ModItems.WANDERING_TRADER_ROBE_ITEM, "Wandering Trader Robe");
        translationBuilder.addItem(ModItems.WANDERING_TRADER_LEGGINGS_ITEM, "Wandering Trader Leggings");
        translationBuilder.addItem(ModItems.IRON_GOLEM_ROBE_ITEM, "Iron Golem Chestplate");
        translationBuilder.addItem(ModItems.IRON_GOLEM_LEGGINGS_ITEM, "Iron Golem Leggings");
        translationBuilder.addItem(ModItems.EVOKER_ROBE_ITEM, "Evoker Robe");
        translationBuilder.addItem(ModItems.EVOKER_LEGGINGS_ITEM, "Evoker Leggings");
        translationBuilder.addItem(ModItems.PILLAGER_JACKET_ITEM, "Pillager Jacket");
        translationBuilder.addItem(ModItems.PILLAGER_LEGGINGS_ITEM, "Pillager Leggings");
        translationBuilder.addItem(ModItems.VINDICATOR_JACKET_ITEM, "Vindicator Jacket");
        translationBuilder.addItem(ModItems.VINDICATOR_LEGGINGS_ITEM, "Vindicator Leggings");
        translationBuilder.addItem(ModItems.WITCH_HAT_ITEM, "Witch Hat");
        translationBuilder.addItem(ModItems.WITCH_ROBE_ITEM, "Witch Robe");
        translationBuilder.addItem(ModItems.WITCH_LEGGINGS_ITEM, "Witch Leggings");
        translationBuilder.addItem(ModItems.SANTA_HAT_ITEM, "Santa Hat");
        translationBuilder.addItem(ModItems.SANTA_COAT_ITEM, "Santa Coat");
        translationBuilder.addItem(ModItems.SANTA_LEGGINGS_ITEM, "Santa Leggings");
    }
}
