package com.black_dog20.tucs.utility;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.oredict.OreDictionary;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.upgrades.ItemTUCSUpgrades;
import com.black_dog20.tucs.reference.NBTTags;

public class EnchantHelper {
	
	public static void setEnchant(ItemStack ContainerItem, ItemStack UpgradeItem, NBTTagCompound NBT){
		if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.soulboundUpgrade,1))){
			NBT.setString(NBTTags.SOULBOUND, NBTTags.OK);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting1Upgrade,1))){
			if(ContainerItem.areItemStackTagsEqual(ContainerItem, new ItemStack(ModItems.TLSOC,1,OreDictionary.WILDCARD_VALUE))){
				ContainerItem.addEnchantment(Enchantment.looting, 1);
			}
			else{
				ContainerItem.addEnchantment(Enchantment.fortune, 1);
			}
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting2Upgrade,1))){
			if(ContainerItem.areItemStackTagsEqual(ContainerItem, new ItemStack(ModItems.TLSOC,1,OreDictionary.WILDCARD_VALUE))){
				ContainerItem.addEnchantment(Enchantment.looting, 2);
			}
			else{
				ContainerItem.addEnchantment(Enchantment.fortune, 2);
			}
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.looting3Upgrade,1))){
			if(ContainerItem.areItemStackTagsEqual(ContainerItem, new ItemStack(ModItems.TLSOC,1,OreDictionary.WILDCARD_VALUE))){
				ContainerItem.addEnchantment(Enchantment.looting, 3);
			}
			else{
				ContainerItem.addEnchantment(Enchantment.fortune, 3);
			}
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.Sharpness1Upgrade,1)) && Enchantment.sharpness.canApply(ContainerItem)){				
			ContainerItem.addEnchantment(Enchantment.sharpness, 1);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.Sharpness2Upgrade,1)) && Enchantment.sharpness.canApply(ContainerItem)){				
			ContainerItem.addEnchantment(Enchantment.sharpness, 2);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.Sharpness3Upgrade,1)) && Enchantment.sharpness.canApply(ContainerItem)){				
			ContainerItem.addEnchantment(Enchantment.sharpness, 3);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.Sharpness4Upgrade,1)) && Enchantment.sharpness.canApply(ContainerItem)){				
			ContainerItem.addEnchantment(Enchantment.sharpness, 4);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.Sharpness5Upgrade,1)) && Enchantment.sharpness.canApply(ContainerItem)){				
			ContainerItem.addEnchantment(Enchantment.sharpness, 5);
		}
		else if(ContainerItem.areItemStacksEqual(UpgradeItem, new ItemStack(ModItems.Sliktouch1Upgrade,1)) && Enchantment.silkTouch.canApply(ContainerItem)){				
			ContainerItem.addEnchantment(Enchantment.silkTouch, 1);
		}
		
	}
	
	public static boolean checkItem(ItemStack itemstack){
		
		if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.soulboundUpgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.looting1Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.looting2Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.looting3Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.Sharpness1Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.Sharpness2Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.Sharpness3Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.Sharpness4Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.Sharpness5Upgrade,1))){
			return true;
		}
		else if(itemstack.areItemStacksEqual(itemstack, new ItemStack(ModItems.Sliktouch1Upgrade,1))){
			return true;
		}
		else{
			return false;
		}
		
	}

}
