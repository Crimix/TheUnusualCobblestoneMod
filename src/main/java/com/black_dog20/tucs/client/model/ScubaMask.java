package com.black_dog20.tucs.client.model;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ScubaMask - Black_dog20
 * Created using Tabula 4.1.1
 */
public class ScubaMask extends ModelBiped {
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer shape12_1;

    public ScubaMask() {
    	super(1.0F);
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape12 = new ModelRenderer(this, 1, 29);
        this.shape12.setRotationPoint(2.0F, -2.0F, -6.0F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape10 = new ModelRenderer(this, 37, 25);
        this.shape10.setRotationPoint(-3.0F, -2.0F, -6.0F);
        this.shape10.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1, 0.0F);
        this.shape11 = new ModelRenderer(this, 0, 25);
        this.shape11.setRotationPoint(-2.0F, -3.0F, -6.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
        this.shape12_1 = new ModelRenderer(this, 1, 29);
        this.shape12_1.setRotationPoint(-3.0F, -2.0F, -6.0F);
        this.shape12_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape9 = new ModelRenderer(this, 17, 22);
        this.shape9.mirror = true;
        this.shape9.setRotationPoint(-4.0F, -8.0F, -5.0F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 8, 8, 1, 0.0F);
        this.bipedHead.addChild(shape9);
        this.bipedHead.addChild(shape10);
        this.bipedHead.addChild(shape11);
        this.bipedHead.addChild(shape12);
        this.bipedHead.addChild(shape10);
        this.bipedHead.addChild(shape12_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
       
        this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
/*
    	this.shape12.render(f5);
        this.shape10.render(f5);
        this.shape11.render(f5);
        this.shape12_1.render(f5);
        this.shape9.render(f5);
*/

        if (this.isChild)
        {
            float f6 = 2.0F;
            GL11.glPushMatrix();
            GL11.glScalef(1.5F / f6, 1.5F / f6, 1.5F / f6);
            GL11.glTranslatef(0.0F, 16.0F * f5, 0.0F);
            GL11.glEnable(GL11.GL_BLEND);
            this.bipedHead.render(f5);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glPopMatrix();
        }
        else
        {
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
