package com.black_dog20.tucs.item.tool;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.handler.ConfigurationHandler;
import com.black_dog20.tucs.item.ItemTUCS;

public class ItemCobblestoneLighter extends ItemTUCS {

	public ItemCobblestoneLighter(){
		super();
		this.setUnlocalizedName("cobblestoneLighter");
		this.setMaxDamage(128);
		this.setNoRepair();
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	}
	@Override
	public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
	{
		return false;
	}

	@Override
	public boolean getShareTag()
	{
		return true;
	}

	public boolean hasContainerItem(ItemStack itemStack)
	{
		return true;
	}
	@Override
	public ItemStack getContainerItem(ItemStack itemStack)
	{
		ItemStack stack = itemStack.copy();

		stack.setItemDamage(stack.getItemDamage() + 1);
		stack.stackSize = 1;

		return stack;
	}

	public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_)
	{
		if(ConfigurationHandler.ToolFire == true){
			if (p_77648_7_ == 0)
			{
				--p_77648_5_;
			}

			if (p_77648_7_ == 1)
			{
				++p_77648_5_;
			}

			if (p_77648_7_ == 2)
			{
				--p_77648_6_;
			}

			if (p_77648_7_ == 3)
			{
				++p_77648_6_;
			}

			if (p_77648_7_ == 4)
			{
				--p_77648_4_;
			}

			if (p_77648_7_ == 5)
			{
				++p_77648_4_;
			}

			if (!p_77648_2_.canPlayerEdit(p_77648_4_, p_77648_5_, p_77648_6_, p_77648_7_, p_77648_1_))
			{
				return false;
			}
			else
			{
				if (p_77648_3_.isAirBlock(p_77648_4_, p_77648_5_, p_77648_6_))
				{
					p_77648_3_.playSoundEffect((double)p_77648_4_ + 0.5D, (double)p_77648_5_ + 0.5D, (double)p_77648_6_ + 0.5D, "fire.ignite", 1.0F, itemRand.nextFloat() * 0.4F + 0.8F);
					p_77648_3_.setBlock(p_77648_4_, p_77648_5_, p_77648_6_, Blocks.fire);
				}

				p_77648_1_.damageItem(1, p_77648_2_);
				return true;
			}
		}
		return false;
	}
}
