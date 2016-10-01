/*
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
package de.haw.hamburg.productcomponent.accesslayer.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.haw.hamburg.productcomponent.businesslogiclayer.ProductComponentBusinessLogic;
import de.haw.hamburg.productcomponent.dataaccesslayer.dtos.ArtikelDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.ArtikelRepository;

/**
 * Description...
 *
 * @author Patrick Steinhauer
 */
@RestController
public class ProductController {

    @Autowired
    private ArtikelRepository artikelRepository;
    @Autowired
    private ProductComponentBusinessLogic productComponentBusinessLogic;

    public ProductController() {

    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<ArtikelDTO> getAllProducts() {
        List<ArtikelDTO> artikelDTOs = null;
        artikelDTOs = productComponentBusinessLogic.getAllArtikel(artikelRepository);

        return artikelDTOs;
    }
}
