package net.tinzin.relocate.items

import net.minecraft.item.Item
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.init.Items
import net.minecraft.init.SoundEvents
import net.minecraft.item.IItemTier
import net.minecraft.item.ItemTier
import net.minecraft.item.ItemTiered
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.IItemProvider
import net.minecraft.util.SoundEvent

class Springboard(builder: Item.Builder) : ItemTiered(PistonTier(), builder) {
    val VELOCITY = 3.0 // arcane speed units
    private class PistonTier : IItemTier {
        override fun getMaxUses(): Int {return 4}

        override fun getEfficiency(): Float {return 0f}

        override fun getAttackDamage(): Float {return 0f}

        override fun getHarvestLevel(): Int {return 0}

        override fun getEnchantability(): Int {return 0}

        override fun func_200924_f(): Ingredient {
            return Ingredient.fromItems(IItemProvider { Items.FIREWORK_ROCKET })
        }
    }

    override fun onItemUse(context : net.minecraft.item.ItemUseContext): net.minecraft.util.EnumActionResult{
        var player : EntityPlayer? = context.getPlayer()

        if (player == null){return net.minecraft.util.EnumActionResult.FAIL} // check for null

        if (player.onGround){
            player.playSound(SoundEvents.BLOCK_PISTON_EXTEND, .7f, 1f)
            player.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_LAUNCH, .7f, 1f)
            player.playSound(SoundEvents.ENTITY_FIREWORK_ROCKET_SHOOT, .5f, 1f)
            player.addVelocity(0.0,VELOCITY,0.0) // wheeeee
            player.cooldownTracker.setCooldown(this, 20)
            context.item.damageItem(1,player)
        }
        return net.minecraft.util.EnumActionResult.PASS
    }
}