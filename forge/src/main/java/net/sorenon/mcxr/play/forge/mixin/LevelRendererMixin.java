package net.sorenon.mcxr.play.forge.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Matrix4f;
import net.minecraft.client.Camera;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.RenderBuffers;
import net.sorenon.mcxr.play.MCXRPlayClient;
import net.sorenon.mcxr.play.rendering.RenderPass;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import javax.annotation.Nullable;

import static net.sorenon.mcxr.play.MCXRPlayClient.MCXR_GAME_RENDERER;

@Mixin(LevelRenderer.class)
public class LevelRendererMixin {
    @Shadow @Final public RenderBuffers renderBuffers;

    @Shadow @Nullable public ClientLevel level;

    @Inject(method = "renderLevel", at = @At(value = "INVOKE", target = "Lnet/minecraft/util/profiling/ProfilerFiller;popPush(Ljava/lang/String;)V", shift = At.Shift.BEFORE, ordinal = 11))
    private void renderLevel(PoseStack stack, float partialTick, long m, boolean bl, Camera arg2, GameRenderer arg3, LightTexture arg4, Matrix4f arg5, CallbackInfo ci) {
        if (MCXR_GAME_RENDERER.renderPass instanceof RenderPass.XrWorld) {
            MCXRPlayClient.INSTANCE.vrFirstPersonRenderer.onPreBlockEntityRender(stack, this.renderBuffers.bufferSource(), this.level, partialTick);
        }
    }

    @Inject(method = "setupRender", at = @At("HEAD"), cancellable = true)
    void cancelSetupRender(CallbackInfo ci) {
        if (MCXRPlayClient.MCXR_GAME_RENDERER.renderPass == RenderPass.VANILLA) {
            ci.cancel();
        }
    }

    @Inject(method = "renderLevel", at = @At("HEAD"), cancellable = true)
    void cancelRender(CallbackInfo ci) {
        if (MCXRPlayClient.MCXR_GAME_RENDERER.renderPass == RenderPass.VANILLA) {
            ci.cancel();
        }
    }
}
