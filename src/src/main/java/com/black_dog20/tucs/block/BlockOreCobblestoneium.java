package com.black_dog20.tucs.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockOreCobblestoneium extends BlockTUCS {

	public BlockOreCobblestoneium(){

		super(Material.rock);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setBlockName("oreCobblestoneium");
		this.setHardness(3.0F);
		this.setHarvestLevel("pickaxe", 2);
		this.setStepSound(soundTypeStone);
	}
}
