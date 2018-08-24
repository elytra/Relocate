package net.tinzin.relocate

import net.minecraft.item.Item
import net.minecraft.entity.player.EntityPlayer

class Springboard : Item {
    constructor(builder: Item.Builder) : super(builder) {}

    override fun onItemUse(context : net.minecraft.item.ItemUseContext): net.minecraft.util.EnumActionResult{
        var player : EntityPlayer? = context.getPlayer()

        if (player == null){return net.minecraft.util.EnumActionResult.FAIL} // check for null

        if (player.onGround){
            player.addVelocity(0.0,2.0,0.0) // wheeeee
            return net.minecraft.util.EnumActionResult.SUCCESS
        }
        return net.minecraft.util.EnumActionResult.PASS
    }
}