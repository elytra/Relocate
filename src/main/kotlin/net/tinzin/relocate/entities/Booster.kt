package net.tinzin.relocate.entities

import net.minecraft.entity.Entity
import net.minecraft.entity.item.EntityBoat
import net.minecraft.nbt.NBTTagCompound
import net.minecraft.util.math.MathHelper
import net.minecraft.world.World
import net.tinzin.relocate.Relocate

class Booster : Entity {
    constructor(w: World, attached: Entity) : super(Relocate.BOOSTER, w) {
        this.attached = attached
    }

    private val lifetime : Int = 20
    private var age : Int = 0
    private var attached : Entity

    override fun entityInit() {}

    override fun onUpdate() {
        super.onUpdate()
        if(attached is EntityBoat){
            val scaleX = MathHelper.sin(-attached.rotationYaw * 0.017453292f) //yay magic numbers
            val scaleZ = MathHelper.cos( attached.rotationYaw * 0.017453292f)
            attached.motionX += scaleX * 0.1 + (scaleX * 1.5 - attached.motionX) * 0.5 //sparkles emoji
            attached.motionZ += scaleZ * 0.1 + (scaleZ * 1.5 - attached.motionZ) * 0.5

            this.setPosition(attached.posX, attached.posY, attached.posZ)
        }

        ++age
        if(!world.isRemote && age > lifetime){
            setDead()
        }
    }

    override fun readEntityFromNBT(tag: NBTTagCompound) {
        this.age = tag.getInteger("age")
    }

    override fun writeEntityToNBT(tag: NBTTagCompound) {
        tag.setInteger("age", this.age)
    }

}