package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by patri on 11.10.2016.
 */
@Entity
@Table(name = "Kunde")
public class Kunde extends Geschaeftspartner {

    @Id
    private long geschaeftspartnerNummer;
    private String vorname;
    private String nachname;


    public Kunde() {

    }

    public long getGeschaeftspartnerNummer() {
        return geschaeftspartnerNummer;
    }

    public void setGeschaeftspartnerNummer(long geschaeftspartnerNummer) {
        this.geschaeftspartnerNummer = geschaeftspartnerNummer;
    }

    public String getVorname() {
        return vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }
}
