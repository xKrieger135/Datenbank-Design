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
package de.haw.hamburg.productcomponent.businesslogiclayer;

import de.haw.hamburg.productcomponent.dataaccesslayer.dtos.ArtikelDTO;
import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.ArtikelRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Description...
 *
 * @author $(USER)
 * @company Werum IT Solutions GmbH
 * @created $(DATE)
 * @since PAS-X V3.2.1
 */
@Component
public class ProductComponentBusinessLogic {

    public ProductComponentBusinessLogic() {

    }

    public List<ArtikelDTO> getAllArtikel(ArtikelRepository artikelRepository) {
        List<ArtikelDTO> artikelDTOs = new ArrayList<ArtikelDTO>();
        for (Artikel artikel : artikelRepository.findAll()) {
            artikelDTOs.add(artikel.convertToArtikelDTO());
        }
        return artikelDTOs;
    }
}
