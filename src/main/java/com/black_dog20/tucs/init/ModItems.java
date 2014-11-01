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
import com.black_dog20.tucs.item.ItemTUCSDebug;
import com.black_dog20.tucs.item.ItemTorchTalisman;
import com.black_dog20.tucs.item.armor.ItemBootCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemChestplateCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemHelmetCobblestoneium;
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
import com.black_dog20.tucs.item.tool.ItemCobblestonediumLighter;
import com.black_dog20.tucs.item.tool.ItemCobblestoneiumLighter;
import com.black_dog20.tucs.item.tool.ItemHatchetCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemHoeCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemPickaxeCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemShovelCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemSwordCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemTLBOTB;
import com.black_dog20.tucs.item.tool.ItemTLHOWF;
import com.black_dog20.tucs.item.tool.ItemTLPOLM;
import com.black_dog20.tucs.item.tool.ItemTLSOC;
import com.black_dog20.tucs.item.tool.ItemCobblestoneLighter;
import com.black_dog20.tucs.item.tool.ItemTLSOHD;
import com.black_dog20.tucs.item.upgrades.ItemLooting1Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemLooting2Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemLooting3Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpness1Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpness2Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpness3Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpness4Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpness5Upgrade;
import com.black_dog20.tucs.item.upgrades.ItemSoulboundUpgrade;
import com.black_dog20.tucs.reference.PageTypes;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static ToolMaterial COBBLESTONEDIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEDIUM_MATERIAL", 3, 1692, 8.0F, 10.0F, 22);
	public static ToolMaterial COBBLESTONEIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEIUM_MATERIAL", 2, 381, 6.0F, 3.0F, 15);
	public static ArmorMaterial COBBLESTONEIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("Cobblestoneium", 17 , new int[] {3,7,6,3}, 10);

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
	public static final ItemLooting1Upgrade looting1Upgrade = new ItemLooting1Upgrade();
	public static final ItemLooting2Upgrade looting2Upgrade = new ItemLooting2Upgrade();
	public static final ItemLooting3Upgrade looting3Upgrade = new ItemLooting3Upgrade();
	public static final ItemSoulboundUpgrade soulboundUpgrade = new ItemSoulboundUpgrade();
	public static final ItemSharpness1Upgrade Sharpness1Upgrade = new ItemSharpness1Upgrade();
	public static final ItemSharpness2Upgrade Sharpness2Upgrade = new ItemSharpness2Upgrade();
	public static final ItemSharpness3Upgrade Sharpness3Upgrade = new ItemSharpness3Upgrade();
	public static final ItemSharpness4Upgrade Sharpness4Upgrade = new ItemSharpness4Upgrade();
	public static final ItemSharpness5Upgrade Sharpness5Upgrade = new ItemSharpness5Upgrade();
	
	
	public static void init(){
		
		//TOOLS
		GameRegistry.registerItem(TLSOC, "TLSOC");
		GameRegistry.registerItem(TLBOTB, "TLBOTB");
		GameRegistry.registerItem(TLHOWF, "TLHOWF");
		GameRegistry.registerItem(TLSOHD, "TLSOHD");
		GameRegistry.registerItem(TLPOLM, "TLPOLM");
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
		
		
		//INGOTS
		GameRegistry.registerItem(ingotCobblestoneium, "ingotCobblestoneium");
		GameRegistry.registerItem(ingotCobblestonedium, "ingotCobblestonedium");
		GameRegistry.registerItem(ingotYellowstoneium, "ingotYellowstoneium");
		
		//ITEMS
		GameRegistry.registerItem(cobblestoneLighter, "cobblestoneLighter");
		GameRegistry.registerItem(TUCSbook, "TUCSBook");
		GameRegistry.registerItem(TUCSdebug, "TUCSdebug");
		GameRegistry.registerItem(CobbleCoal, "CobbleCoal");
		GameRegistry.registerItem(cobblestonediumLighter, "cobblestonediumLighter");
		GameRegistry.registerItem(cobblestoneiumLighter, "cobblestoneiumLighter");
		GameRegistry.registerItem(FlightTalisman, "FlightTalisman");
		GameRegistry.registerItem(torchTalisman, "torchTalisman");
		GameRegistry.registerItem(craftingTalisman, "craftingTalisman");
		
		//UPGRADES
		GameRegistry.registerItem(looting1Upgrade, "looting1Upgrade");
		GameRegistry.registerItem(looting2Upgrade, "looting2Upgrade");
		GameRegistry.registerItem(looting3Upgrade, "looting3Upgrade");
		GameRegistry.registerItem(soulboundUpgrade, "soulboundUpgrade");
		GameRegistry.registerItem(Sharpness1Upgrade, "sharpness1Upgrade");
		GameRegistry.registerItem(Sharpness2Upgrade, "sharpness2Upgrade");
		GameRegistry.registerItem(Sharpness3Upgrade, "sharpness3Upgrade");
		GameRegistry.registerItem(Sharpness4Upgrade, "sharpness4Upgrade");
		GameRegistry.registerItem(Sharpness5Upgrade, "sharpness5Upgrade");
		
		
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
