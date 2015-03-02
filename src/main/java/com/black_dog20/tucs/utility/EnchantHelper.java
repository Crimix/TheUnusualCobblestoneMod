package com.black_dog20.tucs.utility;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.upgrades.ItemBeheadingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemInfiArrowUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemLootingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSharpnessUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSliktouchUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSoulboundUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemTUCSUpgrades;
import com.black_dog20.tucs.reference.NBTTags;

public class EnchantHelper {
	
	public static void setEnchant(ItemStack ContainerItem, ItemStack UpgradeItem, NBTTagCompound NBT){
		if(UpgradeItem.getItem() instanceof ItemSoulboundUpgrade){
			NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
		}
		else if(UpgradeItem.getItem() instanceof ItemLootingUpgrade){
			String s = UpgradeItem.getUnlocalizedName();
			int lvl = Integer.parseInt(s.replaceAll("[\\D]", ""));
			if(Enchantment.looting.canApplyAtEnchantingTable(ContainerItem)){
				ContainerItem.addEnchantment(Enchantment.looting, lvl);
			}
			else{
				ContainerItem.addEnchantment(Enchantment.fortune, lvl);
			}
		}
		else if(UpgradeItem.getItem() instanceof ItemSharpnessUpgrade && Enchantment.sharpness.canApplyAtEnchantingTable(ContainerItem)){
			String s = UpgradeItem.getUnlocalizedName();
			int lvl = Integer.parseInt(s.replaceAll("[\\D]", ""));
			ContainerItem.addEnchantment(Enchantment.sharpness, lvl);
		}
		else if(UpgradeItem.getItem() instanceof ItemSliktouchUpgrade && Enchantment.silkTouch.canApplyAtEnchantingTable(ContainerItem)){
			String s = UpgradeItem.getUnlocalizedName();
			int lvl = Integer.parseInt(s.replaceAll("[\\D]", ""));
			ContainerItem.addEnchantment(Enchantment.silkTouch, lvl);
		}
		else if(UpgradeItem.getItem() instanceof ItemBeheadingUpgrade){
			NBT.setBoolean(NBTTags.Beheading, true);
		}
		else if(UpgradeItem.getItem() instanceof ItemInfiArrowUpgrade){
			NBT.setBoolean(NBTTags.NoArrow, true);
		}
		
	}
	
	public static boolean checkItem(ItemStack itemstack){
		
		Item item = itemstack.getItem();
		
		if(item instanceof ItemSoulboundUpgrade){
			return true;
		}
		else if(item instanceof ItemLootingUpgrade){
			return true;
		}
		else if(item instanceof ItemSharpnessUpgrade){
			return true;
		}
		else if(item instanceof ItemSliktouchUpgrade){
			return true;
		}
		else if(item instanceof ItemBeheadingUpgrade){
			return true;
		}
		else if(item instanceof ItemInfiArrowUpgrade){
			return true;
		}
		else{
			return false;
		}
		
		
	}

}
