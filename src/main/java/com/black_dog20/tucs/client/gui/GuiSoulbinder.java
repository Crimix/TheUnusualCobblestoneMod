package com.black_dog20.tucs.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.container.ContainerSoulbinder;
import com.black_dog20.tucs.tileEntity.TileEntitySoulForge;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

	@SideOnly(Side.CLIENT)
	public class GuiSoulbinder extends GuiContainer {

		private static final ResourceLocation texture = new ResourceLocation("tucs:textures/gui/upgradeGuiTalisman.png");
		
	    public GuiSoulbinder(InventoryPlayer IPlayer, TileEntitySoulForge tileEntity)
	    {
	        super(new ContainerSoulbinder(IPlayer, tileEntity));
	    }
		
		protected void drawGuiContainerForegroundLayer(int i, int j) {

			
		}
		
		@Override
		protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {

			GL11.glColor4f(1F, 1F, 1F, 1F);
			
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
			
		}
	}
