package com.black_dog20.tucs.handler;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ConfigurationHandler {

	public static Configuration configuration;
	public static boolean ToolFire = true;
	public static boolean Allow_To_Fly = true;
	public static int Max_Luck_Upgrade = 3;
	public static int Max_Sharpness_Upgrade = 5;
	public static boolean Max_Silktouch_Upgrade = true;
	public static boolean Max_Beheading_Upgrade = true;
	public static boolean Max_Infi_Upgrade = true;
	public static boolean configurationServer = false;
	public static boolean Server_Flying_Allowed = false;
	public static int Max_Bane_of_Arthropods = 5;
	public static boolean Max_Aqua_Affinity = true;
	public static boolean Max_Auto_Bow = true;
	public static int Max_Blast_Protection = 4;
	public static int Efficiency = 5;
	public static int Feather_Falling = 4;
	public static int Fire_Aspect = 2;
	public static int Fire_Protection = 4;
	public static boolean Max_Flame = true;
	public static int Knockback = 2;
	public static int Power = 5;
	public static int Projectile_Protection = 4;
	public static int Unbreaking = 3;
	public static int Thorns = 3;
	public static int Smite = 5;
	public static int Respiration = 3;
	public static int Punch = 2;
	public static int Protection = 4;
	public static String Category_Upgrades = "Upgrades";

	public static void init(File configFile) {

		// Create configuration object from the given configurations file
		if (configuration == null) {
			configuration = new Configuration(configFile);
			loadConfiguration();
		}
	}

	@SubscribeEvent public void onConfigurationChangedEvent(ConfigChangedEvent.OnConfigChangedEvent event) {

		if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
			loadConfiguration();
		}
	}

	public static void loadConfiguration() {

		ToolFire = configuration.getBoolean("Lighters_Make_Fire", Configuration.CATEGORY_GENERAL, true, "Can Lighters make fire like flint & steel");
		Allow_To_Fly = configuration.getBoolean("Allow_To_Fly", Configuration.CATEGORY_GENERAL, true, "Are players allowed to fly with the talisman");
		Max_Luck_Upgrade = configuration.getInt("Max_Luck", Category_Upgrades, 3, 0, 3, "How many luck upgrades the player is able to craft");
		Max_Sharpness_Upgrade = configuration.getInt("Max_Sharpness", Category_Upgrades, 5, 0, 5, "How many sharpness upgrades the player is able to craft");
		Max_Silktouch_Upgrade = configuration.getBoolean("Silktouch", Category_Upgrades, true, "Is the Silktouch upgrade craftable");
		Max_Beheading_Upgrade = configuration.getBoolean("Beheading", Category_Upgrades, true, "Is the Beheading upgrade craftable");
		Max_Infi_Upgrade = configuration.getBoolean("Infinity", Category_Upgrades, true, "Is the Infinity Arrow upgrade craftable");
		Max_Aqua_Affinity = configuration.getBoolean("Aqua_Affinity", Category_Upgrades, true, "Is the Aqua Affinity upgrade craftable");
		Max_Auto_Bow = configuration.getBoolean("Auto_Bow", Category_Upgrades, true, "Is the Auto Bow upgrade craftable");
		Max_Flame = configuration.getBoolean("Flame", Category_Upgrades, true, "Is the Flame upgrade craftable");
		Max_Bane_of_Arthropods = configuration.getInt("Max_Bane_of_Arthropods", Category_Upgrades, 5, 0, 5, "How many Bane of Arthropods upgrades the player is able to craft");
		Max_Blast_Protection = configuration.getInt("Max_Blast_Protection", Category_Upgrades, 4, 0, 4, "How many Blast Protection upgrades the player is able to craft");
		Efficiency = configuration.getInt("Max_Efficiency", Category_Upgrades, 5, 0, 5, "How many Efficiency upgrades the player is able to craft");
		Feather_Falling = configuration.getInt("Max_Feather_Falling", Category_Upgrades, 4, 0, 4, "How many Feather Falling upgrades the player is able to craft");
		Fire_Aspect = configuration.getInt("Max_Fire_Aspect", Category_Upgrades, 2, 0, 2, "How many Fire Aspect upgrades the player is able to craft");
		Fire_Protection = configuration.getInt("Max_Fire_Protection", Category_Upgrades, 4, 0, 4, "How many Fire Protection upgrades the player is able to craft");
		Knockback = configuration.getInt("Max_Knockback", Category_Upgrades, 2, 0, 2, "How many Knockback upgrades the player is able to craft");
		Power = configuration.getInt("Max_Power", Category_Upgrades, 5, 0, 5, "How many Power upgrades the player is able to craft");
		Projectile_Protection = configuration.getInt("Max_Projectile_Protection", Category_Upgrades, 4, 0, 4, "How many Projectile Protection upgrades the player is able to craft");
		Unbreaking = configuration.getInt("Max_Unbreaking", Category_Upgrades, 3, 0, 3, "How many Unbreaking upgrades the player is able to craft");
		Thorns = configuration.getInt("Max_Thorns", Category_Upgrades, 3, 0, 3, "How many Thorns upgrades the player is able to craft");
		Smite = configuration.getInt("Max_Smite", Category_Upgrades, 5, 0, 5, "How many Smite upgrades the player is able to craft");
		Respiration = configuration.getInt("Max_Respiration", Category_Upgrades, 3, 0, 3, "How many Respiration upgrades the player is able to craft");
		Punch = configuration.getInt("Max_Punch", Category_Upgrades, 2, 0, 2, "How many Punch upgrades the player is able to craft");
		Protection = configuration.getInt("Max_Protection", Category_Upgrades, 4, 0, 4, "How many Protection upgrades the player is able to craft");

		if (configuration.hasChanged() && !configurationServer) {
			configuration.save();
		}
	}
}
