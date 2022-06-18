package net.sorenon.mcxr.play;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.HumanoidArm;
import net.sorenon.mcxr.core.MCXRCore;
import net.sorenon.mcxr.core.MCXRCoreExpectPlatform;
import net.sorenon.mcxr.play.input.ControllerPoses;
import net.sorenon.mcxr.play.openxr.MCXRGameRenderer;
import net.sorenon.mcxr.play.openxr.OpenXRState;
import net.sorenon.mcxr.play.rendering.VrFirstPersonRenderer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.joml.Quaternionf;
import org.joml.Vector3d;
import org.joml.Vector3f;
import org.lwjgl.openxr.XR;

public class MCXRPlayClient {
    public static final String MOD_ID = "mcxrplay";

    public static Logger LOGGER = LogManager.getLogger("MCXR");

    public static final OpenXRState OPEN_XR_STATE = new OpenXRState();
    public static final MCXRGameRenderer MCXR_GAME_RENDERER = new MCXRGameRenderer();

    public static MCXRPlayClient INSTANCE = new MCXRPlayClient();
    public MCXRGuiManager MCXRGuiManager = new MCXRGuiManager();
    public VrFirstPersonRenderer vrFirstPersonRenderer;
    public static final ControllerPoses viewSpacePoses = new ControllerPoses();

    //Stage space => Unscaled Physical Space => Physical Space => Minecraft Space
    //OpenXR         GUI                        Roomscale Logic   Minecraft Logic
    //      Rotated + Translated           Scaled          Translated

    public static boolean heightAdjustStand = false;

    public static float heightAdjust = 0;

    /**
     * The yaw rotation of STAGE space in physical space
     * Used to let the user turn
     */
    public static float stageTurn = 0;

    /**
     * The position of STAGE space in physical space
     * Used to let the user turn around one physical space position and
     * to let the user snap to the player entity position when roomscale movement is off
     */
    public static Vector3f stagePosition = new Vector3f(0, 0, 0);

    /**
     * The position of physical space in Minecraft space
     * xrOrigin = camaraEntity.pos - playerPhysicalPosition
     */
    public static Vector3d xrOrigin = new Vector3d(0, 0, 0);

    /**
     * The position of the player entity in physical space
     * If roomscale movement is disabled this vector is zero (meaning the player is at xrOrigin)
     * This is used to calculate xrOrigin
     */
    public static Vector3d playerPhysicalPosition = new Vector3d();

    public static int getMainHand() {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player != null) {
            return player.getMainArm().ordinal();
        } else {
            return HumanoidArm.RIGHT.ordinal();
        }
    }

    public void init() {
        PlayOptions.init();
        PlayOptions.load();
        PlayOptions.save();

        INSTANCE = this;
        if (!PlayOptions.xrUninitialized) {
            XR.create("openxr_loader");
        }
    }

    public static ResourceLocation id(String name) {
        return new ResourceLocation("mcxrplay", name);
    }

    public static void resetView() {
        Vector3f pos = new Vector3f(MCXRPlayClient.viewSpacePoses.getStagePose().getPos());
        new Quaternionf().rotateLocalY(stageTurn).transform(pos);
        if (MCXRCore.getCoreConfig().roomscaleMovement()) {
            playerPhysicalPosition.set(MCXRPlayClient.viewSpacePoses.getPhysicalPose().getPos());
        } else {
            playerPhysicalPosition.zero();
        }

        MCXRPlayClient.stagePosition = new Vector3f(0, 0, 0).sub(pos).mul(1, 0, 1);
    }

    public static float getCameraScale() {
        var cam = Minecraft.getInstance().cameraEntity;
        if (cam == null) {
            return 1;
        } else {
            return MCXRCoreExpectPlatform.getScale(cam);
        }
    }

    public static float modifyProjectionMatrixDepth(float depth, Entity entity, float tickDelta) {
        return depth;
    }
}
