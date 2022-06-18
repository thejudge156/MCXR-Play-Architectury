package net.sorenon.mcxr.play.fabric;

import net.fabricmc.loader.api.FabricLoader;
import net.sorenon.mcxr.play.MCXRPlayExpectPlatform;

import java.nio.file.Path;

public class MCXRPlayExpectPlatformImpl {
    /**
     * This is our actual method to {@link MCXRPlayExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FabricLoader.getInstance().getConfigDir();
    }

    public static boolean isModLoaded(String modId) {
        return FabricLoader.getInstance().isModLoaded(modId);
    }
}
