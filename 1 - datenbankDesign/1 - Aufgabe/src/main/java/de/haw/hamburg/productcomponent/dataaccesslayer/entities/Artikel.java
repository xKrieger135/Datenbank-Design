package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import de.haw.hamburg.productcomponent.dataaccesslayer.dtos.ArtikelDTO;

import javax.persistence.*;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long artikelnummer;
    private String artikelname;
    private int typ;
    private int bestand;
    private float preis;
    private String kategorie;
    private String bildURL;
    private String beschreibung;

    public Artikel() {

    }

    public long getArtikelnummer() {
        return artikelnummer;
    }

    public void setArtikelnummer(long artikelnummer) {
        this.artikelnummer = artikelnummer;
    }

    public String getArtikelname() {
        return artikelname;
    }

    public void setArtikelname(String artikelname) {
        this.artikelname = artikelname;
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
        return new ArtikelDTO(artikelname, typ, bestand, preis, kategorie, bildURL, beschreibung);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artikel)) return false;

        Artikel artikel = (Artikel) o;

        if (artikelnummer != artikel.artikelnummer) return false;
        if (getTyp() != artikel.getTyp()) return false;
        if (getBestand() != artikel.getBestand()) return false;
        if (Float.compare(artikel.getPreis(), getPreis()) != 0) return false;
        if (!getArtikelname().equals(artikel.getArtikelname())) return false;
        if (getKategorie() != null ? !getKategorie().equals(artikel.getKategorie()) : artikel.getKategorie() != null)
            return false;
        if (getBildURL() != null ? !getBildURL().equals(artikel.getBildURL()) : artikel.getBildURL() != null)
            return false;
        return getBeschreibung() != null ? getBeschreibung().equals(artikel.getBeschreibung()) : artikel.getBeschreibung() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (artikelnummer ^ (artikelnummer >>> 32));
        result = 31 * result + getArtikelname().hashCode();
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
                "artikelnummer=" + artikelnummer +
                ", artikelname='" + artikelname + '\'' +
                ", typ=" + typ +
                ", bestand=" + bestand +
                ", preis=" + preis +
                ", kategorie='" + kategorie + '\'' +
                ", bildURL='" + bildURL + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }
}
