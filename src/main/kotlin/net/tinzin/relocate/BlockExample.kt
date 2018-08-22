package net.tinzin.relocate

import net.minecraft.block.ITileEntityProvider
import net.minecraft.tileentity.TileEntity

class BlockExample : Block(), ITileEntityProvider {

    constructor(builder: Builder) : super(builder) {}

    fun hasTileEntity(): Boolean {
        return true
    }

    fun createNewTileEntity(world: IBlockReader): TileEntity {
        return TileEntityExample()
    }

}
