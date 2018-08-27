package net.tinzin.relocate.items

import net.minecraft.init.Items
import net.minecraft.init.SoundEvents
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.IArmorMaterial
import net.minecraft.item.ItemArmor
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.IItemProvider
import net.minecraft.util.SoundEvent

class SlimeBoots/* : ItemArmor */{
    private val SLIME = object : IArmorMaterial{
        override fun func_200896_a(p_200896_1_: EntityEquipmentSlot): Int {
            return 0
        }

        override fun func_200902_b(p_200902_1_: EntityEquipmentSlot): Int {
            return 0
        }

        override fun getEnchantability(): Int {
            return 0
        }

        override fun getSoundEvent(): SoundEvent {
            return SoundEvents.BLOCK_SLIME_BLOCK_PLACE
        }

        override fun func_200898_c(): Ingredient {
            return Ingredient.fromItems(IItemProvider { Items.SLIME_BALL })
        }

        override fun getName(): String {
            return "slime"
        }

        override fun getToughness(): Float {
            return 0f
        }
    }


}