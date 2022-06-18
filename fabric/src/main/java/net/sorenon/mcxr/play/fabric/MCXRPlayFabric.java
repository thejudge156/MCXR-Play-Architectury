package net.sorenon.mcxr.play.fabric;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientLifecycleEvents;
import net.fabricmc.fabric.api.client.rendering.v1.WorldRenderEvents;
import net.minecraft.client.Camera;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.sorenon.fart.FartRenderEvents;
import net.sorenon.mcxr.play.MCXRPlayClient;
import net.sorenon.mcxr.play.fabric.rendering.VrFirstPersonRendererImpl;
import net.sorenon.mcxr.play.rendering.RenderPass;
import net.sorenon.mcxr.play.rendering.VrFirstPersonRenderer;

import static net.minecraft.client.gui.GuiComponent.GUI_ICONS_LOCATION;
import static net.sorenon.mcxr.play.MCXRPlayClient.MCXR_GAME_RENDERER;

public class MCXRPlayFabric implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MCXRPlayClient.INSTANCE.init();
        MCXRPlayClient.INSTANCE.vrFirstPersonRenderer = new VrFirstPersonRendererImpl(MCXRPlayClient.INSTANCE.MCXRGuiManager);

        ClientLifecycleEvents.CLIENT_STARTED.register(MCXR_GAME_RENDERER::initialize);

        WorldRenderEvents.AFTER_ENTITIES.register(context -> {
            if (MCXR_GAME_RENDERER.renderPass instanceof RenderPass.XrWorld) {
                if (!Minecraft.getInstance().options.hideGui && !MCXRPlayClient.INSTANCE.MCXRGuiManager.isScreenOpen()) {
                    Camera camera = context.camera();

                    var matrices = context.matrixStack();

                    var hitResult = Minecraft.getInstance().hitResult;
                    if (hitResult != null && !MCXRPlayClient.INSTANCE.MCXRGuiManager.isScreenOpen()) {
                        Vec3 camPos = camera.getPosition();
                        matrices.pushPose();

                        double x = hitResult.getLocation().x();
                        double y = hitResult.getLocation().y();
                        double z = hitResult.getLocation().z();
                        matrices.translate(x - camPos.x, y - camPos.y, z - camPos.z);

                        if (hitResult.getType() == HitResult.Type.BLOCK) {
                            matrices.mulPose(((BlockHitResult) hitResult).getDirection().getRotation());
                        } else {
                            matrices.mulPose(camera.rotation());
                            matrices.mulPose(com.mojang.math.Vector3f.XP.rotationDegrees(90.0F));
                        }

                        matrices.scale(0.5f, 1, 0.5f);
                        RenderType cursorLayer = RenderType.entityCutoutNoCull(GUI_ICONS_LOCATION);
                        VertexConsumer vertexConsumer = context.consumers().getBuffer(cursorLayer);

                        PoseStack.Pose entry = matrices.last();

                        vertexConsumer.vertex(entry.pose(), -0.5f + (0.5f / 16f), 0.005f, -0.5f + (0.5f / 16f)).color(1.0F, 1.0F, 1.0F, 1.0f).uv(0, 0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(0.0F, 0.0F, 1.0F).endVertex();
                        vertexConsumer.vertex(entry.pose(), -0.5f + (0.5f / 16f), 0.005f, 0.5f + (0.5f / 16f)).color(1.0F, 1.0F, 1.0F, 1.0f).uv(0, 0.0625f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(0.0F, 0.0F, 1.0F).endVertex();
                        vertexConsumer.vertex(entry.pose(), 0.5f + (0.5f / 16f), 0.005f, 0.5f + (0.5f / 16f)).color(1.0F, 1.0F, 1.0F, 1.0f).uv(0.0625f, 0.0625f).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(0.0F, 0.0F, 1.0F).endVertex();
                        vertexConsumer.vertex(entry.pose(), 0.5f + (0.5f / 16f), 0.005f, -0.5f + (0.5f / 16f)).color(1.0F, 1.0F, 1.0F, 1.0f).uv(0.0625f, 0).overlayCoords(OverlayTexture.NO_OVERLAY).uv2(15728880).normal(0.0F, 0.0F, 1.0F).endVertex();

                        matrices.popPose();
                    }

                    if (camera.getEntity() instanceof LocalPlayer player) {
                        MCXRPlayClient.INSTANCE.vrFirstPersonRenderer.render(
                                player,
                                VrFirstPersonRenderer.getLight(camera, context.world()),
                                context.matrixStack(),
                                context.consumers(),
                                context.tickDelta()
                        );
                    }
                }
            }
        });

        FartRenderEvents.LAST.register(context -> {
            if (MCXR_GAME_RENDERER.renderPass instanceof RenderPass.XrWorld) {
                MCXRPlayClient.INSTANCE.vrFirstPersonRenderer.renderLast(context);
            }
        });
    }
}
