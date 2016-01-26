package com.black_dog20.tucs.item.armor.cobblestonedium;

import java.util.List;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.model.ScubaMask_armor;
import com.black_dog20.tucs.client.model.ScubaMaskeV2;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.item.ItemArmorTUCS;
import com.black_dog20.tucs.item.ItemUpgradableArmorTUCS;
import com.black_dog20.tucs.item.armor.IScubaMask;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemHelmetCobblestonedium_Scuba_v2 extends ItemUpgradableArmorTUCS implements IScubaMask {

	public ItemHelmetCobblestonedium_Scuba_v2(ArmorMaterial Material, int armortype, String Name) {
		super(Material, 2, armortype);
		this.setUnlocalizedName(Name);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
		if (stack.getItem() instanceof ItemHelmetCobblestonedium_Scuba_v2) {
			return Reference.MOD_ID + ":models/armor/scuba_1_v2.png";
		} else {
			return null;
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, int armorSlot) {
		ModelBiped armorModel = null;
		if (itemStack != null) {
			armorModel = new ScubaMaskeV2();
			if (armorModel != null) {
				armorModel.bipedHead.showModel = armorSlot == 0;
				armorModel.isSneak = entityLiving.isSneaking();
				armorModel.isRiding = entityLiving.isRiding();
				armorModel.isChild = entityLiving.isChild();
				return armorModel;
			}
		}
		return null;
	}


	@Override
	public String GetEnviromentType() {
		return "Effects";
	}

	@Override
	public void doSpeciel(EntityPlayer player) {
		player.clearActivePotions();
	}

}
