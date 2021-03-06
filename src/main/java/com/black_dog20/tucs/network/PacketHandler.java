package com.black_dog20.tucs.network;

import com.black_dog20.tucs.network.message.MessageConfigSync;
import com.black_dog20.tucs.network.message.MessagePlayerActivateFlight;
import com.black_dog20.tucs.network.message.MessagePlayerSpeed;
import com.black_dog20.tucs.network.message.MessageToolRender;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;

public class PacketHandler {

	public static final SimpleNetworkWrapper network = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID.toLowerCase());

	public static void init() {
		network.registerMessage(MessageToolRender.class, MessageToolRender.class, 1, Side.CLIENT);
		network.registerMessage(MessageConfigSync.class, MessageConfigSync.class, 2, Side.CLIENT);
		network.registerMessage(MessagePlayerActivateFlight.class, MessagePlayerActivateFlight.class, 3, Side.SERVER);
		network.registerMessage(MessagePlayerSpeed.class, MessagePlayerSpeed.class, 4, Side.CLIENT);
	}

}
