package com.black_dog20.tucs.handler;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerDropsEvent;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.tool.ItemTLBOTH;
import com.black_dog20.tucs.item.tool.ItemTLPOLM;
import com.black_dog20.tucs.item.tool.ItemTLSOC;
import com.black_dog20.tucs.network.PacketHandler;
import com.black_dog20.tucs.network.message.MessageToolRender;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.PlayerEvent.PlayerRespawnEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class EventHandler {
	NBTTagCompound nbt;


	@SubscribeEvent
	public void onEntityDeath(PlayerDropsEvent event) {
		EntityPlayer player = event.entityPlayer;
		ArrayList<EntityItem> list = event.drops;
		NBTTagList nbttaglist = new NBTTagList();
		ListIterator<EntityItem> litr = list.listIterator();
		nbt = NBTHelper.getPlayerNBT(player);
		int i = 0;
		while(litr.hasNext()){

			EntityItem item = litr.next();
			ItemStack itemstack = item.getEntityItem();


			if(item !=null){
				if(itemstack.hasTagCompound()){
					NBTTagCompound itemT = itemstack.getTagCompound();
					if(itemT.hasKey(NBTTags.SOULBOUND) || itemT.hasKey(NBTTags.SOULBOUND_P)){
						NBTTagCompound nbttagcompound1 = new NBTTagCompound();
						nbttagcompound1.setByte("Slot", (byte)i);
						itemstack.writeToNBT(nbttagcompound1);
						nbttaglist.appendTag(nbttagcompound1);
						litr.remove();
						i++;
					}
				}
			}
		}
		nbt.setTag("SoulboundItems", nbttaglist);

	}

	@SubscribeEvent
	public void Tool(ItemTooltipEvent event){
		ItemStack item = event.itemStack;
		List list = event.toolTip;
		//list.add((item.getMaxDamage()-item.getItemDamage()) + "/" + item.getMaxDamage());
		if(item.hasTagCompound()){
			NBTTagCompound nbtTagCompound = item.getTagCompound();
			if(nbtTagCompound.hasKey(NBTTags.SOULBOUND)){
				list.add("\u00A7d"+"Soulbound");
			}
			else if(nbtTagCompound.hasKey(NBTTags.SOULBOUND_P)){
				list.add("\u00A7d"+"Soulbound");
			}
			else{
				list.remove("Soulbound");
			}

			if(nbtTagCompound.hasKey(NBTTags.Beheading)){
				list.add("\u00A7d"+"Beheading");
			}
			else if(!nbtTagCompound.hasKey(NBTTags.Beheading)){
				list.remove("Beheading");
			}

			if(nbtTagCompound.hasKey(NBTTags.MachineBow)){
				list.add("\u00A7d"+"AutoBow");
			}
			else if(!nbtTagCompound.hasKey(NBTTags.MachineBow)){
				list.remove("AutoBow");
			}
			if(nbtTagCompound.hasKey(NBTTags.NoArrow)){
				list.add("\u00A7d"+"Infinity Arrow");
			}
			else if(!nbtTagCompound.hasKey(NBTTags.NoArrow)){
				list.remove("Infinity Arrow");
			}

		}
	}
	@SubscribeEvent
	public void onPlayerRespawn(PlayerRespawnEvent event){
		EntityPlayer player = event.player;
		nbt = NBTHelper.getPlayerNBT(player);
		NBTTagList nbttaglist = nbt.getTagList("SoulboundItems", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i <= nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");
			player.inventory.addItemStackToInventory(ItemStack.loadItemStackFromNBT(nbttagcompound1));
		}
		nbt.removeTag("SoulboundItems");
	}

	@SubscribeEvent
	public void onLivingUpdatePlayer(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			NBTTagCompound nbtt = NBTHelper.getPlayerNBT(player);
			if(!nbtt.getBoolean(NBTTags.FLY) && player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman))){
				nbtt.setBoolean(NBTTags.FLY, true);
			}
			else if(nbtt.getBoolean(NBTTags.FLY) && player.capabilities.allowFlying && !player.capabilities.isCreativeMode){
				if(player.capabilities.allowFlying && !(player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)))){
					player.capabilities.allowFlying = false;
					player.capabilities.isFlying = false;
					player.sendPlayerAbilities();
					nbtt.setBoolean(NBTTags.FLY, false);
				}
			}
			if(nbtt.hasKey(NBTTags.nightA)){
				player.addPotionEffect(new PotionEffect(Potion.nightVision.id,500,1,false));
			}
			if(nbtt.hasKey(NBTTags.nightA) && !(player.inventory.hasItem(ModItems.torchTalisman))){
				player.removePotionEffect(Potion.nightVision.id);
				nbtt.removeTag(NBTTags.nightA);
			}
			if(!(nbtt.hasKey(NBTTags.night)) && player.inventory.hasItem(ModItems.torchTalisman)){
				nbtt.setBoolean(NBTTags.night, true);
				send(player);
			}
			else if(nbtt.hasKey(NBTTags.night) && !(player.inventory.hasItem(ModItems.torchTalisman))){
				nbtt.removeTag(NBTTags.night);
				send(player);
			}
			if(!(nbtt.hasKey(NBTTags.AllowFly)) && player.inventory.hasItem(ModItems.FlightTalisman)){
				nbtt.setBoolean(NBTTags.AllowFly, true);
				send(player);
			}
			else if(nbtt.hasKey(NBTTags.AllowFly) && !(player.inventory.hasItem(ModItems.FlightTalisman))){
				nbtt.removeTag(NBTTags.AllowFly);
				send(player);
			}
			if(!(nbtt.hasKey(NBTTags.PickAxeRender)) && player.inventory.hasItem(ModItems.TLPOLM)){
				nbtt.setBoolean(NBTTags.PickAxeRender, true);
				send(player);
			}
			else if(nbtt.hasKey(NBTTags.PickAxeRender) && !(player.inventory.hasItem(ModItems.TLPOLM))){
				nbtt.removeTag(NBTTags.PickAxeRender);
				send(player);
			}
			if(!(nbtt.hasKey(NBTTags.SwordRender)) && player.inventory.hasItem(ModItems.TLSOC)){
				nbtt.setBoolean(NBTTags.SwordRender, true);
				send(player);
			}
			else if(nbtt.hasKey(NBTTags.SwordRender) && !(player.inventory.hasItem(ModItems.TLSOC))){
				nbtt.removeTag(NBTTags.SwordRender);
				send(player);
			}
		}
	}
	public void send(EntityPlayer player){
		if(player.worldObj instanceof WorldServer)
		{
			WorldServer world = (WorldServer)player.worldObj;
			MessageToolRender msg = new MessageToolRender(player.getEntityId(), NBTHelper.getPlayerNBT(player));
			world.getEntityTracker().func_151248_b(player, PacketHandler.network.getPacketFrom(msg));
		}
	}

	@SubscribeEvent
	@SideOnly(Side.CLIENT)
	public void onRenderPlayer(RenderPlayerEvent.Specials.Pre event){
		EntityPlayer me = Minecraft.getMinecraft().thePlayer;
		EntityPlayer player = event.entityPlayer;
		NBTTagCompound nbt = NBTHelper.getPlayerNBT(me);
		if(nbt.hasKey(Integer.toString(player.getEntityId()))){
			nbt = (NBTTagCompound) nbt.getTag(Integer.toString(player.getEntityId()));
			InventoryPlayer IPlayer = player.inventory;
			if(nbt.hasKey(NBTTags.AllowFly)){
				float offset = 0.25F;
				float size = 0.325F;
				float dis = 0F;
				if(IPlayer.armorInventory[2] != null){
					dis = 1.71F;
				}
				else{
					dis = 1.6F;
				}
				GL11.glPushMatrix();
				GL11.glScalef(size, size, size);
				GL11.glTranslatef(dis, -0.25F, offset);
				GL11.glRotatef(45.0F-180, 0.0F, 1.0F, 0.0F);
				RenderManager.instance.itemRenderer.renderItem(player, new ItemStack(ModItems.FlightTalisman), 0);
				GL11.glPopMatrix();
			}
			if(nbt.hasKey(NBTTags.SwordRender)){
				ItemStack item = player.getHeldItem();
				if(item == null || !(item.getItem() instanceof ItemTLSOC)){
					float offset = -0.5F;
					float size = 0.525F;
					float dis = 0F;
					if(IPlayer.armorInventory[1] != null){
						dis = 0.6F;
					}
					else{
						dis = 0.5F;
					}		
					GL11.glPushMatrix();
					GL11.glScalef(size, size, size);
					GL11.glTranslatef(dis, 0.9F, offset);
					GL11.glRotatef(45.0F-180, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(45.0F-110, 1.0F, 0.0F, 1.0F);
					RenderManager.instance.itemRenderer.renderItem(player, new ItemStack(ModItems.TLSOC), 0);
					GL11.glPopMatrix();
				}
			}
			if(nbt.hasKey(NBTTags.PickAxeRender)){
				ItemStack item = player.getHeldItem();
				if(item == null || !(item.getItem() instanceof ItemTLPOLM)){
					float offset = 0.45F;
					float size = 0.6F;
					if(IPlayer.armorInventory[2] != null){
						offset = 0.45F;
					}
					else{
						offset = 0.4F;
					}	
					GL11.glPushMatrix();
					GL11.glScalef(size, size, size);
					GL11.glTranslatef(-0.5F, -0.15F, offset);
					GL11.glRotatef(45.0F-90, 0.0F, 1.0F, 0.0F);
					GL11.glRotatef(45.0F-115, 1.0F, 0.0F, 1.0F);
					RenderManager.instance.itemRenderer.renderItem(player, new ItemStack(ModItems.TLPOLM), 0);
					GL11.glPopMatrix();
				}
			}
			if(nbt.hasKey(NBTTags.night)){
				float offset = 0.45F;
				float size = 0.325F;
				if(IPlayer.armorInventory[2] != null){
					offset = -0.7F;
				}
				else{
					offset = -0.45F;
				}	
				GL11.glPushMatrix();
				GL11.glScalef(size, size, size);
				GL11.glTranslatef(-0.4F, 1.4F, offset);
				GL11.glRotatef(45.0F-90, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(45.0F-115, 1.0F, 0.0F, 1.0F);
				RenderManager.instance.itemRenderer.renderItem(player, new ItemStack(ModItems.torchTalisman), 0);
				GL11.glPopMatrix();

			}
		}
	}



	@SubscribeEvent
	public void onFall(LivingFallEvent event){
		if (event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if((player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)))){
				event.setCanceled(true);
			}
		}
	}

	@SubscribeEvent
	public void onItemUseUp(PlayerDestroyItemEvent event){
		EntityPlayer player = (EntityPlayer) event.entity;
		ItemStack item = event.original;
		InventoryPlayer inv = player.inventory;
		if(item.isItemEqual( new ItemStack(ModItems.TLSOC))){
			ItemStack hilt = new ItemStack(ModItems.SwordHilt);
			ItemStack blade = new ItemStack(ModItems.SwordBlade);
			if(!inv.addItemStackToInventory(blade)){
				player.dropPlayerItemWithRandomChoice(blade, false);
			}
			if(!inv.addItemStackToInventory(hilt)){
				player.dropPlayerItemWithRandomChoice(hilt, false);
			}

			giveItems(item, inv);

		}
		else if(item.isItemEqual( new ItemStack(ModItems.TLBOTB))){
			ItemStack rod = new ItemStack(ModItems.toolRod);
			ItemStack toolHead = new ItemStack(ModItems.hatchetHead);
			if(!inv.addItemStackToInventory(rod)){
				player.dropPlayerItemWithRandomChoice(rod, false);
			}
			if(!inv.addItemStackToInventory(toolHead)){
				player.dropPlayerItemWithRandomChoice(toolHead, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual(new ItemStack(ModItems.TLHOWF))){
			ItemStack rod = new ItemStack(ModItems.toolRod);
			ItemStack toolHead = new ItemStack(ModItems.hoeHead);
			if(!inv.addItemStackToInventory(rod)){
				player.dropPlayerItemWithRandomChoice(rod, false);
			}
			if(!inv.addItemStackToInventory(toolHead)){
				player.dropPlayerItemWithRandomChoice(toolHead, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual(new ItemStack(ModItems.TLPOLM))){
			ItemStack rod = new ItemStack(ModItems.toolRod);
			ItemStack toolHead = new ItemStack(ModItems.pickaxeHead);
			if(!inv.addItemStackToInventory(rod)){
				player.dropPlayerItemWithRandomChoice(rod, false);
			}
			if(!inv.addItemStackToInventory(toolHead)){
				player.dropPlayerItemWithRandomChoice(toolHead, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual(new ItemStack(ModItems.TLSOHD))){
			ItemStack rod = new ItemStack(ModItems.toolRod);
			ItemStack toolHead = new ItemStack(ModItems.shovelHead);
			if(!inv.addItemStackToInventory(rod)){
				player.dropPlayerItemWithRandomChoice(rod, false);
			}
			if(!inv.addItemStackToInventory(toolHead)){
				player.dropPlayerItemWithRandomChoice(toolHead, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual( new ItemStack(ModItems.helmetCobblestonedium))){
			ItemStack arrmor = new ItemStack(ModItems.helmetCobblestonediumBroken);
			if(!inv.addItemStackToInventory(arrmor)){
				player.dropPlayerItemWithRandomChoice(arrmor, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual( new ItemStack(ModItems.chestplateCobblestonedium))){
			ItemStack arrmor = new ItemStack(ModItems.chestplateCobblestonediumBroken);
			if(!inv.addItemStackToInventory(arrmor)){
				player.dropPlayerItemWithRandomChoice(arrmor, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual( new ItemStack(ModItems.leggingsCobblestonedium))){
			ItemStack arrmor = new ItemStack(ModItems.leggingsCobblestonediumBroken);
			if(!inv.addItemStackToInventory(arrmor)){
				player.dropPlayerItemWithRandomChoice(arrmor, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual( new ItemStack(ModItems.bootsCobblestonedium))){
			ItemStack arrmor = new ItemStack(ModItems.bootsCobblestonediumBroken);
			if(!inv.addItemStackToInventory(arrmor)){
				player.dropPlayerItemWithRandomChoice(arrmor, false);
			}

			giveItems(item, inv);
		}
		else if(item.isItemEqual( new ItemStack(ModItems.TUCSBow))){
			ItemStack arrmor = new ItemStack(ModItems.TUCSBowBroken);
			if(!inv.addItemStackToInventory(arrmor)){
				player.dropPlayerItemWithRandomChoice(arrmor, false);
			}

			giveItems(item, inv);
		}

	}


	private void giveItems(ItemStack item, InventoryPlayer inv){
		NBTTagCompound nbt = item.getTagCompound();
		NBTTagList nbttaglist = nbt.getTagList("upgradeItems", Constants.NBT.TAG_COMPOUND);
		for(int i = 0; i <= nbttaglist.tagCount(); i++){
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			int b0 = nbttagcompound1.getInteger("Slot");
			ItemStack slotItem = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			if(slotItem !=null){
				if(!inv.addItemStackToInventory(slotItem)){
					inv.player.dropPlayerItemWithRandomChoice(slotItem, false);
				}
			}
			nbt.removeTag("upgradeItems");
		}
	}

}