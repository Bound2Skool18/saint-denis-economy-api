package com.saintdenis.economy;

import com.saintdenis.economy.model.TraderPrice;
import com.saintdenis.economy.repository.TraderPriceRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EconomyApiApplication {

    private final TraderPriceRepository traderPriceRepository;

    EconomyApiApplication(TraderPriceRepository traderPriceRepository) {
        this.traderPriceRepository = traderPriceRepository;
    }

	public static void main(String[] args) {
		SpringApplication.run(EconomyApiApplication.class, args);
	}

	@Bean
	CommandLineRunner
	initDatabase(TraderPriceRepository repository) {
		return args -> {
			repository.save(new TraderPrice("Moonshine", 30.0, 80.0, 15));
			repository.save(new TraderPrice("Trader Wagon Delivery", 50.0, 175.0, 25));
			repository.save(new TraderPrice("Collectibles", 10.0, 45.0, 10));
			
			System.out.println("Database initialized with trader prices!");
		};
	}

}
