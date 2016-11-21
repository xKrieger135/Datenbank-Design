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
    private int plz;
    private String iban;
    private String email;

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

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getNummer() {
        return nummer;
    }

    public void setNummer(String nummer) {
        this.nummer = nummer;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public String getemail() {
        return email;
    }

    public void setemail(String email) {
        this.email = email;
    }
}
