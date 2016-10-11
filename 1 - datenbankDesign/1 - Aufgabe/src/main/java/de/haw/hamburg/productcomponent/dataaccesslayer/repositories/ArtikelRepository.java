package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import org.springframework.data.repository.CrudRepository;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;

/**
 * Created by patrick_steinhauer on 30.09.2016.
 */
public interface ArtikelRepository extends CrudRepository<Artikel, Long> {

    /**
     *
     * @param artikelID This is the given ID for which the related article should be found.
     * @return Returns an artikel.
     */
    Artikel findByArtikelID(long artikelID);

}
