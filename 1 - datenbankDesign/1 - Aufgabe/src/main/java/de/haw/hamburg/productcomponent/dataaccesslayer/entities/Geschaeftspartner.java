package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;

/**
 * Created by Patrick Steinhauer
 * On 17.Nov.2016
 */
@Entity
@Table(name = "Geschaeftspartner")
@Inheritance
public abstract class Geschaeftspartner {

    @Id
    private long geschaeftspartnerNummer;
    private String strasse;
    private String nummer;
    private int plz;
    private String iban;
    private String eMail;

    public Geschaeftspartner() {

    }

    public long getGeschaeftspartnerNummer() {
        return geschaeftspartnerNummer;
    }

    public void setGeschaeftspartnerNummer(long geschaeftspartnerNummer) {
        this.geschaeftspartnerNummer = geschaeftspartnerNummer;
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

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
