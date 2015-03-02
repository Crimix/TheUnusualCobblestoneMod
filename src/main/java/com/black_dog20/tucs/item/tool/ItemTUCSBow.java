package com.black_dog20.tucs.item.tool;

import com.black_dog20.tucs.tucs;
import com.black_dog20.tucs.creativetab.CreativeTabTUCS;
import com.black_dog20.tucs.item.ItemTUCS;
import com.black_dog20.tucs.reference.NBTTags;
import com.black_dog20.tucs.reference.Reference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemTUCSBow extends ItemTUCS
{
    public static final String[] bowPullIconNameArray = new String[] {"pulling_0", "pulling_1", "pulling_2"};
    @SideOnly(Side.CLIENT)
    private IIcon[] iconArray;
    private static final String __OBFID = "CL_00001777";

    public ItemTUCSBow()
    {
    	this.setFull3D();
        this.maxStackSize = 1;
        this.setMaxDamage(1384);
        this.setCreativeTab(CreativeTabTUCS.TUCS_TAB);
        this.setUnlocalizedName("bowTLBOTH");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public boolean isFull3D()
    {
        return true;
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World world, EntityPlayer Eplayer, int useCount)
    {
        int j = this.getMaxItemUseDuration(stack) - useCount;

        ArrowLooseEvent event = new ArrowLooseEvent(Eplayer, stack, j);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return;
        }
        j = event.charge;

        boolean flag = Eplayer.capabilities.isCreativeMode || stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTTags.NoArrow);

        if (flag || Eplayer.inventory.hasItem(Items.arrow))
        {

            EntityArrow entityarrow = spawnArrow(world, Eplayer);

            stack.damageItem(1, Eplayer);
            world.playSoundAtEntity(Eplayer, "random.bow", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);

            if (flag)
            {
                entityarrow.canBePickedUp = 0;
            }
            else
            {
                Eplayer.inventory.consumeInventoryItem(Items.arrow);
            }

            if (!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }
        }
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
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer Eplayer)
    {
        ArrowNockEvent event = new ArrowNockEvent(Eplayer, stack);
        MinecraftForge.EVENT_BUS.post(event);
        if (event.isCanceled())
        {
            return event.result;
        }

        if(stack.hasTagCompound() && stack.getTagCompound().hasKey(NBTTags.MachineBow)){
            EntityArrow entityarrow = spawnArrow(world, Eplayer);
            
            stack.damageItem(1, Eplayer);
            if (!world.isRemote)
            {
                world.spawnEntityInWorld(entityarrow);
            }
        }
        else if (Eplayer.capabilities.isCreativeMode || Eplayer.inventory.hasItem(Items.arrow))
        {
            Eplayer.setItemInUse(stack, this.getMaxItemUseDuration(stack));
        }
        

        return stack;
    }
    
    public EntityArrow spawnArrow(World world, EntityPlayer Eplayer){
    	EntityArrow entityarrow = new EntityArrow(world, Eplayer, 2.0F);

        entityarrow.setIsCritical(true);
        entityarrow.setDamage(entityarrow.getDamage() +100D);
        entityarrow.setKnockbackStrength(1);
        entityarrow.canBePickedUp = 0;
        return entityarrow;
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister IIcon)
    {
        this.itemIcon = IIcon.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1) +"_standby");
        this.iconArray = new IIcon[bowPullIconNameArray.length];

        for (int i = 0; i < this.iconArray.length; ++i)
        {
            this.iconArray[i] = IIcon.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1)+ "_" + bowPullIconNameArray[i]);
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public IIcon getIcon (ItemStack stack, int renderPass, EntityPlayer player, ItemStack usingItem, int useRemaining)
    {
        if (usingItem != null)
        {
            int time = getMaxItemUseDuration(stack) - useRemaining;
            if (time < 8)
                return iconArray[0];
            if (time < 14)
                return iconArray[1];
            return iconArray[2];
        }
        return getIcon(stack, renderPass);
    }

    @SideOnly(Side.CLIENT)
    public IIcon getItemIconForUseDuration(int duration)
    {
        return this.iconArray[duration];
    }
}