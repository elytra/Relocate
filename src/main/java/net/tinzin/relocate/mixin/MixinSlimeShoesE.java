package net.tinzin.relocate.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EntityType;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.tinzin.relocate.Relocate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLivingBase.class)
public abstract class MixinSlimeShoesE extends Entity {

    public MixinSlimeShoesE(EntityType<?> p_i48580_1_, World p_i48580_2_) {
        super(p_i48580_1_, p_i48580_2_);
    }

    @Shadow
    public abstract ItemStack getItemStackFromSlot(EntityEquipmentSlot entityEquipmentSlot);

    @Inject(method="fall",
            at=@At(value="INVOKE", target="Lnet/minecraft/entity/EntityLivingBase;playSound(Lnet/minecraft/util/SoundEvent;FF)V"),
            cancellable=true, require=1)
    void fall(CallbackInfo ci){
        if (getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == Relocate.Companion.getSLIMEBOOTS()) {
            ci.cancel();
            playSound(SoundEvents.BLOCK_SLIME_BLOCK_FALL,1,1);
        }
    }
}