package fuzs.villagemasquerade.init;

import fuzs.puzzleslib.api.init.v3.registry.ContentRegistrationHelper;
import fuzs.puzzleslib.api.init.v3.registry.RegistryManager;
import fuzs.villagemasquerade.VillageMasquerade;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.level.block.SkullBlock;

public class ModRegistry {
    public static final RegistrySetBuilder REGISTRY_SET_BUILDER = new RegistrySetBuilder();
    public static final SkullBlock.Type VILLAGER_SKULL_TYPE = ContentRegistrationHelper.registerSkullBlockType(
            VillageMasquerade.id("villager"));
    public static final SkullBlock.Type IRON_GOLEM_SKULL_TYPE = ContentRegistrationHelper.registerSkullBlockType(
            VillageMasquerade.id("iron_golem"));
    public static final SkullBlock.Type ILLAGER_SKULL_TYPE = ContentRegistrationHelper.registerSkullBlockType(
            VillageMasquerade.id("illager_golem"));
    static final RegistryManager REGISTRIES = RegistryManager.from(VillageMasquerade.MOD_ID);
    public static final Holder.Reference<DataComponentType<ResourceKey<VillagerProfession>>> VILLAGER_PROFESSION_DATA_COMPONENT_TYPE = REGISTRIES.registerDataComponentType(
            "villager/profession",
            (DataComponentType.Builder<ResourceKey<VillagerProfession>> builder) -> builder.persistent(ResourceKey.codec(
                            Registries.VILLAGER_PROFESSION))
                    .networkSynchronized(ResourceKey.streamCodec(Registries.VILLAGER_PROFESSION)));
    public static final Holder.Reference<CreativeModeTab> CREATIVE_MODE_TAB = REGISTRIES.registerCreativeModeTab(
            ModItems.VILLAGER_HEAD_ITEM);

    public static void bootstrap() {
        ModEquipmentAssets.bootstrap();
        ModBlocks.bootstrap();
        ModItems.bootstrap();
        ModTags.bootstrap();
        ModLootTables.bootstrap();
    }
}
