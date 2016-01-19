package com.black_dog20.tucs.client.gui;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ShapedRecipes;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.input.Keyboard;

import com.black_dog20.tucs.crafting.AncientTableManager;
import com.black_dog20.tucs.crafting.AncientTableShapedRecipes;
import com.black_dog20.tucs.crafting.AncientTableShapelessRecipes;
import com.black_dog20.tucs.init.ModBlocks;
import com.black_dog20.tucs.init.ModItems;

public class GuiTUCSBook extends GuiScreen {
	static final ResourceLocation texture = new ResourceLocation(
			"minecraft:textures/gui/book.png");
	static final ResourceLocation textureC = new ResourceLocation(
			"minecraft:textures/gui/container/crafting_table.png");
	static final ResourceLocation textureF = new ResourceLocation(
			"minecraft:textures/gui/container/furnace.png");
	private List MCList = CraftingManager.getInstance().getRecipeList();
	private List TUCSList = AncientTableManager.getInstance().getRecipeList();
	Block craftingB;

	private static final int BUTTON_NEXT = 0;
	private static final int BUTTON_PREV = 1;

	private int pageIndex = 0;
	private int maxPage = 40;
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
		this.player = player;

	}

	@Override
	public void initGui() {
		super.initGui();
		@SuppressWarnings("unchecked")
		List<GuiButton> buttons = buttonList;
		int bookXBegin = (width - 192) / 2;

		buttons.add(nextPage = new GuiButtonChangePage(BUTTON_NEXT,
				bookXBegin + 120, 2 + 154, false));
		buttons.add(prevPage = new GuiButtonChangePage(BUTTON_PREV,
				bookXBegin + 38, 2 + 154, true));
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
		if (pageIndex == 0) {
			prevPage.visible = false;
			nextPage.visible = true;
		} else if (pageIndex == maxPage - 1) {
			nextPage.visible = false;
			prevPage.visible = true;
		} else {
			prevPage.visible = true;
			nextPage.visible = true;
		}
	}

	public void onGuiClosed() {
		super.onGuiClosed();
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartials) {
		this.MouseX = mouseX;
		this.MouseY = mouseY;
		this.RenderPartials = renderPartials;
		int bookXStart = (width - 192) / 2;
		switch (pageIndex) {
		case 0:
			drawTitle("The Ancient book",
					"Written by the last wise man of Cobblestoneia", bookXStart);
			break;
		case 1:
			String introductionText = "This book contains information from an ancint society, who believed that cobblestone was a gift from the gods";
			drawTitle("Introduction", introductionText, bookXStart);
			break;
		case 2:
			text = "This table is used to craft the higher tier of items and tools, it has been used for many centuries to make the finest tools of stone. It is also the only table that can handle the alloy of diamonds and cobblestone";
			drawPage("Ancient Table", text, new ItemStack(
					ModBlocks.ancientTable), bookXStart);
			break;
		case 3:
			text = "This Crafting Table can also be used to vailla recipes";
			drawRecipePageBot(new ItemStack(ModBlocks.ancientTable), text,
					bookXStart);
			break;
		case 4:
			text = "The book which has the magic properties to hold all the knowledge you have found out about Cobblestoneia and it's traditions";
			drawPage("The Ancient book", text,
					new ItemStack(ModItems.TUCSbook), bookXStart);
			break;
		case 5:
			text = "This book kan be crafted so you never lose the knowledge of the ancint society";
			drawRecipePageBot(new ItemStack(ModItems.TUCSbook), text,
					bookXStart);
			break;
		case 6:
			text = " \nThis Lighter can be used like a flint and steel";
			drawPage("Cobblestone Lighter", text, new ItemStack(
					ModItems.cobblestoneLighter), bookXStart);
			break;
		case 7:
			text = "It can be used in crafting";
			drawRecipePageBot(new ItemStack(ModItems.cobblestoneLighter), text,
					bookXStart);
			break;
		case 8:
			text = "\nThis Lighter can be used like a flint and steel";
			drawPage("Cobblestoneium Lighter", text, new ItemStack(
					ModItems.cobblestoneiumLighter), bookXStart);
			break;
		case 9:
			text = "It can be used in crafting, more durability than a Cobblestone Lighter";
			drawRecipePageBot(new ItemStack(ModItems.cobblestoneiumLighter),
					text, bookXStart);
			break;
		case 10:
			text = "\nThis Lighter can be used like a flint and steel";
			drawPage("Cobblestonedium Lighter", text, new ItemStack(
					ModItems.cobblestonediumLighter), bookXStart);
			break;
		case 11:
			text = "It can be used in crafting, it can't be broken";
			drawRecipePageBot(new ItemStack(ModItems.cobblestonediumLighter),
					text, bookXStart);
			break;
		case 12:
			text = "This alloy combines the power of iron and cobblestone to make a ingot stronger than iron. To get the ingot smelt the ore \nAny Lighter made of cobblestone or it's alloys will also work ";
			drawPage("Cobblestoneium", text, new ItemStack(
					ModBlocks.oreCobblestoneium), bookXStart);
			break;
		case 13:
			text = "This Material have the combined durability of iron and stone ";
			drawRecipePageBot(new ItemStack(ModBlocks.oreCobblestoneium), text,
					bookXStart);
			break;
		case 14:
			text = "This ingot is an alloy of iron and cobblestone";
			drawPage("Cobblestoneium", text, new ItemStack(
					ModItems.ingotCobblestoneium), bookXStart);
			break;
		case 15:
			text = "This ingot have the combined durability of iron and stone";
			DrawFurnaceRecipe("Recipe", text, new ItemStack(
					ModBlocks.oreCobblestoneium), new ItemStack(
					ModItems.ingotCobblestoneium, 2), new ItemStack(
					ModBlocks.blockAncientForge), bookXStart);
			break;
		case 16:
			text = "This ingot is an alloy of diamond and cobblestone";
			drawPage("Cobblestonedium", text, new ItemStack(
					ModItems.ingotCobblestonedium), bookXStart);
			break;
		case 17:
			text = "This ingot have the combined durability of diamond and stone";
			drawRecipePageBot(new ItemStack(ModItems.ingotCobblestonedium),
					text, bookXStart);
			break;
		case 18:
			text = "This ingot is just stone and dye. You wil get 2 pr crafting";
			drawPage(
					new ItemStack(ModItems.ingotYellowstoneium)
							.getDisplayName(),
					text, new ItemStack(ModItems.ingotYellowstoneium),
					bookXStart);
			break;
		case 19:
			text = "This ingot is kind of plain an nice to craft with";
			drawRecipePageBot(new ItemStack(ModItems.ingotYellowstoneium, 2),
					text, bookXStart);
			break;
		case 20:
			text = "\nThis sword has the power of the legendary fighter";
			ItemStack sword = new ItemStack(ModItems.TLSOC);
			drawPage(sword.getDisplayName(), text,
					new ItemStack(ModItems.TLSOC), bookXStart);
			break;
		case 21:
			text = "This sword is crafted by the finest materials ever known";
			drawRecipePageBot(new ItemStack(ModItems.SwordBlade), text,
					bookXStart);
			break;
		case 22:
			text = "To finaly complete this legendary sword you will need a hilt";
			drawRecipePageBot(new ItemStack(ModItems.SwordHilt), text,
					bookXStart);
			break;
		case 23:
			text = "To make you'r legendary tools you will need a tool rod";
			ItemStack toolRod = new ItemStack(ModItems.toolRod);
			drawPage(toolRod.getDisplayName(), text, new ItemStack(
					ModItems.toolRod), bookXStart);
			break;
		case 24:
			text = "The tool rod will make any ordinary tool legendary";
			drawRecipePageBot(new ItemStack(ModItems.toolRod), text, bookXStart);
			break;
		case 25:
			text = "\nThis legendary pickaxe was used by the lost miner";
			ItemStack pickaxe = new ItemStack(ModItems.TLPOLM);
			drawPage(pickaxe.getDisplayName(), text, new ItemStack(
					ModItems.TLPOLM), bookXStart);
			break;
		case 26:
			text = "This legendary pickaxe will serve you through good and bad times";
			drawRecipePageBot(new ItemStack(ModItems.pickaxeHead), text,
					bookXStart);
			break;
		case 27:
			text = "\nThe legendary hoe can be upgraded to help you in ways you can't yet understand";
			ItemStack hoe = new ItemStack(ModItems.TLHOWF);
			drawPage(hoe.getDisplayName(), text,
					new ItemStack(ModItems.TLHOWF), bookXStart);
			break;
		case 28:
			text = "The legendary hoe will make farming a breeze";
			drawRecipePageBot(new ItemStack(ModItems.hoeHead), text, bookXStart);
			break;
		case 29:
			text = "\nThe legendary BattleAxe will slay you'r enemies like anything you have ever seen";
			ItemStack battle = new ItemStack(ModItems.TLBOTB);
			drawPage(battle.getDisplayName(), text, new ItemStack(
					ModItems.TLBOTB), bookXStart);
			break;
		case 30:
			text = "The legendary BattleAxe was first used by The Legendary Battle Master";
			drawRecipePageBot(new ItemStack(ModItems.hatchetHead), text,
					bookXStart);
			break;
		case 31:
			text = "\nThis legendary shovel has made digging holes easier than ever";
			ItemStack shovel = new ItemStack(ModItems.TLSOHD);
			drawPage(shovel.getDisplayName(), text, shovel, bookXStart);
			break;
		case 32:
			text = "The legendary shovel was first seen in the late 90's";
			drawRecipePageBot(new ItemStack(ModItems.shovelHead), text,
					bookXStart);
			break;
		case 33:
			text = "\nThis is the legendary Talisman of flight which was given by the semi god of Norway!";
			ItemStack flightTalisman = new ItemStack(ModItems.FlightTalisman);
			drawPage(flightTalisman.getDisplayName(), text, flightTalisman,
					bookXStart);
			break;
		case 34:
			text = "To make the talisman you first need to make a talisman base";
			drawRecipePageBot(new ItemStack(ModItems.talismanBaseT1), text,
					bookXStart);
			break;
		case 35:
			text = "Then you will need to make the tier2 base!";
			drawRecipePageBot(new ItemStack(ModItems.TalismanBase), text,
					bookXStart);
			break;
		case 36:
			text = "After that you will need to make the unfinished flight talisman";
			drawRecipePageBot(new ItemStack(ModItems.UnfinshedFlightTalisman),
					text, bookXStart);
			break;
		case 37:
			text = "This is the last thing you will need to make i promise";
			drawRecipePageBot(new ItemStack(ModItems.ungoldenFligtTalisman),
					text, bookXStart);
			break;
		case 38:
			text = "Oh wait there is actually one last step";
			drawRecipePageBot(new ItemStack(ModItems.FlightTalisman), text,
					bookXStart);
			break;
		default:
			mc.renderEngine.bindTexture(texture);
			this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
			super.drawScreen(MouseX, MouseY, RenderPartials);
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
			mc.thePlayer.closeScreen();
		}
	}

	public void drawTitle(String title, String text, int bookXStart) {
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + title,
				bookXStart + 34, 17, 0x000000);
		this.fontRendererObj.drawSplitString("\u00A7r" + text, bookXStart + 34,
				35, 120, 0x000000);
	}

	public void drawPage(String title, String text, ItemStack item,
			int bookXStart) {
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		fontRendererObj.drawSplitString("\u00A7l" + "\u00A7n" + title,
				bookXStart + 52, 17, 100, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + text, bookXStart + 34, 35,
				120, 0x000000);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine,
				item, bookXStart + 34, 15);
	}

	public void drawRecipePageTop(int bookXStart) {
		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);
	}

	public void drawRecipePageBot(ItemStack item, String tip, int bookXStart) {
		drawRecipePageTop(bookXStart);
		ItemStack[] list = null;
		List listSL = null;
		mc.renderEngine.bindTexture(textureC);
		this.drawTexturedModalRect(bookXStart + 62, 100, 28, 15, 56, 56);
		super.drawScreen(MouseX, MouseY, RenderPartials);
		Object obj = test(item);
		if (obj instanceof ItemStack[]) {
			list = (ItemStack[]) obj;
		} else if (obj instanceof List) {
			listSL = (List) obj;
		}

		ItemStack crafting = new ItemStack(craftingB);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine,
				crafting, bookXStart + 35, 80);
		fontRendererObj.drawString("\u00A7r" + "\u00A7n" + "Crafted in a",
				bookXStart + 35, 70, 0x000000);
		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + "Recipe",
				bookXStart + 52, 17, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + tip, bookXStart + 34, 35,
				120, 0x000000);
		fontRendererObj.drawString("\u00A7r" + crafting.getDisplayName(),
				bookXStart + 53, 84, 0x000000);

		if (item.getItem() instanceof ItemBlock) {
			itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
					mc.renderEngine, item, bookXStart + 34, 15);
		}
		int counter = 0;
		int j = 0;
		int k = 0;
		if (list != null) {
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null && list[i].getItem() instanceof ItemBlock) {
					itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
							mc.renderEngine, list[i], bookXStart + xCraft
									+ (k * 18), yCraft + (j * 18));
				}
				counter++;
				k++;
				if (counter == 3) {
					j++;
					k = 0;
					counter = 0;
				}
			}
			if (!(item.getItem() instanceof ItemBlock)) {
				itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
						mc.renderEngine, item, bookXStart + 34, 15);
			}
			counter = 0;
			j = 0;
			k = 0;
			for (int i = 0; i < list.length; i++) {
				if (list[i] != null
						&& !(list[i].getItem() instanceof ItemBlock)) {
					itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
							mc.renderEngine, list[i], bookXStart + xCraft
									+ (k * 18), yCraft + (j * 18));
				}
				counter++;
				k++;
				if (counter == 3) {
					j++;
					k = 0;
					counter = 0;
				}
			}
		} else if (listSL != null) {
			for (int i = 0; i < listSL.size(); i++) {
				if (listSL.get(i) != null
						&& ((ItemStack) listSL.get(i)).getItem() instanceof ItemBlock) {
					itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
							mc.renderEngine, (ItemStack) listSL.get(i),
							bookXStart + xCraft + (k * 18), yCraft + (j * 18));
				}
				counter++;
				k++;
				if (counter == 3) {
					j++;
					k = 0;
					counter = 0;
				}
			}
			if (!(item.getItem() instanceof ItemBlock)) {
				itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
						mc.renderEngine, item, bookXStart + 34, 15);
			}
			counter = 0;
			j = 0;
			k = 0;
			for (int i = 0; i < listSL.size(); i++) {
				if (listSL.get(i) != null
						&& !(((ItemStack) listSL.get(i)).getItem() instanceof ItemBlock)) {
					itemRender.renderItemAndEffectIntoGUI(fontRendererObj,
							mc.renderEngine, (ItemStack) listSL.get(i),
							bookXStart + xCraft + (k * 18), yCraft + (j * 18));
				}
				counter++;
				k++;
				if (counter == 3) {
					j++;
					k = 0;
					counter = 0;
				}
			}
		}
	}

	public void DrawFurnaceRecipe(String title, String tip, ItemStack input,
			ItemStack output, ItemStack crafting, int bookXStart) {

		mc.renderEngine.bindTexture(texture);
		this.drawTexturedModalRect(bookXStart, 2, 0, 0, 192, 192);
		super.drawScreen(MouseX, MouseY, RenderPartials);

		mc.renderEngine.bindTexture(textureF);
		this.drawTexturedModalRect(bookXStart + 52, 100, 54, 15, 84, 55);
		super.drawScreen(MouseX, MouseY, RenderPartials);

		fontRendererObj.drawString("\u00A7l" + "\u00A7n" + title,
				bookXStart + 52, 17, 0x000000);
		fontRendererObj.drawSplitString("\u00A7r" + tip, bookXStart + 34, 35,
				120, 0x000000);

		fontRendererObj.drawString("\u00A7r" + "\u00A7n" + "Smelted in a",
				bookXStart + 35, 70, 0x000000);
		fontRendererObj.drawString("\u00A7r" + crafting.getDisplayName(),
				bookXStart + 53, 84, 0x000000);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine,
				crafting, bookXStart + 35, 80);

		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine,
				input, bookXStart + 54, 102);
		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine,
				output, bookXStart + 114, 120);
		itemRender.renderItemOverlayIntoGUI(fontRendererObj, mc.renderEngine,
				output, bookXStart + 114, 120);

		itemRender.renderItemAndEffectIntoGUI(fontRendererObj, mc.renderEngine,
				output, bookXStart + 34, 15);

	}

	public void DrawPageNumber(int pageNumber, int bookXStart) {

	}

	public Object test(ItemStack testItem) {
		Object itemList = null;
		for (int i = 0; i < this.TUCSList.size(); i++) {
			IRecipe irecipe = (IRecipe) this.TUCSList.get(i);
			ItemStack item = null;
			if (irecipe != null) {
				item = irecipe.getRecipeOutput();
			}

			if (item != null && item.areItemStacksEqual(item, testItem)) {
				if (irecipe instanceof AncientTableShapedRecipes) {
					AncientTableShapedRecipes recipe = (AncientTableShapedRecipes) irecipe;
					itemList = recipe.recipeItems;
				}
				if (irecipe instanceof AncientTableShapelessRecipes) {
					AncientTableShapelessRecipes recipe = (AncientTableShapelessRecipes) irecipe;
					itemList = recipe.recipeItems;
				}
				craftingB = ModBlocks.ancientTable;
			}
		}
		for (int j = 0; j < this.MCList.size(); ++j) {
			IRecipe irecipeMC = (IRecipe) this.MCList.get(j);
			ItemStack itemMC = null;
			if (irecipeMC != null) {
				itemMC = irecipeMC.getRecipeOutput();
			}
			if (itemMC != null && itemMC.areItemStacksEqual(itemMC, testItem)) {
				if (irecipeMC instanceof ShapelessRecipes) {
					ShapelessRecipes recipe = (ShapelessRecipes) irecipeMC;
					itemList = recipe.recipeItems;

				}
				if (irecipeMC instanceof ShapedRecipes) {
					ShapedRecipes recipe = (ShapedRecipes) irecipeMC;
					itemList = recipe.recipeItems;
				}
				craftingB = Blocks.crafting_table;
			}
		}

		return itemList;
	}

}
