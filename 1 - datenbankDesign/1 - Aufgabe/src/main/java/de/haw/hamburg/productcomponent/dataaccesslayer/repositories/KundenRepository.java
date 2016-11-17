package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Kunde;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Patrick Steinhauer
 * On 12.Okt.2016
 */
@Transactional
public interface KundenRepository extends GeschaeftspartnerBaseRepository<Kunde> {

    Kunde findByNachname(String nachname);

}
