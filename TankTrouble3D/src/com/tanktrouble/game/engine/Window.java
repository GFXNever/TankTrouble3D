package com.tanktrouble.game.engine;


public class Window {

	Window(float width,float height){
		this.width = width;
		this.height = height;
		
		// Configure GLFW
		glfwDefaultWindowHints(); // optional, the current window hints are already the default
		glfwWindowHint(GLFW_VISIBLE, GLFW_FALSE); // the window will stay hidden after creation
		glfwWindowHint(GLFW_RESIZABLE, GLFW_TRUE); // the window will be resizable

		// Create the window
		handle = glfwCreateWindow(300, 300, "Hello World!", NULL, NULL);
	}
	
	// The window handle
	private long handle;
	private float width;
	private float height;
	
	
}
