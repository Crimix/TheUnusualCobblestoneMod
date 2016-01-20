package com.black_dog20.tucs.network.message;

import io.netty.buffer.ByteBuf;

import com.black_dog20.tucs.tucs;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayerActivateFlight implements IMessage, IMessageHandler<MessagePlayerActivateFlight, IMessage> {

	int entityId;

	@Override
	public IMessage onMessage(MessagePlayerActivateFlight message, MessageContext context) {
		tucs.instance.Proxy.ActivateFlight(context.getServerHandler().playerEntity);
		return null;
	}

	public MessagePlayerActivateFlight() {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public void fromBytes(ByteBuf buf) {}
}
