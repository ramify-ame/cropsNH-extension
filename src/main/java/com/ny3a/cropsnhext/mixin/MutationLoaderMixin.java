package com.ny3a.cropsnhext.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.gtnewhorizon.cropsnh.loaders.MutationLoader;
import com.ny3a.cropsnhext.crops.CropExtender;

@Mixin(value = MutationLoader.class, remap = false)
public abstract class MutationLoaderMixin {

    @Inject(method = "postInit()V", at = @At("RETURN"), require = 1)
    private static void cropsnhext$registerCrops(CallbackInfo ci) {
        CropExtender.register();
    }
}
