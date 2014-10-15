package com.black_dog20.tucs.item.tool;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTLPOLM extends ItemPickaxe {
	
public ItemTLPOLM(ToolMaterial Material){
		
		super(Material);
		this.setUnlocalizedName("TLPOLM");
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
	itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "pickaxeTLPOLM");
}

protected String getUnwrappedUnlocalizedName(String unlocalizedName)
{
    return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
}

}
