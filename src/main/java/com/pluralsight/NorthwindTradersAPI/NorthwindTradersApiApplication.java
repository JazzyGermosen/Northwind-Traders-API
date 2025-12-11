package com.pluralsight.NorthwindTradersAPI;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NorthwindTradersApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
        if (args.length != 2){
            System.out.println("need username and password");
            System.exit(1);

        }

        System.setProperty("dbUsername", args[0]);
        System.setProperty("dbPassword", args[1]);

        SpringApplication.run(NorthwindTradersApiApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        // adding code to run after the start up
        System.out.println("Darkness is no longer my friend <3");
    }
}
