package net.sorenon.mcxr.play.forge;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLPaths;
import net.sorenon.mcxr.play.MCXRPlayExpectPlatform;

import java.nio.file.Path;

public class MCXRPlayExpectPlatformImpl {
    /**
     * This is our actual method to {@link MCXRPlayExpectPlatform#getConfigDirectory()}.
     */
    public static Path getConfigDirectory() {
        return FMLPaths.CONFIGDIR.get();
    }

    public static boolean isModLoaded(String modId) {
        return ModList.get().isLoaded(modId);
    }
}
