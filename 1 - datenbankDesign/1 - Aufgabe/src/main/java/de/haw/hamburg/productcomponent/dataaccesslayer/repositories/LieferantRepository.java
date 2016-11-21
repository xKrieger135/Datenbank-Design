package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Lieferant;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
public interface LieferantRepository extends CrudRepository<Lieferant, Long> {

    List<Lieferant> findByLieferantenname(String lieferantenName);
}
