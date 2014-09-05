package com.black_dog20.tucs.handler;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.container.ContainerAncientTable;
import com.black_dog20.tucs.init.ModBlocks;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(ID == tucs.guiIDAncientTable) {
			return ID == tucs.guiIDAncientTable && world.getBlock(x, y, z) == ModBlocks.ancientTable ? new ContainerAncientTable(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(ID == tucs.guiIDAncientTable) {
			return ID == tucs.guiIDAncientTable && world.getBlock(x, y, z) == ModBlocks.ancientTable ? new GuiAncientTable(player.inventory, world, x, y, z) : null;
		}

		return null;
	}

}