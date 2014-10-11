package com.black_dog20.tucs.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.creativetab.CreativeTabTUCSPages;
import com.black_dog20.tucs.reference.PageTypes;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTUCSPageDebug extends ItemTUCS{
	public ItemTUCSPageDebug(){
		super();
		this.setUnlocalizedName("TUCSDebug");
		this.setCreativeTab(CreativeTabTUCSPages.TUCSPages_TAB);
}
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		NBTTagCompound nbt = NBTHelper.getPlayerNBT(player);
		nbt.removeTag(PageTypes.FLAME);
		return Item;
		
	    }
	
	@Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister)
    {
        itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":page");
    }
}
