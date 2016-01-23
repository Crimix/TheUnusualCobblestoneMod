package com.black_dog20.tucs.item.armor.cobblestonedium;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.model.ScubaTank_armor;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.item.armor.IScubaAirTank;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemChestplateCobblestonedium_scuba extends ItemArmorTUCS implements IScubaAirTank {

	public ItemChestplateCobblestonedium_scuba(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() instanceof ItemChestplateCobblestonedium_scuba) {
			return Reference.MOD_ID + ":models/armor/Cobblestonedium_1_scuba.png";
		} else {
			return null;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped armorModel = null;
		if (itemStack != null) {
			armorModel = new ScubaTank_armor();
			if (armorModel != null) {
				armorModel.bipedBody.showModel = armorSlot == 1;
				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();
				return armorModel;
			}
		}
		return null;
	}

	@Override
	public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player) {

		if (player.isSneaking()) {
			tucs.Proxy.openToolUpgrade(player);
		} else {
			this.Euip(Item, world, player);
		}

		return Item;

	}

	@Override
	public boolean hasEffect(ItemStack stack) {

		if (!stack.hasTagCompound()) {
			stack.stackTagCompound = new NBTTagCompound();
		}
		if (stack.hasTagCompound()) {
			NBTTagCompound nbt = stack.getTagCompound();

			if (nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK) || nbt.hasKey("ench")) {
				return true;
			}
			if (nbt.hasKey(NBTTags.SOULBOUND_P) || nbt.hasKey("ench")) {
				return true;
			}
			if (nbt.hasKey(NBTTags.Beheading) || nbt.hasKey("ench")) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	@Override
	public double getMaxAir() {
		return MAX_AIR;
	}

	@Override
	public int getAir(ItemStack Item) {
		NBTTagCompound nbt = nbtTag(Item);
		if(nbt.hasKey("StoredAir")){
			return nbt.getInteger("StoredAir");
		}
		else{
			return 0;
		}

	}

	@Override
	public void decAir(ItemStack Item) {
		NBTTagCompound nbt = nbtTag(Item);
		nbt.setInteger("StoredAir", nbt.getInteger("StoredAir") - 1);

	}

	@Override
	public void addAir(ItemStack Item, int amount) {
		NBTTagCompound nbt = nbtTag(Item);
		if (nbt.getInteger("StoredAir") + amount > MAX_AIR) {
			nbt.setInteger("StoredAir", MAX_AIR);
		} else {
			nbt.setInteger("StoredAir", nbt.getInteger("StoredAir") + amount);
		}
	}

	@Override
	public void removeAir(ItemStack Item, int amount) {
		NBTTagCompound nbt = nbtTag(Item);
		nbt.setInteger("StoredAir", nbt.getInteger("StoredAir") - amount);
		if (nbt.getInteger("StoredAir") < 0) {
			nbt.setInteger("StoredAir", 0);
		}
	}

	@Override
	public void setAir(ItemStack Item, int amount) {
		NBTTagCompound nbt = nbtTag(Item);
		nbt.setInteger("StoredAir", amount);
	}

	@Override
	public void setMaxAir(ItemStack Item, int amount) {
		NBTTagCompound nbt = nbtTag(Item);
		if (amount == 0) {
			nbt.setInteger("MaxAir", MAX_AIR);
		} else {
			nbt.setInteger("MaxAir", amount);
		}
	}

	private NBTTagCompound nbtTag(ItemStack item) {
		if (!item.hasTagCompound()) {
			item.stackTagCompound = new NBTTagCompound();
			setMaxAir(item, 0);
			setAir(item, 0);
		}
		return item.stackTagCompound;
	}

	@Override
	public void getSubItems(Item item, CreativeTabs tab, List subItems) {
		ItemStack Airtank = new ItemStack(ModItems.chestplateCobblestonedium_scuba);
		Airtank.stackTagCompound = new NBTTagCompound();
		setMaxAir(Airtank, 0);
		setAir(Airtank, MAX_AIR);
		subItems.add(Airtank);
	}

	@Override
	public String GetEnviromentType() {
		return "Water";
	}

	@Override
	public void addInformation(ItemStack stack, EntityPlayer player, List List, boolean par) {
		List.add(EnumChatFormatting.GOLD + "Upgradeable");
	}

}
