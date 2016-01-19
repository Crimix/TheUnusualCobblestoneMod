package com.black_dog20.tucs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * SoulForge - Black_dog20 Created using Tabula 4.1.1
 */
public class SoulForgeModel extends ModelBase {
	public ModelRenderer Base;
	public ModelRenderer shape11;
	public ModelRenderer shape11_1;
	public ModelRenderer shape11_2;
	public ModelRenderer shape11_3;

	public SoulForgeModel() {
		this.textureWidth = 100;
		this.textureHeight = 100;
		this.shape11_1 = new ModelRenderer(this, 0, 32);
		this.shape11_1.setRotationPoint(4.0F, 8.0F, 3.0F);
		this.shape11_1.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
		this.shape11_2 = new ModelRenderer(this, 0, 32);
		this.shape11_2.setRotationPoint(-5.0F, 8.0F, -4.0F);
		this.shape11_2.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
		this.Base = new ModelRenderer(this, 0, 0);
		this.Base.setRotationPoint(0.0F, 24.0F, 6.9F);
		this.Base.addBox(-8.0F, -8.0F, -1.0F, 16, 8, 16, 0.0F);
		this.setRotateAngle(Base, 0.0F, 3.141592653589793F, 0.0F);
		this.shape11_3 = new ModelRenderer(this, 0, 32);
		this.shape11_3.setRotationPoint(4.0F, 8.0F, -4.0F);
		this.shape11_3.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
		this.shape11 = new ModelRenderer(this, 0, 32);
		this.shape11.setRotationPoint(-5.0F, 8.0F, 3.0F);
		this.shape11.addBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		this.shape11_1.render(f5);
		this.shape11_2.render(f5);
		this.Base.render(f5);
		this.shape11_3.render(f5);
		this.shape11.render(f5);
	}

	/**
	 * This is a helper function from Tabula to set the rotation of model parts
	 */
	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
