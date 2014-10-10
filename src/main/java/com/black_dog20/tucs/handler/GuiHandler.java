package com.black_dog20.tucs.handler;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiAncientForge;
import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.client.gui.GuiTUCSBook;
import com.black_dog20.tucs.container.ContainerAncientForge;
import com.black_dog20.tucs.container.ContainerAncientTable;
import com.black_dog20.tucs.container.ContainerDummy;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case tucs.guiIDAncientForge:
				if (entity instanceof TileEntityAncientForge) {
					return new ContainerAncientForge(player.inventory, (TileEntityAncientForge) entity);
				}
				return null;
			}
		}

		if(ID == tucs.guiIDAncientTable) {
			return ID == tucs.guiIDAncientTable && world.getBlock(x, y, z) == ModBlocks.ancientTable ? new ContainerAncientTable(player.inventory, world, x, y, z, player) : null;
		}
		if(ID == tucs.guiIDBook){
			return new ContainerDummy(player);
		}

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if(entity != null) {
			switch(ID) {
			case tucs.guiIDAncientForge:
				if (entity instanceof TileEntityAncientForge) {
					return new GuiAncientForge(player.inventory, (TileEntityAncientForge) entity);
				}
				return null;
			}
		}

		if(ID == tucs.guiIDAncientTable) {
			return ID == tucs.guiIDAncientTable && world.getBlock(x, y, z) == ModBlocks.ancientTable ? new GuiAncientTable(player.inventory, world, x, y, z, player) : null;
		}
		
		if(ID == tucs.guiIDBook){
			
			return new  GuiTUCSBook(player);
		}

		return null;
	}

}