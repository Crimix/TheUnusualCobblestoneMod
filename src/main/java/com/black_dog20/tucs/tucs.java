	package com.black_dog20.tucs;


import net.minecraftforge.common.MinecraftForge;

import com.black_dog20.tucs.handler.ConfigurationHandler;
import com.black_dog20.tucs.handler.EventHandler;
import com.black_dog20.tucs.handler.GuiHandler;
import com.black_dog20.tucs.handler.ModLivingDropsEvent;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.init.Recipes;
import com.black_dog20.tucs.proxies.IProxy;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;
import com.black_dog20.tucs.utility.LogHelper;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;


@Mod(modid=Reference.MOD_ID, name=Reference.MOD_NAME, version=Reference.VERSION, guiFactory=Reference.GUI_FACTORY_CLASS)
public class tucs {

	@Mod.Instance(Reference.MOD_ID)
	public static tucs instance = new tucs();
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static IProxy Proxy;
	
	public static final int guiIDAncientTable = 1;
	public static final int guiIDAncientForge = 2;
	public static final int guiIDBook = 3;
	public static final int guiIDFlightTalisman = 4;
	public static final int guiIDCraftingTalisman = 5;
	public static final int guiIDUpgradeTools = 6;
	public static final int guiSoulBinder = 7;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event){

		ConfigurationHandler.init(event.getSuggestedConfigurationFile());
		FMLCommonHandler.instance().bus().register(new ConfigurationHandler());
		MinecraftForge.EVENT_BUS.register(new ModLivingDropsEvent());
		MinecraftForge.EVENT_BUS.register(new EventHandler());
		FMLCommonHandler.instance().bus().register(new EventHandler());
		Proxy.registerKeyBindings();
		ModItems.init();
		ModBlocks.init();
		
		
		LogHelper.info("Pre Initialization Complete!");
	}

	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event){
		
		NetworkRegistry.INSTANCE.registerGuiHandler(this, new GuiHandler());
		LogHelper.info("Initialization Complete!");
		Proxy.keyinput();
		Recipes.init();
		GameRegistry.registerTileEntity(TileEntityAncientForge.class, "AncientForge");
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event){
		
		LogHelper.info("Post Initialization Complete!");
	}
}
