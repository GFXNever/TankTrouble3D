package com.tanktrouble.game;

public class Main implements Runnable{
	public static void main(String[] args){
		setNatives();
		new Thread(new Main()).start();
	}

	@Override
	public void run() {
		TankTrouble gameObj = new TankTrouble();
		gameObj.handleGame();
	}
	
	private static void setNatives(){
		System.setProperty("org.lwjgl.librarypath", "/libs/");
		System.setProperty("org.lwjgl.assimp.librarypath", "/libs/");
		System.setProperty("org.lwjgl.glfw.librarypath", "/libs/");
		System.setProperty("org.lwjgl.opengl.librarypath", "/libs/");
		
	}
}
