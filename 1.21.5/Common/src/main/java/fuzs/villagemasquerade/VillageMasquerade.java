package fuzs.villagemasquerade;

import fuzs.puzzleslib.api.core.v1.ModConstructor;
import fuzs.puzzleslib.api.core.v1.utility.ResourceLocationHelper;
import fuzs.puzzleslib.api.event.v1.AddBlockEntityTypeBlocksCallback;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
        });
    }

    public static ResourceLocation id(String path) {
        return ResourceLocationHelper.fromNamespaceAndPath(MOD_ID, path);
    }
}
