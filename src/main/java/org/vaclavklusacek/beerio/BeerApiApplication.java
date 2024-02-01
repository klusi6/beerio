package org.vaclavklusacek.beerio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vaclavklusacek.beerio.service.BeerService;

/**
 * BeerApiApplication is the main entry point for the Spring Boot application.
 * It implements CommandLineRunner to run specific code at application startup.
 */
@SpringBootApplication
public class BeerApiApplication implements CommandLineRunner {

    private final BeerService beerService;

    /**
     * Constructor for the BeerApiApplication.
     *
     * @param beerService The BeerService to use for loading beers at startup.
     */
    public BeerApiApplication(BeerService beerService){
        this.beerService = beerService;
    }

    /**
     * The main method that starts the Spring Boot application.
     *
     * @param args The command line arguments.
     */
    public static void main(String[] args){
        SpringApplication.run(BeerApiApplication.class, args);
    }

    /**
     * This method is run at application startup.
     * It uses the BeerService to load beers.
     *
     * @param args The command line arguments.
     */
    @Override
    public void run(String... args)  {
        beerService.loadBeers();
    }
}