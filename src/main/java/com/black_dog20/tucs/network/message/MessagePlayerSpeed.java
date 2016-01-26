package com.black_dog20.tucs.network.message;

import io.netty.buffer.ByteBuf;

import com.black_dog20.tucs.tucs;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessagePlayerSpeed implements IMessage, IMessageHandler<MessagePlayerSpeed, IMessage> {

	int entityId;

	@Override
	public IMessage onMessage(MessagePlayerSpeed message, MessageContext context) {
		tucs.instance.Proxy.Speed();
		return null;
	}

	public MessagePlayerSpeed() {}

	@Override
	public void toBytes(ByteBuf buf) {}

	@Override
	public void fromBytes(ByteBuf buf) {}
}
