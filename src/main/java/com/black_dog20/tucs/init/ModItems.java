package com.black_dog20.tucs.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.black_dog20.tucs.item.ItemBook;
import com.black_dog20.tucs.item.ItemCobbleCoal;
import com.black_dog20.tucs.item.ItemCraftingTalisman;
import com.black_dog20.tucs.item.ItemFlightTalisman;
import com.black_dog20.tucs.item.ItemIngotCobblestonedium;
import com.black_dog20.tucs.item.ItemIngotCobblestoneium;
import com.black_dog20.tucs.item.ItemIngotYellowstoneium;
import com.black_dog20.tucs.item.ItemM1911Ammo;
import com.black_dog20.tucs.item.ItemTUCSDebug;
import com.black_dog20.tucs.item.ItemTorchTalisman;
import com.black_dog20.tucs.item.armor.ItemBootCobblestonedium;
import com.black_dog20.tucs.item.armor.ItemBootCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.ItemBootCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemChestplateCobblestonedium;
import com.black_dog20.tucs.item.armor.ItemChestplateCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.ItemChestplateCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemHelmetCobblestonedium;
import com.black_dog20.tucs.item.armor.ItemHelmetCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.ItemHelmetCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemLegCobblestonedium;
import com.black_dog20.tucs.item.armor.ItemLegCobblestonediumBroken;
import com.black_dog20.tucs.item.armor.ItemLegCobblestoneium;
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

import cpw.mods.fml.common.registry.GameRegistry;


