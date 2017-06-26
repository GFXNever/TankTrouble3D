package com.tanktrouble.game;

import com.tanktrouble.game.log.Logger;

import java.io.File;
import java.io.IOException;

public class Main implements Runnable{
	public static void main(String[] args){
		setNatives();
		new Thread(new Main()).start();
	}

	@Override
	public void run() {
		Logger.initializeLogger();
		TankTrouble gameObj = new TankTrouble();
		gameObj.handleGame();
	}

	private static void setNatives(){
		System.setProperty("java.library.path", "natives/");
		System.setProperty("org.lwjgl.librarypath", "natives/");
		System.setProperty("org.lwjgl.assimp.librarypath", "natives/");
		System.setProperty("org.lwjgl.glfw.librarypath", "natives/");
		System.setProperty("org.lwjgl.opengl.librarypath", "natives/");
	}
}
