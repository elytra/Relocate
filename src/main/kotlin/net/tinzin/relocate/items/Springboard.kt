package net.tinzin.relocate

import net.minecraft.item.Item
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.SoundEvents
import net.minecraft.util.SoundEvent

class Springboard : Item {
    val VELOCITY = 3.0 // arcane speed units

    constructor(builder: Item.Builder) : super(builder) {}

    override fun onItemUse(context : net.minecraft.item.ItemUseContext): net.minecraft.util.EnumActionResult{
        var player : EntityPlayer? = context.getPlayer()

        if (player == null){return net.minecraft.util.EnumActionResult.FAIL} // check for null

        if (player.onGround){
            player.playSound(SoundEvents.BLOCK_PISTON_EXTEND, .7f, 1f)
            player.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, .7f, 1f)
            player.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_SHOOT, .5f, 1f)
            player.addVelocity(0.0,VELOCITY,0.0) // wheeeee
            player.cooldownTracker.setCooldown(this, 20)
        }
        return net.minecraft.util.EnumActionResult.PASS
    }
}