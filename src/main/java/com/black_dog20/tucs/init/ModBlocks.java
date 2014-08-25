package com.black_dog20.tucs.init;


import net.minecraft.tileentity.TileEntity;

import com.black_dog20.tucs.block.BlockAncientTable;
import com.black_dog20.tucs.block.BlockCobblestonedium;
import com.black_dog20.tucs.block.BlockCobblestoneium;
import com.black_dog20.tucs.block.BlockOreCobblestoneium;
import com.black_dog20.tucs.block.BlockTUCS;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final BlockAncientTable ancientTable = new BlockAncientTable();
	public static final BlockOreCobblestoneium oreCobblestoneium = new BlockOreCobblestoneium();
	public static final BlockCobblestoneium blockCobblestoneium = new BlockCobblestoneium();
	public static final BlockCobblestonedium blockCobblestonedium = new BlockCobblestonedium();

	public static void init()
	{
		GameRegistry.registerBlock(ancientTable, "ancientTable");
		GameRegistry.registerBlock(oreCobblestoneium, "oreCobblestoneium");
		GameRegistry.registerBlock(blockCobblestoneium, "blocCobblestoneium");
		GameRegistry.registerBlock(blockCobblestonedium, "blocCobblestonedium");

	}
}
