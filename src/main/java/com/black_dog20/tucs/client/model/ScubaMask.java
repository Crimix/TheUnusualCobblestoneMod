package com.black_dog20.tucs.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import org.lwjgl.opengl.GL11;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class ScubaMask extends ModelBiped {
    public ModelRenderer glass;
    public ModelRenderer air_2;
    public ModelRenderer air_1;
    public ModelRenderer small_1;
    public ModelRenderer small_2;
    public ModelRenderer headSurport_1;
    public ModelRenderer headSurport_2;
    public ModelRenderer headSurport_3;

    public ScubaMask() {
    	//super(1.0F);
        this.textureWidth = 256;
        this.textureHeight = 128;
        this.glass = new ModelRenderer(this, 215, 105);
        this.glass.setRotationPoint(-4.0F, -8.0F, -5.0F);
        this.glass.addBox(0.0F, 0.0F, 0.0F, 8, 8, 1, 0.0F);
        this.small_1 = new ModelRenderer(this, 199, 112);
        this.small_1.setRotationPoint(-3.0F, -2.0F, -6.0F);
        this.small_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.headSurport_3 = new ModelRenderer(this, 208, 60);
        this.headSurport_3.setRotationPoint(-5.01F, -5.0F, -5.0F);
        this.headSurport_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
        this.air_2 = new ModelRenderer(this, 235, 108);
        this.air_2.setRotationPoint(-3.0F, -2.0F, -6.0F);
        this.air_2.addBox(0.0F, 0.0F, -1.0F, 6, 1, 1, 0.0F);
        this.headSurport_2 = new ModelRenderer(this, 208, 60);
        this.headSurport_2.setRotationPoint(-5.0F, -5.0F, 4.0F);
        this.headSurport_2.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
        this.headSurport_1 = new ModelRenderer(this, 208, 64);
        this.headSurport_1.setRotationPoint(4.01F, -5.0F, -5.0F);
        this.headSurport_1.addBox(0.0F, 0.0F, 0.0F, 1, 1, 9, 0.0F);
        this.air_1 = new ModelRenderer(this, 198, 108);
        this.air_1.setRotationPoint(-2.0F, -3.0F, -6.0F);
        this.air_1.addBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F);
        this.small_2 = new ModelRenderer(this, 199, 112);
        this.small_2.setRotationPoint(2.0F, -2.0F, -6.0F);
        this.small_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.bipedHead.addChild(glass);
        this.bipedHead.addChild(air_2);
        this.bipedHead.addChild(air_1);
        this.bipedHead.addChild(small_1);
        this.bipedHead.addChild(small_2);
        this.bipedHead.addChild(headSurport_1);
        this.bipedHead.addChild(headSurport_2);
        this.bipedHead.addChild(headSurport_3);
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
