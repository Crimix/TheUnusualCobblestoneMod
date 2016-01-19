package com.black_dog20.tucs.client.render;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.IBlockAccess;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.block.BlockAirMaker;
import com.black_dog20.tucs.client.model.AirCompressor;
import com.black_dog20.tucs.tileEntity.TileEntityAirMaker;

import cpw.mods.fml.client.registry.ISimpleBlockRenderingHandler;

public class AirMakerRender extends TileEntitySpecialRenderer implements ISimpleBlockRenderingHandler {

	private AirCompressor model;
	private static final ResourceLocation texture = new ResourceLocation("tucs:models/blocks/airCompressor_texture.png");

	public AirMakerRender() {
		model = new AirCompressor(false);
	}

	@Override public void renderInventoryBlock(Block block, int metadata, int modelId, RenderBlocks renderer) {
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		GL11.glTranslatef(0F, -1F, 0F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
	}

	@Override public void renderTileEntityAt(TileEntity te, double x, double y, double z, float f) {
		if (((TileEntityAirMaker) te).AirTankForModel != null) {
			model = new AirCompressor(true);
		} else {
			model = new AirCompressor(false);
		}
		bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glPushMatrix();
		GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
		int angle = 0;
		switch (te.getBlockMetadata()) {
		case 2:
			angle = 0;
			break;
		case 3:
			angle = 180;
			break;
		case 4:
			angle = -90;
			break;
		case 5:
			angle = 90;
			break;

		default:
			angle = 0;
			break;
		}
		// Rotates model on the spot, depending on direction, making the front
		// always to player) which is not the front but the side
		GL11.glRotatef(angle - 90, 0.0F, 1.0F, 0.0F);
		this.model.render((Entity) null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}

	@Override public boolean shouldRender3DInInventory(int modelId) {
		return true;
	}

	@Override public int getRenderId() {
		return BlockAirMaker.renderID;
	}

	@Override public boolean renderWorldBlock(IBlockAccess world, int x, int y, int z, Block block, int modelId, RenderBlocks renderer) {
		return false;
	}

}
