package de.haw.hamburg;

import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.ArtikelRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main entry point to start the application.
 *
 * @author Patrick Steinhauer
 *
 *
 */
@SpringBootApplication
@ComponentScan("de.haw.hamburg")
public class Main {

    @Bean
    public ArtikelRepository artikelRepository(ArtikelRepository artikelRepository) {
        return artikelRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
