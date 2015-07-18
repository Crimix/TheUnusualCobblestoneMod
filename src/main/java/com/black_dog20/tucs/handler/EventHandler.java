package com.black_dog20.tucs.handler;

import java.text.DecimalFormat;
import java.util.List;

import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.WorldServer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.entity.EntityHoverBike;
import com.black_dog20.tucs.entity.IEntityHoverVehicle;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.armor.IScubaAirTank;
import com.black_dog20.tucs.item.armor.IScubaMask;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemBootCobblestonedium;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemChestplateCobblestonedium_scuba;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemHelmetCobblestonedium;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemHelmetCobblestonedium_Scuba;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemLegCobblestonedium;
import com.black_dog20.tucs.item.tool.ItemM1911;
import com.black_dog20.tucs.item.tool.ItemTLPOLM;
import com.black_dog20.tucs.item.tool.ItemTLSOC;
import com.black_dog20.tucs.item.tool.ItemTLSOTD;
import com.black_dog20.tucs.network.PacketHandler;
import com.black_dog20.tucs.network.message.MessageToolRender;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;



public class EventHandler {
	NBTTagCompound nbt;
	boolean hasChanged;
	
	static final DecimalFormat df = new DecimalFormat("#0.00");

	@SubscribeEvent
	public void Tool(ItemTooltipEvent event){
		ItemStack item = event.itemStack;
		List list = event.toolTip;
		//list.add((item.getMaxDamage()-item.getItemDamage()) + "/" + item.getMaxDamage());
		if(item.hasTagCompound()){
			NBTTagCompound nbtTagCompound = item.getTagCompound();
			if(nbtTagCompound.hasKey(NBTTags.SOULBOUND)){
				list.add(EnumChatFormatting.LIGHT_PURPLE+I18n.format("tucs.tips.soulbound"));
			}
			else if(nbtTagCompound.hasKey(NBTTags.SOULBOUND_P)){
				list.add(EnumChatFormatting.LIGHT_PURPLE+I18n.format("tucs.tips.soulbound"));
			}
			else{
				list.remove(I18n.format("tucs.tips.soulbound"));
			}

			if(nbtTagCompound.hasKey(NBTTags.Beheading)){
				list.add(EnumChatFormatting.LIGHT_PURPLE+I18n.format("tucs.tips.beheading"));
			}
			else if(!nbtTagCompound.hasKey(NBTTags.Beheading)){
				list.remove(I18n.format("tucs.tips.beheading"));
			}

			if(nbtTagCompound.hasKey(NBTTags.MachineBow)){
				list.add(EnumChatFormatting.LIGHT_PURPLE+I18n.format("tucs.tips.autobow"));
			}
			else if(!nbtTagCompound.hasKey(NBTTags.MachineBow)){
				list.remove(I18n.format("tucs.tips.autobow"));
			}
			if(nbtTagCompound.hasKey(NBTTags.NoArrow)){
				list.add(EnumChatFormatting.LIGHT_PURPLE+I18n.format("tucs.tips.infinity"));
			}
			else if(!nbtTagCompound.hasKey(NBTTags.NoArrow)){
				list.remove(I18n.format("tucs.tips.infinity"));
			}
			if(nbtTagCompound.hasKey("StoredAir")){
				double procent = (nbtTagCompound.getInteger("StoredAir")/nbtTagCompound.getDouble("MaxAir"))*100;
				list.add("Air: " + df.format(procent)+"%");
			}

		}
	}

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onGuiRender(RenderGameOverlayEvent event){
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
		{      
			return;
		}
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		if(checkScubaGear(player) && player.isInWater()){
			ItemStack scubatank = (player.inventory.armorItemInSlot(2));
			IScubaAirTank tank = (IScubaAirTank) scubatank.getItem();
			double procent = (tank.getAir(scubatank)/tank.getMaxAir())*100;
			Minecraft.getMinecraft().fontRenderer.drawStringWithShadow(df.format(procent)+"%", 2, 2, 0xffffff);
		}
	}

	

