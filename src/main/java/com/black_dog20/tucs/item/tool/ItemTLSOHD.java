package com.black_dog20.tucs.item.tool;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Item.ToolMaterial;

public class ItemTLSOHD extends ItemSpade{
	
public ItemTLSOHD(ToolMaterial Material){
		
		super(Material);
		this.setUnlocalizedName("TLSOHD");
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
	itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "shovelTLSOHD");
}

protected String getUnwrappedUnlocalizedName(String unlocalizedName)
{
    return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
}

}
