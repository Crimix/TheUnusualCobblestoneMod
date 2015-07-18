package com.black_dog20.tucs.item.upgrades;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.render.IOverlayItem;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.item.ITucsItem;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTUCSUpgrades extends Item implements ITucsItem, IOverlayItem{
	
	public ItemTUCSUpgrades(){
		
		super();
		this.setCreativeTab(CreativeTabTUCS.TUCS_UPGRADETAB);
		registerItemForOverlay();
		
	}
	
	public Enchantment getEnchantment(){
		return null;
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
        itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().replaceAll("[0-9]", "").substring(this.getUnlocalizedName().indexOf(".") + 1));
    }

    protected String getUnwrappedUnlocalizedName(String unlocalizedName)
    {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }

	@Override
	public void registerItemForOverlay() {
		tucs.overlayList.add(this);
	}
    
    
}
