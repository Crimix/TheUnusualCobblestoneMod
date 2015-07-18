package com.black_dog20.tucs.client.render;

import java.util.Map;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.texture.LayeredTexture;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityHorse;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.client.model.HoverBike;
import com.black_dog20.tucs.entity.EntityHoverBike;
import com.google.common.collect.Maps;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSpeeder extends Render
{
	private ModelBase modelBoat;
	
	    public RenderSpeeder()
	    {
	        this.shadowSize = 0.5F;
	        this.modelBoat = new HoverBike();
	    }

	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	     */
	    public void doRender(EntityHoverBike p_76986_1_, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	    {
	        GL11.glPushMatrix();
	        GL11.glTranslatef((float)p_76986_2_, (float)p_76986_4_, (float)p_76986_6_);
	        GL11.glRotatef(180.0F - p_76986_8_, 0.0F, 1.0F, 0.0F);

	        float f4 = 0.75F;
	        GL11.glScalef(f4, f4, f4);
	        GL11.glScalef(1.0F / f4, 1.0F / f4, 1.0F / f4);
	        this.bindEntityTexture(p_76986_1_);
	        GL11.glScalef(-1.0F, -1.0F, 1.0F);
	        this.modelBoat.render(p_76986_1_, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
	    }

	    /**
	     * Actually renders the given argument. This is a synthetic bridge method, always casting down its argument and then
	     * handing it off to a worker function which does the actual work. In all probabilty, the class Render is generic
	     * (Render<T extends Entity) and this method has signature public void func_76986_a(T entity, double d, double d1,
	     * double d2, float f, float f1). But JAD is pre 1.5 so doesn't do that.
	     */
	    @Override
	    public void doRender(Entity entity, double p_76986_2_, double p_76986_4_, double p_76986_6_, float p_76986_8_, float p_76986_9_)
	    {
	        this.doRender((EntityHoverBike)entity, p_76986_2_, p_76986_4_, p_76986_6_, p_76986_8_, p_76986_9_);
	    }
    
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
		return new ResourceLocation("tucs:textures/entity/Speeder-texturemap.png");
	}


}
