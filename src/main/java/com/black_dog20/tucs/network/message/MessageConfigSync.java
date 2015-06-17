package com.black_dog20.tucs.network.message;


import io.netty.buffer.ByteBuf;

import com.black_dog20.tucs.handler.ConfigurationHandler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageConfigSync  implements IMessage, IMessageHandler<MessageConfigSync, IMessage>{

	@Override
	public IMessage onMessage(MessageConfigSync message, MessageContext context){
		return null;
	}
	public MessageConfigSync() {}

	@Override
	public void toBytes(ByteBuf buf){
		buf.writeBoolean(ConfigurationHandler.ToolFire);
		buf.writeBoolean(ConfigurationHandler.Allow_To_Fly);
		buf.writeInt(ConfigurationHandler.Max_Luck_Upgrade);
	}

	@Override
	public void fromBytes(ByteBuf buf){
		ConfigurationHandler.ToolFire = buf.readBoolean();
		ConfigurationHandler.Allow_To_Fly = buf.readBoolean();
		ConfigurationHandler.Max_Luck_Upgrade = buf.readInt();
		ConfigurationHandler.configurationServer = true;
	}
}
