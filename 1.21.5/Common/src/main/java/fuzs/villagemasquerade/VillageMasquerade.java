package fuzs.villagemasquerade;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.event.v1.AddBlockEntityTypeBlocksCallback;
import fuzs.puzzleslib.api.event.v1.core.EventResult;
import fuzs.puzzleslib.api.event.v1.entity.living.LivingDropsCallback;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.function.BiConsumer;

public class VillageMasquerade implements ModConstructor {
    public static final String MOD_ID = "villagemasquerade";
    public static final String MOD_NAME = "Village Masquerade";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onConstructMod() {
        ModRegistry.bootstrap();
        registerEventHandlers();
    }

    private static void registerEventHandlers() {
        AddBlockEntityTypeBlocksCallback.EVENT.register((BiConsumer<BlockEntityType<?>, Block> consumer) -> {
            consumer.accept(BlockEntityType.SKULL, ModRegistry.VILLAGER_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.VILLAGER_WALL_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.IRON_GOLEM_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.IRON_GOLEM_WALL_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.ILLAGER_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.ILLAGER_WALL_HEAD_BLOCK.value());
        });
        LivingDropsCallback.EVENT.register((LivingEntity livingEntity, DamageSource damageSource, Collection<ItemEntity> itemDrops, boolean recentlyHit) -> {
            if (damageSource.getEntity() instanceof Creeper creeper && creeper.canDropMobsSkull()) {
                Holder<Item> item;
                if (livingEntity.getType().is(EntityTypeTags.ILLAGER)) {
                    item = ModRegistry.ILLAGER_HEAD_ITEM;
                } else if (livingEntity instanceof Villager) {
                    item = ModRegistry.VILLAGER_HEAD_ITEM;
                } else if (livingEntity instanceof IronGolem) {
                    item = ModRegistry.IRON_GOLEM_HEAD_ITEM;
                } else {
                    item = null;
                }
                if (item != null) {
                    livingEntity.spawnAtLocation((ServerLevel) livingEntity.level(), new ItemStack(item));
                    creeper.increaseDroppedSkulls();
                }
            }
            return EventResult.PASS;
        });
    }

    public static ResourceLocation id(String path) {
        return ResourceLocationHelper.fromNamespaceAndPath(MOD_ID, path);
    }
}
