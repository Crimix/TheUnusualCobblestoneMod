package com.black_dog20.tucs.block;

import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.tileEntity.TileEntitySoulForge;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockSoulbind extends BlockTUCS implements ITileEntityProvider{

	@SideOnly(Side.CLIENT)
	private IIcon iconFront;

	public static final int renderID = 	RenderingRegistry.getNextAvailableRenderId();
	@SideOnly(Side.CLIENT)
	private IIcon iconTop;

	@SideOnly(Side.CLIENT)
	private IIcon iconSide;

	@SideOnly(Side.CLIENT)
	private IIcon iconBot;

	public BlockSoulbind(){

		super(Material.wood);

		this.setHardness(3.5F);
		this.setResistance(100.0F);
		this.setBlockName("soulbinder");
	}
    @Override
    public int getRenderType() {
            return renderID;
    }
    
    @Override
    public boolean isOpaqueCube() {
            return false;
    }
    
    @Override
    public boolean renderAsNormalBlock() {
            return false;
    }
	
	@Override
	public TileEntity createNewTileEntity(World world, int par) {
		return new TileEntitySoulForge();
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.blockIcon = iconRegister.registerIcon(Reference.MOD_ID + ":" + "soulBinder_side");
		this.iconFront = iconRegister.registerIcon(Reference.MOD_ID + ":" + "soulBinder_side");
		this.iconTop = iconRegister.registerIcon(Reference.MOD_ID + ":" + "soulBinder_top");
		this.iconBot = iconRegister.registerIcon("minecraft:soul_sand");
	}

	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int metadata) {
		return metadata == 0 && side == 3 ? this.iconFront : side == 1 ? this.iconTop : (side == 0 ? this.iconBot : (side == metadata ? this.iconFront : this.blockIcon));
		//return side == 1 ? this.iconTop : (side == 0 ? this.iconBot : (side != metadata ? this.blockIcon : this.iconFront));
	}


	public boolean onBlockActivated (World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {

		if (!player.isSneaking()) {
			player.openGui(tucs.instance, tucs.guiSoulBinder, world, x, y, z);
			return true;
		}else{
			return false;
		}
	}

}
