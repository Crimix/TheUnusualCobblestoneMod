package com.black_dog20.tucs.item.tool;

import static net.minecraftforge.common.util.ForgeDirection.EAST;
import static net.minecraftforge.common.util.ForgeDirection.NORTH;
import static net.minecraftforge.common.util.ForgeDirection.SOUTH;
import static net.minecraftforge.common.util.ForgeDirection.WEST;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.client.render.IOverlayItem;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.item.ITucsItem;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.InventoryHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTLPOLM extends ItemPickaxe implements ITucsItem, IOverlayItem{

	public ItemTLPOLM(ToolMaterial Material){

		super(Material);
		this.setUnlocalizedName("TLPOLM");
		this.setMaxStackSize(1);
		this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
		this.setNoRepair();
		this.canRepair = false;
		this.registerItemForOverlay();

	}

	@Override
	public String getUnlocalizedName()
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
		return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
		itemIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "pickaxeTLPOLM");
	}

	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
		return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player){

		if(player.isSneaking()){
			tucs.Proxy.openToolUpgrade(player);
		}

		return Item;

	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int side, float par2, float par3, float par4)
	{
		if(!player.isSneaking()){
			return torchLogic(item, world, player, side, x, y, z);
		}
		return false;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z)
	{
		return world.isSideSolid(x - 1, y, z, EAST,  true) ||
				world.isSideSolid(x + 1, y, z, WEST,  true) ||
				world.isSideSolid(x, y, z - 1, SOUTH, true) ||
				world.isSideSolid(x, y, z + 1, NORTH, true) ||
				func_150107_m(world, x, y - 1, x);
	}
	
    private boolean func_150107_m(World p_150107_1_, int p_150107_2_, int p_150107_3_, int p_150107_4_)
    {
        if (World.doesBlockHaveSolidTopSurface(p_150107_1_, p_150107_2_, p_150107_3_, p_150107_4_))
        {
            return true;
        }
        else
        {
            Block block = p_150107_1_.getBlock(p_150107_2_, p_150107_3_, p_150107_4_);
            return block.canPlaceTorchOnTop(p_150107_1_, p_150107_2_, p_150107_3_, p_150107_4_);
        }
    }

	public boolean torchLogic(ItemStack item, World world, EntityPlayer player, int side, int x, int y, int z){
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
		if (player.canPlayerEdit(x, y, z, side, item) && player.inventory.hasItemStack(new ItemStack(Blocks.torch))){
			if (world.isAirBlock(x, y, z) && canPlaceBlockAt(world, x, y, z) && world.setBlock(x, y, z, Blocks.torch)){
				player.inventory.decrStackSize(InventoryHelper.findTorch(player.inventory),1);
				return true;
			}
		}
		return false;
	}



	@Override
	public boolean hasEffect(ItemStack stack){

		if(!stack.hasTagCompound()){
			stack.stackTagCompound = new NBTTagCompound();
		}
		if(stack.hasTagCompound()){
			NBTTagCompound nbt= stack.getTagCompound();

			if(nbt.getString(NBTTags.SOULBOUND).equals(NBTTags.OK) || nbt.hasKey("ench")){
				return true;
			}
			if(nbt.hasKey(NBTTags.SOULBOUND_P) || nbt.hasKey("ench")){
				return true;
			}
			if(nbt.hasKey(NBTTags.Beheading) || nbt.hasKey("ench")){
				return true;
			}
			else{
				return false;
			}
		}
		return false;
	}

	@Override
	public void registerItemForOverlay() {
		tucs.overlayList.add(this);
	}

}
