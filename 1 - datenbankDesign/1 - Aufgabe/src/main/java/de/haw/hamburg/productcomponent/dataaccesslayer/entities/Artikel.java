package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import de.haw.hamburg.productcomponent.dataaccesslayer.dtos.ArtikelDTO;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description...
 *
 * @author Patrick Steinhauer
 * @Table This is the name of the database table.
 */
@Entity
@Table(name = "Artikel")
public class Artikel {

    @Id
    private long artikelNummer;
    private String artikelName;
    private int typ;
    private int bestand;
    private float preis;
    private String kategorie;
    private String bildURL;
    private String beschreibung;

    public Artikel() {

    }

    public String getArtikelName() {
        return artikelName;
    }

    public void setArtikelName(String artikelName) {
        this.artikelName = artikelName;
    }

    public int getTyp() {
        return typ;
    }

    public void setTyp(int typ) {
        this.typ = typ;
    }

    public int getBestand() {
        return bestand;
    }

    public void setBestand(int bestand) {
        this.bestand = bestand;
    }

    public float getPreis() {
        return preis;
    }

    public void setPreis(float preis) {
        this.preis = preis;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public String getBildURL() {
        return bildURL;
    }

    public void setBildURL(String bildURL) {
        this.bildURL = bildURL;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    public ArtikelDTO convertToArtikelDTO() {
        return new ArtikelDTO(artikelName, typ, bestand, preis, kategorie, bildURL, beschreibung);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artikel)) return false;

        Artikel artikel = (Artikel) o;

        if (artikelNummer != artikel.artikelNummer) return false;
        if (getTyp() != artikel.getTyp()) return false;
        if (getBestand() != artikel.getBestand()) return false;
        if (Float.compare(artikel.getPreis(), getPreis()) != 0) return false;
        if (!getArtikelName().equals(artikel.getArtikelName())) return false;
        if (getKategorie() != null ? !getKategorie().equals(artikel.getKategorie()) : artikel.getKategorie() != null)
            return false;
        if (getBildURL() != null ? !getBildURL().equals(artikel.getBildURL()) : artikel.getBildURL() != null)
            return false;
        return getBeschreibung() != null ? getBeschreibung().equals(artikel.getBeschreibung()) : artikel.getBeschreibung() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (artikelNummer ^ (artikelNummer >>> 32));
        result = 31 * result + getArtikelName().hashCode();
        result = 31 * result + getTyp();
        result = 31 * result + getBestand();
        result = 31 * result + (getPreis() != +0.0f ? Float.floatToIntBits(getPreis()) : 0);
        result = 31 * result + (getKategorie() != null ? getKategorie().hashCode() : 0);
        result = 31 * result + (getBildURL() != null ? getBildURL().hashCode() : 0);
        result = 31 * result + (getBeschreibung() != null ? getBeschreibung().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Artikel{" +
                "artikelNummer=" + artikelNummer +
                ", artikelName='" + artikelName + '\'' +
                ", typ=" + typ +
                ", bestand=" + bestand +
                ", preis=" + preis +
                ", kategorie='" + kategorie + '\'' +
                ", bildURL='" + bildURL + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }
}
