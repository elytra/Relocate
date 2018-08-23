package net.tinzin.relocate.mixin;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EntityBoat.class)
public abstract class MixinEntityBoat extends Entity {

    @Shadow
    boolean forwardInputDown;

    @Shadow
    boolean backInputDown;

    @Shadow
    boolean leftInputDown;

    @Shadow
    boolean rightInputDown;

    public MixinEntityBoat(World world) {
        super(EntityType.BOAT, world);
    }

    @SuppressWarnings("UnusedAssignment")
    @Inject(method = "x",
            at = @At(value = "FIELD", target = "Lapf;aB:Z", ordinal = 1),
            locals = LocalCapture.CAPTURE_FAILHARD,
            remap = false)
    public void appendAdditionalMotion(CallbackInfo ci, float lvt_1_1_) {
        if (this.forwardInputDown) {
            lvt_1_1_ += 2.0F;
        }

    }

}
