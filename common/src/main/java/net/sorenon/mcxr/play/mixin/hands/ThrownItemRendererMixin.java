package net.sorenon.mcxr.play.mixin.hands;

import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.ItemSupplier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ThrownItemRenderer.class)
public abstract class ThrownItemRendererMixin<T extends Entity & ItemSupplier> extends EntityRenderer<T> {

    @Shadow @Final private float scale;

    @Shadow @Final private ItemRenderer itemRenderer;

    protected ThrownItemRendererMixin(EntityRendererProvider.Context context) {
        super(context);
    }

//    This fails outside of dev-env for some reason
//    @Inject(method = "render", at = @At("HEAD"))
//    void preRender(T entity,
//                   float f,
//                   float delta,
//                   PoseStack poseStack,
//                   MultiBufferSource multiBufferSource,
//                   int i,
//                   CallbackInfo ci) {
//        if (MCXRPlayClient.MCXR_GAME_RENDERER.isXrMode() && entity.tickCount <= 1) {
//            float scale = ((entity.tickCount + delta) / 2) * this.scale;
//
//            poseStack.pushPose();
//            poseStack.scale(scale, scale, scale);
//            poseStack.mulPose(this.entityRenderDispatcher.cameraOrientation());
//            poseStack.mulPose(Vector3f.YP.rotationDegrees(180.0F));
//            this.itemRenderer.renderStatic(entity.getItem(), ItemTransforms.TransformType.GROUND, i, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, entity.getId());
//            poseStack.popPose();
//            super.render(entity, f, delta, poseStack, multiBufferSource, i);
//        }
//    }
}
