package com.black_dog20.tucs.nei;

import com.black_dog20.tucs.reference.Reference;

import codechicken.nei.api.IConfigureNEI;

public class NEITucsConfig  implements IConfigureNEI{

	@Override
	public String getName() {
		return Reference.MOD_NAME;
	}

	@Override
	public String getVersion() {
		return Reference.VERSION;
	}

	@Override
	public void loadConfig() {
		// TODO Auto-generated method stub
		
	}

}
