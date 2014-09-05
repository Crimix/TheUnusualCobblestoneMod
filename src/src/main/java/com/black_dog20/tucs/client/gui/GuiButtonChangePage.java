package com.black_dog20.tucs.client.gui;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;

public class GuiButtonChangePage extends GuiButton {

	private final boolean previous;

	public GuiButtonChangePage(int id, int x, int y, boolean previous) {
		super(id, x, y, 23, 13, "");
		this.previous = previous;
	}

	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY) {
		if (visible) {
			boolean mouseOver = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
			GL11.glColor4f(1F, 1F, 1F, 1F);
				mc.renderEngine.bindTexture(GuiTUCSBook.texture);
			int u = 0;
			int v = 192;
			if (mouseOver) {
				u += 23;
			}

			if (previous) {
				v += 13;
			}
			drawTexturedModalRect(xPosition, yPosition, u, v, 23, 13);
		}
	}
}
