package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by patrick_steinhauer on 30.09.2016.
 */
public interface ArtikelRepository extends CrudRepository<Artikel, Long> {

    /**
     * @param artikelNummer This is the given ID for which the related article should be found.
     * @return Returns an artikel.
     */
    Artikel findByArtikelNummer(long artikelNummer);

}
