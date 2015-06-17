package com.black_dog20.tucs.block;

import net.minecraft.block.material.Material;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;

public class BlockCobblestonedium extends BlockTUCS{

	public BlockCobblestonedium(){

		super(Material.rock);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setBlockName("blockCobblestonedium");
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeMetal);
	}
}
