package com.black_dog20.tucs.client.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.container.ContainerAncientForge;
import com.black_dog20.tucs.tileEntity.TileEntityAncientForge;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiAncientForge extends GuiContainer {
	private static final ResourceLocation furnaceGuiTextures = new ResourceLocation(
			"textures/gui/container/furnace.png");
	private TileEntityAncientForge tileForge;

	public GuiAncientForge(InventoryPlayer IPlayer,
			TileEntityAncientForge tileEntity) {
		super(new ContainerAncientForge(IPlayer, tileEntity));
		this.tileForge = tileEntity;
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_,
			int p_146979_2_) {
		String s = this.tileForge.hasCustomInventoryName() ? this.tileForge
				.getInventoryName() : I18n.format(
				this.tileForge.getInventoryName(), new Object[0]);
		this.fontRendererObj.drawString(s, this.xSize / 2
				- this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		this.fontRendererObj.drawString(
				I18n.format("Inventory", new Object[0]), 8,
				this.ySize - 96 + 2, 4210752);
	}

	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(furnaceGuiTextures);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);

		if (this.tileForge.isBurning()) {
			int i1 = this.tileForge.getBurnTimeRemainingScaled(13);
			this.drawTexturedModalRect(k + 56, l + 36 + 12 - i1, 176, 12 - i1,
					14, i1 + 1);
			i1 = this.tileForge.getCookProgressScaled(24);
			this.drawTexturedModalRect(k + 79, l + 34, 176, 14, i1 + 1, 16);
		}
	}
}