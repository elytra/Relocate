package net.tinzin.relocate

import org.dimdev.riftloader.listener.InitializationListener
import org.spongepowered.asm.launch.MixinBootstrap
import org.spongepowered.asm.mixin.Mixins

class RelocateCore : InitializationListener {
    override fun onInitialization() {
        MixinBootstrap.init() // not needed for much longer
    }
}
