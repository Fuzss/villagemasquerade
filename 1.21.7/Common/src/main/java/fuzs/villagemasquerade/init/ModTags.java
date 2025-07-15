package fuzs.villagemasquerade.init;

import fuzs.puzzleslib.api.init.v3.tags.TagFactory;
import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;

public class ModTags {
    static final TagFactory TAGS = TagFactory.make(VillageMasquerade.MOD_ID);
    public static final TagKey<Item> CLOTHING_ITEM_TAG = TAGS.registerItemTag("clothing");
    public static final TagKey<Item> HEAD_CLOTHING_ITEM_TAG = TAGS.registerItemTag("head_clothing");
    public static final TagKey<Item> CHEST_CLOTHING_ITEM_TAG = TAGS.registerItemTag("chest_clothing");
    public static final TagKey<Item> LEG_CLOTHING_ITEM_TAG = TAGS.registerItemTag("leg_clothing");
    public static final TagKey<Item> WANDERING_TRADER_CLOTHING_ITEM_TAG = TAGS.registerItemTag(
            "wandering_trader_clothing");
    public static final TagKey<Item> EVOKER_CLOTHING_ITEM_TAG = TAGS.registerItemTag("evoker_clothing");
    public static final TagKey<Item> PILLAGER_CLOTHING_ITEM_TAG = TAGS.registerItemTag("pillager_clothing");
    public static final TagKey<Item> VINDICATOR_CLOTHING_ITEM_TAG = TAGS.registerItemTag("vindicator_clothing");
    public static final TagKey<Item> WITCH_CLOTHING_ITEM_TAG = TAGS.registerItemTag("witch_clothing");
    public static final TagKey<Item> ENEMY_CLOTHING_ITEM_TAG = TAGS.registerItemTag("enemy_clothing");
    public static final TagKey<Item> SANTA_CLOTHING_ITEM_TAG = TAGS.registerItemTag("santa_clothing");
    public static final TagKey<EntityType<?>> FASHIONABLE_ENTITY_TYPE_TAG = TAGS.registerEntityTypeTag("fashionable");
    public static final TagKey<MobEffect> WITCH_CLOTHING_RESISTANT_TO_MOB_EFFECT_TAG = TAGS.registerTagKey(Registries.MOB_EFFECT,
            "witch_clothing_resistant_to");

    public static void bootstrap() {
        // NO-OP
    }
}
