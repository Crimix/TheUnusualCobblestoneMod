package com.black_dog20.tucs.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerDummy extends Container{


    public ContainerDummy(EntityPlayer Player)
    {
        
    }

	@Override
	public boolean canInteractWith(EntityPlayer EPlayer) {

		return true;
	}
}