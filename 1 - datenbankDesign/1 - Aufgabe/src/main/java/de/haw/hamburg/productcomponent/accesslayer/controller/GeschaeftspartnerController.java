package de.haw.hamburg.productcomponent.accesslayer.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Lieferant;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.LieferantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import de.haw.hamburg.productcomponent.accesslayer.view.IFrameController;
import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Geschaeftspartner;
import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Kunde;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.GeschaeftspartnerRepository;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.KundenRepository;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
//@RestController
@Component
public class GeschaeftspartnerController<T> implements IFrameController {

    @Autowired
    private GeschaeftspartnerRepository geschaeftspartnerRepository;
    @Autowired
    private KundenRepository kundenRepository;
    @Autowired
    private LieferantRepository lieferantRepository;

    public Kunde findKundeByKundenNummer(long kundenNummer) {
        Kunde kunde = kundenRepository.findByKundennummer(kundenNummer);
        return kunde;
    }

    public Geschaeftspartner findGeschaeftspartnerByGeschaeftspartnerNummer(long geschaeftspartnernummer) {
        Geschaeftspartner geschaeftspartner = geschaeftspartnerRepository.findByGeschaeftspartnernummer(geschaeftspartnernummer);
        return geschaeftspartner;
    }

    public void changeGeschaeftspartnerAdress(long kundennummer) {
        Kunde kunde = kundenRepository.findByKundennummer(kundennummer);
        Geschaeftspartner geschaeftspartner = geschaeftspartnerRepository.findByGeschaeftspartnernummer(kunde.getGeschaeftspartnernummer());
    }

    @Override
    public boolean login(String username, String password) {
        return true;
    }

    @Override
    public void logout() {

    }

    @Override
    public boolean deleteGeschaeftspartner(Number geschaeftspartnerNummer) {
        return false;
    }

    @Override
    public List<de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner> searchGeschaeftspartner(String searchString) {
        List<de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner> geschaeftspartnerList = new ArrayList<>();
        List<T> lieferantenAndKunden = new ArrayList<T>();
        List<Kunde> kunden = kundenRepository.findByNachname(searchString);
        List<Lieferant> lieferanten = lieferantRepository.findByLieferantenname(searchString);
        lieferantenAndKunden.addAll((Collection<? extends T>) kunden);
        lieferantenAndKunden.addAll((Collection<? extends T>) lieferanten);
        for (T obj : lieferantenAndKunden) {
            if (obj instanceof Kunde) {

                Geschaeftspartner gp = geschaeftspartnerRepository.findByGeschaeftspartnernummer(((Kunde) obj).getGeschaeftspartnernummer());
                de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner geschaeftspartner =
                        new de.haw.hamburg.productcomponent.accesslayer.model.Kunde(gp.getGeschaeftspartnernummer(),
                                gp.getStrasse(), gp.getNummer(), gp.getOrt(), gp.getPlz(), gp.getIban(), gp.getemail(),
                                ((Kunde) obj).getVorname(), ((Kunde) obj).getNachname());
                geschaeftspartnerList.add(geschaeftspartner);
            } else if(obj instanceof Lieferant) {
                Geschaeftspartner gp = geschaeftspartnerRepository.findByGeschaeftspartnernummer(((Lieferant) obj).getGeschaeftspartnernummer());
                de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner geschaeftspartner =
                        new de.haw.hamburg.productcomponent.accesslayer.model.Lieferant(gp.getGeschaeftspartnernummer(),
                                gp.getStrasse(), gp.getNummer(), gp.getOrt(), gp.getPlz(), gp.getIban(), gp.getemail(),
                                ((Lieferant) obj).getLieferantenname());
                geschaeftspartnerList.add(geschaeftspartner);
            } else {
                throw new RuntimeException("The actual object is not specified at our context!");
            }
        }
        return geschaeftspartnerList;
    }

    @Override
    public boolean updateGeschaeftspartner(de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner updatedG) {
        Geschaeftspartner geschaeftspartner = new Geschaeftspartner((Long) updatedG.getGeschaeftspartnerNummer(),
                updatedG.getStrasse(), updatedG.getNummer(), updatedG.getOrt(), updatedG.getPlz(), updatedG.getIBAN(),
                updatedG.getEmail());
        if(geschaeftspartnerRepository.save(geschaeftspartner) != null) {
            return true;
        }
        return false;
    }

    @Override
    public void createGeschaeftspartner(de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner g) {

    }
}
