package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import org.springframework.data.repository.CrudRepository;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;

/**
 * Created by patrick_steinhauer on 30.09.2016.
 */
public interface ArtikelRepository extends CrudRepository<Artikel, Long> {
}
