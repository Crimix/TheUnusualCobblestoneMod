package com.black_dog20.tucs.item;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemArmorTUCS extends ItemArmor implements ITucsItem{
	
	 public final static int render = 0;
	 public final static ArmorMaterial material = null;
	
	public ItemArmorTUCS(ArmorMaterial material, int render, int armorType){
		
		super(material, render, armorType);
		
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		
	}
	
	 public ItemStack Euip(ItemStack itemStack, World world, EntityPlayer player)
	    {
	        int i = EntityLiving.getArmorPosition(itemStack) - 1;
	        ItemStack itemstack1 = player.getCurrentArmor(i);

	        if (itemstack1 == null)
	        {
	            player.setCurrentItemOrArmor(i + 1, itemStack.copy());
	            itemStack.stackSize = 0;
	        }

	        return itemStack;
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
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

}
