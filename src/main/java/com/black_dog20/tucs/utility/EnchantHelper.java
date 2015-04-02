package com.black_dog20.tucs.utility;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import com.black_dog20.tucs.item.upgrades.ItemAutoBowUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemBeheadingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemInfiArrowUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemLootingUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemSoulboundUpgrade;
import com.black_dog20.tucs.item.upgrades.ItemTUCSUpgrades;
import com.black_dog20.tucs.reference.NBTTags;

public class EnchantHelper {
	
	public static void setEnchant(ItemStack ContainerItem, ItemStack UpgradeItem, NBTTagCompound NBT){
		ItemTUCSUpgrades item = (ItemTUCSUpgrades) UpgradeItem.getItem();
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
		else if(UpgradeItem.getItem() instanceof ItemBeheadingUpgrade){
			NBT.setBoolean(NBTTags.Beheading, true);
		}
		else if(UpgradeItem.getItem() instanceof ItemInfiArrowUpgrade){
			NBT.setBoolean(NBTTags.NoArrow, true);
		}
		else if(UpgradeItem.getItem() instanceof ItemAutoBowUpgrade){
			NBT.setBoolean(NBTTags.MachineBow, true);
		}else{
			Enchantment enchant = item.getEnchantment();
			String s = UpgradeItem.getUnlocalizedName();
			int lvl = Integer.parseInt(s.replaceAll("[\\D]", ""));
			if(enchant.canApplyAtEnchantingTable(ContainerItem)){
				ContainerItem.addEnchantment(enchant, lvl);
			}
		}
		
	}
	
	public static boolean checkItem(ItemStack itemstack){
		
		Item item = itemstack.getItem();
		
		if(item instanceof ItemTUCSUpgrades){
			return true;
		}
		else{
			return false;
		}
		
		
	}

}
