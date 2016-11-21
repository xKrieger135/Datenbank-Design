package de.haw.hamburg.productcomponent.dataaccesslayer.dtos;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;

/**
 * This DTO implementation of the artikel entity is used, to make sure that information hiding over components won't be
 * violated.
 *
 * @author Patrick Steinhauer
 */
public class ArtikelDTO {

    private String artikelName;
    private int typ;
    private int bestand;
    private float preis;
    private String kategorie;
    private String bildURL;
    private String beschreibung;

    public ArtikelDTO() {

    }

    public ArtikelDTO(String artikelName, int typ, int bestand, float preis, String kategorie,
                      String bildURL, String beschreibung) {
        this.artikelName = artikelName;
        this.typ = typ;
        this.bestand = bestand;
        this.preis = preis;
        this.kategorie = kategorie;
        this.bildURL = bildURL;
        this.beschreibung = beschreibung;
    }

    public Artikel convertToArtikelEntity() {
        Artikel artikel = new Artikel();
        artikel.setArtikelname(artikelName);
        artikel.setBeschreibung(beschreibung);
        artikel.setTyp(typ);
        artikel.setPreis(preis);
        artikel.setBestand(bestand);
        artikel.setBildURL(bildURL);
        artikel.setKategorie(kategorie);
        return artikel;
    }

    public String getArtikelName() {
        return artikelName;
    }

    public int getTyp() {
        return typ;
    }

    public int getBestand() {
        return bestand;
    }

    public float getPreis() {
        return preis;
    }

    public String getKategorie() {
        return kategorie;
    }

    public String getBildURL() {
        return bildURL;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof ArtikelDTO))
            return false;

        ArtikelDTO that = (ArtikelDTO) o;

        if (getTyp() != that.getTyp())
            return false;
        if (getBestand() != that.getBestand())
            return false;
        if (Float.compare(that.getPreis(), getPreis()) != 0)
            return false;
        if (!getArtikelName().equals(that.getArtikelName()))
            return false;
        if (getKategorie() != null ? !getKategorie().equals(that.getKategorie()) : that.getKategorie() != null)
            return false;
        if (getBildURL() != null ? !getBildURL().equals(that.getBildURL()) : that.getBildURL() != null)
            return false;
        return getBeschreibung() != null ? getBeschreibung().equals(that.getBeschreibung())
                : that.getBeschreibung() == null;

    }

    @Override
    public int hashCode() {
        int result = getArtikelName().hashCode();
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
        return "ArtikelDTO{" + "artikelName='" + artikelName + '\'' + ", typ=" + typ + ", bestand=" + bestand
                + ", preis=" + preis + '\'' + ", kategorie='" + kategorie + '\''
                + ", bildURL='" + bildURL + '\'' + ", beschreibung='" + beschreibung + '\'' + '}';
    }
}
