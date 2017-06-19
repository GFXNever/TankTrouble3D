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
	
	private Settings(){
		this.width = 1280;
		this.height = 720;
		this.vsync = false;
	}
	
	private final int width;
	private final int height;
	private final boolean vsync;
	
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
