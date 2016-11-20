package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.*;

/**
 * Created by patri on 11.10.2016.
 */
@Entity
@Table(name = "Kunde")
public class Kunde {

    private long kundenNummer;
    private String vorname;
    private String nachname;


    public Kunde() {

    }

    public long getKundenNummer() {
        return kundenNummer;
    }

    public void setKundenNummer(long kundenNummer) {
        this.kundenNummer = kundenNummer;
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
