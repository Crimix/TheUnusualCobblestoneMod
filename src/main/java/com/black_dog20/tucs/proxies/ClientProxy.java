package com.black_dog20.tucs.proxies;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.MinecraftForgeClient;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.handler.KeyInputEventHandler;
import com.black_dog20.tucs.client.render.AirMakerRender;
import com.black_dog20.tucs.client.render.RenderSpeeder;
import com.black_dog20.tucs.client.render.RoundRender;
import com.black_dog20.tucs.client.render.SoulForgeRender;
import com.black_dog20.tucs.client.render.TUCSOverlay;
import com.black_dog20.tucs.client.settings.Keybindings;
import com.black_dog20.tucs.entity.EntityHoverBike;
import com.black_dog20.tucs.entity.EntityRound;
import com.black_dog20.tucs.handler.ConfigurationHandler;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.init.Recipes;
import com.black_dog20.tucs.tileEntity.TileEntityAirMaker;
import com.black_dog20.tucs.tileEntity.TileEntitySoulForge;
import com.black_dog20.tucs.utility.LogHelper;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.relauncher.Side;

public class ClientProxy extends CommonProxy {

	String FIRSTFLY = "firstFlight";

	@Override
	public void openBook(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}

	@Override
	public void openToolUpgrade(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDUpgradeTools, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
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
	public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
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
	public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx) {
		if (ctx.side == Side.CLIENT) {
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
		RenderingRegistry.registerEntityRenderingHandler(EntityRound.class, new RoundRender());
		RenderingRegistry.registerBlockHandler(new SoulForgeRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntitySoulForge.class, new SoulForgeRender());
		RenderingRegistry.registerBlockHandler(new AirMakerRender());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityAirMaker.class, new AirMakerRender());
		RenderingRegistry.registerEntityRenderingHandler(EntityHoverBike.class, new RenderSpeeder());
	}

	@Override
	public void ServerRecipes() {
		TucsRegistry.RemoveRecipe(ModItems.looting1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.looting2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.looting3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Sharpness1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Sharpness2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Sharpness3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Sharpness4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Sharpness5Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Sliktouch1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BeheadingUpgrade);
		TucsRegistry.RemoveRecipe(ModItems.InfiUpgrade);
		TucsRegistry.RemoveRecipe(ModItems.BoA1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BoA2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BoA3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BoA4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BoA5Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.AquaAffinityUpgrade);
		TucsRegistry.RemoveRecipe(ModItems.AutoBowUpgrade);
		TucsRegistry.RemoveRecipe(ModItems.BlastProtection1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BlastProtection2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BlastProtection3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.BlastProtection4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Efficiency1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Efficiency2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Efficiency3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Efficiency4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Efficiency5Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FeatherFalling1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FeatherFalling2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FeatherFalling3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FeatherFalling4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FireAspect1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FireAspect2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FireProtection1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FireProtection2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FireProtection3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FireProtection4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.FlameUpgrade);
		TucsRegistry.RemoveRecipe(ModItems.Knockback1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Knockback2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Power1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Power2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Power3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Power4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Power5Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Protection1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Protection2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Protection3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Protection4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Punch1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Punch2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Respiration1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Respiration2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Respiration3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Smite1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Smite2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Smite3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Smite4Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Smite5Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Thorns1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Thorns2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Thorns3Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Unbreaking1Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Unbreaking2Upgrade);
		TucsRegistry.RemoveRecipe(ModItems.Unbreaking3Upgrade);
		Recipes.Upgrades();

		LogHelper.info("removed " + TucsRegistry.number + " recipes");
		TucsRegistry.number = 0;
	}

	@Override
	public void ActivateFlight(EntityPlayer entityPlayer) {}

}
