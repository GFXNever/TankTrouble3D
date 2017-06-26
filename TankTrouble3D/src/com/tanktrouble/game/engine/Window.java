package com.tanktrouble.game.engine;

import org.lwjgl.*;
import org.lwjgl.glfw.*;
import org.lwjgl.opengl.*;
import org.lwjgl.system.*;

import java.nio.*;

import static org.lwjgl.glfw.Callbacks.*;
import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryStack.*;
import static org.lwjgl.system.MemoryUtil.*;


public class Window {
	
	public final int NUM_OF_KEYS = 1024;
	
	// Constructors
	public Window(String title,int width,int height,boolean vsync){
		// Init fields
		this.title = title;
		this.width = width;
		this.height = height;
		this.vsync = vsync;
		this.keys = new boolean[1024];
		// Set all keys to not pressed
		for(int i=0; i< NUM_OF_KEYS ; i++){
			keys[i] = false;
		}
		// Init GLFW and Create Window
		init();
	}
	
	// Helpers
	private void init(){
		// Configure GLFW
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window will be resizable

		// Create the window
		this.handle = glfwCreateWindow(this.width, this.height, this.title, NULL, NULL);
		if ( this.handle == NULL )
			throw new RuntimeException("Failed to create the GLFW window");
		
		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(this.handle, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
		});
		
		// Make the OpenGL context current
		glfwMakeContextCurrent(handle);
		
		// Enable v-sync
		if(this.vsync){
			glfwSwapInterval(1);
		}
	}
	
	// Mutators
	public void setKeyState(int keyCode,boolean state){
		keys[keyCode] = state;
	}
	public void show(){
		// Make the window visible
		glfwShowWindow(handle);
	}
	public void cleanup(){
		// Free the window callbacks and destroy the window
		glfwFreeCallbacks(handle);
		glfwDestroyWindow(handle);
	}
	
	// Getters
	public long getWindow(){
		return this.handle;
	}
	public float getWidth(){
		return this.width;
	}
	public float getHeight(){
		return this.height;
	}
	public boolean shouldClose(){
		return glfwWindowShouldClose(handle);
	}
	public boolean isKeyPressed(int keyCode) {
		return keys[keyCode];
	}
	
	// Fields
	private long handle;
	private String title;
	private int width;
	private int height;
	private boolean vsync;
	//TODO: Use Enum instead of boolean?
	private boolean[] keys;
	
}
