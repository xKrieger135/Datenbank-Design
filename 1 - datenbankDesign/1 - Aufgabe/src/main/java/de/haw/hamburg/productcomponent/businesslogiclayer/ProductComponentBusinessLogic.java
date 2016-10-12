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
 * @author Patrick Steinhauer
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
