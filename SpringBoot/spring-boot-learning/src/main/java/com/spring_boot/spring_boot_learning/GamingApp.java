package com.spring_boot.spring_boot_learning;

import com.spring_boot.spring_boot_learning.game.GameRunner;
import com.spring_boot.spring_boot_learning.game.PacmanGame;

public class GamingApp {

	public static void main(String[] args) {

		var game=new PacmanGame();
		var gameRunner = new GameRunner(game);
		gameRunner.run();
	}

}
