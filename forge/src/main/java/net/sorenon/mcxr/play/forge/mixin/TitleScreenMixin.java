package net.sorenon.mcxr.play.forge.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.sorenon.mcxr.play.MCXROptionsScreen;
import net.sorenon.mcxr.play.MCXRPlayClient;
import net.sorenon.mcxr.play.MCXRPlayExpectPlatform;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class TitleScreenMixin extends Screen {
    @Shadow
    @Final
    private boolean fading;
    @Shadow
    private long fadeInStart;
    @Unique
    private static boolean initialized = false;

    protected TitleScreenMixin(Component arg) {
        super(arg);
    }

    @Inject(method = "render", at = @At(value = "INVOKE", target = "Ljava/util/List;iterator()Ljava/util/Iterator;", shift = At.Shift.BEFORE))
    void render(PoseStack matrices, int mouseX, int mouseY, float delta, CallbackInfo ci) {
        if (!initialized) {
            if (MCXRPlayClient.OPEN_XR_STATE.session == null) {
                MCXRPlayClient.OPEN_XR_STATE.tryInitialize();
            }
            initialized = true;
        }
        float f = this.fading ? (float) (Util.getMillis() - this.fadeInStart) / 1000.0F : 1.0F;
        float g = this.fading ? Mth.clamp(f - 1.0F, 0.0F, 1.0F) : 1.0F;
        int l = Mth.ceil(g * 255.0F) << 24;
        int y = this.height / 4 + 48;
        int x = this.width / 2 + 104;

        if (!MCXRPlayExpectPlatform.isModLoaded("modmenu")) {
            y += 12;
        }

        MCXROptionsScreen.renderStatus(this, this.font, matrices, mouseX, mouseY, x, y, l, 20);
    }
}
