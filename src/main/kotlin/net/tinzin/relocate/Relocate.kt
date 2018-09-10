package net.tinzin.relocate

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.entity.EntityType
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemGroup
import net.minecraft.util.ResourceLocation
import net.tinzin.relocate.blocks.SpeedDust
import net.tinzin.relocate.entities.Booster
import net.tinzin.relocate.items.SlimeBoots
import net.tinzin.relocate.items.Springboard
import org.dimdev.rift.listener.BlockAdder
import org.dimdev.rift.listener.EntityTypeAdder
import org.dimdev.rift.listener.ItemAdder

class Relocate : BlockAdder, ItemAdder, EntityTypeAdder {

    override fun registerBlocks() {
        Block.register(ResourceLocation("relocate:speeddust"), SPEEDDUST)
    }

    override fun registerItems() {
        Item.registerItem("relocate:springboard", SPRINGBOARD)
        Item.registerItem("relocate:slime_boots", SLIMEBOOTS)
        Item.register(ItemBlock(SPEEDDUST,Item.Builder().group(ItemGroup.TRANSPORTATION)))
    }

    override fun registerEntityTypes() {
        EntityType.register("relocate:booster", BOOSTER_BUILD)
    }

    companion object {
        val SPRINGBOARD = Springboard(Item.Builder().group(net.minecraft.item.ItemGroup.TRANSPORTATION))

        private val damageArray : IntArray = IntArray(4){_ -> 0}
        val SLIMEBOOTS = SlimeBoots(Item.Builder().group(net.minecraft.item.ItemGroup.COMBAT),damageArray)

        private val DUST = Material.Builder(MapColor.AIR).notSolid().doesNotBlockMovement().build()
        val SPEEDDUST = SpeedDust(Block.Builder.create(DUST).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.SAND))

        val BOOSTER_BUILD = EntityType.Builder.create(Booster::class.java)
        val BOOSTER = BOOSTER_BUILD.build("relocate:booster")
        //var EXAMPLE_TE: TileEntityType<TileEntityExample>
    }
}
