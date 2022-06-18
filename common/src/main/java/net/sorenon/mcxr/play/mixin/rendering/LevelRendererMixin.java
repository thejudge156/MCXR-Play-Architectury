package net.sorenon.mcxr.play.mixin.rendering;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.LevelRenderer;
import net.sorenon.mcxr.play.rendering.MCXRMainTarget;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    @Shadow @Final private Minecraft minecraft;

    @Inject(method = "graphicsChanged()V", at = @At("RETURN"))
    void onGraphicsChanged(CallbackInfo ci) {
        MCXRMainTarget MCXRMainTarget = (MCXRMainTarget) minecraft.getMainRenderTarget();
        MCXRMainTarget.minecraftFramebufferWidth = minecraft.getMainRenderTarget().width;
        MCXRMainTarget.minecraftFramebufferHeight = minecraft.getMainRenderTarget().height;
    }

//    @Inject(method = "setupRender", at = @At("HEAD"), cancellable = true)
//    void cancelSetupRender(CallbackInfo ci) {
//        if (MCXRPlayClient.RENDERER.renderPass != RenderPass.VANILLA && MCXRPlayClient.RENDERER.eye != 0) {
//            ci.cancel();
//        }
//    }
}
