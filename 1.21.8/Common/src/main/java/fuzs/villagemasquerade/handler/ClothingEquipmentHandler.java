package fuzs.villagemasquerade.handler;

import com.google.common.collect.ImmutableList;
import fuzs.puzzleslib.api.event.v1.core.EventResult;
import fuzs.puzzleslib.api.event.v1.data.MutableDouble;
import fuzs.villagemasquerade.init.ModItems;
import fuzs.villagemasquerade.init.ModTags;
import net.minecraft.core.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.WrappedGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.List;

public class ClothingEquipmentHandler {
    static final List<EquipmentSlot> CLOTHING_EQUIPMENT_SLOTS = ImmutableList.of(EquipmentSlot.HEAD,
            EquipmentSlot.CHEST,
            EquipmentSlot.LEGS);
    static final TargetingConditions.Selector ENEMY_SELECTOR = (LivingEntity livingEntity, ServerLevel serverLevel) -> {
        return isWearingOutfit(livingEntity, ModTags.ENEMY_CLOTHING_ITEM_TAG);
    };

    public static EventResult onLivingDrops(LivingEntity livingEntity, DamageSource damageSource, Collection<ItemEntity> itemDrops, boolean recentlyHit) {
        if (damageSource.getEntity() instanceof Creeper creeper && creeper.canDropMobsSkull()) {
            Holder<Item> holder = getHeadItem(livingEntity);
            if (holder != null) {
                livingEntity.spawnAtLocation((ServerLevel) livingEntity.level(), new ItemStack(holder));
                creeper.increaseDroppedSkulls();
            }
        }
        return EventResult.PASS;
    }

    private static @Nullable Holder<Item> getHeadItem(LivingEntity livingEntity) {
        if (livingEntity.getType().is(EntityTypeTags.ILLAGER)) {
            return ModItems.ILLAGER_HEAD_ITEM;
        } else if (livingEntity instanceof Villager) {
            return ModItems.VILLAGER_HEAD_ITEM;
        } else if (livingEntity instanceof IronGolem) {
            return ModItems.IRON_GOLEM_HEAD_ITEM;
        } else {
            return null;
        }
    }

    public static EventResult onEntityLoad(Entity entity, ServerLevel serverLevel, boolean isNewlySpawned) {
        if (entity instanceof IronGolem ironGolem) {
            ironGolem.targetSelector.addGoal(3,
                    new NearestAttackableTargetGoal<>(ironGolem, Player.class, 10, true, false, ENEMY_SELECTOR));
        }

        if (entity instanceof Mob mob && entity.getType().is(EntityTypeTags.RAIDERS)) {
            for (WrappedGoal wrappedGoal : mob.targetSelector.getAvailableGoals()) {
                if (wrappedGoal.getGoal() instanceof NearestAttackableTargetGoal<?> goal
                        && goal.targetType == Player.class) {
                    TargetingConditions.Selector originalSelector = goal.targetConditions.selector;
                    goal.targetConditions.selector = (LivingEntity livingEntity, ServerLevel serverLevelX) -> {
                        return (originalSelector == null || originalSelector.test(livingEntity, serverLevelX))
                                && !ENEMY_SELECTOR.test(livingEntity, serverLevelX);
                    };
                }
            }
        }

        return EventResult.PASS;
    }

    public static void onLivingVisibility(LivingEntity livingEntity, @Nullable Entity lookingEntity, MutableDouble visibilityPercentage) {
        if (lookingEntity instanceof Enemy && lookingEntity.level().isDarkOutside() && isWearingOutfit(livingEntity,
                ModTags.WANDERING_TRADER_CLOTHING_ITEM_TAG)) {
            visibilityPercentage.mapDouble((double value) -> value * 0.25);
        }
    }

    public static EventResult onMobEffectAffects(LivingEntity livingEntity, MobEffectInstance mobEffect) {
        if (isWearingOutfit(livingEntity, ModTags.WITCH_CLOTHING_ITEM_TAG)) {
            if (mobEffect.getEffect().is(ModTags.WITCH_CLOTHING_RESISTANT_TO_MOB_EFFECT_TAG)) {
                return EventResult.INTERRUPT;
            }
        }

        return EventResult.PASS;
    }

    private static boolean isWearingOutfit(LivingEntity livingEntity, TagKey<Item> tagKey) {
        for (EquipmentSlot equipmentSlot : CLOTHING_EQUIPMENT_SLOTS) {
            if (!livingEntity.getItemBySlot(equipmentSlot).is(tagKey)) {
                return false;
            }
        }

        return true;
    }
}
