package com.black_dog20.tucs.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.container.ContainerFlightTalisman;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiFlightTalisman extends GuiContainer {

	private ResourceLocation texture = new ResourceLocation(
			"tucs:textures/gui/upgradeGuiTalisman.png");

	public GuiFlightTalisman(World world, int x, int y, int z,
			EntityPlayer player) {
		super(new ContainerFlightTalisman(world, x, y, z, player,
				player.getHeldItem()));

		this.xSize = 175;
		this.ySize = 165;

	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float var1, int var2,
			int var3) {

		GL11.glColor4f(1F, 1F, 1F, 1F);

		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);

	}
}
