package net.tinzin.relocate.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.world.IBlockReader;
import net.tinzin.relocate.Relocate;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;


@Mixin(Block.class)
public abstract class MixinSlimeShoes{
    @Inject(method = "onLanded",
    at=@At(value="HEAD", target="Lnet/minecraft/entity/Entity;motionY:D"),
    cancellable = true, require=1,
    locals = LocalCapture.CAPTURE_FAILEXCEPTION)
    public void onLanded(IBlockReader reader, Entity e, CallbackInfo ci){
        if(e instanceof EntityLivingBase &&
            ((EntityLivingBase) e).getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == Relocate.Companion.getSLIMEBOOTS()){
            e.playSound(SoundType.SLIME.getFallSound(), .5f,1f);
            //TODO add particles??
            if(!e.isSneaking()) {
                e.motionY *= -0.8;
                ci.cancel();
            }
        }
    }
}