package com.tanktrouble.game.configuration;

public final class Settings {
	private static Settings currentConfig;
	static{
		currentConfig = new Settings();
//		currentConfig.loadFromJSON("");
	}
	
	public static Settings getCurrentConfiguration(){
		return currentConfig;
	}
	
	//Default values
	private final int width = 1280;
	private final int height = 720;
	private final boolean vsync = false;
	
	public int getWidth(){ 
		return this.width; 
	}
	public int getHeight(){ 
		return this.height; 
	}
	public boolean getVsync(){
		return this.vsync;
	}
	
	
}
