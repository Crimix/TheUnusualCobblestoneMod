package com.black_dog20.tucs.client.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.IItemRenderer;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.item.tool.ItemM1911;
import com.black_dog20.tucs.item.tool.ItemTLBOTH;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.utility.InventoryHelper;
import com.black_dog20.tucs.utility.M1911Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TUCSWeaponOverlayRender implements IItemRenderer
{
	private static RenderItem renderItem = new RenderItem();

	public TUCSWeaponOverlayRender() {}

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
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;;
        FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
        IIcon icon = itemStack.getIconIndex();
        GL11.glEnable(GL11.GL_ALPHA_TEST);
        renderItem.renderIcon(0, 0, icon, 16, 16);
        GL11.glDisable(GL11.GL_ALPHA_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glScalef(0.5F, 0.5F, 0.5F);
        String text = null;
        if(itemStack.getItem() instanceof ItemTLBOTH){
        	
        	if(itemStack.hasTagCompound()){
        		NBTTagCompound nbt = itemStack.getTagCompound();
        		if(!nbt.hasKey(NBTTags.NoArrow) && !player.capabilities.isCreativeMode){
        			text = Integer.toString(InventoryHelper.findItem(Items.arrow, player.inventory));
        		}
        		if(nbt.hasKey(NBTTags.NoArrow)){
        			text = EnumChatFormatting.GOLD+"\u221E";
        		}
        	}
        	else if(!player.capabilities.isCreativeMode){
        		text = Integer.toString(InventoryHelper.findItem(Items.arrow, player.inventory));
    			
        	}
        } 
        else if(itemStack.getItem() instanceof ItemM1911){
        	ItemM1911 m1911 = (ItemM1911) itemStack.getItem();
        	text = Integer.toString(M1911Helper.getAmmo(itemStack)) + " / " + Integer.toString(InventoryHelper.findItem(ModItems.ammo, player.inventory)); 
        	fontRenderer.drawString(text, 1, 1, 0xFFFFFF); 
        }
        if(text != null && !(itemStack.getItem() instanceof ItemM1911)){
        	fontRenderer.drawString(text, 1, 1, 0xFFFFFF);     
        }
        
}
}