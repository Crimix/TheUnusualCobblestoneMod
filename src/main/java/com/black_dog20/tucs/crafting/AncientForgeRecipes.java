package com.black_dog20.tucs.crafting;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;

public class AncientForgeRecipes {
	private static final AncientForgeRecipes smeltingBase = new AncientForgeRecipes();
	/** The list of smelting results. */
	private Map smeltingList = new HashMap();
	private Map experienceList = new HashMap();

	public static AncientForgeRecipes smelting() {
		return smeltingBase;
	}

	private AncientForgeRecipes() {
		this.smeltBlock(ModBlocks.oreCobblestoneium, new ItemStack(ModItems.ingotCobblestoneium, 2), 1.0F);
		this.smeltItem(ModItems.chestplateCobblestonediumBroken, new ItemStack(ModItems.chestplateCobblestonedium, 1), 1.0F);
		this.smeltItem(ModItems.helmetCobblestonediumBroken, new ItemStack(ModItems.helmetCobblestonedium, 1), 1.0F);
		this.smeltItem(ModItems.leggingsCobblestonediumBroken, new ItemStack(ModItems.leggingsCobblestonedium, 1), 1.0F);
		this.smeltItem(ModItems.bootsCobblestonediumBroken, new ItemStack(ModItems.bootsCobblestonedium, 1), 1.0F);
		this.smeltItem(ModItems.TUCSBowBroken, new ItemStack(ModItems.TUCSBow, 1), 1.0F);
	}

	public void smeltBlock(Block block, ItemStack itemStack, float xp) {
		this.smeltItem(Item.getItemFromBlock(block), itemStack, xp);
	}

	public void smeltItem(Item item, ItemStack itemStack, float xp) {
		this.addItem(new ItemStack(item, 1, 32767), itemStack, xp);
	}

	public void addItem(ItemStack input, ItemStack output, float xp) {
		this.smeltingList.put(input, output);
		this.experienceList.put(output, Float.valueOf(xp));
	}

	/**
	 * Returns the smelting result of an item.
	 */
	public ItemStack getSmeltingResult(ItemStack itemStack) {
		Iterator iterator = this.smeltingList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return null;
			}

			entry = (Entry) iterator.next();
		} while (!this.check(itemStack, (ItemStack) entry.getKey()));

		return (ItemStack) entry.getValue();
	}

	private boolean check(ItemStack itemStack1, ItemStack itemStack2) {
		return itemStack2.getItem() == itemStack1.getItem() && (itemStack2.getItemDamage() == 32767 || itemStack2.getItemDamage() == itemStack1.getItemDamage());
	}

	public Map getSmeltingList() {
		return this.smeltingList;
	}

	public float func_151398_b(ItemStack itemStack) {
		float ret = itemStack.getItem().getSmeltingExperience(itemStack);
		if (ret != -1)
			return ret;

		Iterator iterator = this.experienceList.entrySet().iterator();
		Entry entry;

		do {
			if (!iterator.hasNext()) {
				return 0.0F;
			}

			entry = (Entry) iterator.next();
		} while (!this.check(itemStack, (ItemStack) entry.getKey()));

		return ((Float) entry.getValue()).floatValue();
	}
}