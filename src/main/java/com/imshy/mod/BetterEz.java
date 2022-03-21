package com.imshy.mod;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Mod(modid = BetterEz.MODID, version = BetterEz.VERSION)
public class BetterEz
{
    public static final String MODID = "BetterEz";
    public static final String VERSION = "1.0";
    public static BetterEz instance;
    private final Minecraft mc = Minecraft.getMinecraft();
    public final ExecutorService THREAD_POOL = Executors.newSingleThreadExecutor();
    //only works when the player is on hypixel
    private boolean onHypixel;


    public static BetterEz getInstance() {
        if(instance == null) {
            // synchronization is not required here because this class is the first thing initialized
            instance = new BetterEz();
        }
        return instance;
    }
    @SubscribeEvent
    public void playerConnect(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        this.onHypixel = !this.mc.isSingleplayer() && event.manager.getRemoteAddress().toString().toLowerCase().contains("hypixel.net");
    }
    public boolean onhypixel() {
        return this.onHypixel;
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        registerAll();
    }

    private void registerAll()
    {
        MinecraftForge.EVENT_BUS.register(BetterEz.getInstance());
        ClientCommandHandler.instance.registerCommand(new BetterEzCommand());
    }
}