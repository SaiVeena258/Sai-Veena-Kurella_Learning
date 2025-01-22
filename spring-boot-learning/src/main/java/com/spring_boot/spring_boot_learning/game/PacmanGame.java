package com.spring_boot.spring_boot_learning.game;

public class PacmanGame implements GamingConsole{

    public void up() {
		System.out.println("Move up");
	}

	public void down() {
		System.out.println("Move down");
	}
	
	public void left() {
		System.out.println("Grab coins towards left");
	}

	public void right() {
		System.out.println("Grab coins towards right");
	}

}


