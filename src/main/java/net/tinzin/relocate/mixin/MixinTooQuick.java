package net.tinzin.relocate.mixin;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.NetHandlerPlayServer;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(NetHandlerPlayServer.class)
public class MixinTooQuick {
    @Redirect(method = "processPlayer",
    at=@At(value = "INVOKE", target = "Lnet/minecraft/entity/player/EntityPlayerMP;isInvulnerableDimensionChange()Z", ordinal = 0),
    require = 1)
    boolean elyRedirect(EntityPlayerMP entityPlayerMP){
        return true;
    }

    @Redirect(method = "processVehicleMove",
    at=@At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;isSinglePlayer()Z", ordinal = 0))
    boolean spRedirect(MinecraftServer minecraftServer){
        return true;
    }
    @Redirect(method = "processVehicleMove",
    at=@At(value = "INVOKE", target = "Ljava/lang/String;equals(Ljava/lang/Object;)Z", ordinal = 0))
    boolean strRecdirect(String s, Object o){
        return true;
    }
}
