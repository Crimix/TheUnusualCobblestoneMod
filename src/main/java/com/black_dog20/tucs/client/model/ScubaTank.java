package com.black_dog20.tucs.client.model;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBiped - Either Mojang or a mod author Created using Tabula 4.1.1
 */
public class ScubaTank extends ModelBiped {
	public ModelRenderer tank_1;
	public ModelRenderer tank_2;
	public ModelRenderer support_1;
	public ModelRenderer support_2;
	public ModelRenderer support_3;
	public ModelRenderer air_flow;

	public ScubaTank() {
		this.textureWidth = 256;
		this.textureHeight = 128;
		this.support_2 = new ModelRenderer(this, 84, 53);
		this.support_2.setRotationPoint(-5.0F, 3.0F, -3.0F);
		this.support_2.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.air_flow = new ModelRenderer(this, 74, 76);
		this.air_flow.setRotationPoint(-3.0F, -1.0F, 3.0F);
		this.air_flow.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
		this.tank_2 = new ModelRenderer(this, 84, 74);
		this.tank_2.setRotationPoint(-6.2F, -2.0F, 0.0F);
		this.tank_2.addBox(0.0F, 0.0F, 0.0F, 8, 13, 8, -2.0F);
		this.support_1 = new ModelRenderer(this, 84, 67);
		this.support_1.setRotationPoint(-5.0F, 3.0F, -3.0F);
		this.support_1.addBox(0.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
		this.support_3 = new ModelRenderer(this, 85, 53);
		this.support_3.setRotationPoint(4.0F, 3.0F, -3.0F);
		this.support_3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F);
		this.tank_1 = new ModelRenderer(this, 84, 74);
		this.tank_1.setRotationPoint(-1.7F, -2.0F, 0.0F);
		this.tank_1.addBox(0.0F, 0.0F, 0.0F, 8, 13, 8, -2.0F);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		this.support_2.render(f5);
		this.air_flow.render(f5);
		this.tank_2.render(f5);
		this.support_1.render(f5);
		this.support_3.render(f5);
		this.tank_1.render(f5);
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
