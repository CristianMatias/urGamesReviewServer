package com.gamesreview.server;

import com.gamesreview.server.controller.MockController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = MockController.class)
public class UrGamesReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrGamesReviewApplication.class, args);
	}

}
