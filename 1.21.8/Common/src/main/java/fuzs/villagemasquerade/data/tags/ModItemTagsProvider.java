package fuzs.villagemasquerade.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.villagemasquerade.init.ModItems;
import fuzs.villagemasquerade.init.ModTags;
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
                .add(ModItems.VILLAGER_HEAD_ITEM, ModItems.IRON_GOLEM_HEAD_ITEM, ModItems.ILLAGER_HEAD_ITEM);
        this.tag(ItemTags.NOTE_BLOCK_TOP_INSTRUMENTS).add(ModItems.VILLAGER_HEAD_ITEM, ModItems.ILLAGER_HEAD_ITEM);
        this.tag(ModTags.CLOTHING_ITEM_TAG)
                .addTag(ModTags.HEAD_CLOTHING_ITEM_TAG, ModTags.CHEST_CLOTHING_ITEM_TAG, ModTags.LEG_CLOTHING_ITEM_TAG);
        this.tag(ModTags.HEAD_CLOTHING_ITEM_TAG)
                .add(ModItems.ARMORER_GOGGLES_ITEM,
                        ModItems.BUTCHER_HEADBAND_ITEM,
                        ModItems.CARTOGRAPHER_MONOCLE_ITEM,
                        ModItems.CLERIC_COLLAR_ITEM,
                        ModItems.FARMER_HAT_ITEM,
                        ModItems.FISHERMAN_HAT_ITEM,
                        ModItems.FLETCHER_HAT_ITEM,
                        ModItems.LIBRARIAN_HEADWEAR_ITEM,
                        ModItems.SHEPHERD_HAT_ITEM,
                        ModItems.WEAPONSMITH_EYEPATCH_ITEM,
                        ModItems.WANDERING_TRADER_HOOD_ITEM,
                        ModItems.WITCH_HAT_ITEM,
                        ModItems.SANTA_HAT_ITEM);
        this.tag(ModTags.CHEST_CLOTHING_ITEM_TAG)
                .add(ModItems.ARMORER_APRON_ITEM,
                        ModItems.BUTCHER_APRON_ITEM,
                        ModItems.CARTOGRAPHER_HARNESS_ITEM,
                        ModItems.CLERIC_ROBE_ITEM,
                        ModItems.FARMER_BELT_ITEM,
                        ModItems.FISHERMAN_VEST_ITEM,
                        ModItems.FLETCHER_BELT_ITEM,
                        ModItems.LEATHERWORKER_APRON_ITEM,
                        ModItems.LIBRARIAN_TOGA_ITEM,
                        ModItems.MASON_APRON_ITEM,
                        ModItems.NITWIT_ROBE_ITEM,
                        ModItems.SHEPHERD_VEST_ITEM,
                        ModItems.TOOLSMITH_APRON_ITEM,
                        ModItems.WEAPONSMITH_APRON_ITEM,
                        ModItems.LEGACY_FARMER_ROBE_ITEM,
                        ModItems.LEGACY_LIBRARIAN_ROBE_ITEM,
                        ModItems.LEGACY_NITWIT_ROBE_ITEM,
                        ModItems.LEGACY_PRIEST_ROBE_ITEM,
                        ModItems.WANDERING_TRADER_ROBE_ITEM,
                        ModItems.IRON_GOLEM_ROBE_ITEM,
                        ModItems.EVOKER_ROBE_ITEM,
                        ModItems.PILLAGER_JACKET_ITEM,
                        ModItems.VINDICATOR_JACKET_ITEM,
                        ModItems.WITCH_ROBE_ITEM,
                        ModItems.SANTA_COAT_ITEM);
        this.tag(ModTags.LEG_CLOTHING_ITEM_TAG)
                .add(ModItems.FISHERMAN_LEGGINGS_ITEM,
                        ModItems.NITWIT_LEGGINGS_ITEM,
                        ModItems.LEGACY_FARMER_LEGGINGS_ITEM,
                        ModItems.LEGACY_LIBRARIAN_LEGGINGS_ITEM,
                        ModItems.LEGACY_NITWIT_LEGGINGS_ITEM,
                        ModItems.LEGACY_PRIEST_LEGGINGS_ITEM,
                        ModItems.WANDERING_TRADER_LEGGINGS_ITEM,
                        ModItems.IRON_GOLEM_LEGGINGS_ITEM,
                        ModItems.EVOKER_LEGGINGS_ITEM,
                        ModItems.PILLAGER_LEGGINGS_ITEM,
                        ModItems.VINDICATOR_LEGGINGS_ITEM,
                        ModItems.WITCH_LEGGINGS_ITEM,
                        ModItems.SANTA_LEGGINGS_ITEM);
        this.tag(ModTags.WANDERING_TRADER_CLOTHING_ITEM_TAG)
                .add(ModItems.WANDERING_TRADER_HOOD_ITEM,
                        ModItems.WANDERING_TRADER_ROBE_ITEM,
                        ModItems.WANDERING_TRADER_LEGGINGS_ITEM);
        this.tag(ModTags.EVOKER_CLOTHING_ITEM_TAG)
                .add(ModItems.ILLAGER_HEAD_ITEM, ModItems.EVOKER_ROBE_ITEM, ModItems.EVOKER_LEGGINGS_ITEM);
        this.tag(ModTags.PILLAGER_CLOTHING_ITEM_TAG)
                .add(ModItems.ILLAGER_HEAD_ITEM, ModItems.PILLAGER_JACKET_ITEM, ModItems.PILLAGER_LEGGINGS_ITEM);
        this.tag(ModTags.VINDICATOR_CLOTHING_ITEM_TAG)
                .add(ModItems.ILLAGER_HEAD_ITEM, ModItems.VINDICATOR_JACKET_ITEM, ModItems.VINDICATOR_LEGGINGS_ITEM);
        this.tag(ModTags.WITCH_CLOTHING_ITEM_TAG)
                .add(ModItems.WITCH_HAT_ITEM, ModItems.WITCH_ROBE_ITEM, ModItems.WITCH_LEGGINGS_ITEM);
        this.tag(ModTags.ENEMY_CLOTHING_ITEM_TAG)
                .addTag(ModTags.EVOKER_CLOTHING_ITEM_TAG,
                        ModTags.PILLAGER_CLOTHING_ITEM_TAG,
                        ModTags.VINDICATOR_CLOTHING_ITEM_TAG,
                        ModTags.WITCH_CLOTHING_ITEM_TAG);
        this.tag(ModTags.SANTA_CLOTHING_ITEM_TAG)
                .add(ModItems.SANTA_HAT_ITEM, ModItems.SANTA_COAT_ITEM, ModItems.SANTA_LEGGINGS_ITEM);
    }
}
