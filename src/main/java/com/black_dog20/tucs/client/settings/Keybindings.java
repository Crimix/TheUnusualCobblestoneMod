package com.black_dog20.tucs.client.settings;

import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import com.black_dog20.tucs.reference.Names;

public class Keybindings {
	
	 public static KeyBinding fly = new KeyBinding(Names.Keys.FLY, Keyboard.KEY_F, Names.Keys.CATEGORY);
	 public static KeyBinding flyspeed = new KeyBinding(Names.Keys.FLYSPEED, Keyboard.KEY_V, Names.Keys.CATEGORY);
	 public static KeyBinding night = new KeyBinding(Names.Keys.NIGHT, Keyboard.KEY_N, Names.Keys.CATEGORY);

}
