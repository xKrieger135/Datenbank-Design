package de.haw.hamburg.productcomponent.dataaccesslayer.repositories;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Geschaeftspartner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
public interface GeschaeftspartnerRepository extends GeschaeftspartnerBaseRepository<Geschaeftspartner> {

    public Geschaeftspartner findByEMail(String eMail);
}
