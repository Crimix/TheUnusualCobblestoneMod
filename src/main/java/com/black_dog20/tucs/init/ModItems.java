package com.black_dog20.tucs.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.black_dog20.tucs.item.ItemBook;
import com.black_dog20.tucs.item.ItemCobbleCoal;
import com.black_dog20.tucs.item.ItemCraftingTalisman;
import com.black_dog20.tucs.item.ItemFlightTalisman;
import com.black_dog20.tucs.item.ItemHealthUpgrade;
import com.black_dog20.tucs.item.ItemHoverBike;
import com.black_dog20.tucs.item.ItemIngotCobblestonedium;
import com.black_dog20.tucs.item.ItemIngotCobblestoneium;
import com.black_dog20.tucs.item.ItemIngotYellowstoneium;
import com.black_dog20.tucs.item.ItemM1911Ammo;
import com.black_dog20.tucs.item.ItemTUCS;
import com.black_dog20.tucs.item.ItemTUCSDebug;
import com.black_dog20.tucs.item.ItemTorchTalisman;
import com.black_dog20.tucs.item.armor.ItemAirTank;
import com.black_dog20.tucs.item.armor.ItemScubaMask;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemBootCobblestonedium;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemBootCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemChestplateCobblestonedium;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemChestplateCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemChestplateCobblestonedium_scuba;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemHelmetCobblestonedium;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemHelmetCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemHelmetCobblestonedium_Scuba;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemLegCobblestonedium;
import com.black_dog20.tucs.item.armor.cobblestonedium.ItemLegCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.cobblestoneium.ItemBootCobblestoneium;
import com.black_dog20.tucs.item.armor.cobblestoneium.ItemChestplateCobblestoneium;
import com.black_dog20.tucs.item.armor.cobblestoneium.ItemHelmetCobblestoneium;
import com.black_dog20.tucs.item.armor.cobblestoneium.ItemLegCobblestoneium;
import com.black_dog20.tucs.item.crafting.ItemHatchetHead;
import com.black_dog20.tucs.item.crafting.ItemHoeHead;
import com.black_dog20.tucs.item.crafting.ItemPickaxeHead;
import com.black_dog20.tucs.item.crafting.ItemShovelHead;
import com.black_dog20.tucs.item.crafting.ItemSwordBlade;
import com.black_dog20.tucs.item.crafting.ItemSwordHilt;
import com.black_dog20.tucs.item.crafting.ItemTalismanBaseT1;
import com.black_dog20.tucs.item.crafting.ItemTalismanBaseT2;
import com.black_dog20.tucs.item.crafting.ItemToolRod;
import com.black_dog20.tucs.item.crafting.ItemUnfinshedflightTalisman;
import com.black_dog20.tucs.item.crafting.ItemUngoldenflightTalisman;
import com.black_dog20.tucs.item.crafting.ItemUpgradeBase;
import com.black_dog20.tucs.item.crafting.ItemUpgradeBaseT2;
import com.black_dog20.tucs.item.tool.ItemCobblestoneLighter;
import com.black_dog20.tucs.item.tool.ItemCobblestonediumLighter;
import com.black_dog20.tucs.item.tool.ItemCobblestoneiumLighter;
import com.black_dog20.tucs.item.tool.ItemHatchetCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemHoeCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemM1911;
import com.black_dog20.tucs.item.tool.ItemPickaxeCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemShovelCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemSwordCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemTLBOTB;
import com.black_dog20.tucs.item.tool.ItemTLBOTH;
import com.black_dog20.tucs.item.tool.ItemTLBOTHBroken;
import com.black_dog20.tucs.item.tool.ItemTLHOWF;
import com.black_dog20.tucs.item.tool.ItemTLPOLM;
import com.black_dog20.tucs.item.tool.ItemTLSOC;
import com.black_dog20.tucs.item.tool.ItemTLSOHD;
import com.black_dog20.tucs.item.tool.ItemTLSOTD;
import com.black_dog20.tucs.item.upgrades.ItemAquaAffinityUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemAutoBowUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemBeheadingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemBlastProtectionUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemBoAUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemEfficiencyUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemFeatherFallingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemFireAspectUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemFireProtectionUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemFlameUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemInfiArrowUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemKnockbackUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemLootingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemPowerUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemProjectileProtectionUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemProtectionUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemPunchUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemRespirationUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpnessUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSliktouchUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSmiteUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSoulboundUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemThornsUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemUnbreakingUpgrade;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.TucsRegistry;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {

	public static ToolMaterial COBBLESTONEDIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEDIUM_MATERIAL", 3, 1692, 8.0F, 10.0F, 22);
	public static ToolMaterial COBBLESTONEIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEIUM_MATERIAL", 2, 381, 6.0F, 3.0F, 15);
	public static ArmorMaterial COBBLESTONEIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("Cobblestoneium", 17, new int[] { 3, 7, 6, 3 }, 10);
	public static ArmorMaterial COBBLESTONEdIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("Cobblestonedium", 66, new int[] { 4, 9, 7, 4 }, 0);
	public static ToolMaterial COBBLESTONEDIUM_UBER_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEDIUM_UBER_MATERIAL", 3, -100, 16.0F, 20.0F, 22);

	// Ingots
	public static final ItemIngotCobblestoneium ingotCobblestoneium = new ItemIngotCobblestoneium();
	public static final ItemIngotCobblestonedium ingotCobblestonedium = new ItemIngotCobblestonedium();
	public static final ItemIngotYellowstoneium ingotYellowstoneium = new ItemIngotYellowstoneium();

	// Cobblestoneium tools and armor
	public static final ItemShovelCobblestoneium shovelCobblestoneium = new ItemShovelCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemSwordCobblestoneium swordCobblestoneium = new ItemSwordCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHatchetCobblestoneium hatchetCobblestoneium = new ItemHatchetCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHoeCobblestoneium hoeCobblestoneium = new ItemHoeCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemPickaxeCobblestoneium pickaxeCobblestoneium = new ItemPickaxeCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHelmetCobblestoneium helmetCobblestoneium = new ItemHelmetCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 0, "helmetCobblestoneium");
	public static final ItemLegCobblestoneium leggingsCobblestoneium = new ItemLegCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 2, "leggingsCobblestoneium");
	public static final ItemBootCobblestoneium bootsCobblestoneium = new ItemBootCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 3, "bootsCobblestoneium");
	public static final ItemChestplateCobblestoneium chestplateCobblestoneium = new ItemChestplateCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 1, "chestplateCobblestoneium");

	// Cobblestondium armor
	public static final ItemHelmetCobblestonedium helmetCobblestonedium = new ItemHelmetCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 0, "helmetCobblestonedium");
	public static final ItemLegCobblestonedium leggingsCobblestonedium = new ItemLegCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 2, "leggingsCobblestonedium");
	public static final ItemBootCobblestonedium bootsCobblestonedium = new ItemBootCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 3, "bootsCobblestonedium");
	public static final ItemChestplateCobblestonedium chestplateCobblestonedium = new ItemChestplateCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 1, "chestplateCobblestonedium");
	public static final ItemHelmetCobblestonedium_Scuba helmetCobblestonedium_scuba = new ItemHelmetCobblestonedium_Scuba(COBBLESTONEdIUM_ARMORMATERIAL, 0, "helmetCobblestonedium_scuba");
	public static final ItemChestplateCobblestonedium_scuba chestplateCobblestonedium_scuba = new ItemChestplateCobblestonedium_scuba(COBBLESTONEdIUM_ARMORMATERIAL, 1, "chestplateCobblestonedium_scuba");

	public static final ItemHelmetCobblestonediumBroken helmetCobblestonediumBroken = new ItemHelmetCobblestonediumBroken();
	public static final ItemLegCobblestonediumBroken leggingsCobblestonediumBroken = new ItemLegCobblestonediumBroken();
	public static final ItemBootCobblestonediumBroken bootsCobblestonediumBroken = new ItemBootCobblestonediumBroken();
	public static final ItemChestplateCobblestonediumBroken chestplateCobblestonediumBroken = new ItemChestplateCobblestonediumBroken();

	public static final ItemTLBOTH TUCSBow = new ItemTLBOTH();
	public static final ItemTLBOTHBroken TUCSBowBroken = new ItemTLBOTHBroken();
	public static final ItemM1911 M1911 = new ItemM1911(false);
	public static final ItemM1911Ammo ammo = new ItemM1911Ammo();

	// Mics items
	public static final ItemBook TUCSbook = new ItemBook();
	public static final ItemTUCSDebug TUCSdebug = new ItemTUCSDebug();
	public static final ItemCobbleCoal CobbleCoal = new ItemCobbleCoal();
	public static final ItemScubaMask ScubaMask = new ItemScubaMask(ArmorMaterial.IRON, 0, "scubaMask");
	public static final ItemAirTank AirTank = new ItemAirTank(ArmorMaterial.IRON, 1, "airtank");
	public static final ItemHealthUpgrade HealthUpgrade = new ItemHealthUpgrade();
	public static final ItemHoverBike HoverBike = new ItemHoverBike();
	public static final ItemTUCS Tier1CraftingMat = new ItemTUCS("tier1CraftingMat");
	public static final ItemTUCS Tier2CraftingMat = new ItemTUCS("tier2CraftingMat");
	public static final ItemTUCS Tier3CraftingMat = new ItemTUCS("tier3CraftingMat");

	// Lighters
	public static final ItemCobblestonediumLighter cobblestonediumLighter = new ItemCobblestonediumLighter();
	public static final ItemCobblestoneiumLighter cobblestoneiumLighter = new ItemCobblestoneiumLighter();
	public static final ItemCobblestoneLighter cobblestoneLighter = new ItemCobblestoneLighter();

	// Tools
	public static final ItemTLBOTB TLBOTB = new ItemTLBOTB(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLHOWF TLHOWF = new ItemTLHOWF(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLSOHD TLSOHD = new ItemTLSOHD(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLPOLM TLPOLM = new ItemTLPOLM(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLSOC TLSOC = new ItemTLSOC(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLSOTD TLSOTD = new ItemTLSOTD(COBBLESTONEDIUM_UBER_MATERIAL);

	// Tool parts
	public static final ItemShovelHead shovelHead = new ItemShovelHead();
	public static final ItemHatchetHead hatchetHead = new ItemHatchetHead();
	public static final ItemPickaxeHead pickaxeHead = new ItemPickaxeHead();
	public static final ItemHoeHead hoeHead = new ItemHoeHead();
	public static final ItemToolRod toolRod = new ItemToolRod();
	public static final ItemSwordBlade SwordBlade = new ItemSwordBlade();
	public static final ItemSwordHilt SwordHilt = new ItemSwordHilt();

	// Talismans
	public static final ItemTorchTalisman torchTalisman = new ItemTorchTalisman();
	public static final ItemTalismanBaseT1 talismanBaseT1 = new ItemTalismanBaseT1();
	public static final ItemCraftingTalisman craftingTalisman = new ItemCraftingTalisman();
	public static final ItemFlightTalisman FlightTalisman = new ItemFlightTalisman();
	public static final ItemUnfinshedflightTalisman UnfinshedFlightTalisman = new ItemUnfinshedflightTalisman();
	public static final ItemUngoldenflightTalisman ungoldenFligtTalisman = new ItemUngoldenflightTalisman();
	public static final ItemTalismanBaseT2 TalismanBase = new ItemTalismanBaseT2();

	// Upgrades
	public static final ItemUpgradeBase upgradBase = new ItemUpgradeBase();
	public static final ItemUpgradeBaseT2 upgradBaseT2 = new ItemUpgradeBaseT2();
	public static final ItemLootingUpgrade looting1Upgrade = new ItemLootingUpgrade(1);
	public static final ItemLootingUpgrade looting2Upgrade = new ItemLootingUpgrade(2);
	public static final ItemLootingUpgrade looting3Upgrade = new ItemLootingUpgrade(3);
	public static final ItemSoulboundUpgrade soulboundUpgrade = new ItemSoulboundUpgrade();
	public static final ItemSharpnessUpgrade Sharpness1Upgrade = new ItemSharpnessUpgrade(1);
	public static final ItemSharpnessUpgrade Sharpness2Upgrade = new ItemSharpnessUpgrade(2);
	public static final ItemSharpnessUpgrade Sharpness3Upgrade = new ItemSharpnessUpgrade(3);
	public static final ItemSharpnessUpgrade Sharpness4Upgrade = new ItemSharpnessUpgrade(4);
	public static final ItemSharpnessUpgrade Sharpness5Upgrade = new ItemSharpnessUpgrade(5);
	public static final ItemBoAUpgrade BoA1Upgrade = new ItemBoAUpgrade(1);
	public static final ItemBoAUpgrade BoA2Upgrade = new ItemBoAUpgrade(2);
	public static final ItemBoAUpgrade BoA3Upgrade = new ItemBoAUpgrade(3);
	public static final ItemBoAUpgrade BoA4Upgrade = new ItemBoAUpgrade(4);
	public static final ItemBoAUpgrade BoA5Upgrade = new ItemBoAUpgrade(5);
	public static final ItemEfficiencyUpgrade Efficiency1Upgrade = new ItemEfficiencyUpgrade(1);
	public static final ItemEfficiencyUpgrade Efficiency2Upgrade = new ItemEfficiencyUpgrade(2);
	public static final ItemEfficiencyUpgrade Efficiency3Upgrade = new ItemEfficiencyUpgrade(3);
	public static final ItemEfficiencyUpgrade Efficiency4Upgrade = new ItemEfficiencyUpgrade(4);
	public static final ItemEfficiencyUpgrade Efficiency5Upgrade = new ItemEfficiencyUpgrade(5);
	public static final ItemSmiteUpgrade Smite1Upgrade = new ItemSmiteUpgrade(1);
	public static final ItemSmiteUpgrade Smite2Upgrade = new ItemSmiteUpgrade(2);
	public static final ItemSmiteUpgrade Smite3Upgrade = new ItemSmiteUpgrade(3);
	public static final ItemSmiteUpgrade Smite4Upgrade = new ItemSmiteUpgrade(4);
	public static final ItemSmiteUpgrade Smite5Upgrade = new ItemSmiteUpgrade(5);
	public static final ItemFireAspectUpgrade FireAspect1Upgrade = new ItemFireAspectUpgrade(1);
	public static final ItemFireAspectUpgrade FireAspect2Upgrade = new ItemFireAspectUpgrade(2);
	public static final ItemKnockbackUpgrade Knockback1Upgrade = new ItemKnockbackUpgrade(1);
	public static final ItemKnockbackUpgrade Knockback2Upgrade = new ItemKnockbackUpgrade(2);
	public static final ItemSliktouchUpgrade Sliktouch1Upgrade = new ItemSliktouchUpgrade(1);
	public static final ItemUnbreakingUpgrade Unbreaking1Upgrade = new ItemUnbreakingUpgrade(1);
	public static final ItemUnbreakingUpgrade Unbreaking2Upgrade = new ItemUnbreakingUpgrade(2);
	public static final ItemUnbreakingUpgrade Unbreaking3Upgrade = new ItemUnbreakingUpgrade(3);
	public static final ItemBeheadingUpgrade BeheadingUpgrade = new ItemBeheadingUpgrade();
	public static final ItemInfiArrowUpgrade InfiUpgrade = new ItemInfiArrowUpgrade();
	public static final ItemAutoBowUpgrade AutoBowUpgrade = new ItemAutoBowUpgrade();
	public static final ItemAquaAffinityUpgrade AquaAffinityUpgrade = new ItemAquaAffinityUpgrade(1);
	public static final ItemBlastProtectionUpgrade BlastProtection1Upgrade = new ItemBlastProtectionUpgrade(1);
	public static final ItemBlastProtectionUpgrade BlastProtection2Upgrade = new ItemBlastProtectionUpgrade(2);
	public static final ItemBlastProtectionUpgrade BlastProtection3Upgrade = new ItemBlastProtectionUpgrade(3);
	public static final ItemBlastProtectionUpgrade BlastProtection4Upgrade = new ItemBlastProtectionUpgrade(4);
	public static final ItemFeatherFallingUpgrade FeatherFalling1Upgrade = new ItemFeatherFallingUpgrade(1);
	public static final ItemFeatherFallingUpgrade FeatherFalling2Upgrade = new ItemFeatherFallingUpgrade(2);
	public static final ItemFeatherFallingUpgrade FeatherFalling3Upgrade = new ItemFeatherFallingUpgrade(3);
	public static final ItemFeatherFallingUpgrade FeatherFalling4Upgrade = new ItemFeatherFallingUpgrade(4);
	public static final ItemFireProtectionUpgrade FireProtection1Upgrade = new ItemFireProtectionUpgrade(1);
	public static final ItemFireProtectionUpgrade FireProtection2Upgrade = new ItemFireProtectionUpgrade(2);
	public static final ItemFireProtectionUpgrade FireProtection3Upgrade = new ItemFireProtectionUpgrade(3);
	public static final ItemFireProtectionUpgrade FireProtection4Upgrade = new ItemFireProtectionUpgrade(4);
	public static final ItemFlameUpgrade FlameUpgrade = new ItemFlameUpgrade(1);
	public static final ItemPowerUpgrade Power1Upgrade = new ItemPowerUpgrade(1);
	public static final ItemPowerUpgrade Power2Upgrade = new ItemPowerUpgrade(2);
	public static final ItemPowerUpgrade Power3Upgrade = new ItemPowerUpgrade(3);
	public static final ItemPowerUpgrade Power4Upgrade = new ItemPowerUpgrade(4);
	public static final ItemPowerUpgrade Power5Upgrade = new ItemPowerUpgrade(5);
	public static final ItemProjectileProtectionUpgrade ProjectileProtection1Upgrade = new ItemProjectileProtectionUpgrade(1);
	public static final ItemProjectileProtectionUpgrade ProjectileProtection2Upgrade = new ItemProjectileProtectionUpgrade(2);
	public static final ItemProjectileProtectionUpgrade ProjectileProtection3Upgrade = new ItemProjectileProtectionUpgrade(3);
	public static final ItemProjectileProtectionUpgrade ProjectileProtection4Upgrade = new ItemProjectileProtectionUpgrade(4);
	public static final ItemProtectionUpgrade Protection1Upgrade = new ItemProtectionUpgrade(1);
	public static final ItemProtectionUpgrade Protection2Upgrade = new ItemProtectionUpgrade(2);
	public static final ItemProtectionUpgrade Protection3Upgrade = new ItemProtectionUpgrade(3);
	public static final ItemProtectionUpgrade Protection4Upgrade = new ItemProtectionUpgrade(4);
	public static final ItemPunchUpgrade Punch1Upgrade = new ItemPunchUpgrade(1);
	public static final ItemPunchUpgrade Punch2Upgrade = new ItemPunchUpgrade(2);
	public static final ItemRespirationUpgrade Respiration1Upgrade = new ItemRespirationUpgrade(1);
	public static final ItemRespirationUpgrade Respiration2Upgrade = new ItemRespirationUpgrade(2);
	public static final ItemRespirationUpgrade Respiration3Upgrade = new ItemRespirationUpgrade(3);
	public static final ItemThornsUpgrade Thorns1Upgrade = new ItemThornsUpgrade(1);
	public static final ItemThornsUpgrade Thorns2Upgrade = new ItemThornsUpgrade(2);
	public static final ItemThornsUpgrade Thorns3Upgrade = new ItemThornsUpgrade(3);

	public static void init() {

		// TOOLS
		TucsRegistry.registerItem(TLSOC, "TLSOC");
		TucsRegistry.registerItem(TLBOTB, "TLBOTB");
		TucsRegistry.registerItem(TLHOWF, "TLHOWF");
		TucsRegistry.registerItem(TLSOHD, "TLSOHD");
		TucsRegistry.registerItem(TLPOLM, "TLPOLM");
		TucsRegistry.registerItem(TLSOTD, "TLSOTD");

		TucsRegistry.registerItem(shovelCobblestoneium, "shovelCobblestoneium");
		TucsRegistry.registerItem(swordCobblestoneium, "swordCobblestoneium");
		TucsRegistry.registerItem(hatchetCobblestoneium, "hatchetCobblestoneium");
		TucsRegistry.registerItem(hoeCobblestoneium, "hoeCobblestoneium");
		TucsRegistry.registerItem(pickaxeCobblestoneium, "pickaxeCobblestoneium");

		// ARMOR
		TucsRegistry.registerItem(helmetCobblestoneium, "helmetCobblestoneium");
		TucsRegistry.registerItem(leggingsCobblestoneium, "leggingsCobblestoneium");
		TucsRegistry.registerItem(bootsCobblestoneium, "bootsCobblestoneium");
		TucsRegistry.registerItem(chestplateCobblestoneium, "chestplateCobblestoneium");
		TucsRegistry.registerItem(helmetCobblestonedium, "helmetCobblestonedium");
		TucsRegistry.registerItem(leggingsCobblestonedium, "leggingsCobblestonedium");
		TucsRegistry.registerItem(bootsCobblestonedium, "bootsCobblestonedium");
		TucsRegistry.registerItem(chestplateCobblestonedium, "chestplateCobblestonedium");
		TucsRegistry.registerItem(ScubaMask, "scubaMask");
		TucsRegistry.registerItem(AirTank, "AirTank");
		TucsRegistry.registerItem(helmetCobblestonedium_scuba, "helmetCobblestonedium_scuba");
		TucsRegistry.registerItem(chestplateCobblestonedium_scuba, "chestplateCobblestonedium_scuba");

		// INGOTS
		TucsRegistry.registerItem(ingotCobblestoneium, "ingotCobblestoneium");
		TucsRegistry.registerItem(ingotCobblestonedium, "ingotCobblestonedium");
		TucsRegistry.registerItem(ingotYellowstoneium, "ingotYellowstoneium");

		// ITEMS
		TucsRegistry.registerItem(cobblestoneLighter, "cobblestoneLighter");
		// TucsRegistry.registerItem(TUCSbook, "TUCSbook");
		// TucsRegistry.registerItem(TUCSdebug, "TUCSdebug");
		TucsRegistry.registerItem(CobbleCoal, "CobbleCoal");
		TucsRegistry.registerItem(cobblestonediumLighter, "cobblestonediumLighter");
		TucsRegistry.registerItem(cobblestoneiumLighter, "cobblestoneiumLighter");
		TucsRegistry.registerItem(FlightTalisman, "FlightTalisman");
		TucsRegistry.registerItem(torchTalisman, "torchTalisman");
		TucsRegistry.registerItem(craftingTalisman, "craftingTalisman");

		TucsRegistry.registerItem(TUCSBow, "TUCSBow");
		TucsRegistry.registerItem(TUCSBowBroken, "TUCSBowBroken");
		TucsRegistry.registerItem(M1911, "M1911");
		TucsRegistry.registerItem(ammo, "ammo");
		TucsRegistry.registerItem(Tier1CraftingMat, "Tier1CraftingMat");
		TucsRegistry.registerItem(Tier2CraftingMat, "Tier2CraftingMat");
		TucsRegistry.registerItem(Tier3CraftingMat, "Tier3CraftingMat");
		// TucsRegistry.registerItem(HealthUpgrade, "HealthUpgrade");
		// TucsRegistry.registerItem(HoverBike, "HoverBike");

		TucsRegistry.registerItem(helmetCobblestonediumBroken, "helmetCobblestonediumBroken");
		TucsRegistry.registerItem(leggingsCobblestonediumBroken, "leggingsCobblestonediumBroken");
		TucsRegistry.registerItem(bootsCobblestonediumBroken, "bootsCobblestonediumBroken");
		TucsRegistry.registerItem(chestplateCobblestonediumBroken, "chestplateCobblestonediumBroken");

		// UPGRADES
		TucsRegistry.registerItem(looting1Upgrade, "looting1Upgrade");
		TucsRegistry.registerItem(looting2Upgrade, "looting2Upgrade");
		TucsRegistry.registerItem(looting3Upgrade, "looting3Upgrade");
		TucsRegistry.registerItem(soulboundUpgrade, "soulboundUpgrade");
		TucsRegistry.registerItem(Sharpness1Upgrade, "Sharpness1Upgrade");
		TucsRegistry.registerItem(Sharpness2Upgrade, "Sharpness2Upgrade");
		TucsRegistry.registerItem(Sharpness3Upgrade, "Sharpness3Upgrade");
		TucsRegistry.registerItem(Sharpness4Upgrade, "Sharpness4Upgrade");
		TucsRegistry.registerItem(Sharpness5Upgrade, "Sharpness5Upgrade");
		TucsRegistry.registerItem(Sliktouch1Upgrade, "Sliktouch1Upgrade");
		TucsRegistry.registerItem(BeheadingUpgrade, "BeheadingUpgrade");
		TucsRegistry.registerItem(BoA1Upgrade, "BoA1Upgrade");
		TucsRegistry.registerItem(BoA2Upgrade, "BoA2Upgrade");
		TucsRegistry.registerItem(BoA3Upgrade, "BoA3Upgrade");
		TucsRegistry.registerItem(BoA4Upgrade, "BoA4Upgrade");
		TucsRegistry.registerItem(BoA5Upgrade, "BoA5Upgrade");
		TucsRegistry.registerItem(Efficiency1Upgrade, "Efficiency1Upgrade");
		TucsRegistry.registerItem(Efficiency2Upgrade, "Efficiency2Upgrade");
		TucsRegistry.registerItem(Efficiency3Upgrade, "Efficiency3Upgrade");
		TucsRegistry.registerItem(Efficiency4Upgrade, "Efficiency4Upgrade");
		TucsRegistry.registerItem(Efficiency5Upgrade, "Efficiency5Upgrade");
		TucsRegistry.registerItem(Smite1Upgrade, "Smite1Upgrade");
		TucsRegistry.registerItem(Smite2Upgrade, "Smite2Upgrade");
		TucsRegistry.registerItem(Smite3Upgrade, "Smite3Upgrade");
		TucsRegistry.registerItem(Smite4Upgrade, "Smite4Upgrade");
		TucsRegistry.registerItem(Smite5Upgrade, "Smite5Upgrade");
		TucsRegistry.registerItem(FireAspect1Upgrade, "FireAspect1Upgrade");
		TucsRegistry.registerItem(FireAspect2Upgrade, "FireAspect2Upgrade");
		TucsRegistry.registerItem(Knockback1Upgrade, "Knockback1Upgrade");
		TucsRegistry.registerItem(Knockback2Upgrade, "Knockback2Upgrade");
		TucsRegistry.registerItem(Unbreaking1Upgrade, "Unbreaking1Upgrade");
		TucsRegistry.registerItem(Unbreaking2Upgrade, "Unbreaking2Upgrade");
		TucsRegistry.registerItem(Unbreaking3Upgrade, "Unbreaking3Upgrade");
		TucsRegistry.registerItem(InfiUpgrade, "InfiUpgrade");
		TucsRegistry.registerItem(AutoBowUpgrade, "AutoBowUpgrade");
		TucsRegistry.registerItem(AquaAffinityUpgrade, "AquaAffinityUpgrade");
		TucsRegistry.registerItem(BlastProtection1Upgrade, "BlastProtection1Upgrade");
		TucsRegistry.registerItem(BlastProtection2Upgrade, "BlastProtection2Upgrade");
		TucsRegistry.registerItem(BlastProtection3Upgrade, "BlastProtection3Upgrade");
		TucsRegistry.registerItem(BlastProtection4Upgrade, "BlastProtection4Upgrade");
		TucsRegistry.registerItem(FeatherFalling1Upgrade, "FeatherFalling1Upgrade");
		TucsRegistry.registerItem(FeatherFalling2Upgrade, "FeatherFalling2Upgrade");
		TucsRegistry.registerItem(FeatherFalling3Upgrade, "FeatherFalling3Upgrade");
		TucsRegistry.registerItem(FeatherFalling4Upgrade, "FeatherFalling4Upgrade");
		TucsRegistry.registerItem(FireProtection1Upgrade, "FireProtection1Upgrade");
		TucsRegistry.registerItem(FireProtection2Upgrade, "FireProtection2Upgrade");
		TucsRegistry.registerItem(FireProtection3Upgrade, "FireProtection3Upgrade");
		TucsRegistry.registerItem(FireProtection4Upgrade, "FireProtection4Upgrade");
		TucsRegistry.registerItem(FlameUpgrade, "FlameUpgrade");
		TucsRegistry.registerItem(Power1Upgrade, "Power1Upgrade");
		TucsRegistry.registerItem(Power2Upgrade, "Power2Upgrade");
		TucsRegistry.registerItem(Power3Upgrade, "Power3Upgrade");
		TucsRegistry.registerItem(Power4Upgrade, "Power4Upgrade");
		TucsRegistry.registerItem(Power5Upgrade, "Power5Upgrade");
		TucsRegistry.registerItem(ProjectileProtection1Upgrade, "ProjectileProtection1Upgrade");
		TucsRegistry.registerItem(ProjectileProtection2Upgrade, "ProjectileProtection2Upgrade");
		TucsRegistry.registerItem(ProjectileProtection3Upgrade, "ProjectileProtection3Upgrade");
		TucsRegistry.registerItem(ProjectileProtection4Upgrade, "ProjectileProtection4Upgrade");
		TucsRegistry.registerItem(Punch1Upgrade, "Punch1Upgrade");
		TucsRegistry.registerItem(Punch2Upgrade, "Punch2Upgrade");
		TucsRegistry.registerItem(Respiration1Upgrade, "Respiration1Upgrade");
		TucsRegistry.registerItem(Respiration2Upgrade, "Respiration2Upgrade");
		TucsRegistry.registerItem(Respiration3Upgrade, "Respiration3Upgrade");
		TucsRegistry.registerItem(Thorns1Upgrade, "Thorns1Upgrade");
		TucsRegistry.registerItem(Thorns2Upgrade, "Thorns2Upgrade");
		TucsRegistry.registerItem(Thorns3Upgrade, "Thorns3Upgrade");
		TucsRegistry.registerItem(Protection1Upgrade, "Protection1Upgrade");
		TucsRegistry.registerItem(Protection2Upgrade, "Protection2Upgrade");
		TucsRegistry.registerItem(Protection3Upgrade, "Protection3Upgrade");
		TucsRegistry.registerItem(Protection4Upgrade, "Protection4Upgrade");

		// TOOL PARTS
		TucsRegistry.registerItem(SwordBlade, "SwordBlade");
		TucsRegistry.registerItem(SwordHilt, "SwordHilt");
		TucsRegistry.registerItem(toolRod, "toolRod");
		TucsRegistry.registerItem(shovelHead, "shovelHead");
		TucsRegistry.registerItem(hatchetHead, "hatchetHead");
		TucsRegistry.registerItem(pickaxeHead, "pickaxeHead");
		TucsRegistry.registerItem(hoeHead, "hoeHead");
		TucsRegistry.registerItem(UnfinshedFlightTalisman, "UnfinshedFlightTalisman");
		TucsRegistry.registerItem(ungoldenFligtTalisman, "ungoldenFligtTalisman");
		TucsRegistry.registerItem(talismanBaseT1, "talismanBaseT1");
		TucsRegistry.registerItem(TalismanBase, "TalismanBase");
		TucsRegistry.registerItem(upgradBase, "upgradBase");
		TucsRegistry.registerItem(upgradBaseT2, "upgradBaseT2");
	}

}
