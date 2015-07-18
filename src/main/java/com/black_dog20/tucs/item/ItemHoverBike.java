package com.black_dog20.tucs.item;

import java.util.List;

import com.black_dog20.tucs.entity.EntityHoverBike;

import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemHoverBike extends ItemTUCS {

	public ItemHoverBike(){

		super();
		this.setUnlocalizedName("hoverBike");

	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float xOffset, float yOffset, float zOffSet)
	{
	
		if(!world.isRemote){
		EntityHoverBike ent = new EntityHoverBike(world); //change to whatever entity you're trying to spawn
		ent.setLocationAndAngles(x, y + 1, z, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		world.spawnEntityInWorld(ent);
		}
		return true;
	}


}
