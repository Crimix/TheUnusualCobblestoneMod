package com.black_dog20.tucs.block;

import net.minecraft.block.material.Material;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;

public class BlockCobblestoneium extends BlockTUCS {

	public BlockCobblestoneium(){

		super(Material.iron);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setBlockName("blockCobblestoneium");
		this.setHardness(5.0F);
		this.setHarvestLevel("pickaxe", 1);
		this.setStepSound(soundTypeMetal);
	}
}
