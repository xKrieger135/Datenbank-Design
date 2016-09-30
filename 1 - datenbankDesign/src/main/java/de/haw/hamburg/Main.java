package de.haw.hamburg;/*
 * This file is part of a Werum IT Solutions GmbH project.
 *
 * Copyright (c)
 *    Werum IT Solutions GmbH
 *    All rights reserved.
 *
 * This source file may be managed in different Java package structures,
 * depending on actual usage of the source file by the Copyright holders:
 *
 * for Werum:  com.werum.* or any other Werum owned Internet domain
 *
 * Any use of this file as part of a software system by none Copyright holders
 * is subject to license terms.
 *
 * Last Change: $Id: $$
 */

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
