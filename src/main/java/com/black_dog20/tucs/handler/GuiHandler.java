package com.black_dog20.tucs.handler;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiAncientForge;
import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.client.gui.GuiFlightTalisman;
import com.black_dog20.tucs.client.gui.GuiTUCSBook;
import com.black_dog20.tucs.client.gui.GuiUpgradeTools;
import com.black_dog20.tucs.container.ContainerAncientForge;
import com.black_dog20.tucs.container.ContainerAncientTable;
import com.black_dog20.tucs.container.ContainerCraftingTalisman;
import com.black_dog20.tucs.container.ContainerDummy;
import com.black_dog20.tucs.container.ContainerFlightTalisman;
import com.black_dog20.tucs.container.ContainerUpgradeTools;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.ContainerFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,	int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		ItemStack item = player.getHeldItem();

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
		if(ID == tucs.guiIDFlightTalisman){
			return new ContainerFlightTalisman(world, x, y, z, player, item);
		}
		if(ID == tucs.guiIDCraftingTalisman){
			return new ContainerCraftingTalisman(player.inventory, world, x, y, z, player);
		}
		if(ID == tucs.guiIDUpgradeTools){
			return new ContainerUpgradeTools(world, x, y, z, player, item);
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
		if(ID == tucs.guiIDFlightTalisman){
			return new GuiFlightTalisman(world, x, y, z, player);
		}
		if(ID == tucs.guiIDCraftingTalisman){
			return new GuiAncientTable(player.inventory, world, x, y, z, player);
		}
		if(ID == tucs.guiIDUpgradeTools){
			return new GuiUpgradeTools(world, x, y, z, player);
		}

		return null;
	}

}