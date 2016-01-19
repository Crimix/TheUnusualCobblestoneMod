package com.black_dog20.tucs.client.render;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.entity.EntityRound;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RoundRender extends Render {

	private static final ResourceLocation texture = new ResourceLocation(
			"tucs:textures/entity/round.png");

	public void doRender(EntityRound p_76986_1_, double p_76986_2_,
			double p_76986_4_, double p_76986_6_, float p_76986_8_,
			float p_76986_9_) {
		this.bindEntityTexture(p_76986_1_);
		GL11.glPushMatrix();
		GL11.glPopMatrix();
	}

	protected ResourceLocation getEntityTexture(EntityRound p_110775_1_) {
		return texture;
	}

	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return this.getEntityTexture((EntityRound) p_110775_1_);
	}

	public void doRender(Entity p_76986_1_, double p_76986_2_,
			double p_76986_4_, double p_76986_6_, float p_76986_8_,
			float p_76986_9_) {
		this.doRender((EntityRound) p_76986_1_, p_76986_2_, p_76986_4_,
				p_76986_6_, p_76986_8_, p_76986_9_);
	}
}
