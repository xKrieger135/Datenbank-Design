package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
@Entity
@Table(name = "Lieferant")
public class Lieferant extends Geschaeftspartner {

    @Id
    private long geschaeftspartnerNummer;
    private String lieferantenName;

    public Lieferant() {

    }

    public long getGeschaeftspartnerNummer() {
        return geschaeftspartnerNummer;
    }

    public void setGeschaeftspartnerNummer(long geschaeftspartnerNummer) {
        this.geschaeftspartnerNummer = geschaeftspartnerNummer;
    }

    public String getLieferantenName() {
        return lieferantenName;
    }

    public void setLieferantenName(String lieferantenName) {
        this.lieferantenName = lieferantenName;
    }
}
