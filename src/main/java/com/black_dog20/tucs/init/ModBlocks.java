package com.black_dog20.tucs.init;


import com.black_dog20.tucs.block.BlockAncientForge;
import com.black_dog20.tucs.block.BlockAncientTable;
import com.black_dog20.tucs.block.BlockCobblestonedium;
import com.black_dog20.tucs.block.BlockCobblestoneium;
import com.black_dog20.tucs.block.BlockOreCobblestoneium;
import com.black_dog20.tucs.block.BlockSoulbind;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.reference.Reference;

import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks {

	public static final BlockAncientTable ancientTable = new BlockAncientTable();
	public static final BlockOreCobblestoneium oreCobblestoneium = new BlockOreCobblestoneium();
	public static final BlockCobblestoneium blockCobblestoneium = new BlockCobblestoneium();
	public static final BlockCobblestonedium blockCobblestonedium = new BlockCobblestonedium();
	public static final BlockAncientForge blockAncientForge = (BlockAncientForge) new BlockAncientForge(false).setCreativeTab(CreativeTabTUCS.TUCS_TAB);
	public static final BlockAncientForge blockAncientForge_lit = new BlockAncientForge(true);
	public static final BlockSoulbind blockSoulbind = new BlockSoulbind();

	public static void init()
	{
		GameRegistry.registerBlock(ancientTable, "ancientTable");
		GameRegistry.registerBlock(oreCobblestoneium, "oreCobblestoneium");
		GameRegistry.registerBlock(blockCobblestoneium, "blocCobblestoneium");
		GameRegistry.registerBlock(blockCobblestonedium, "blocCobblestonedium");
		GameRegistry.registerBlock(blockAncientForge, "blockAncientForge");
		GameRegistry.registerBlock(blockAncientForge_lit, "blockAncientForge_lit");
		GameRegistry.registerBlock(blockSoulbind, "blockSoulbindt");

	}
}
