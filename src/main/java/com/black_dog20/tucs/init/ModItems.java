package com.black_dog20.tucs.init;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.black_dog20.tucs.item.ItemBook;
import com.black_dog20.tucs.item.ItemIngotCobblestonedium;
import com.black_dog20.tucs.item.ItemIngotCobblestoneium;
import com.black_dog20.tucs.item.ItemTUCSDebug;
import com.black_dog20.tucs.item.armor.ItemBootCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemChestplateCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemHelmetCobblestoneium;
import com.black_dog20.tucs.item.armor.ItemLegCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemHatchetCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemHoeCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemPickaxeCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemShovelCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemSwordCobblestoneium;
import com.black_dog20.tucs.item.tool.ItemTLSOC;
import com.black_dog20.tucs.item.tool.ItemTool;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems {
	
	public static ToolMaterial COBBLESTONEDIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEDIUM_MATERIAL", 3, 1692, 8.0F, 10.0F, 22);
	public static ToolMaterial COBBLESTONEIUM_MATERIAL = EnumHelper.addToolMaterial("COBBLESTONEIUM_MATERIAL", 2, 381, 6.0F, 3.0F, 15);
	public static ArmorMaterial COBBLESTONEIUM_ARMORMATERIAL = EnumHelper.addArmorMaterial("Cobblestoneium", 17 , new int[] {3,7,6,3}, 10);
	public static final ItemTLSOC TLSOC = new ItemTLSOC(COBBLESTONEDIUM_MATERIAL);
	public static final ItemIngotCobblestoneium ingotCobblestoneium = new ItemIngotCobblestoneium();
	public static final ItemIngotCobblestonedium ingotCobblestonedium = new ItemIngotCobblestonedium();
	public static final ItemTool tool = new ItemTool();
	public static final ItemShovelCobblestoneium shovelCobblestoneium = new ItemShovelCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemSwordCobblestoneium swordCobblestoneium = new ItemSwordCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHatchetCobblestoneium hatchetCobblestoneium = new ItemHatchetCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHoeCobblestoneium hoeCobblestoneium = new ItemHoeCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemPickaxeCobblestoneium pickaxeCobblestoneium = new ItemPickaxeCobblestoneium(COBBLESTONEIUM_MATERIAL);
	public static final ItemHelmetCobblestoneium helmetCobblestoneium = new ItemHelmetCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 0, "helmetCobblestoneium");
	public static final ItemLegCobblestoneium leggingsCobblestoneium = new ItemLegCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 2, "leggingsCobblestoneium");
	public static final ItemBootCobblestoneium bootsCobblestoneium = new ItemBootCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 3, "bootsCobblestoneium");
	public static final ItemChestplateCobblestoneium chestplateCobblestoneium = new ItemChestplateCobblestoneium(COBBLESTONEIUM_ARMORMATERIAL, 3, "chestplateCobblestoneium");
	public static final ItemBook TUCSbook = new ItemBook();
	public static final ItemTUCSDebug TUCSdebug = new ItemTUCSDebug();
	
	public static void init(){

		
		GameRegistry.registerItem(TLSOC, "TLSOC");
		GameRegistry.registerItem(ingotCobblestoneium, "ingotCobblestoneium");
		GameRegistry.registerItem(ingotCobblestonedium, "ingotCobblestonedium");
		GameRegistry.registerItem(tool, "tool");
		GameRegistry.registerItem(shovelCobblestoneium, "shovelCobblestoneium");
		GameRegistry.registerItem(swordCobblestoneium, "swordCobblestoneium");
		GameRegistry.registerItem(hatchetCobblestoneium, "hatchetCobblestoneium");
		GameRegistry.registerItem(hoeCobblestoneium, "hoeCobblestoneium");
		GameRegistry.registerItem(pickaxeCobblestoneium, "pickaxeCobblestoneium");
		GameRegistry.registerItem(helmetCobblestoneium, "helmetCobblestoneium");
		GameRegistry.registerItem(leggingsCobblestoneium, "leggingsCobblestoneium");
		GameRegistry.registerItem(bootsCobblestoneium, "bootsCobblestoneium");
		GameRegistry.registerItem(chestplateCobblestoneium, "chestplateCobblestoneium");
		GameRegistry.registerItem(TUCSbook , "TUCSBook");
		GameRegistry.registerItem(TUCSdebug , "TUCSdebug");
	}

}
