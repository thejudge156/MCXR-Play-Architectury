package net.sorenon.mcxr.play.rendering;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.util.Mth;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public interface VrFirstPersonRenderer {

    /**
     * This function contains a lot of depth hackery so each draw call has to be done in a specific order
     */
    void renderLast(Object context);

    static void stringVertex(float x,
                             float y,
                             float z,
                             VertexConsumer buffer,
                             PoseStack.Pose normal,
                             float f,
                             float g,
                             boolean blocked) {
        float x1 = x * f;
        float y1 = y * (f * f + f) * 0.5F;
        float z1 = z * f;

        float x2 = x * g;
        float y2 = y * (g * g + g) * 0.5F;
        float z2 = z * g;

        float dx = x2 - x1;
        float dy = y2 - y1;
        float dz = z2 - z1;
        float n1 = Mth.sqrt(dx * dx * dy * dy + dz * dz);
        dx /= n1;
        dy /= n1;
        dz /= n1;
        if (blocked) {
            buffer.vertex(normal.pose(), x1, y1, z1).color(1, 0.3f, 0.3f, 1).normal(normal.normal(), dx, dy, dz).endVertex();
            buffer.vertex(normal.pose(), x2, y2, z2).color(1, 0.3f, 0.3f, 1).normal(normal.normal(), dx, dy, dz).endVertex();
        } else {
            buffer.vertex(normal.pose(), x1, y1, z1).color(0.3f, 0.3f, 1, 1).normal(normal.normal(), dx, dy, dz).endVertex();
            buffer.vertex(normal.pose(), x2, y2, z2).color(0.3f, 0.3f, 1, 1).normal(normal.normal(), dx, dy, dz).endVertex();
        }
    }

    static int getLight(Camera camera, Level world) {
        return LightTexture.pack(world.getBrightness(LightLayer.BLOCK, camera.getBlockPosition()), world.getBrightness(LightLayer.SKY, camera.getBlockPosition()));
    }

    void transformToHand(PoseStack matrices, int hand, float tickDelta);

    void renderGuiQuad(PoseStack.Pose transform, MultiBufferSource consumers);

    void render(LocalPlayer player,
                int light,
                PoseStack matrices,
                MultiBufferSource consumers,
                float deltaTick);

    void onPreBlockEntityRender(PoseStack matrices, MultiBufferSource consumer, Level level, float partialTicks);
}
