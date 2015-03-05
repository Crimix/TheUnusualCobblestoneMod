package com.black_dog20.tucs.network.message;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageToolRender  implements IMessage, IMessageHandler<MessageToolRender, IMessage>{

	int reqPlayer;
	NBTTagCompound nbt;
	
	 public MessageToolRender(){
		 
	 }
	public MessageToolRender(int id, NBTTagCompound nbt)
    {
        this.reqPlayer = id;
        this.nbt = nbt;
        		
        		
    }

	

	@Override
	public void fromBytes(ByteBuf buf) {
		this.reqPlayer = buf.readInt();
		this.nbt = ByteBufUtils.readTag(buf);
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(reqPlayer);
		ByteBufUtils.writeTag(buf, nbt);
	}

	@Override
	public IMessage onMessage(MessageToolRender message, MessageContext ctx) {
		EntityPlayer player = tucs.Proxy.getPlayerByIDFromMessageContext(message.reqPlayer,ctx);
		EntityPlayer me  = tucs.Proxy.getPlayerFromMessageContext(ctx);
		NBTTagCompound nbt = message.nbt;
		NBTTagCompound nbtt = NBTHelper.getPlayerNBT(me);
		boolean flight = nbt.hasKey(NBTTags.AllowFly);
		boolean sword = nbt.hasKey(NBTTags.SwordRender);
		boolean pick = nbt.hasKey(NBTTags.PickAxeRender);
		boolean night = nbt.hasKey(NBTTags.night);
		NBTTagCompound list = new NBTTagCompound();
		if(flight){
			list.setBoolean(NBTTags.AllowFly, true);
		}
		else{
			list.removeTag(NBTTags.AllowFly);
		}
		if(sword){
			list.setBoolean(NBTTags.SwordRender, true);
		}
		else{
			list.removeTag(NBTTags.SwordRender);
		}
		if(pick){
			list.setBoolean(NBTTags.PickAxeRender, true);
		}
		else{
			list.removeTag(NBTTags.PickAxeRender);
		}
		if(night){
			list.setBoolean(NBTTags.night, true);
		}
		else{
			list.removeTag(NBTTags.night);
		}
		
		nbtt.setTag(Integer.toString(message.reqPlayer), list);
		return null;
	}
}
