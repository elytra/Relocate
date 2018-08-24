package net.tinzin.relocate

import net.minecraft.block.Block
import net.minecraft.block.SoundType
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material
import net.minecraft.item.Item
import net.minecraft.item.ItemBlock
import net.minecraft.item.ItemGroup
import net.minecraft.util.ResourceLocation
import net.tinzin.relocate.blocks.SpeedDust
import net.tinzin.relocate.items.Springboard
import org.dimdev.rift.listener.BlockAdder
import org.dimdev.rift.listener.ItemAdder

class Relocate : BlockAdder, ItemAdder {

    override fun registerBlocks() {
        Block.register(ResourceLocation("relocate:speeddust"), SPEEDDUST)
        //Block.register(ResourceLocation("examplemod:example_block"), EXAMPLE_BLOCK)
    }

    override fun registerItems() {
        Item.registerItem(ResourceLocation("relocate:springboard"), SPRINGBOARD)
        Item.registerItemBlock(ItemBlock(SPEEDDUST,Item.Builder().group(ItemGroup.TRANSPORTATION)))
        //Item.registerItemBlock(EXAMPLE_BLOCK, ItemGroup.DECORATION)
        //Item.registerItem(ResourceLocation("examplemod:example_item"), EXAMPLE_ITEM)
    }

    companion object {
        val DUST = Material.Builder(MapColor.AIR).notSolid().doesNotBlockMovement().build()


        val SPRINGBOARD = Springboard(Item.Builder().group(net.minecraft.item.ItemGroup.TRANSPORTATION))

        val SPEEDDUST = SpeedDust(Block.Builder.create(DUST).doesNotBlockMovement().zeroHardnessAndResistance().sound(SoundType.SAND))

        //val EXAMPLE_ITEM = Item(Item.Builder().group(ItemGroup.DECORATION).rarity(EnumRarity.RARE))

        //val EXAMPLE_BLOCK = BlockExample(Block.Builder.create(Material.ROCK, MapColor.STONE).hardnessAndResistance(2f, 3f).sound(SoundType.METAL))

        //var EXAMPLE_TE: TileEntityType<TileEntityExample>
    }
}
