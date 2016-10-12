package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Kunde;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Patrick Steinhauer
 * On 12.Okt.2016
 */
public interface KundenRepository extends CrudRepository<Kunde, Long> {

}
