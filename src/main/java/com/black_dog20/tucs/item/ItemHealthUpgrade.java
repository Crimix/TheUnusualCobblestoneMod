package com.black_dog20.tucs.item;

import java.util.UUID;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemHealthUpgrade extends ItemTUCS {

	public UUID id = UUID.fromString("e7d7f610-269c-42e1-b440-30dc36e8aa72");

	public ItemHealthUpgrade() {

		super();
		this.setUnlocalizedName("healthUpgrade");

	}

	@Override public ItemStack onItemRightClick(ItemStack Item, World world, EntityPlayer player) {

		IAttributeInstance attributeinstance = player.getAttributeMap().getAttributeInstance(SharedMonsterAttributes.maxHealth);
		try {
			attributeinstance.removeModifier(attributeinstance.getModifier(id));
		} catch (Exception e) {}
		attributeinstance.applyModifier(new AttributeModifier(id, "tucs.health", 20, 0));

		return Item;
	}

}