	@SubscribeEvent
	public void playerBreakSpeed(PlayerEvent.BreakSpeed event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if(player.isInWater() && checkScubaGear(player)){
				event.newSpeed = event.originalSpeed+1F;
			}
		}
	}

	@SubscribeEvent
	public void onLivingUpdatePlayer(LivingUpdateEvent event){
		if(event.entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			NBTTagCompound nbtt = NBTHelper.getPlayerNBT(player);
			allowFlight(player, nbtt);
			checkForArmor(player);
			if(checkScubaGear(player) && player.isInsideOfMaterial(Material.water)){
				ItemStack scubatank = (player.inventory.armorItemInSlot(2));
				IScubaAirTank tank = (IScubaAirTank) scubatank.getItem();

				if(tank.getAir(scubatank)>0){
					player.setAir(300);
					tank.decAir(scubatank);
				}
			}
			if(player.isInWater() && checkScubaGear(player) && !player.capabilities.isFlying){
				player.motionX *=1.2F;
				player.motionZ *=1.2F;
			}
			
			if(player.getActivePotionEffects()!= null && mask(player) && getMask(player).GetEnviromentType().equals("Effects")){
				getMask(player).doSpeciel(player);
			}

			setNBTData(player, nbtt);
			if(hasChanged){
				send(player);
			}

		}
	}

	private boolean checkScubaGear(EntityPlayer player){
		boolean result = false;
		if(mask(player)){
			if(tank(player)){
				result = true;
			}
		}
		return result;

	}
	
	private boolean mask(EntityPlayer player){
		return ((player.inventory.armorItemInSlot(3) != null) && ((player.inventory.armorItemInSlot(3).getItem() instanceof IScubaMask)));
	}
	
	private IScubaMask getMask(EntityPlayer player){
		return (IScubaMask) player.inventory.armorItemInSlot(3).getItem();
		
	}
	
	private boolean tank(EntityPlayer player){
		return ((player.inventory.armorItemInSlot(2) != null) && ((player.inventory.armorItemInSlot(2).getItem() instanceof IScubaAirTank)));
	}


	private void allowFlight(EntityPlayer player, NBTTagCompound nbtt) {
		if(!nbtt.getBoolean(NBTTags.FLY) && (player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)) || player.inventory.hasItemStack(new ItemStack(ModItems.TLSOTD)))){
			nbtt.setBoolean(NBTTags.FLY, true);
		}
		else if(nbtt.getBoolean(NBTTags.FLY) && player.capabilities.allowFlying && !player.capabilities.isCreativeMode){
			if(player.capabilities.allowFlying && !((player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman)) || player.inventory.hasItemStack(new ItemStack(ModItems.TLSOTD))))){
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
				player.sendPlayerAbilities();
				nbtt.setBoolean(NBTTags.FLY, false);
			}
		}
	}

	private void setNBTData(EntityPlayer player, NBTTagCompound nbtt) {
		if(nbtt.hasKey(NBTTags.nightA)){
			player.addPotionEffect(new PotionEffect(Potion.nightVision.id,500,1,false));
		}
		if(nbtt.hasKey(NBTTags.nightA) && !(player.inventory.hasItem(ModItems.torchTalisman))){
			player.removePotionEffect(Potion.nightVision.id);
			nbtt.removeTag(NBTTags.nightA);
		}
		if(!(nbtt.hasKey(NBTTags.night)) && player.inventory.hasItem(ModItems.torchTalisman)){
			nbtt.setBoolean(NBTTags.night, true);
			hasChanged = true;
		}
		else if(nbtt.hasKey(NBTTags.night) && !(player.inventory.hasItem(ModItems.torchTalisman))){
			nbtt.removeTag(NBTTags.night);
			hasChanged = true;
		}
		if(!(nbtt.hasKey(NBTTags.AllowFly)) && player.inventory.hasItem(ModItems.FlightTalisman)){
			nbtt.setBoolean(NBTTags.AllowFly, true);
			hasChanged = true;
		}
		else if(nbtt.hasKey(NBTTags.AllowFly) && !(player.inventory.hasItem(ModItems.FlightTalisman))){
			nbtt.removeTag(NBTTags.AllowFly);
			hasChanged = true;
		}
		if(!(nbtt.hasKey(NBTTags.PickAxeRender)) && player.inventory.hasItem(ModItems.TLPOLM)){
			nbtt.setBoolean(NBTTags.PickAxeRender, true);
			hasChanged = true;
		}
		else if(nbtt.hasKey(NBTTags.PickAxeRender) && !(player.inventory.hasItem(ModItems.TLPOLM))){
			nbtt.removeTag(NBTTags.PickAxeRender);
			hasChanged = true;
		}
		if(!(nbtt.hasKey(NBTTags.SwordRender)) && player.inventory.hasItem(ModItems.TLSOC)){
			nbtt.setBoolean(NBTTags.SwordRender, true);
			hasChanged = true;
		}
		else if(nbtt.hasKey(NBTTags.SwordRender) && !(player.inventory.hasItem(ModItems.TLSOC))){
			nbtt.removeTag(NBTTags.SwordRender);
			hasChanged = true;
		}
		if(!(nbtt.hasKey(NBTTags.TLSOTD)) && player.inventory.hasItem(ModItems.TLSOTD)){
			nbtt.setBoolean(NBTTags.TLSOTD, true);
			hasChanged = true;
		}
		else if(nbtt.hasKey(NBTTags.TLSOTD) && !(player.inventory.hasItem(ModItems.TLSOTD))){
			nbtt.removeTag(NBTTags.TLSOTD);
			hasChanged = true;
		}
		if(!(nbtt.hasKey(NBTTags.m1119)) && player.inventory.hasItem(ModItems.M1911)){
			nbtt.setBoolean(NBTTags.m1119, true);
			hasChanged = true;
		}
		else if(nbtt.hasKey(NBTTags.m1119) && !(player.inventory.hasItem(ModItems.M1911))){
			nbtt.removeTag(NBTTags.m1119);
			hasChanged = true;
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
		if(me == player){
			doRenderTools(nbt, me, me.inventory);
		}
		else{
			if(nbt.hasKey(Integer.toString(player.getEntityId()))){
				nbt = (NBTTagCompound) nbt.getTag(Integer.toString(player.getEntityId()));
				doRenderTools(nbt, player, player.inventory);
			}
		}
	}

	@SideOnly(Side.CLIENT)
	public void doRenderTools(NBTTagCompound nbt, EntityPlayer player, InventoryPlayer IPlayer){
		renderFlight(nbt, player, IPlayer);
		renderSwordTLSOC(nbt, player, IPlayer);
		renderPickaxe(nbt, player, IPlayer);
		renderNightVisionTalisman(nbt, player, IPlayer);
		renderSwordTLSOTD(nbt, player, IPlayer);
		renderM1911(nbt, player, IPlayer);
	}

	private void renderSwordTLSOTD(NBTTagCompound nbt, EntityPlayer player,
			InventoryPlayer IPlayer) {
		if(nbt.hasKey(NBTTags.TLSOTD)){
			ItemStack item = player.getHeldItem();
			if(item == null || !(item.getItem() instanceof ItemTLSOTD)){
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
				RenderManager.instance.itemRenderer.renderItem(player, new ItemStack(ModItems.TLSOTD), 0);
				GL11.glPopMatrix();
			}
		}
	}

	private void renderM1911(NBTTagCompound nbt, EntityPlayer player,
			InventoryPlayer IPlayer) {
		if(nbt.hasKey(NBTTags.m1119)){
			ItemStack item = player.getHeldItem();
			if(item == null || !(item.getItem() instanceof ItemM1911)){
				float offset = 0.2F;
				float size = 0.4F;
				float dis = 0F;
				if(IPlayer.armorInventory[1] != null){
					dis = -0.31F;
				}
				else{
					dis = -0.3F;
				}		
				GL11.glPushMatrix();
				GL11.glTranslatef(dis, 0.6F, offset);
				GL11.glRotatef(45.0F-180, 0.0F, 1.0F, 0.0F);
				GL11.glRotatef(45.0F+20, 1.0F, 0.0F, 1.0F);
				GL11.glRotatef(45.0F-50 ,0.0F, 1.0F, 0.0F);
				GL11.glScalef(size, size, size);
				RenderManager.instance.itemRenderer.renderItem(player, new ItemStack(ModItems.M1911), 0);
				GL11.glPopMatrix();
			}
		}
	}

	private void renderNightVisionTalisman(NBTTagCompound nbt,
			EntityPlayer player, InventoryPlayer IPlayer) {
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

	private void renderPickaxe(NBTTagCompound nbt, EntityPlayer player,
			InventoryPlayer IPlayer) {
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
	}

	private void renderSwordTLSOC(NBTTagCompound nbt, EntityPlayer player,
			InventoryPlayer IPlayer) {
		if(nbt.hasKey(NBTTags.SwordRender) && !(nbt.hasKey(NBTTags.TLSOTD))){
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
	}

	private void renderFlight(NBTTagCompound nbt, EntityPlayer player,
			InventoryPlayer IPlayer) {
		if(nbt.hasKey(NBTTags.AllowFly) && !(nbt.hasKey(NBTTags.TLSOTD))){
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
	}


	@SubscribeEvent
	public void onFall(LivingFallEvent event){
		if (event.entityLiving instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer) event.entity;
			if((player.inventory.hasItemStack(new ItemStack(ModItems.FlightTalisman))||player.inventory.hasItemStack(new ItemStack(ModItems.TLSOTD)))){
				event.setCanceled(true);
			}
			if(player.ridingEntity instanceof IEntityHoverVehicle){
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

			giveUpgrades(item, inv);

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

			giveUpgrades(item, inv);
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

			giveUpgrades(item, inv);
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

			giveUpgrades(item, inv);
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

			giveUpgrades(item, inv);
		}
		else if(item.isItemEqual( new ItemStack(ModItems.TUCSBow))){
			ItemStack arrmor = new ItemStack(ModItems.TUCSBowBroken);
			if(!inv.addItemStackToInventory(arrmor)){
				player.dropPlayerItemWithRandomChoice(arrmor, false);
			}

			giveUpgrades(item, inv);
		}

	}


	private void giveUpgrades(ItemStack item, InventoryPlayer inv){
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

	private void checkForArmor(EntityPlayer player){
		ItemStack boots = player.inventory.armorInventory[0];
		ItemStack legs = player.inventory.armorInventory[1];
		ItemStack chest = player.inventory.armorInventory[2];
		ItemStack helmet = player.inventory.armorInventory[3];
		InventoryPlayer inv = player.inventory;

		if(helmet != null && helmet.getItem() instanceof ItemHelmetCobblestonedium){
			if(helmet.getMaxDamage()-helmet.getItemDamage() <= 1){
				ItemStack arrmor = new ItemStack(ModItems.helmetCobblestonediumBroken);
				if(!inv.addItemStackToInventory(arrmor)){
					player.dropPlayerItemWithRandomChoice(arrmor, false);
				}
				giveUpgrades(helmet, inv);
				player.inventory.armorInventory[3] = null;
			}


		}
		else if(helmet != null && helmet.getItem() instanceof ItemHelmetCobblestonedium_Scuba){
			if(helmet.getMaxDamage()-helmet.getItemDamage() <= 1){
				ItemStack arrmor = new ItemStack(ModItems.helmetCobblestonediumBroken);
				ItemStack mask = new ItemStack(ModItems.ScubaMask);
				if(!inv.addItemStackToInventory(arrmor)){
					player.dropPlayerItemWithRandomChoice(arrmor, false);
				}
				if(!inv.addItemStackToInventory(mask)){
					player.dropPlayerItemWithRandomChoice(mask, false);
				}
				giveUpgrades(helmet, inv);
				player.inventory.armorInventory[3] = null;
			}


		}
		else if(chest != null && chest.getItem() instanceof ItemChestplateCobblestonedium_scuba){
			if(

					chest.getMaxDamage()-chest.getItemDamage() <= 1){
				ItemStack arrmor = new ItemStack(ModItems.chestplateCobblestonediumBroken);
				if(!inv.addItemStackToInventory(arrmor)){
					player.dropPlayerItemWithRandomChoice(arrmor, false);
				}
				giveUpgrades(chest, inv);
				player.inventory.armorInventory[2] = null;
			}


		}
		else if(legs != null && legs.getItem() instanceof ItemLegCobblestonedium){
			if(legs.getMaxDamage()-legs.getItemDamage() <= 1){
				ItemStack arrmor = new ItemStack(ModItems.leggingsCobblestonediumBroken);
				if(!inv.addItemStackToInventory(arrmor)){
					player.dropPlayerItemWithRandomChoice(arrmor, false);
				}
				giveUpgrades(legs, inv);
				player.inventory.armorInventory[1] = null;
			}


		}
		else if(boots != null && boots.getItem() instanceof ItemBootCobblestonedium){
			if(boots.getMaxDamage()-boots.getItemDamage() <= 1){
				ItemStack arrmor = new ItemStack(ModItems.bootsCobblestonediumBroken);
				if(!inv.addItemStackToInventory(arrmor)){
					player.dropPlayerItemWithRandomChoice(arrmor, false);
				}
				giveUpgrades(boots, inv);
				player.inventory.armorInventory[0] = null;
			}


		}


	}

}