package com.black_dog20.tucs.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.gui.GuiAirMaker;
import com.black_dog20.tucs.client.gui.GuiAncientForge;
import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.client.gui.GuiFlightTalisman;
import com.black_dog20.tucs.client.gui.GuiHoverBike;
import com.black_dog20.tucs.client.gui.GuiSoulForge;
import com.black_dog20.tucs.client.gui.GuiTUCSBook;
import com.black_dog20.tucs.client.gui.GuiUpgradeTools;
import com.black_dog20.tucs.container.ContainerAirMaker;
import com.black_dog20.tucs.container.ContainerAncientForge;
import com.black_dog20.tucs.container.ContainerAncientTable;
import com.black_dog20.tucs.container.ContainerCraftingTalisman;
import com.black_dog20.tucs.container.ContainerDummy;
import com.black_dog20.tucs.container.ContainerFlightTalisman;
import com.black_dog20.tucs.container.ContainerHoverBike;
import com.black_dog20.tucs.container.ContainerSoulForge;
import com.black_dog20.tucs.container.ContainerUpgradeTools;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.tileEntity.TileEntityAirMaker;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;
import com.black_dog20.tucs.tileEntity.TileEntitySoulForge;
import com.black_dog20.tucs.utility.NBTHelper;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);
		ItemStack item = player.getHeldItem();

		if (entity != null) {
			switch (ID) {
			case tucs.guiIDAncientForge:
				if (entity instanceof TileEntityAncientForge) {
					return new ContainerAncientForge(player.inventory, (TileEntityAncientForge) entity);
				}
				return null;
			}
		}

		if (ID == tucs.guiIDAncientTable) {
			return ID == tucs.guiIDAncientTable && world.getBlock(x, y, z) == ModBlocks.ancientTable ? new ContainerAncientTable(player.inventory, world, x, y, z, player) : null;
		} else if (ID == tucs.guiIDBook) {
			return new ContainerDummy(player);
		} else if (ID == tucs.guiIDFlightTalisman) {
			return new ContainerFlightTalisman(world, x, y, z, player, item);
		} else if (ID == tucs.guiIDFlightTalisman) {
			return new ContainerFlightTalisman(world, x, y, z, player, item);
		} else if (ID == tucs.guiIDCraftingTalisman) {
			return new ContainerCraftingTalisman(player.inventory, world, x, y, z, player);
		} else if (ID == tucs.guiIDUpgradeTools) {
			return new ContainerUpgradeTools(world, x, y, z, player, item);
		} else if (ID == tucs.guiSoulBinder) {
			if (entity != null) {
				if (entity instanceof TileEntitySoulForge) {
					return new ContainerSoulForge(player.inventory, (TileEntitySoulForge) entity);
				}
			}
		} else if (ID == tucs.guiAirMaker) {
			if (entity != null) {
				if (entity instanceof TileEntityAirMaker) {
					return new ContainerAirMaker(player.inventory, (TileEntityAirMaker) entity);
				}
			}
		} else if (ID == tucs.guiHoverBike) {
			return new ContainerHoverBike(player, world, x, y, z, world.getEntityByID(NBTHelper.getPlayerNBT(player).getInteger("TucsHoverBikeId")));
		}
		return null;
	}

	@Override public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity entity = world.getTileEntity(x, y, z);

		if (entity != null) {
			switch (ID) {
			case tucs.guiIDAncientForge:
				if (entity instanceof TileEntityAncientForge) {
					return new GuiAncientForge(player.inventory, (TileEntityAncientForge) entity);
				}
				return null;
			}
		}

		if (ID == tucs.guiIDAncientTable) {
			return ID == tucs.guiIDAncientTable && world.getBlock(x, y, z) == ModBlocks.ancientTable ? new GuiAncientTable(player.inventory, world, x, y, z, player) : null;
		}

		else if (ID == tucs.guiIDBook) {

			return new GuiTUCSBook(player);
		} else if (ID == tucs.guiIDFlightTalisman) {
			return new GuiFlightTalisman(world, x, y, z, player);
		} else if (ID == tucs.guiIDCraftingTalisman) {
			return new GuiAncientTable(player.inventory, world, x, y, z, player);
		} else if (ID == tucs.guiIDUpgradeTools) {
			return new GuiUpgradeTools(world, x, y, z, player);
		} else if (ID == tucs.guiSoulBinder) {
			if (entity != null) {
				if (entity instanceof TileEntitySoulForge) {
					return new GuiSoulForge(player.inventory, (TileEntitySoulForge) entity);
				}
			}
		} else if (ID == tucs.guiAirMaker) {
			if (entity != null) {
				if (entity instanceof TileEntityAirMaker) {
					return new GuiAirMaker(player.inventory, (TileEntityAirMaker) entity);
				}
			}
		} else if (ID == tucs.guiHoverBike) {
			return new GuiHoverBike(player, world, x, y, z, world.getEntityByID(NBTHelper.getPlayerNBT(player).getInteger("TucsHoverBikeId")));
		}

		return null;
	}

}