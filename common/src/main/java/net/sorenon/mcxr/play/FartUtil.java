package net.sorenon.mcxr.play;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.math.Matrix3f;
import com.mojang.math.Matrix4f;
import net.minecraft.Util;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import java.util.function.BiFunction;

public class FartUtil {

    public static void renderCrosshair(MultiBufferSource consumerProvider, PoseStack poseStack, float size, boolean depthTest) {
        renderCrosshair(consumerProvider, poseStack, size, depthTest, true, true, true);
    }

    public static void renderCrosshair(MultiBufferSource consumerProvider, PoseStack poseStack, float size, boolean depthTest, boolean drawX, boolean drawY, boolean drawZ) {
        Matrix4f model = poseStack.last().pose();
        Matrix3f normal = poseStack.last().normal() ;

        VertexConsumer consumer = consumerProvider.getBuffer(LINE_COLOR_ONLY.apply(4d, depthTest));
        if (drawX) {
            consumer.vertex(model, 0.0f, 0.0f, 0.0f).color(0, 0, 0, 255).normal(normal, 1.0F, 0.0F, 0.0F).endVertex();
            consumer.vertex(model, size, 0.0f, 0.0f).color(0, 0, 0, 255).normal(normal, 1.0F, 0.0F, 0.0F).endVertex();
        }

        if (drawY) {
            consumer.vertex(model, 0.0f, 0.0f, 0.0f).color(0, 0, 0, 255).normal(normal, 0.0F, 1.0F, 0.0F).endVertex();
            consumer.vertex(model, 0.0f, size, 0.0f).color(0, 0, 0, 255).normal(normal, 0.0F, 1.0F, 0.0F).endVertex();
        }

        if (drawZ) {
            consumer.vertex(model, 0.0f, 0.0f, 0.0f).color(0, 0, 0, 255).normal(normal, 0.0F, 0.0F, 1.0F).endVertex();
            consumer.vertex(model, 0.0f, 0.0f, size).color(0, 0, 0, 255).normal(normal, 0.0F, 0.0F, 1.0F).endVertex();
        }

        consumer = consumerProvider.getBuffer(LINE.apply(2d, depthTest));

        if (drawX) {
            consumer.vertex(model, 0.0f, 0.0f, 0.0f).color(255, 0, 0, 255).normal(normal, 1.0F, 0.0F, 0.0F).endVertex();
            consumer.vertex(model, size, 0.0f, 0.0f).color(255, 0, 0, 255).normal(normal, 1.0F, 0.0F, 0.0F).endVertex();
        }

        if (drawY) {
            consumer.vertex(model, 0.0f, 0.0f, 0.0f).color(0, 255, 0, 255).normal(normal, 0.0F, 1.0F, 0.0F).endVertex();
            consumer.vertex(model, 0.0f, size, 0.0f).color(0, 255, 0, 255).normal(normal, 0.0F, 1.0F, 0.0F).endVertex();
        }

        if (drawZ) {
            consumer.vertex(model, 0.0f, 0.0f, 0.0f).color(127, 127, 255, 255).normal(normal, 0.0F, 0.0F, 1.0F).endVertex();
            consumer.vertex(model, 0.0f, 0.0f, size).color(127, 127, 255, 255).normal(normal, 0.0F, 0.0F, 1.0F).endVertex();
        }
    }

    public static final BiFunction<Double, Boolean, RenderType> LINE = Util.memoize((lineWidth, depthTest) -> {
        RenderStateShard.DepthTestStateShard depthTest1 = RenderStateShards.NO_DEPTH_TEST;
        if (depthTest) {
            depthTest1 = RenderStateShards.LEQUAL_DEPTH_TEST;
        }

        RenderTypeBuilder builder = new RenderTypeBuilder(new ResourceLocation("fart", "line"), DefaultVertexFormat.POSITION_COLOR_NORMAL, VertexFormat.Mode.LINES, 16, false, false);
        builder.innerBuilder
                .setShaderState(RenderStateShards.shader(GameRenderer::getRendertypeLinesShader))
                .setLineState(RenderStateShards.lineWidth(lineWidth))
                .setLayeringState(RenderStateShards.VIEW_OFFSET_Z_LAYERING)
                .setTransparencyState(RenderStateShards.TRANSLUCENT_TRANSPARENCY)
                .setWriteMaskState(RenderStateShards.COLOR_DEPTH_WRITE)
                .setCullState(RenderStateShards.NO_CULL)
                .setDepthTestState(depthTest1);
        return builder.build(true);
    });

    public static final BiFunction<Double, Boolean, RenderType> LINE_COLOR_ONLY = Util.memoize((lineWidth, depthTest) -> {
        RenderStateShard.DepthTestStateShard depthTest1 = RenderStateShards.NO_DEPTH_TEST;
        if (depthTest) {
            depthTest1 = RenderStateShards.LEQUAL_DEPTH_TEST;
        }

        RenderTypeBuilder builder = new RenderTypeBuilder(new ResourceLocation("fart", "line_color_only"), DefaultVertexFormat.POSITION_COLOR_NORMAL, VertexFormat.Mode.LINES, 16, false, false);
        builder.innerBuilder
                .setShaderState(RenderStateShards.shader(GameRenderer::getRendertypeLinesShader))
                .setLineState(RenderStateShards.lineWidth(lineWidth))
                .setLayeringState(RenderStateShards.VIEW_OFFSET_Z_LAYERING)
                .setTransparencyState(RenderStateShards.TRANSLUCENT_TRANSPARENCY)
                .setWriteMaskState(RenderStateShards.COLOR_WRITE)
                .setCullState(RenderStateShards.NO_CULL)
                .setDepthTestState(depthTest1);
        return builder.build(true);
    });
}
