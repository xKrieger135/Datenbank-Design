package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.*;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
@Entity
@Table(name = "Geschaeftspartner")
//@DiscriminatorColumn(name = "geschaeftspartnernummer")
//@Inheritance
public class Geschaeftspartner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long geschaeftspartnernummer;
    private String strasse;
    private String nummer;
    private String ort;
    private int plz;
    private String iban;
    private String email;

    public Geschaeftspartner(long geschaeftspartnernummer, String strasse, String nummer, String ort, int plz, String iban, String email) {
        this.geschaeftspartnernummer = geschaeftspartnernummer;
        this.strasse = strasse;
        this.nummer = nummer;
        this.ort = ort;
        this.plz = plz;
        this.iban = iban;
        this.email = email;
    }

    public Geschaeftspartner() {
    }

    public long getGeschaeftspartnernummer() {
        return geschaeftspartnernummer;
    }

    public void setGeschaeftspartnernummer(long geschaeftspartnernummer) {
        this.geschaeftspartnernummer = geschaeftspartnernummer;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getNummer() {
        return nummer;
    }

    public String getOrt() {
        return ort;
    }

    public int getPlz() {
        return plz;
    }

    public String getIban() {
        return iban;
    }

    public String getemail() {
        return email;
    }

}
