package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Kunde;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Patrick Steinhauer
 * On 12.Okt.2016
 */
//@Transactional
public interface KundenRepository extends CrudRepository<Kunde, Long> {

    Kunde findByKundennummer(long kundennummer);

    List<Kunde> findByVorname(String vorname);

    List<Kunde> findByNachname(String nachname);
}
