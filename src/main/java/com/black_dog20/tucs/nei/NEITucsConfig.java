package com.black_dog20.tucs.nei;

import mcp.mobius.waila.Waila;
import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;
import codechicken.nei.recipe.DefaultOverlayHandler;

import com.black_dog20.tucs.client.gui.GuiAncientTable;
import com.black_dog20.tucs.nei.handlers.AncientForgeHandler;
import com.black_dog20.tucs.nei.handlers.ShapedAncientTableHandler;
import com.black_dog20.tucs.nei.handlers.ShapelessAncientTableHandler;
import com.black_dog20.tucs.reference.Reference;

public class NEITucsConfig implements IConfigureNEI{

	@Override
	public void loadConfig(){

		API.registerRecipeHandler(new ShapedAncientTableHandler());
		API.registerUsageHandler(new ShapedAncientTableHandler());
		API.registerRecipeHandler(new ShapelessAncientTableHandler());
		API.registerUsageHandler(new ShapelessAncientTableHandler());
		API.registerGuiOverlay(GuiAncientTable.class, "crafting",5,11);
        API.registerGuiOverlayHandler(GuiAncientTable.class, new DefaultOverlayHandler(5,11), "crafting");
        API.registerGuiOverlayHandler(GuiAncientTable.class, new DefaultOverlayHandler(5,11), Reference.MOD_ID+"AncientTable");
		API.registerRecipeHandler(new AncientForgeHandler());

	 }

	@Override
	public String getName() {
		return Reference.MOD_NAME;
	}

	@Override
	public String getVersion() {
		return Reference.VERSION;
	}
	
}