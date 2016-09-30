/*
 * This file is part of a Werum IT Solutions GmbH project.
 *
 * Copyright (c)
 *    Werum IT Solutions GmbH
 *    All rights reserved.
 *
 * This source file may be managed in different Java package structures,
 * depending on actual usage of the source file by the Copyright holders:
 *
 * for Werum:  com.werum.* or any other Werum owned Internet domain
 *
 * Any use of this file as part of a software system by none Copyright holders
 * is subject to license terms.
 *
 * Last Change: $Id: $$
 */
package de.haw.hamburg.productcomponent.dataaccesslayer.dtos;

import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;

/**
 * This DTO implementation of the artikel entity is used, to make sure that information hiding over components won't be
 * violated.
 *
 * @author Patrick Steinhauer
 *
 */
public class ArtikelDTO {

    private String artikelName;
    private int typ;
    private int bestand;
    private float preis;
    private String baugruppe;
    private String kategorie;
    private String bildURL;
    private String beschreibung;

    public ArtikelDTO() {

    }

    public ArtikelDTO(String artikelName, int typ, int bestand, float preis, String baugruppe, String kategorie, String bildURL, String beschreibung) {
        this.artikelName = artikelName;
        this.typ = typ;
        this.bestand = bestand;
        this.preis = preis;
        this.baugruppe = baugruppe;
        this.kategorie = kategorie;
        this.bildURL = bildURL;
        this.beschreibung = beschreibung;
    }

    public Artikel convertToArtikelEntity() {
        Artikel artikel = new Artikel();
        artikel.setArtikelName(artikelName);
        artikel.setBeschreibung(beschreibung);
        artikel.setTyp(typ);
        artikel.setBaugruppe(baugruppe);
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

    public String getBaugruppe() {
        return baugruppe;
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
        if (this == o) return true;
        if (!(o instanceof ArtikelDTO)) return false;

        ArtikelDTO that = (ArtikelDTO) o;

        if (getTyp() != that.getTyp()) return false;
        if (getBestand() != that.getBestand()) return false;
        if (Float.compare(that.getPreis(), getPreis()) != 0) return false;
        if (!getArtikelName().equals(that.getArtikelName())) return false;
        if (getBaugruppe() != null ? !getBaugruppe().equals(that.getBaugruppe()) : that.getBaugruppe() != null)
            return false;
        if (getKategorie() != null ? !getKategorie().equals(that.getKategorie()) : that.getKategorie() != null)
            return false;
        if (getBildURL() != null ? !getBildURL().equals(that.getBildURL()) : that.getBildURL() != null) return false;
        return getBeschreibung() != null ? getBeschreibung().equals(that.getBeschreibung()) : that.getBeschreibung() == null;

    }

    @Override
    public int hashCode() {
        int result = getArtikelName().hashCode();
        result = 31 * result + getTyp();
        result = 31 * result + getBestand();
        result = 31 * result + (getPreis() != +0.0f ? Float.floatToIntBits(getPreis()) : 0);
        result = 31 * result + (getBaugruppe() != null ? getBaugruppe().hashCode() : 0);
        result = 31 * result + (getKategorie() != null ? getKategorie().hashCode() : 0);
        result = 31 * result + (getBildURL() != null ? getBildURL().hashCode() : 0);
        result = 31 * result + (getBeschreibung() != null ? getBeschreibung().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ArtikelDTO{" +
                "artikelName='" + artikelName + '\'' +
                ", typ=" + typ +
                ", bestand=" + bestand +
                ", preis=" + preis +
                ", baugruppe='" + baugruppe + '\'' +
                ", kategorie='" + kategorie + '\'' +
                ", bildURL='" + bildURL + '\'' +
                ", beschreibung='" + beschreibung + '\'' +
                '}';
    }
}
