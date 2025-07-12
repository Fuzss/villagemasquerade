package fuzs.villagemasquerade;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.event.v1.AddBlockEntityTypeBlocksCallback;
import fuzs.puzzleslib.api.event.v1.core.EventResult;
import fuzs.puzzleslib.api.event.v1.entity.living.LivingDropsCallback;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
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

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.function.BiConsumer;

public class VillageMasquerade implements ModConstructor {
    public static final String MOD_ID = "villagemasquerade";
    public static final String MOD_NAME = "Village Masquerade";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    @Override
    public void onConstructMod() {
        for (Method method : EquipmentClientInfo.LayerType.class.getDeclaredMethods()) {
            System.out.println(method);
        }
        ModRegistry.bootstrap();
        registerEventHandlers();
        EquipmentClientInfo.LayerType[] values = EquipmentClientInfo.LayerType.values();
        System.out.println(values);
        Class<EquipmentClientInfo.LayerType> layerTypeClass = EquipmentClientInfo.LayerType.class;
        System.out.println(layerTypeClass);
    }

    private static void registerEventHandlers() {
        AddBlockEntityTypeBlocksCallback.EVENT.register((BiConsumer<BlockEntityType<?>, Block> consumer) -> {
            consumer.accept(BlockEntityType.SKULL, ModRegistry.VILLAGER_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.VILLAGER_WALL_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.IRON_GOLEM_HEAD_BLOCK.value());
            consumer.accept(BlockEntityType.SKULL, ModRegistry.IRON_GOLEM_WALL_HEAD_BLOCK.value());
        });
        LivingDropsCallback.EVENT.register((LivingEntity livingEntity, DamageSource damageSource, Collection<ItemEntity> itemDrops, boolean recentlyHit) -> {
            if (damageSource.getEntity() instanceof Creeper creeper && creeper.canDropMobsSkull()) {
                Holder<Item> item;
                if (livingEntity instanceof Villager) {
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
