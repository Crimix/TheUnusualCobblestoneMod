package com.black_dog20.tucs.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.World;

public class EntityRound extends EntityArrow {

	public EntityRound(World world) {
		super(world);
	}

	public EntityRound(World world, double x, double y, double z) {
		super(world, x, y, z);
	}

	public EntityRound(World world, EntityLivingBase entityShooter,
			EntityLivingBase entity, float par1, float par2) {
		super(world, entityShooter, entity, par1, par2);
	}

	public EntityRound(World world, EntityLivingBase entityShooter, float par) {
		super(world, entityShooter, par);
	}
}
