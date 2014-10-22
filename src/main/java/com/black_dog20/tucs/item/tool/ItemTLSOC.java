package com.black_dog20.tucs.item.tool;

import java.util.List;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemTLSOC extends ItemSword {
	
	public ItemTLSOC(ToolMaterial Material){
		
		super(Material);
		this.setUnlocalizedName("TLSOC");
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
    	itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "swordTLSOC");
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
    
    @Override
	public void addInformation(ItemStack stack, EntityPlayer player, List list, boolean par4)
	{
    	/*
		
		list.add("Shift right click to upgrade");
		list.add("");
		if(!stack.hasTagCompound()){
			stack.stackTagCompound = new NBTTagCompound();
		}
		if(stack.hasTagCompound()){
			NBTTagCompound nbt= stack.getTagCompound();
			
			if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK)){
				list.add("Soulbound");
			}
			else{
				list.remove("Soulbound");
			}
		}*/
	}
	
	
	@Override
	 public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){
		
		if(player.isSneaking()){
				player.openGui(tucs.instance, tucs.guiIDUpgradeTools, world, (int)player.posX, (int)player.posY, (int)player.posZ);
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
			
			if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK)){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	
}
