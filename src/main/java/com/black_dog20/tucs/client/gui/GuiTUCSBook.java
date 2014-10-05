package com.black_dog20.tucs.client.gui;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;
import com.black_dog20.tucs.reference.Reference;
import com.black_dog20.tucs.utility.LogHelper;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.oredict.OreDictionary;

public class GuiTUCSBook extends GuiScreen {
	static final ResourceLocation texture = new ResourceLocation("minecraft:textures/gui/book.png");
	static final ResourceLocation textureC = new ResourceLocation("minecraft:textures/gui/container/crafting_table.png");
	static final ResourceLocation textureF = new ResourceLocation("minecraft:textures/gui/container/furnace.png");
	private int postion;

	private static final int BUTTON_NEXT = 0;
	private static final int BUTTON_PREV = 1;

	private int pageIndex = 0;
	private int maxPage = 10;
	private int xCraft = 64;
	private int yCraft = 102;
	private int MouseX;
	private int MouseY;
	private String text;
	private float RenderPartials;
	private GuiButtonChangePage nextPage;
	private GuiButtonChangePage prevPage;
	private EntityPlayer player;

	public GuiTUCSBook(EntityPlayer player) {
		this.player=player;
	}

	@Override
	public void initGui() {
		super.initGui();
		@SuppressWarnings("unchecked")
		List<GuiButton> buttons = buttonList;
		int bookXBegin = (width - 192) / 2;

		buttons.add(nextPage = new GuiButtonChangePage(BUTTON_NEXT, bookXBegin + 120, 2 + 154, false));
		buttons.add(prevPage = new GuiButtonChangePage(BUTTON_PREV, bookXBegin + 38, 2 + 154, true));
		updateButtonState();
	}


	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
		case BUTTON_NEXT:
			++pageIndex;
			break;
		case BUTTON_PREV:
			--pageIndex;
			break;
		}
		updateButtonState();
	}

	private void updateButtonState() {
		if(pageIndex == 0){
			prevPage.visible = false;
			nextPage.visible = true;
		}
		else if(pageIndex == maxPage-1){
			nextPage.visible = false;
			prevPage.visible = true;
		}
		else {
			prevPage.visible = true;
			nextPage.visible = true;
		}
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartials) {
		this.MouseX = mouseX;
		this.MouseY = mouseY;
		this.RenderPartials = renderPartials;
		int bookXStart = (width - 192) / 2;
		switch(pageIndex){
		case 0:
			drawTitle("The Ancient book", "Written by the last wise man of Cobblestoneia", bookXStart);
			break;
		case 1:
			String introductionText = "This book contains information from an ancint society, who believed that cobblestone was a gift from the gods";
			drawTitle("Introduction", introductionText, bookXStart);
			break;
		case 2:
			String  atText = "This table is used to craft the higher tier of items and tools, it has been used for many centuries to make the finest tools of stone. It is also the only table that can handle the alloy of diamonds and cobblestone";
			drawPage("Ancient Table", atText, new ItemStack(ModBlocks.ancientTable), bookXStart);
			break;
		case 3:
			drawRecipePageTop("Recipe", "This Crafting Table can also be used to vailla recipes", new ItemStack(ModBlocks.ancientTable), bookXStart);

			ItemStack gold = new ItemStack(Items.gold_ingot);
			ItemStack cobblestoneium = new ItemStack(ModItems.ingotCobblestoneium);
			ItemStack craftingTable = new ItemStack(Blocks.crafting_table);
			drawRecipePageBot(gold, false, cobblestoneium, false, gold, false, cobblestoneium, false, craftingTable, true, cobblestoneium, false, gold, false, cobblestoneium, false, gold, false, craftingTable, bookXStart);
			break;
		case 4:
			text="This alloy combines the power of iron and cobblestone to make a ingot stronger than iron. To get the ingot smelt the ore";
			drawPage("Cobblestoneium", text, new ItemStack(ModBlocks.oreCobblestoneium), bookXStart);
			break;
		case 5:
			drawRecipePageTop("Recipe", "This Material have the combined durability of iron and stone ", new ItemStack(ModBlocks.oreCobblestoneium), bookXStart);
			ItemStack rcsi1 = new ItemStack(Blocks.cobblestone);
			ItemStack rcsi2 = new ItemStack(Items.iron_ingot);
			ItemStack rcsi3 = new ItemStack(Items.gunpowder);
			ItemStack rcsi4 = new ItemStack(ModItems.cobblestoneLighter, 1, OreDictionary.WILDCARD_VALUE);
			drawRecipePageBot(rcsi1, true, rcsi2, false, null, false, rcsi3, false, rcsi4, false, null, false, null, false, null, false, null, false, new ItemStack(Blocks.crafting_table), bookXStart);
			break;
		case 6:
			text="This ingot is an alloy of iron and cobblestone";
			drawPage("Cobblestoneium", text, new ItemStack(ModItems.ingotCobblestoneium), bookXStart);
			break;
		case 7:
			text="This ingot have the combined durability of iron and stone";
			DrawFurnaceRecipe("Recipe", text, new ItemStack(ModBlocks.oreCobblestoneium), new ItemStack(ModItems.ingotCobblestoneium,2), new ItemStack(ModBlocks.blockAncientForge), bookXStart);
			break;
		default:
			mc.renderEngine.bindTexture(texture);
			this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
			super.drawScreen(mouseX, mouseY, renderPartials);
			DrawDontUnderstandPage(bookXStart);
			break;

		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return false;
	}

	@Override
	protected void keyTyped(char c, int key) {
		char lowerCase = Character.toLowerCase(c);
		if (key == Keyboard.KEY_ESCAPE) {
			mc.displayGuiScreen(null);
		}
	}

	public void drawTitle(String title, String text, int bookXStart){
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + title, bookXStart + 34, 17, 0x000000);
		this.fontRendererObj.drawSplitString("\u00A7r" + text, bookXStart + 34, 35, 120, 0x000000);
	}

	public void drawPage(String title, String text, ItemStack item, int bookXStart){
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + title, bookXStart + 52, 17, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + text, bookXStart + 34, 35, 120, 0x000000);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, item, bookXStart + 34, 15);
	}

	public void drawRecipePageTop(String title, String tip, ItemStack item, int bookXStart){
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);

		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + title, bookXStart + 52, 17, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + tip, bookXStart + 34, 35, 120, 0x000000);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, item, bookXStart + 34, 15);
	}

	public void drawRecipePageBot(ItemStack r1c1, Boolean r1c1_a_block, ItemStack r1c2, Boolean r1c2_a_block, ItemStack r1c3, Boolean r1c3_a_block, ItemStack r2c1, Boolean r2c1_a_block, ItemStack r2c2, Boolean r2c2_a_block, ItemStack r2c3, Boolean r2c3_a_block, ItemStack r3c1, Boolean r3c1_a_block, ItemStack r3c2, Boolean r3c2_a_block, ItemStack r3c3, Boolean r3c3_a_block, ItemStack crafting, int bookXStart){

		mc.renderEngine.bindTexture(textureC);
		this.drawTexturedModalRect(bookXStart + 62, 100, 28, 15, 56, 56);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, crafting, bookXStart + 35, 80);
		fontRendererObj.drawString("\u00A7r" + "\u00A7n" + "Crafted in a", bookXStart + 35, 70, 0x000000);
		fontRendererObj.drawString("\u00A7r" + crafting.getDisplayName(), bookXStart + 53, 84, 0x000000);
		
		if(r1c1_a_block && r1c1 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r1c1, bookXStart + xCraft, yCraft);
		}
		if(r1c2_a_block  && r1c2 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r1c2, bookXStart + xCraft + 18, yCraft);
		}
		if(r1c2_a_block  && r1c3 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r1c3, bookXStart + xCraft + (2*18), yCraft);
		}
		if(r2c1_a_block  && r2c1 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r2c1, bookXStart + xCraft, yCraft + 18);
		}
		if(r2c2_a_block  && r2c2 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r2c2, bookXStart + xCraft + 18, yCraft + 18);
		}
		if(r2c2_a_block  && r2c3 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r2c3, bookXStart + xCraft + (2*18), yCraft + 18);
		}
		if(r3c1_a_block  && r3c1 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r3c1, bookXStart + xCraft, yCraft + (2*18));
		}
		if(r3c2_a_block  && r3c2 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r3c2, bookXStart + xCraft + 18, yCraft + (2*18));
		}
		if(r3c2_a_block  && r3c3 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r3c3, bookXStart + xCraft + (2*18), yCraft + (2*18));
		}
		if(r1c1_a_block.equals(false)  && r1c1 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r1c1, bookXStart + xCraft, yCraft);
		}
		if(r1c2_a_block.equals(false)  && r1c2 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r1c2, bookXStart + xCraft + 18, yCraft);
		}
		if(r1c2_a_block.equals(false)  && r1c3 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r1c3, bookXStart + xCraft + (2*18), yCraft);
		}
		if(r2c1_a_block.equals(false)  && r2c1 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r2c1, bookXStart + xCraft, yCraft + 18);
		}
		if(r2c2_a_block.equals(false)  && r2c2 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r2c2, bookXStart + xCraft + 18, yCraft + 18);
		}
		if(r2c2_a_block.equals(false)  && r2c3 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r2c3, bookXStart + xCraft + (2*18), yCraft + 18);
		}
		if(r3c1_a_block.equals(false)  && r3c1 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r3c1, bookXStart + xCraft, yCraft + (2*18));
		}
		if(r3c2_a_block.equals(false)  && r3c2 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r3c2, bookXStart + xCraft + 18, yCraft + (2*18));
		}
		if(r3c2_a_block.equals(false)  && r3c3 != null){
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, r3c3, bookXStart + xCraft + (2*18), yCraft + (2*18));
		}
	}
	
	public void DrawFurnaceRecipe(String title, String tip, ItemStack input, ItemStack output, ItemStack crafting, int bookXStart){
		
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);

		
		mc.renderEngine.bindTexture(textureF);
		this.drawTexturedModalRect(bookXStart + 52, 100, 54, 15, 84, 55);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		
		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + title, bookXStart + 52, 17, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + tip, bookXStart + 34, 35, 120, 0x000000);
		
		fontRendererObj.drawString("\u00A7r" + "\u00A7n" + "Smelted in a", bookXStart + 35, 70, 0x000000);
		fontRendererObj.drawString("\u00A7r" + crafting.getDisplayName(), bookXStart + 53, 84, 0x000000);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, crafting, bookXStart + 35, 80);
		
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, input, bookXStart + 54, 102);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, output, bookXStart + 114, 120);
		itemRender.renderItemOverlayIntoGUI(fontRendererObj, mc.renderEngine, output, bookXStart + 114, 120);
		
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine, output, bookXStart + 34, 15);
		
	}
	
	public void DrawDontUnderstandPage(int bookXStart){
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + "§k" + "Youdont", bookXStart + 52, 17, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + "§k" + "you dont understand this, find a page to fully undestand this", bookXStart + 34, 35, 120, 0x000000);
	}
	
	public void DrawPageNumber(int pageNumber, int bookXStart){
		
	}
}
