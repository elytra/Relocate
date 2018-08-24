package net.tinzin.relocate

import net.minecraft.item.Item
import net.minecraft.util.ResourceLocation
import org.dimdev.rift.listener.BlockAdder
import org.dimdev.rift.listener.ItemAdder

class Relocate : BlockAdder, ItemAdder {

    override fun registerBlocks() {
        //Block.register(ResourceLocation("examplemod:example_block"), EXAMPLE_BLOCK)
    }

    override fun registerItems() {
        Item.registerItem(ResourceLocation("relocate:springboard"), SPRINGBOARD)
        //Item.registerItemBlock(EXAMPLE_BLOCK, ItemGroup.DECORATION)
        //Item.registerItem(ResourceLocation("examplemod:example_item"), EXAMPLE_ITEM)
    }

    companion object {
        val SPRINGBOARD = Springboard(Item.Builder().group(net.minecraft.item.ItemGroup.TRANSPORTATION))

        //val EXAMPLE_ITEM = Item(Item.Builder().group(ItemGroup.DECORATION).rarity(EnumRarity.RARE))

        //val EXAMPLE_BLOCK = BlockExample(Block.Builder.create(Material.ROCK, MapColor.STONE).hardnessAndResistance(2f, 3f).sound(SoundType.METAL))

        //var EXAMPLE_TE: TileEntityType<TileEntityExample>
    }
}
