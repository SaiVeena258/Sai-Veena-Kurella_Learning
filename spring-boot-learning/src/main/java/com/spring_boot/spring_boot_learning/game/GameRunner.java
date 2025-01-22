package com.spring_boot.spring_boot_learning.game;

import org.springframework.stereotype.Component;

@Component
public class GameRunner {

	private GamingConsole game;
	
	public GameRunner(GamingConsole game) {
		this.game = game;
	}

	public void run() {
		
		System.out.println("Running game: " + game);
		game.up();
		game.down();
		game.left();
		game.right();
		
	}

}
