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
        this.tag(ItemTags.SKULLS)
                .add(ModRegistry.VILLAGER_HEAD_ITEM, ModRegistry.IRON_GOLEM_HEAD_ITEM, ModRegistry.ILLAGER_HEAD_ITEM);
        this.tag(ItemTags.NOTE_BLOCK_TOP_INSTRUMENTS)
                .add(ModRegistry.VILLAGER_HEAD_ITEM, ModRegistry.IRON_GOLEM_HEAD_ITEM, ModRegistry.ILLAGER_HEAD_ITEM);
        this.tag(ModRegistry.HEAD_CLOTHING_ITEM_TAG)
                .add(ModRegistry.ARMORER_GOGGLES_ITEM,
                        ModRegistry.BUTCHER_HEADBAND_ITEM,
                        ModRegistry.CARTOGRAPHER_MONOCLE_ITEM,
                        ModRegistry.CLERIC_COLLAR_ITEM,
                        ModRegistry.FARMER_HAT_ITEM,
                        ModRegistry.FISHERMAN_HAT_ITEM,
                        ModRegistry.FLETCHER_HAT_ITEM,
                        ModRegistry.LIBRARIAN_HEADWEAR_ITEM,
                        ModRegistry.SHEPHERD_HAT_ITEM,
                        ModRegistry.WEAPONSMITH_EYEPATCH_ITEM,
                        ModRegistry.WANDERING_TRADER_HOOD_ITEM,
                        ModRegistry.WITCH_HAT_ITEM,
                        ModRegistry.SANTA_HAT_ITEM);
        this.tag(ModRegistry.CHEST_CLOTHING_ITEM_TAG)
                .add(ModRegistry.ARMORER_APRON_ITEM,
                        ModRegistry.BUTCHER_APRON_ITEM,
                        ModRegistry.CARTOGRAPHER_HARNESS_ITEM,
                        ModRegistry.CLERIC_ROBE_ITEM,
                        ModRegistry.FARMER_BELT_ITEM,
                        ModRegistry.FISHERMAN_VEST_ITEM,
                        ModRegistry.FLETCHER_BELT_ITEM,
                        ModRegistry.LEATHERWORKER_APRON_ITEM,
                        ModRegistry.LIBRARIAN_TOGA_ITEM,
                        ModRegistry.MASON_APRON_ITEM,
                        ModRegistry.NITWIT_ROBE_ITEM,
                        ModRegistry.SHEPHERD_VEST_ITEM,
                        ModRegistry.TOOLSMITH_APRON_ITEM,
                        ModRegistry.WEAPONSMITH_APRON_ITEM,
                        ModRegistry.LEGACY_FARMER_ROBE_ITEM,
                        ModRegistry.LEGACY_LIBRARIAN_ROBE_ITEM,
                        ModRegistry.LEGACY_NITWIT_ROBE_ITEM,
                        ModRegistry.LEGACY_PRIEST_ROBE_ITEM,
                        ModRegistry.WANDERING_TRADER_ROBE_ITEM,
                        ModRegistry.IRON_GOLEM_ROBE_ITEM,
                        ModRegistry.EVOKER_ROBE_ITEM,
                        ModRegistry.PILLAGER_JACKET_ITEM,
                        ModRegistry.VINDICATOR_JACKET_ITEM,
                        ModRegistry.WITCH_ROBE_ITEM,
                        ModRegistry.SANTA_COAT_ITEM);
        this.tag(ModRegistry.LEG_CLOTHING_ITEM_TAG)
                .add(ModRegistry.FISHERMAN_LEGGINGS_ITEM,
                        ModRegistry.NITWIT_LEGGINGS_ITEM,
                        ModRegistry.LEGACY_FARMER_LEGGINGS_ITEM,
                        ModRegistry.LEGACY_LIBRARIAN_LEGGINGS_ITEM,
                        ModRegistry.LEGACY_NITWIT_LEGGINGS_ITEM,
                        ModRegistry.LEGACY_PRIEST_LEGGINGS_ITEM,
                        ModRegistry.WANDERING_TRADER_LEGGINGS_ITEM,
                        ModRegistry.IRON_GOLEM_LEGGINGS_ITEM,
                        ModRegistry.EVOKER_LEGGINGS_ITEM,
                        ModRegistry.PILLAGER_LEGGINGS_ITEM,
                        ModRegistry.VINDICATOR_LEGGINGS_ITEM,
                        ModRegistry.WITCH_LEGGINGS_ITEM,
                        ModRegistry.SANTA_LEGGINGS_ITEM);
    }
}
