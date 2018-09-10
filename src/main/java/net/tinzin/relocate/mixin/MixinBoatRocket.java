package net.tinzin.relocate.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFireworkRocket;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.tinzin.relocate.entities.Booster;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ItemFireworkRocket.class)
public class MixinBoatRocket {
    @Inject(method="onItemRightClick",
    at=@At(value = "HEAD"),
    cancellable = true, require = 1)
    public void rightClick(World world, EntityPlayer player, EnumHand hand, CallbackInfoReturnable<ActionResult<ItemStack>> cir){
        if(player.isRiding()){
            Entity r = player.getRidingEntity();
            if(r instanceof EntityBoat){
                if(!world.isRemote){
                    Booster booster = new Booster(world,r);
                    world.spawnEntity(booster);
                }

                if(!player.capabilities.isCreativeMode){
                    player.getHeldItem(hand).shrink(1);
                }
                cir.setReturnValue(new ActionResult(EnumActionResult.SUCCESS, player.getHeldItem(hand)));
            }
        }
    }
}
