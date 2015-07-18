package com.black_dog20.tucs.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.container.ContainerHoverBike;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHoverBike extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation("minecraft:textures/gui/container/crafting_table.png");

	public GuiHoverBike(EntityPlayer player, World world, int x, int y, int z, Entity entity) {
		super(new ContainerHoverBike(player, world, x, y, z, entity));

		this.xSize = 175;
		this.ySize = 165;

	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {

		this.fontRendererObj.drawString(StatCollector.translateToLocal("Ancient Table"), 28, 6, 4210752);
		this.fontRendererObj.drawString(StatCollector.translateToLocal("Inventory"), 8, this.ySize - 96 + 2, 4210752);


	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	}

}

