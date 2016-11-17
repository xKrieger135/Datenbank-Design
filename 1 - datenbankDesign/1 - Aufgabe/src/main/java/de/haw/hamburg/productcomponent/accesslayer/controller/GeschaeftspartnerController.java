package de.haw.hamburg.productcomponent.accesslayer.controller;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Geschaeftspartner;
import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Kunde;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.GeschaeftspartnerRepository;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.KundenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
@RestController
public class GeschaeftspartnerController {

    @Autowired
    private GeschaeftspartnerRepository geschaeftspartnerRepository;
    @Autowired
    private KundenRepository kundenRepository;

    @RequestMapping(value = "/gp/{nachname}", method = RequestMethod.GET, produces = "application/json")
    public Kunde findGeschaeftspartnerByNachname(@PathVariable String nachname) {
        Kunde kunde = kundenRepository.findByNachname(nachname);
        return kunde;
    }
}
