package com.black_dog20.tucs.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

/**
 * Scuba Maske V2 - Black_dog20
 * Created using Tabula 4.1.1
 */
public class ScubaMaskeV2 extends ModelBiped {
    public ModelRenderer big_glass;
    public ModelRenderer small_glass;
    public ModelRenderer top;
    public ModelRenderer left;
    public ModelRenderer back;
    public ModelRenderer right;
    public ModelRenderer air;

    public ScubaMaskeV2() {
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.air = new ModelRenderer(this, 130, 20);
        this.air.setRotationPoint(-2.0F, -2.0F, -7.0F);
        this.air.addBox(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
        this.small_glass = new ModelRenderer(this, 80, 8);
        this.small_glass.setRotationPoint(-3.5F, -7.0F, -6.01F);
        this.small_glass.addBox(0.0F, 0.0F, 0.0F, 7, 6, 1, 0.0F);
        this.top = new ModelRenderer(this, 120, 26);
        this.top.setRotationPoint(-4.0F, -9.0F, -5.0F);
        this.top.addBox(0.0F, 0.0F, 0.0F, 8, 1, 9, 0.0F);
        this.left = new ModelRenderer(this, 91, 23);
        this.left.setRotationPoint(4.0F, -8.0F, -5.0F);
        this.left.addBox(0.0F, 0.0F, 0.0F, 1, 7, 9, 0.0F);
        this.back = new ModelRenderer(this, 79, 50);
        this.back.setRotationPoint(-4.0F, -8.0F, 4.0F);
        this.back.addBox(0.0F, 0.0F, 0.0F, 8, 7, 1, 0.0F);
        this.right = new ModelRenderer(this, 110, 47);
        this.right.setRotationPoint(-5.0F, -8.0F, -5.0F);
        this.right.addBox(0.0F, 0.0F, 0.0F, 1, 7, 9, 0.0F);
        this.big_glass = new ModelRenderer(this, 110, 8);
        this.big_glass.setRotationPoint(-4.0F, -8.0F, -5.0F);
        this.big_glass.addBox(0.0F, 0.0F, 0.0F, 8, 8, 1, 0.0F);
		this.bipedHead.addChild(big_glass);
		this.bipedHead.addChild(small_glass);
		this.bipedHead.addChild(top);
		this.bipedHead.addChild(left);
		this.bipedHead.addChild(back);
		this.bipedHead.addChild(right);
		this.bipedHead.addChild(air);
        this.bipedHeadwear.isHidden=true;
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 

    	if(!entity.isInWater()){
    		this.big_glass.isHidden = true;
    		this.small_glass.isHidden = true;
    		this.air.isHidden = true;
    	}
    	else{
    		this.big_glass.isHidden = false;
    		this.small_glass.isHidden = false;
    		this.air.isHidden = false;
    	}
    	
    	this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		if (this.isChild) {
			float f6 = 2.0F;
			GL11.glPushMatrix();
			GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
			GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
			GL11.glEnable(GL11.GL_BLEND);
			this.bipedHead.render(f5);
			GL11.glDisable(GL11.GL_BLEND);
			GL11.glPopMatrix();
		} else {
			GL11.glEnable(GL11.GL_BLEND);
			this.bipedHead.render(f5);
			GL11.glDisable(GL11.GL_BLEND);
		}
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
