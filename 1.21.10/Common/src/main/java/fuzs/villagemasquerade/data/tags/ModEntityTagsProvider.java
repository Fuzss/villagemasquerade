package fuzs.villagemasquerade.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.villagemasquerade.init.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.EntityType;

public class ModEntityTagsProvider extends AbstractTagProvider<EntityType<?>> {

    public ModEntityTagsProvider(DataProviderContext context) {
        super(Registries.ENTITY_TYPE, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        this.tag(ModTags.FASHIONABLE_ENTITY_TYPE_TAG)
                .add(EntityType.ARMOR_STAND,
                        EntityType.BOGGED,
                        EntityType.DROWNED,
                        EntityType.HUSK,
                        EntityType.PLAYER,
                        EntityType.STRAY,
                        EntityType.SKELETON,
                        EntityType.WITHER_SKELETON,
                        EntityType.ZOMBIE)
                .addOptional("strawstatues:straw_statue");
    }
}
