package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by patri on 11.10.2016.
 */
@Entity
@Table(name = "Kunde")
public class Kunde {

    @Id
    private long kundennummer;
    private String vorname;
    private String nachname;
    private String adresse;
    private String hausnummer;
    private String stadt;
    private int plz;

    public Kunde() {

    }

    public long getKundennummer() {
        return kundennummer;
    }

    public void setKundennummer(long kundennummer) {
        this.kundennummer = kundennummer;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getHausnummer() {
        return hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public String getStadt() {
        return stadt;
    }

    public void setStadt(String stadt) {
        this.stadt = stadt;
    }

    public int getPlz() {
        return plz;
    }

    public void setPlz(int plz) {
        this.plz = plz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Kunde)) return false;

        Kunde kunde = (Kunde) o;

        if (getKundennummer() != kunde.getKundennummer()) return false;
        if (getPlz() != kunde.getPlz()) return false;
        if (!getVorname().equals(kunde.getVorname())) return false;
        if (!getNachname().equals(kunde.getNachname())) return false;
        if (!getAdresse().equals(kunde.getAdresse())) return false;
        if (!getHausnummer().equals(kunde.getHausnummer())) return false;
        return getStadt().equals(kunde.getStadt());

    }

    @Override
    public int hashCode() {
        int result = (int) (getKundennummer() ^ (getKundennummer() >>> 32));
        result = 31 * result + getVorname().hashCode();
        result = 31 * result + getNachname().hashCode();
        result = 31 * result + getAdresse().hashCode();
        result = 31 * result + getHausnummer().hashCode();
        result = 31 * result + getStadt().hashCode();
        result = 31 * result + getPlz();
        return result;
    }

    @Override
    public String toString() {
        return "Kunde{" +
                "kundennummer=" + kundennummer +
                ", vorname='" + vorname + '\'' +
                ", nachname='" + nachname + '\'' +
                ", adresse='" + adresse + '\'' +
                ", hausnummer='" + hausnummer + '\'' +
                ", stadt='" + stadt + '\'' +
                ", plz=" + plz +
                '}';
    }
}
