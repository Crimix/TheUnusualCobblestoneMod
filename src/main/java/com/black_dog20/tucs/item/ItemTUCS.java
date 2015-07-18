package com.black_dog20.tucs.item;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.render.IOverlayItem;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTUCS extends Item implements ITucsItem, IOverlayItem{
	
	public ItemTUCS(){
		
		super();
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.registerItemForOverlay();
		
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
    
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack item, EntityPlayer player, List list, boolean bool, String text)
    {
        super.addInformation(item, player, list, bool);
        list.add(text);
    }

	@Override
	public void registerItemForOverlay() {
		tucs.overlayList.add(this);
	}
    
    

}
