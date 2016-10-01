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
package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import de.haw.hamburg.productcomponent.dataaccesslayer.dtos.ArtikelDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description...
 *
 * @author Patrick Steinhauer
 */
@Entity
@Table(name = "Artikel")
public class Artikel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long artikelID;
    private String artikelName;
    private int typ;
    private int bestand;
    private float preis;
    private String baugruppe;
    private String kategorie;
    private String bildURL;
    private String beschreibung;

    public Artikel() {

    }

    public long getArtikelID() {
        return artikelID;
    }

    public void setArtikelID(long artikelID) {
        this.artikelID = artikelID;
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

    public String getBaugruppe() {
        return baugruppe;
    }

    public void setBaugruppe(String baugruppe) {
        this.baugruppe = baugruppe;
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
        return new ArtikelDTO(artikelName, typ, bestand, preis, baugruppe, kategorie, bildURL, beschreibung);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Artikel)) return false;

        Artikel artikel = (Artikel) o;

        if (getArtikelID() != artikel.getArtikelID()) return false;
        if (getTyp() != artikel.getTyp()) return false;
        if (getBestand() != artikel.getBestand()) return false;
        if (Float.compare(artikel.getPreis(), getPreis()) != 0) return false;
        if (!getArtikelName().equals(artikel.getArtikelName())) return false;
        if (getBaugruppe() != null ? !getBaugruppe().equals(artikel.getBaugruppe()) : artikel.getBaugruppe() != null)
            return false;
        if (getKategorie() != null ? !getKategorie().equals(artikel.getKategorie()) : artikel.getKategorie() != null)
            return false;
        if (getBildURL() != null ? !getBildURL().equals(artikel.getBildURL()) : artikel.getBildURL() != null)
            return false;
        return getBeschreibung() != null ? getBeschreibung().equals(artikel.getBeschreibung()) : artikel.getBeschreibung() == null;

    }

    @Override
    public int hashCode() {
        int result = (int) (getArtikelID() ^ (getArtikelID() >>> 32));
        result = 31 * result + getArtikelName().hashCode();
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
        return "Artikel{" +
                "artikelID=" + artikelID +
                ", artikelName='" + artikelName + '\'' +
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
