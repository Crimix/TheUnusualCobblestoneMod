package com.black_dog20.tucs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * Speeder - Black_dog20 Created using Tabula 4.1.1
 */
public class HoverBike extends ModelBase {
	public ModelRenderer shape1;

	public HoverBike() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(-15.0F, -5.0F, 2.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 6, 7, 31, 0.0F);
		this.setRotateAngle(shape1, 0.0F, 1.5707963267948966F, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.shape1.render(f5);
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
