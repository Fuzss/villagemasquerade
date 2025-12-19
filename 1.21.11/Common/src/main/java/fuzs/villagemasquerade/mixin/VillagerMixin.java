package fuzs.villagemasquerade.mixin;

import fuzs.villagemasquerade.util.VillagerTradingHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.villager.VillagerDataHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Villager.class)
abstract class VillagerMixin extends AbstractVillager implements VillagerDataHolder {

    public VillagerMixin(EntityType<? extends AbstractVillager> entityType, Level level) {
        super(entityType, level);
    }

    @Inject(method = "updateSpecialPrices", at = @At("TAIL"))
    private void updateSpecialPrices(Player player, CallbackInfo callback) {
        VillagerTradingHelper.updateSpecialPrices(Villager.class.cast(this), player);
    }
}
