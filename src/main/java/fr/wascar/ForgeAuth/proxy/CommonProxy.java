package fr.wascar.ForgeAuth.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import fr.wascar.ForgeAuth.ForgeAuth;
import fr.wascar.ForgeAuth.event.CancelledEvents;
import fr.wascar.ForgeAuth.event.onPlayerJoin;
import fr.wascar.ForgeAuth.network.Packet250CustomPayload;
import fr.wascar.ForgeAuth.network.server.CustomPayloadServerHandler;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	public void registerRenderers()
	{
		ForgeAuth.print("Registering proxies");
		ForgeAuth.print("Mod " + (ForgeAuth.modEnabled ? "enabled" : "disabled") + " because onlinemode = "
				+ !ForgeAuth.modEnabled);
		FMLCommonHandler.instance().bus().register(new onPlayerJoin());
		MinecraftForge.EVENT_BUS.register(new CancelledEvents());
        ForgeAuth.network.registerMessage(CustomPayloadServerHandler.class, Packet250CustomPayload.class, 0, Side.SERVER);
	}

}