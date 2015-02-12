package com.black_dog20.tucs.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

	public static Configuration configuration;
	public static boolean ToolFire = true;

	public static void init(File configFile){

		//Create configuration object from the given configurations file 
		if(configuration == null){
			configuration = new Configuration(configFile); 
			loadConfiguration();
		}

	}

	@SubscribeEvent
	public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event){

		if(event.modID.equalsIgnoreCase(Reference.MOD_ID)){
			loadConfiguration();
		}
	}

	private static void loadConfiguration(){

		ToolFire = configuration.getBoolean("ToolCanMakeFire", Configuration.CATEGORY_GENERAL, true, "Can the Tool make fire like flint & steel");

		if(configuration.hasChanged()){
			configuration.save();
		}
	}
}
