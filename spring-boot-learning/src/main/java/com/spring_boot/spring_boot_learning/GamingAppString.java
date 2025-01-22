package com.spring_boot.spring_boot_learning;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring_boot.spring_boot_learning.game.GameRunner;
import com.spring_boot.spring_boot_learning.game.GamingConsole;
// import com.spring_boot.spring_boot_learning.game.PacmanGame;


@Configuration
@ComponentScan("com.spring_boot.spring_boot_learning.game")

public class GamingAppString {
	public static void main(String[] args) {

		try(var context=
		    new AnnotationConfigApplicationContext
			    (GamingAppString.class)){

					context.getBean(GamingConsole.class).up();
					context.getBean(GameRunner.class).run();

				}

		}
}
