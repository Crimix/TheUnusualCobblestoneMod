package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.handler.KeyInputEventHandler;
import com.black_dog20.tucs.client.render.RenderSpeeder;
import com.black_dog20.tucs.client.render.RoundRender;
import com.black_dog20.tucs.client.render.SoulForgeRender;
import com.black_dog20.tucs.client.render.TUCSOverlay;
import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.entity.EntityHoverBike;
import com.black_dog20.tucs.entity.EntityRound;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.tileEntity.TileEntitySoulForge;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;


public class ClientProxy extends CommonProxy {
	

	@Override
	public void openBook(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void openToolUpgrade(EntityPlayer player){
		player.openGui(tucs.instance, tucs.guiIDUpgradeTools, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
	}

	@Override
	public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.fly);
		ClientRegistry.registerKeyBinding(Keybindings.flyspeed);
		ClientRegistry.registerKeyBinding(Keybindings.night);
	}

	@Override
	public void keyinput() {
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
	}

	@Override
	public EntityPlayer getPlayerFromMessageContext( MessageContext ctx){
		switch (ctx.side) {
		case CLIENT: 
			EntityPlayer entityClientPlayerMP = Minecraft.getMinecraft().thePlayer;
			return entityClientPlayerMP;
		case SERVER:
			EntityPlayer entityPlayerMP = ctx.getServerHandler().playerEntity;
			return entityPlayerMP;
		}
		return null;
	}

	@Override
	public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx){
		if(ctx.side == Side.CLIENT) {
			EntityPlayer entityClientPlayerMP = (EntityPlayer) Minecraft.getMinecraft().theWorld.getEntityByID(id);
			return entityClientPlayerMP;
		}
		return null;
	}

	@Override
	public void registerRenders() {
		
		for (Item iterable_element : tucs.overlayList) {
			MinecraftForgeClient.registerItemRenderer(iterable_element, new TUCSOverlay());
		}
		/*MinecraftForgeClient.registerItemRenderer(ModItems.TUCSBow, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.M1911, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.TLPOLM, new TUCSOverlay());*/
		//upgrades();
		/*MinecraftForgeClient.registerItemRenderer(ModItems.ScubaMask, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.AirTank, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.helmetCobblestonedium_scuba, new TUCSOverlay());*/
		RenderingRegistry.registerEntityRenderingHandler(EntityRound.class, new RoundRender());
		RenderingRegistry.registerBlockHandler(new SoulForgeRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoulForge.class, new SoulForgeRender());
		RenderingRegistry.registerEntityRenderingHandler(EntityHoverBike.class, new RenderSpeeder());
		}

	private void upgrades() {
		MinecraftForgeClient.registerItemRenderer(ModItems.AquaAffinityUpgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.AutoBowUpgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BeheadingUpgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA5Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency5Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireAspect1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireAspect2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.FlameUpgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.InfiUpgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Knockback1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Knockback2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.looting1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.looting2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.looting3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power5Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Punch1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Punch2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Respiration1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Respiration2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Respiration3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness5Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sliktouch1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite4Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite5Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.soulboundUpgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Thorns1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Thorns2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Thorns3Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Unbreaking1Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Unbreaking2Upgrade, new TUCSOverlay());
		MinecraftForgeClient.registerItemRenderer(ModItems.Unbreaking3Upgrade, new TUCSOverlay());
	}


}
