package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Geschaeftspartner;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
//@Transactional
public interface GeschaeftspartnerRepository extends CrudRepository<Geschaeftspartner, Long> {

    Geschaeftspartner findByGeschaeftspartnernummer(long geschaeftspartnernummer);
}
