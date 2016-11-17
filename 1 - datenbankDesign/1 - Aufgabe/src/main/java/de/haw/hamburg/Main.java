package de.haw.hamburg;

import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.ArtikelRepository;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.GeschaeftspartnerRepository;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.KundenRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the main entry point to start the application.
 *
 * @author Patrick Steinhauer
 */
@SpringBootApplication
@ComponentScan("de.haw.hamburg")
public class Main {

    @Bean
    public ArtikelRepository artikelRepository(ArtikelRepository artikelRepository) {
        return artikelRepository;
    }

    @Bean
    public GeschaeftspartnerRepository geschaeftspartnerRepository(GeschaeftspartnerRepository geschaeftspartnerRepository) {
        return geschaeftspartnerRepository;
    }

    @Bean
    public KundenRepository kundenRepository(KundenRepository kundenRepository) {
        return kundenRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
