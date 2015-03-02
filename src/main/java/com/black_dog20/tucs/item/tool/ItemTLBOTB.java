package com.black_dog20.tucs.item.tool;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTLBOTB extends ItemAxe{
	
public ItemTLBOTB(ToolMaterial Material){
		
		super(Material);
		this.setUnlocalizedName("TLBOTB");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setNoRepair();
		this.canRepair = false;
		
	}
@Override
public String getUnlocalizedName()
{
    return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
}

@Override
public String getUnlocalizedName(ItemStack itemStack)
{
    return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
}

@Override
@SideOnly(Side.CLIENT)
public void registerIcons(IIconRegister iconRegister)
{
	itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "hatchetTLBOTB");
}

protected String getUnwrappedUnlocalizedName(String unlocalizedName)
{
    return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
}


@Override
public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
	
		if(player.isSneaking()){
			tucs.Proxy.openToolUpgrade(player);
		}
	
	return Item;

}

@Override
public boolean hasEffect(ItemStack stack){
	
	if(!stack.hasTagCompound()){
		stack.stackTagCompound = new NBTTagCompound();
	}
	if(stack.hasTagCompound()){
		NBTTagCompound nbt= stack.getTagCompound();
		
		if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK) || nbt.hasKey("ench")){
			return true;
		}
		if(nbt.hasKey(NBTTags.SOULBOUND_P) || nbt.hasKey("ench")){
			return true;
		}
		if(nbt.hasKey(NBTTags.Beheading) || nbt.hasKey("ench")){
			return true;
		}
		else{
			return false;
		}
	}
	return false;
}
}


