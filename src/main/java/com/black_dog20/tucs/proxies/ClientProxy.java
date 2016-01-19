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

	@Override public void openBook(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDBook, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}

	@Override public void openToolUpgrade(EntityPlayer player) {
		player.openGui(tucs.instance, tucs.guiIDUpgradeTools, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
	}

	@Override public void registerKeyBindings() {
		ClientRegistry.registerKeyBinding(Keybindings.fly);
		ClientRegistry.registerKeyBinding(Keybindings.flyspeed);
		ClientRegistry.registerKeyBinding(Keybindings.night);
	}

	@Override public void keyinput() {
		FMLCommonHandler.instance().bus().register(new KeyInputEventHandler());
	}

	@Override public EntityPlayer getPlayerFromMessageContext(MessageContext ctx) {
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

	@Override public EntityPlayer getPlayerByIDFromMessageContext(int id, MessageContext ctx) {
		if (ctx.side == Side.CLIENT) {
			EntityPlayer entityClientPlayerMP = (EntityPlayer) Minecraft.getMinecraft().theWorld.getEntityByID(id);
			return entityClientPlayerMP;
		}
		return null;
	}

	@Override public void registerRenders() {

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

	@Override public void ServerRecipes() {
		Recipes.Upgrades();
		switch (3 - ConfigurationHandler.Max_Luck_Upgrade) {
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.looting1Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.looting2Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.looting3Upgrade);
			break;
		}
		switch (5 - ConfigurationHandler.Max_Sharpness_Upgrade) {
		case 5:
			TucsRegistry.RemoveRecipe(ModItems.Sharpness1Upgrade);
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.Sharpness2Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Sharpness3Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Sharpness4Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Sharpness5Upgrade);
			break;
		}
		if (!ConfigurationHandler.Max_Silktouch_Upgrade) {
			TucsRegistry.RemoveRecipe(ModItems.Sliktouch1Upgrade);
		}
		if (!ConfigurationHandler.Max_Beheading_Upgrade) {
			TucsRegistry.RemoveRecipe(ModItems.BeheadingUpgrade);
		}
		if (!ConfigurationHandler.Max_Infi_Upgrade) {
			TucsRegistry.RemoveRecipe(ModItems.InfiUpgrade);
		}
		switch (5 - ConfigurationHandler.Max_Bane_of_Arthropods) {
		case 5:
			TucsRegistry.RemoveRecipe(ModItems.BoA1Upgrade);
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.BoA2Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.BoA3Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.BoA4Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.BoA5Upgrade);
			break;
		}
		if (!ConfigurationHandler.Max_Aqua_Affinity) {
			TucsRegistry.RemoveRecipe(ModItems.AquaAffinityUpgrade);
		}
		if (!ConfigurationHandler.Max_Auto_Bow) {
			TucsRegistry.RemoveRecipe(ModItems.AutoBowUpgrade);
		}
		switch (4 - ConfigurationHandler.Max_Blast_Protection) {
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.BlastProtection1Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.BlastProtection2Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.BlastProtection3Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.BlastProtection4Upgrade);
			break;
		}
		switch (5 - ConfigurationHandler.Efficiency) {
		case 5:
			TucsRegistry.RemoveRecipe(ModItems.Efficiency1Upgrade);
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.Efficiency2Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Efficiency3Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Efficiency4Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Efficiency5Upgrade);
			break;
		}
		switch (4 - ConfigurationHandler.Feather_Falling) {
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.FeatherFalling1Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.FeatherFalling2Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.FeatherFalling3Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.FeatherFalling4Upgrade);
			break;
		}
		switch (2 - ConfigurationHandler.Fire_Aspect) {
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.FireAspect1Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.FireAspect2Upgrade);
			break;
		}
		switch (4 - ConfigurationHandler.Fire_Protection) {
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.FireProtection1Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.FireProtection2Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.FireProtection3Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.FireProtection4Upgrade);
			break;
		}
		if (!ConfigurationHandler.Max_Flame) {
			TucsRegistry.RemoveRecipe(ModItems.FlameUpgrade);
		}
		switch (2 - ConfigurationHandler.Knockback) {
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Knockback1Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Knockback2Upgrade);
			break;
		}
		switch (5 - ConfigurationHandler.Power) {
		case 5:
			TucsRegistry.RemoveRecipe(ModItems.Power1Upgrade);
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.Power2Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Power3Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Power4Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Power5Upgrade);
			break;
		}
		switch (4 - ConfigurationHandler.Projectile_Protection) {
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection1Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection2Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection3Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.ProjectileProtection4Upgrade);
			break;
		}
		switch (4 - ConfigurationHandler.Protection) {
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.Protection1Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Protection2Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Protection3Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Protection4Upgrade);
			break;
		}
		switch (2 - ConfigurationHandler.Punch) {
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Punch1Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Punch2Upgrade);
			break;
		}
		switch (3 - ConfigurationHandler.Respiration) {
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Respiration1Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Respiration2Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Respiration3Upgrade);
			break;
		}
		switch (5 - ConfigurationHandler.Smite) {
		case 5:
			TucsRegistry.RemoveRecipe(ModItems.Smite1Upgrade);
		case 4:
			TucsRegistry.RemoveRecipe(ModItems.Smite2Upgrade);
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Smite3Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Smite4Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Smite5Upgrade);
			break;
		}
		switch (3 - ConfigurationHandler.Thorns) {
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Thorns1Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Thorns2Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Thorns3Upgrade);
			break;
		}
		switch (3 - ConfigurationHandler.Unbreaking) {
		case 3:
			TucsRegistry.RemoveRecipe(ModItems.Unbreaking1Upgrade);
		case 2:
			TucsRegistry.RemoveRecipe(ModItems.Unbreaking2Upgrade);
		case 1:
			TucsRegistry.RemoveRecipe(ModItems.Unbreaking3Upgrade);
			break;
		}
		LogHelper.info("removed " + TucsRegistry.number + " recipes");
		TucsRegistry.number = 0;
	}

}
