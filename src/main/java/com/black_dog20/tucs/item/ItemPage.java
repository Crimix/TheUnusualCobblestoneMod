package com.black_dog20.tucs.item;

import java.util.List;
import java.util.Random;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.creativetab.CreativeTabTUCSPages;
import com.black_dog20.tucs.reference.PageTypes;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.world.World;

public class ItemPage extends ItemTUCS {
	
	private NBTTagCompound nbt;
	private String type;

	public ItemPage(String type){
		super();
		this.type=type;
		this.setUnlocalizedName("page");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabTUCSPages.TUCSPages_TAB);
	    
	}
	
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		
		nbt = player.getEntityData();
		nbt.setBoolean(type, true);
		--Item.stackSize;
	
		return Item;
	    }
	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
		if(type !=null){
			list.add(type);
		}
	}

}