@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static ToolMaterial COBBLESTONEDIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEDIUM_MATERIAL", 3, 1692, 8.0F, 10.0F, 22);
	public static ToolMaterial COBBLESTONEIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEIUM_MATERIAL", 2, 381, 6.0F, 3.0F, 15);
	public static ArmorMaterial COBBLESTONEIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("Cobblestoneium", 17 , new int[] {3,7,6,3}, 10);
	public static ArmorMaterial COBBLESTONEdIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("Cobblestonedium", 66 , new int[] {4,9,7,4}, 0);
	public static ToolMaterial COBBLESTONEDIUM_UBER_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEDIUM_UBER_MATERIAL", 3, -100, 16.0F, 20.0F, 22);
	
	//Ingots
	public static final ItemIngotCobblestoneium ingotCobblestoneium = new ItemIngotCobblestoneium();
	public static final ItemIngotCobblestonedium ingotCobblestonedium = new ItemIngotCobblestonedium();
	public static final ItemIngotYellowstoneium ingotYellowstoneium = new ItemIngotYellowstoneium();

	//Cobblestoneium tools and armor
	public static final ItemShovelCobblestoneium shovelCobblestoneium = new ItemShovelCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemSwordCobblestoneium swordCobblestoneium = new ItemSwordCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHatchetCobblestoneium hatchetCobblestoneium = new ItemHatchetCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHoeCobblestoneium hoeCobblestoneium = new ItemHoeCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemPickaxeCobblestoneium pickaxeCobblestoneium = new ItemPickaxeCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHelmetCobblestoneium helmetCobblestoneium = new ItemHelmetCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 0, "helmetCobblestoneium");
	public static final ItemLegCobblestoneium leggingsCobblestoneium = new ItemLegCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 2, "leggingsCobblestoneium");
	public static final ItemBootCobblestoneium bootsCobblestoneium = new ItemBootCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 3, "bootsCobblestoneium");
	public static final ItemChestplateCobblestoneium chestplateCobblestoneium = new ItemChestplateCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 1, "chestplateCobblestoneium");
	
	
	//Cobblestondium armor
	public static final ItemHelmetCobblestonedium helmetCobblestonedium = new ItemHelmetCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 0, "helmetCobblestonedium");
	public static final ItemLegCobblestonedium leggingsCobblestonedium = new ItemLegCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 2, "leggingsCobblestonedium");
	public static final ItemBootCobblestonedium bootsCobblestonedium = new ItemBootCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 3, "bootsCobblestonedium");
	public static final ItemChestplateCobblestonedium chestplateCobblestonedium = new ItemChestplateCobblestonedium(COBBLESTONEdIUM_ARMORMATERIAL, 1, "chestplateCobblestonedium");
	
	public static final ItemHelmetCobblestonediumBroken helmetCobblestonediumBroken = new ItemHelmetCobblestonediumBroken();
	public static final ItemLegCobblestonediumBroken leggingsCobblestonediumBroken = new ItemLegCobblestonediumBroken();
	public static final ItemBootCobblestonediumBroken bootsCobblestonediumBroken = new ItemBootCobblestonediumBroken();
	public static final ItemChestplateCobblestonediumBroken chestplateCobblestonediumBroken = new ItemChestplateCobblestonediumBroken();
	
	public static final ItemTLBOTH TUCSBow = new ItemTLBOTH();
	public static final ItemTLBOTHBroken TUCSBowBroken = new ItemTLBOTHBroken();
	public static final ItemM1911 M1911 = new ItemM1911(false);
	public static final ItemM1911Ammo ammo = new ItemM1911Ammo();
	
	
	//Mics items
	public static final ItemBook TUCSbook = new ItemBook();
	public static final ItemTUCSDebug TUCSdebug = new ItemTUCSDebug();
	public static final ItemCobbleCoal CobbleCoal = new ItemCobbleCoal();
	
	//Lighters
	public static final ItemCobblestonediumLighter cobblestonediumLighter = new ItemCobblestonediumLighter();
	public static final ItemCobblestoneiumLighter cobblestoneiumLighter = new ItemCobblestoneiumLighter();
	public static final ItemCobblestoneLighter cobblestoneLighter = new ItemCobblestoneLighter();

	//Tools
	public static final ItemTLBOTB TLBOTB = new ItemTLBOTB(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLHOWF TLHOWF = new ItemTLHOWF(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLSOHD TLSOHD = new ItemTLSOHD(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLPOLM TLPOLM = new ItemTLPOLM(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLSOC TLSOC = new ItemTLSOC(COBBLESTONEDIUM_MATERIAL);
	public static final ItemTLSOTD TLSOTD = new ItemTLSOTD(COBBLESTONEDIUM_UBER_MATERIAL);
	
	//Tool parts
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
	
	//Upgrades
	public static final ItemUpgradeBase upgradBase = new ItemUpgradeBase();
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
	
	public static void init(){
		
		//TOOLS
		GameRegistry.registerItem(TLSOC, "TLSOC");
		GameRegistry.registerItem(TLBOTB, "TLBOTB");
		GameRegistry.registerItem(TLHOWF, "TLHOWF");
		GameRegistry.registerItem(TLSOHD, "TLSOHD");
		GameRegistry.registerItem(TLPOLM, "TLPOLM");
		GameRegistry.registerItem(TLSOTD, "TLSOTD");
		
		GameRegistry.registerItem(shovelCobblestoneium, "shovelCobblestoneium");
		GameRegistry.registerItem(swordCobblestoneium, "swordCobblestoneium");
		GameRegistry.registerItem(hatchetCobblestoneium, "hatchetCobblestoneium");
		GameRegistry.registerItem(hoeCobblestoneium, "hoeCobblestoneium");
		GameRegistry.registerItem(pickaxeCobblestoneium, "pickaxeCobblestoneium");
		
		//ARMOR
		GameRegistry.registerItem(helmetCobblestoneium, "helmetCobblestoneium");
		GameRegistry.registerItem(leggingsCobblestoneium, "leggingsCobblestoneium");
		GameRegistry.registerItem(bootsCobblestoneium, "bootsCobblestoneium");
		GameRegistry.registerItem(chestplateCobblestoneium, "chestplateCobblestoneium");
		GameRegistry.registerItem(helmetCobblestonedium, "helmetCobblestonedium");
		GameRegistry.registerItem(leggingsCobblestonedium, "leggingsCobblestonedium");
		GameRegistry.registerItem(bootsCobblestonedium, "bootsCobblestonedium");
		GameRegistry.registerItem(chestplateCobblestonedium, "chestplateCobblestonedium");
		
		
		//INGOTS
		GameRegistry.registerItem(ingotCobblestoneium, "ingotCobblestoneium");
		GameRegistry.registerItem(ingotCobblestonedium, "ingotCobblestonedium");
		GameRegistry.registerItem(ingotYellowstoneium, "ingotYellowstoneium");
		
		//ITEMS
		GameRegistry.registerItem(cobblestoneLighter, "cobblestoneLighter");
		GameRegistry.registerItem(TUCSbook, "TUCSbook");
		GameRegistry.registerItem(TUCSdebug, "TUCSdebug");
		GameRegistry.registerItem(CobbleCoal, "CobbleCoal");
		GameRegistry.registerItem(cobblestonediumLighter, "cobblestonediumLighter");
		GameRegistry.registerItem(cobblestoneiumLighter, "cobblestoneiumLighter");
		GameRegistry.registerItem(FlightTalisman, "FlightTalisman");
		GameRegistry.registerItem(torchTalisman, "torchTalisman");
		GameRegistry.registerItem(craftingTalisman, "craftingTalisman");
		
		GameRegistry.registerItem(TUCSBow, "TUCSBow");
		GameRegistry.registerItem(TUCSBowBroken, "TUCSBowBroken");
		GameRegistry.registerItem(M1911, "M1911");
		GameRegistry.registerItem(ammo, "ammo");
		
		GameRegistry.registerItem(helmetCobblestonediumBroken, "helmetCobblestonediumBroken");
		GameRegistry.registerItem(leggingsCobblestonediumBroken, "leggingsCobblestonediumBroken");
		GameRegistry.registerItem(bootsCobblestonediumBroken, "bootsCobblestonediumBroken");
		GameRegistry.registerItem(chestplateCobblestonediumBroken, "chestplateCobblestonediumBroken");
		
		//UPGRADES
		GameRegistry.registerItem(looting1Upgrade, "looting1Upgrade");
		GameRegistry.registerItem(looting2Upgrade, "looting2Upgrade");
		GameRegistry.registerItem(looting3Upgrade, "looting3Upgrade");
		GameRegistry.registerItem(soulboundUpgrade, "soulboundUpgrade");
		GameRegistry.registerItem(Sharpness1Upgrade, "Sharpness1Upgrade");
		GameRegistry.registerItem(Sharpness2Upgrade, "Sharpness2Upgrade");
		GameRegistry.registerItem(Sharpness3Upgrade, "Sharpness3Upgrade");
		GameRegistry.registerItem(Sharpness4Upgrade, "Sharpness4Upgrade");
		GameRegistry.registerItem(Sharpness5Upgrade, "Sharpness5Upgrade");
		GameRegistry.registerItem(Sliktouch1Upgrade, "Sliktouch1Upgrade");
		GameRegistry.registerItem(BeheadingUpgrade, "BeheadingUpgrade");
		GameRegistry.registerItem(BoA1Upgrade, "BoA1Upgrade");
		GameRegistry.registerItem(BoA2Upgrade, "BoA2Upgrade");
		GameRegistry.registerItem(BoA3Upgrade, "BoA3Upgrade");
		GameRegistry.registerItem(BoA4Upgrade, "BoA4Upgrade");
		GameRegistry.registerItem(BoA5Upgrade, "BoA5Upgrade");
		GameRegistry.registerItem(Efficiency1Upgrade, "Efficiency1Upgrade");
		GameRegistry.registerItem(Efficiency2Upgrade, "Efficiency2Upgrade");
		GameRegistry.registerItem(Efficiency3Upgrade, "Efficiency3Upgrade");
		GameRegistry.registerItem(Efficiency4Upgrade, "Efficiency4Upgrade");
		GameRegistry.registerItem(Efficiency5Upgrade, "Efficiency5Upgrade");
		GameRegistry.registerItem(Smite1Upgrade, "Smite1Upgrade");
		GameRegistry.registerItem(Smite2Upgrade, "Smite2Upgrade");
		GameRegistry.registerItem(Smite3Upgrade, "Smite3Upgrade");
		GameRegistry.registerItem(Smite4Upgrade, "Smite4Upgrade");
		GameRegistry.registerItem(Smite5Upgrade, "Smite5Upgrade");
		GameRegistry.registerItem(FireAspect1Upgrade, "FireAspect1Upgrade");
		GameRegistry.registerItem(FireAspect2Upgrade, "FireAspect2Upgrade");
		GameRegistry.registerItem(Knockback1Upgrade, "Knockback1Upgrade");
		GameRegistry.registerItem(Knockback2Upgrade, "Knockback2Upgrade");
		GameRegistry.registerItem(Unbreaking1Upgrade, "Unbreaking1Upgrade");
		GameRegistry.registerItem(Unbreaking2Upgrade, "Unbreaking2Upgrade");
		GameRegistry.registerItem(Unbreaking3Upgrade, "Unbreaking3Upgrade");
		GameRegistry.registerItem(InfiUpgrade, "InfiUpgrade");
		GameRegistry.registerItem(AutoBowUpgrade, "AutoBowUpgrade");
		GameRegistry.registerItem(AquaAffinityUpgrade, "AquaAffinityUpgrade");
		GameRegistry.registerItem(BlastProtection1Upgrade, "BlastProtection1Upgrade");
		GameRegistry.registerItem(BlastProtection2Upgrade, "BlastProtection2Upgrade");
		GameRegistry.registerItem(BlastProtection3Upgrade, "BlastProtection3Upgrade");
		GameRegistry.registerItem(BlastProtection4Upgrade, "BlastProtection4Upgrade");
		GameRegistry.registerItem(FeatherFalling1Upgrade, "FeatherFalling1Upgrade");
		GameRegistry.registerItem(FeatherFalling2Upgrade, "FeatherFalling2Upgrade");
		GameRegistry.registerItem(FeatherFalling3Upgrade, "FeatherFalling3Upgrade");
		GameRegistry.registerItem(FeatherFalling4Upgrade, "FeatherFalling4Upgrade");
		GameRegistry.registerItem(FireProtection1Upgrade, "FireProtection1Upgrade");
		GameRegistry.registerItem(FireProtection2Upgrade, "FireProtection2Upgrade");
		GameRegistry.registerItem(FireProtection3Upgrade, "FireProtection3Upgrade");
		GameRegistry.registerItem(FireProtection4Upgrade, "FireProtection4Upgrade");
		GameRegistry.registerItem(FlameUpgrade, "FlameUpgrade");
		GameRegistry.registerItem(Power1Upgrade, "Power1Upgrade");
		GameRegistry.registerItem(Power2Upgrade, "Power2Upgrade");
		GameRegistry.registerItem(Power3Upgrade, "Power3Upgrade");
		GameRegistry.registerItem(Power4Upgrade, "Power4Upgrade");
		GameRegistry.registerItem(Power5Upgrade, "Power5Upgrade");
		GameRegistry.registerItem(ProjectileProtection1Upgrade, "ProjectileProtection1Upgrade");
		GameRegistry.registerItem(ProjectileProtection2Upgrade, "ProjectileProtection2Upgrade");
		GameRegistry.registerItem(ProjectileProtection3Upgrade, "ProjectileProtection3Upgrade");
		GameRegistry.registerItem(ProjectileProtection4Upgrade, "ProjectileProtection4Upgrade");
		GameRegistry.registerItem(Punch1Upgrade, "Punch1Upgrade");
		GameRegistry.registerItem(Punch2Upgrade, "Punch2Upgrade");
		GameRegistry.registerItem(Respiration1Upgrade, "Respiration1Upgrade");
		GameRegistry.registerItem(Respiration2Upgrade, "Respiration2Upgrade");
		GameRegistry.registerItem(Respiration3Upgrade, "Respiration3Upgrade");
		GameRegistry.registerItem(Thorns1Upgrade, "Thorns1Upgrade");
		GameRegistry.registerItem(Thorns2Upgrade, "Thorns2Upgrade");
		GameRegistry.registerItem(Thorns3Upgrade, "Thorns3Upgrade");
		GameRegistry.registerItem(Protection1Upgrade, "Protection1Upgrade");
		GameRegistry.registerItem(Protection2Upgrade, "Protection2Upgrade");
		GameRegistry.registerItem(Protection3Upgrade, "Protection3Upgrade");
		GameRegistry.registerItem(Protection4Upgrade, "Protection4Upgrade");
		
		//TOOL PARTS
		GameRegistry.registerItem(SwordBlade, "SwordBlade");
		GameRegistry.registerItem(SwordHilt, "SwordHilt");
		GameRegistry.registerItem(toolRod, "toolRod");
		GameRegistry.registerItem(shovelHead, "shovelHead");
		GameRegistry.registerItem(hatchetHead, "hatchetHead");
		GameRegistry.registerItem(pickaxeHead, "pickaxeHead");
		GameRegistry.registerItem(hoeHead, "hoeHead");
		GameRegistry.registerItem(UnfinshedFlightTalisman, "UnfinshedFlightTalisman");
		GameRegistry.registerItem(ungoldenFligtTalisman, "ungoldenFligtTalisman");
		GameRegistry.registerItem(talismanBaseT1, "talismanBaseT1");
		GameRegistry.registerItem(TalismanBase, "TalismanBase");
		GameRegistry.registerItem(upgradBase, "upgradBase");


		
		

	}

}
