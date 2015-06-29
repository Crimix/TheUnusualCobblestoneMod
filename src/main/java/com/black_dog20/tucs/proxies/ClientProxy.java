package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.handler.KeyInputEventHandler;
import com.black_dog20.tucs.client.render.RoundRender;
import com.black_dog20.tucs.client.render.SoulForgeRender;
import com.black_dog20.tucs.client.render.TUCSPickaxeRender;
import com.black_dog20.tucs.client.render.TUCSScubaGear;
import com.black_dog20.tucs.client.render.TUCSUpgradeOverlayRender;
import com.black_dog20.tucs.client.render.TUCSWeaponOverlayRender;
import com.black_dog20.tucs.client.settings.Keybindings;
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
		MinecraftForgeClient.registerItemRenderer(ModItems.TUCSBow, new TUCSWeaponOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.M1911, new TUCSWeaponOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.TLPOLM, new TUCSPickaxeRender());
		upgrades();
		MinecraftForgeClient.registerItemRenderer(ModItems.ScubaMask, new TUCSScubaGear());
		MinecraftForgeClient.registerItemRenderer(ModItems.AirTank, new TUCSScubaGear());
		MinecraftForgeClient.registerItemRenderer(ModItems.helmetCobblestonedium_scuba, new TUCSScubaGear());
		RenderingRegistry.registerEntityRenderingHandler(EntityRound.class, new RoundRender());
		RenderingRegistry.registerBlockHandler(new SoulForgeRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoulForge.class, new SoulForgeRender());
	}

	private void upgrades() {
		MinecraftForgeClient.registerItemRenderer(ModItems.AquaAffinityUpgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.AutoBowUpgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BeheadingUpgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BlastProtection4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.BoA5Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Efficiency5Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FeatherFalling4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireAspect1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireAspect2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FireProtection4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.FlameUpgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.InfiUpgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Knockback1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Knockback2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.looting1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.looting2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.looting3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Power5Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.ProjectileProtection4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Protection4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Punch1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Punch2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Respiration1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Respiration2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Respiration3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sharpness5Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Sliktouch1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite4Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Smite5Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.soulboundUpgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Thorns1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Thorns2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Thorns3Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Unbreaking1Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Unbreaking2Upgrade, new TUCSUpgradeOverlayRender());
		MinecraftForgeClient.registerItemRenderer(ModItems.Unbreaking3Upgrade, new TUCSUpgradeOverlayRender());
	}


}
