package fuzs.villagemasquerade.neoforge.data.client;

import fuzs.puzzleslib.api.data.v2.core.DataProviderContext;
import fuzs.puzzleslib.neoforge.api.client.data.v2.AbstractEquipmentProvider;
import fuzs.villagemasquerade.init.ModRegistry;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.item.equipment.EquipmentAsset;

public class ModEquipmentProvider extends AbstractEquipmentProvider {

    public ModEquipmentProvider(DataProviderContext context) {
        super(context);
    }

    @Override
    public void addEquipment() {
        this.addVillagerProfession(VillagerProfession.ARMORER);
    }

    public final void addVillagerProfession(ResourceKey<VillagerProfession> resourceKey) {
        this.addHumanoidLayers(ModRegistry.createEquipmentAssetKey(resourceKey));
    }

    public final void addHumanoidLayers(ResourceKey<EquipmentAsset> resourceKey) {
        ResourceLocation resourceLocation = resourceKey.location();
        this.unconditional(resourceLocation, EquipmentClientInfo.builder().addHumanoidLayers(resourceLocation).build());
    }
}
