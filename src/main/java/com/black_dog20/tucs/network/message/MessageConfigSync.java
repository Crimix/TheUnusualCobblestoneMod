package com.black_dog20.tucs.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.server.MinecraftServer;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.handler.ConfigurationHandler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageConfigSync implements IMessage,
		IMessageHandler<MessageConfigSync, IMessage> {

	@Override
	public IMessage onMessage(MessageConfigSync message, MessageContext context) {
		tucs.instance.Proxy.ServerRecipes();
		return null;
	}

	public MessageConfigSync() {
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeBoolean(ConfigurationHandler.ToolFire);
		buf.writeBoolean(ConfigurationHandler.Allow_To_Fly);
		buf.writeInt(ConfigurationHandler.Max_Luck_Upgrade);
		buf.writeBoolean(ConfigurationHandler.Max_Silktouch_Upgrade);
		buf.writeBoolean(ConfigurationHandler.Max_Beheading_Upgrade);
		buf.writeBoolean(ConfigurationHandler.Max_Infi_Upgrade);
		buf.writeInt(ConfigurationHandler.Max_Bane_of_Arthropods);
		buf.writeBoolean(ConfigurationHandler.Max_Aqua_Affinity);
		buf.writeBoolean(ConfigurationHandler.Max_Auto_Bow);
		buf.writeInt(ConfigurationHandler.Max_Blast_Protection);
		buf.writeInt(ConfigurationHandler.Efficiency);
		buf.writeInt(ConfigurationHandler.Feather_Falling);
		buf.writeInt(ConfigurationHandler.Fire_Aspect);
		buf.writeInt(ConfigurationHandler.Fire_Protection);
		buf.writeBoolean(ConfigurationHandler.Max_Flame);
		buf.writeInt(ConfigurationHandler.Knockback);
		buf.writeInt(ConfigurationHandler.Power);
		buf.writeInt(ConfigurationHandler.Projectile_Protection);
		buf.writeInt(ConfigurationHandler.Unbreaking);
		buf.writeInt(ConfigurationHandler.Thorns);
		buf.writeInt(ConfigurationHandler.Smite);
		buf.writeInt(ConfigurationHandler.Respiration);
		buf.writeInt(ConfigurationHandler.Punch);
		buf.writeInt(ConfigurationHandler.Protection);

		buf.writeBoolean(MinecraftServer.getServer().isFlightAllowed());
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		ConfigurationHandler.configurationServer = true;
		ConfigurationHandler.ToolFire = buf.readBoolean();
		ConfigurationHandler.Allow_To_Fly = buf.readBoolean();
		ConfigurationHandler.Max_Luck_Upgrade = buf.readInt();
		ConfigurationHandler.Max_Silktouch_Upgrade = buf.readBoolean();
		ConfigurationHandler.Max_Beheading_Upgrade = buf.readBoolean();
		ConfigurationHandler.Max_Infi_Upgrade = buf.readBoolean();
		ConfigurationHandler.Max_Bane_of_Arthropods = buf.readInt();
		ConfigurationHandler.Max_Aqua_Affinity = buf.readBoolean();
		ConfigurationHandler.Max_Auto_Bow = buf.readBoolean();
		ConfigurationHandler.Max_Blast_Protection = buf.readInt();
		ConfigurationHandler.Efficiency = buf.readInt();
		ConfigurationHandler.Feather_Falling = buf.readInt();
		ConfigurationHandler.Fire_Aspect = buf.readInt();
		ConfigurationHandler.Fire_Protection = buf.readInt();
		ConfigurationHandler.Max_Flame = buf.readBoolean();
		ConfigurationHandler.Knockback = buf.readInt();
		ConfigurationHandler.Power = buf.readInt();
		ConfigurationHandler.Projectile_Protection = buf.readInt();
		ConfigurationHandler.Unbreaking = buf.readInt();
		ConfigurationHandler.Thorns = buf.readInt();
		ConfigurationHandler.Smite = buf.readInt();
		ConfigurationHandler.Respiration = buf.readInt();
		ConfigurationHandler.Punch = buf.readInt();
		ConfigurationHandler.Protection = buf.readInt();

		ConfigurationHandler.Server_Flying_Allowed = buf.readBoolean();

	}
}
