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

public class ItemArmorTUCS extends ItemArmor {
	
	 public final static int render = 0;
	 public final static ArmorMaterial material = null;
	
	public ItemArmorTUCS(ArmorMaterial material, int render, int armorType){
		
		super(material, render, armorType);
		
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		
	}
	
	 public ItemStack euip(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
	    {
	        int i = EntityLiving.getArmorPosition(p_77659_1_) - 1;
	        ItemStack itemstack1 = p_77659_3_.getCurrentArmor(i);

	        if (itemstack1 == null)
	        {
	            p_77659_3_.setCurrentItemOrArmor(i + 1, p_77659_1_.copy());
	            p_77659_1_.stackSize = 0;
	        }

	        return p_77659_1_;
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
