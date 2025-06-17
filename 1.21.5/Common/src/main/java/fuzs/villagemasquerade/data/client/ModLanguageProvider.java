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
        translationBuilder.addItem(ModRegistry.ARMORER_GOGGLES_ITEM, "Armorer Goggles");
        translationBuilder.addItem(ModRegistry.ARMORER_APRON_ITEM, "Armorer Apron");
    }
}
