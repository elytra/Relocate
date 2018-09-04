package net.tinzin.relocate.items

import net.minecraft.init.Items
import net.minecraft.init.SoundEvents
import net.minecraft.inventory.EntityEquipmentSlot
import net.minecraft.item.Item
import net.minecraft.item.ItemArmor
import net.minecraft.item.crafting.Ingredient
import net.minecraft.util.IItemProvider
import org.dimdev.rift.util.ArmorMaterialImpl

class SlimeBoots(builder: Item.Builder, damageArray: IntArray) : ItemArmor(ArmorMaterialImpl("relocate:slime", 0,
        damageArray, 0, SoundEvents.BLOCK_SLIME_BLOCK_PLACE, 0f)
        { Ingredient.fromItems(IItemProvider { Items.SLIME_BALL }) },
        EntityEquipmentSlot.FEET, builder) {

}