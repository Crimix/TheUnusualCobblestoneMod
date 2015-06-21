package com.black_dog20.tucs.item.armor;

import java.util.List;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.reference.Reference;

public class ItemAirTank extends ItemArmorTUCS implements IScubaAirTank {

	public ItemAirTank(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setNoRepair();
		this.setMaxDamage(-1);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if(stack.getItem() instanceof ItemAirTank)
		{
			return Reference.MOD_ID + ":models/armor/scuba_1.png";
		}
		else
		{
			return null;
		}
	}

	@Override
	public double getMaxAir() {
		return MAX_AIR;
	}
	
	@Override
	public int getAir(ItemStack Item){
		
		if(Item.hasTagCompound()){
			NBTTagCompound nbt= Item.getTagCompound();
			
			return nbt.getInteger("StoredAir");
		}
		return 0;

	}
	
	@Override
	public void decAir(ItemStack Item){
		
		if(Item.hasTagCompound()){
			NBTTagCompound nbt= Item.getTagCompound();
			
			nbt.setInteger("StoredAir",nbt.getInteger("StoredAir")-1);
		}
	}

	@Override
	public void addAir(ItemStack Item, int amount) {
		if(Item.hasTagCompound()){
			NBTTagCompound nbt= Item.getTagCompound();
			
			if(nbt.getInteger("StoredAir")+amount > MAX_AIR){
				nbt.setInteger("StoredAir",MAX_AIR);
			}else{
				nbt.setInteger("StoredAir",nbt.getInteger("StoredAir")+amount);
			}
		}
	}

	@Override
	public void removeAir(ItemStack Item, int amount) {
		if(Item.hasTagCompound()){
			NBTTagCompound nbt= Item.getTagCompound();
			
			nbt.setInteger("StoredAir",nbt.getInteger("StoredAir")-amount);
			if(nbt.getInteger("StoredAir")<0){
				nbt.setInteger("StoredAir",0);
			}
		}
	}

	@Override
	public void setAir(ItemStack Item, int amount) {
		if(Item.hasTagCompound()){
			NBTTagCompound nbt= Item.getTagCompound();
			
			nbt.setInteger("StoredAir",amount);
		}
	}

	@Override
	public void setMaxAir(ItemStack Item, int amount) {
		if(Item.hasTagCompound()){
			NBTTagCompound nbt= Item.getTagCompound();
			if(amount == 0){
				nbt.setInteger("MaxAir",MAX_AIR);
			}
			else{
				nbt.setInteger("MaxAir",amount);
			}
		}
	}
	
	@Override
	public void onCreated(ItemStack Item, World world, EntityPlayer player) {
		if(!Item.hasTagCompound()){
			Item.stackTagCompound = new NBTTagCompound();
			setMaxAir(Item, 0);
			setAir(Item, 0);
		}
	}

	
	
	@Override
	public void getSubItems(Item item, CreativeTabs tab, List subItems){
		ItemStack Airtank = new ItemStack(ModItems.AirTank);
		Airtank.stackTagCompound = new NBTTagCompound();
		setMaxAir(Airtank, 0);
		setAir(Airtank, MAX_AIR);
		subItems.add(Airtank);
	}
	
}