package com.tanktrouble.game;

import com.tanktrouble.game.reference.References;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWErrorCallback;

import com.tanktrouble.game.configuration.Settings;
import com.tanktrouble.game.engine.Window;

public class TankTrouble {
	private Window window;
//	private RenderingEngine renderEngine;
	
	private boolean isGameRunning;
	
	public TankTrouble() {
		Settings currentConfig = Settings.getCurrentConfiguration();
		initGLFW();
		this.window = new Window(References.TITLE, currentConfig.getWidth(), currentConfig.getHeight(), currentConfig.getVsync());
//		this.renderEngine = new RenderingEngine(window);
	}

	private void initGLFW() {
		GLFWErrorCallback.createPrint(System.err).set();
		if(!GLFW.glfwInit()){
			throw new IllegalStateException("TankTrouble::[ERROR] Unable to initialize GLFW!");
		}		
	}

	public void handleGame() {
		this.window.show();
//		initGame();
		
		run();
		cleanup();
	}
	
	private void run(){
		isGameRunning = true;
		while(isGameRunning && !window.shouldClose()){

		}
	}
	
	private void cleanup(){
		GLFW.glfwTerminate();
		GLFW.glfwSetErrorCallback(null).free();
	}

}
