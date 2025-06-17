package fuzs.villagemasquerade.data;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;

public class ModItemTagsProvider extends AbstractTagProvider<Item> {

    public ModItemTagsProvider(DataProviderContext context) {
        super(Registries.ITEM, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(ItemTags.SKULLS).add(ModRegistry.VILLAGER_HEAD_ITEM, ModRegistry.IRON_GOLEM_HEAD_ITEM);
        this.tag(ItemTags.NOTE_BLOCK_TOP_INSTRUMENTS)
                .add(ModRegistry.VILLAGER_HEAD_ITEM, ModRegistry.IRON_GOLEM_HEAD_ITEM);
        this.tag(ModRegistry.CLOTHING_ITEM_TAG)
                .add(ModRegistry.ARMORER_GOGGLES_ITEM.value(), ModRegistry.ARMORER_APRON_ITEM.value());
    }
}
