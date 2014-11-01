package com.black_dog20.tucs.nei;

import com.black_dog20.tucs.nei.handlers.AncientForgeHandler;
import com.black_dog20.tucs.nei.handlers.ShapedAncientTableHandler;
import com.black_dog20.tucs.nei.handlers.ShapelessAncientTableHandler;
import com.black_dog20.tucs.reference.Reference;

import codechicken.nei.api.API;
import codechicken.nei.api.IConfigureNEI;

public class NEITucsConfig implements IConfigureNEI{

	@Override
	public void loadConfig(){

		API.registerRecipeHandler(new ShapedAncientTableHandler());
		API.registerUsageHandler(new ShapedAncientTableHandler());
		API.registerRecipeHandler(new ShapelessAncientTableHandler());
		API.registerUsageHandler(new ShapelessAncientTableHandler());

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
