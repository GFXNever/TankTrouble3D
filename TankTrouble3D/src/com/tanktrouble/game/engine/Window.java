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
	
	// Constructors
	public Window(int width,int height,boolean vsync){
		// Init fields
		this.width = width;
		this.height = height;
		this.vsync = vsync;
		// Init GLFW and Create Window
		init();
	}
	
	private void init(){
		// Configure GLFW
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_FALSE); // the window will be resizable

		// Create the window
		this.handle = glfwCreateWindow(this.width, this.height, "Hello World!", NULL, NULL);
		if ( this.handle == NULL )
			throw new RuntimeException("Failed to create the GLFW window");
		
		// Setup a key callback. It will be called every time a key is pressed, repeated or released.
		glfwSetKeyCallback(this.handle, (window, key, scancode, action, mods) -> {
			if ( key == GLFW_KEY_ESCAPE && action == GLFW_RELEASE )
				glfwSetWindowShouldClose(window, true); // We will detect this in the rendering loop
		});
		
		// Make the OpenGL context current
		glfwMakeContextCurrent(handle);
		
		if(this.vsync){
			// Enable v-sync
			glfwSwapInterval(1);
		}

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
	
	// Fields
	private long handle;
	private int width;
	private int height;
	private boolean vsync;
	
}
