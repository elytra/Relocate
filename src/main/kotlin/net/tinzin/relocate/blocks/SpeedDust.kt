package net.tinzin.relocate.blocks

import net.minecraft.block.Block
import net.minecraft.block.material.EnumPushReaction
import net.minecraft.block.state.BlockFaceShape
import net.minecraft.block.state.IBlockState
import net.minecraft.entity.Entity
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.MobEffects
import net.minecraft.potion.Potion
import net.minecraft.potion.PotionEffect
import net.minecraft.potion.PotionUtils
import net.minecraft.util.BlockRenderLayer
import net.minecraft.util.EnumFacing
import net.minecraft.util.math.BlockPos
import net.minecraft.util.math.shapes.VoxelShape
import net.minecraft.world.IBlockReader
import net.minecraft.world.IWorldReaderBase
import net.minecraft.world.World
import net.minecraft.block.material.MapColor
import net.minecraft.block.material.Material


class SpeedDust : Block {

    constructor(p_i48440_1_: Builder?) : super(p_i48440_1_){
    }

    override fun getRenderLayer(): BlockRenderLayer {
        return BlockRenderLayer.TRANSLUCENT
    }

    override fun getShape(p_getCollisionShape_1_: IBlockState?, p_getCollisionShape_2_: IBlockReader?, p_getCollisionShape_3_: BlockPos?): VoxelShape {
        return Block.makeCuboidShape(1.0,0.0,1.0,15.0,1.0,15.0)
    }

    /*override fun getCollisionShape(p_getCollisionShape_1_: IBlockState?, p_getCollisionShape_2_: IBlockReader?, p_getCollisionShape_3_: BlockPos?): VoxelShape {
        return Block.makeCuboidShape(0.0,0.0,0.0,16.0,8.0,16.0)
    }*/

    override fun isValidPosition(state: IBlockState, worldreader: IWorldReaderBase, position: BlockPos): Boolean {
        return worldreader.getBlockState(position.down()).isTopSolid
    }

    override fun onEntityCollision(state: IBlockState, world: World, position: BlockPos, entity: Entity) {
        if(entity is EntityPlayer){
            var player : EntityPlayer = entity
            player.addPotionEffect(PotionEffect(MobEffects.SPEED,2,2,true,false))
        }
    }

    override fun isSolid(p_isSolid_1_: IBlockState?): Boolean {
        return false
    }

    override fun isFullCube(p_isFullCube_1_: IBlockState?): Boolean {
        return false
    }

    override fun getBlockFaceShape(p_getBlockFaceShape_1_: IBlockReader?, p_getBlockFaceShape_2_: IBlockState?, p_getBlockFaceShape_3_: BlockPos?, p_getBlockFaceShape_4_: EnumFacing?): BlockFaceShape {
        return BlockFaceShape.UNDEFINED
    }

    override fun getPushReaction(p_getPushReaction_1_: IBlockState?): EnumPushReaction {
        return EnumPushReaction.DESTROY
    }

}