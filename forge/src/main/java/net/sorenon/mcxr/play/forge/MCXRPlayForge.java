package net.sorenon.mcxr.play.forge;

import dev.architectury.platform.forge.EventBuses;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.ScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.sorenon.mcxr.play.MCXRPlayClient;
import net.sorenon.mcxr.play.forge.rendering.VrFirstPersonRendererImpl;

@Mod(MCXRPlayClient.MOD_ID)
public class MCXRPlayForge {
    public MCXRPlayForge() {
        // Submit our event bus to let architectury register our content on the right time
        EventBuses.registerModEventBus(MCXRPlayClient.MOD_ID, FMLJavaModLoadingContext.get().getModEventBus());
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::initClient);

        MCXRPlayClient.INSTANCE.init();
        MCXRPlayClient.INSTANCE.vrFirstPersonRenderer = new VrFirstPersonRendererImpl(MCXRPlayClient.INSTANCE.MCXRGuiManager);
        MinecraftForge.EVENT_BUS.register(MCXRPlayClient.INSTANCE.vrFirstPersonRenderer);
    }

    public void initClient(FMLClientSetupEvent event) {
        MCXRPlayClient.MCXR_GAME_RENDERER.initialize(Minecraft.getInstance());
    }
}
