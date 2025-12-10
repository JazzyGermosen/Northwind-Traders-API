package com.pluralsight.NorthwindTradersAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NorthwindTradersApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(NorthwindTradersApiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // adding code to run after the start up
        System.out.println("Darkness is no longer my friend <3");
    }
}
