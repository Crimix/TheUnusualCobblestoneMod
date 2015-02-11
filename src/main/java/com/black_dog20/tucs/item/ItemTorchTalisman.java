package com.black_dog20.tucs.item;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.NBTTags;

public class ItemTorchTalisman extends ItemTUCS{

	public ItemTorchTalisman(){
		super();
		this.setUnlocalizedName("torchTalisman");
		this.setMaxStackSize(1);


	}

	@Override
	public boolean hasEffect(ItemStack stack){
		
		if(!stack.hasTagCompound()){
			stack.stackTagCompound = new NBTTagCompound();
		}
		if(stack.hasTagCompound()){
			NBTTagCompound nbt= stack.getTagCompound();
			
			if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK)){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}
	
	/*public boolean canPlaceBlockAt(World world, int x, int y, int z)
    {
        return world.isSideSolid(x - 1, y, z, EAST,  true) ||
               world.isSideSolid(x + 1, y, z, WEST,  true) ||
               world.isSideSolid(x, y, z - 1, SOUTH, true) ||
               world.isSideSolid(x, y, z + 1, NORTH, true) ||
               false;
    }
	
	@Override
	public boolean onItemUse(ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ){
		switch (side){
		case 0:
			y--;
			break;
		case 1:
			y++;
			break;
		case 2:
			z--;
			break;
		case 3:
			z++;
			break;
		case 4:
			x--;
			break;
		case 5:
			x++;
			break;
		}

		if (player.canPlayerEdit(x, y, z, side, stack)){

			if (world.isAirBlock(x, y, z) && canPlaceBlockAt(world, x, y, z) & world.setBlock(x, y, z, Blocks.torch)){

				return true;
			}
		}
	return false;
}*/


}
