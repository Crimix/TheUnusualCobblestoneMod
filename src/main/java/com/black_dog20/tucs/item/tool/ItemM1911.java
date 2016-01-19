package com.black_dog20.tucs.item.tool;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.entity.EntityRound;
import com.black_dog20.tucs.item.ItemBowTUCS;
import com.black_dog20.tucs.utility.M1911Helper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemM1911 extends ItemBowTUCS {
	private IIcon[] iconArray;
	
	boolean upgradeAble;
	public ItemM1911(boolean upgrade)
    {
    	this.setFull3D();
        this.maxStackSize = 1;
        this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
        this.setUnlocalizedName("m1911");
        this.upgradeAble = upgrade;
    }
	
	
	@Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }


    @Override
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return 72000;
    }

    @Override
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.bow;
    }
    
    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer Eplayer, int useCount)
    {

        ArrowLooseEvent event = new ArrowLooseEvent(Eplayer, stack, this.getMaxItemUseDuration(stack));
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }

        EntityRound round = spawnRound(world, Eplayer, 1.0F);

            
            	if (!world.isRemote)
            	{
            		world.playSoundAtEntity(Eplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
            		world.spawnEntityInWorld(round);
            		M1911Helper.shoot(stack);
            	}
    }

    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer Eplayer)
    {
    		ArrowNockEvent event = new ArrowNockEvent(Eplayer, stack);
        	MinecraftForge.EVENT_BUS.post(event);
      
        	if (event.isCanceled())
        	{
            	return event.result;
        	}
        	if(this.upgradeAble && Eplayer.isSneaking()){
        		tucs.Proxy.openToolUpgrade(Eplayer);
			}
        	else if(M1911Helper.getAmmo(stack) > 0){
        		Eplayer.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        	}
        	else{
        		M1911Helper.reload(Eplayer, Eplayer.inventory.getCurrentItem());
        	}
        return stack;
    }
    
    public EntityRound spawnRound(World world, EntityPlayer Eplayer, float f){
    	EntityRound round = new EntityRound(world, Eplayer, f*2.0F);

        round.setIsCritical(true);
        round.setDamage(round.getDamage() +2D);
        round.canBePickedUp = 0;
        return round;
    }
    
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister IIcon)
    {
        this.itemIcon = IIcon.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
        this.iconArray = new IIcon[2];
        this.iconArray[0] = IIcon.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)); 
        this.iconArray[1] = IIcon.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+"_dev"); 
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
            if (player.getDisplayName().toLowerCase().equals("black_dog20")||player.getDisplayName().toLowerCase().equals("simmebabz"))
                return iconArray[1];
            else
                return iconArray[0];
    }
    
   

}
