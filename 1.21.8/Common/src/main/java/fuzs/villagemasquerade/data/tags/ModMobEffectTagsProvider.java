package fuzs.villagemasquerade.data.tags;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagAppender;
import fuzs.puzzleslib.api.data.v2.tags.AbstractTagProvider;
import fuzs.villagemasquerade.init.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;

public class ModMobEffectTagsProvider extends AbstractTagProvider<MobEffect> {

    public ModMobEffectTagsProvider(DataProviderContext context) {
        super(Registries.MOB_EFFECT, context);
    }

    @Override
    public void addTags(HolderLookup.Provider registries) {
        AbstractTagAppender<MobEffect> tagAppender = this.tag(ModTags.WITCH_CLOTHING_RESISTANT_TO_MOB_EFFECT_TAG);
        registries.lookupOrThrow(Registries.MOB_EFFECT).listElements().forEach((Holder.Reference<MobEffect> holder) -> {
            if (holder.value().getCategory() == MobEffectCategory.HARMFUL) {
                tagAppender.add(holder);
            }
        });
    }
}
