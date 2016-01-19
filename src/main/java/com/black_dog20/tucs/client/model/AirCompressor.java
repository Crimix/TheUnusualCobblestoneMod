package com.black_dog20.tucs.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * AirCompressor - Black_dog20 Created using Tabula 4.1.1
 */
public class AirCompressor extends ModelBase {
	public ModelRenderer shape1;
	public ModelRenderer shape2;
	public ModelRenderer shape3;
	public ModelRenderer tank_1;
	public ModelRenderer tank_2;
	public ModelRenderer air_flow;
	public boolean tank = false;

	public AirCompressor(boolean tank) {
		this.tank = tank;
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.air_flow = new ModelRenderer(this, 74, 76);
		this.air_flow.setRotationPoint(-3.0000000000000004F, 10.0F, 3.0F);
		this.air_flow.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.shape2 = new ModelRenderer(this, 0, 25);
		this.shape2.setRotationPoint(-8.0F, 9.0F, -8.0F);
		this.shape2.addBox(0.0F, 0.0F, 0.0F, 16, 11, 7, 0.0F);
		this.tank_2 = new ModelRenderer(this, 84, 74);
		this.tank_2.setRotationPoint(-6.2F, 9.0F, 0.0F);
		this.tank_2.addBox(0.0F, 0.0F, 0.0F, 8, 13, 8, -2.0F);
		this.shape3 = new ModelRenderer(this, 54, 0);
		this.shape3.setRotationPoint(-0.5F, 10.1F, -1.0F);
		this.shape3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F);
		this.tank_1 = new ModelRenderer(this, 84, 74);
		this.tank_1.setRotationPoint(-1.6999999999999997F, 9.0F, 0.0F);
		this.tank_1.addBox(0.0F, 0.0F, 0.0F, 8, 13, 8, -2.0F);
		this.shape1 = new ModelRenderer(this, 0, 0);
		this.shape1.setRotationPoint(-8.0F, 20.0F, -8.0F);
		this.shape1.addBox(0.0F, 0.0F, 0.0F, 16, 4, 16, 0.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		if (tank) {
			this.air_flow.render(f5);
			this.tank_1.render(f5);
			this.tank_2.render(f5);
		}
		this.shape2.render(f5);
		this.shape3.render(f5);
		this.shape1.render(f5);
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
