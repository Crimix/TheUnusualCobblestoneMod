package com.black_dog20.tucs.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.item.armor.IScubaAirTank;
import com.black_dog20.tucs.item.armor.IScubaMask;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TUCSScubaGear implements IItemRenderer
{
	private static RenderItem renderItem = new RenderItem();

	public TUCSScubaGear() {}

	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type) {
		return type == ItemRenderType.INVENTORY;
	}

	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper) {
		return false;
	}

	@Override
	public void renderItem(ItemRenderType type, ItemStack itemStack, Object... data) {
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        IIcon icon = itemStack.getIconIndex();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        renderItem.renderIcon(0, 0, icon, 16, 16);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        String text = null;
        if(itemStack.getItem() instanceof IScubaMask || itemStack.getItem() instanceof IScubaAirTank){
        	text = "O2";
        } 
        if(text != null){
        	fontRenderer.drawString(text, 1, 1, 0x00FFF4);     
        }
        
}
}
