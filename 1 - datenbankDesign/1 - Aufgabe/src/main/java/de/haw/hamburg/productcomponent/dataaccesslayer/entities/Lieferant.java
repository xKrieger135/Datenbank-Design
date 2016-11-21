package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.*;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
@Entity
@Table(name = "Lieferant")
public class Lieferant {


    private long geschaeftspartnernummer;
    private String lieferantenname;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long lieferantennummer;

    public Lieferant() {

    }

    public long getGeschaeftspartnernummer() {
        return geschaeftspartnernummer;
    }

    public void setGeschaeftspartnernummer(long geschaeftspartnernummer) {
        this.geschaeftspartnernummer = geschaeftspartnernummer;
    }

    public String getLieferantenname() {
        return lieferantenname;
    }

    public void setLieferantenname(String lieferantenname) {
        this.lieferantenname = lieferantenname;
    }
}
