package de.haw.hamburg.productcomponent.dataaccesslayer.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Description...
 *
 * @author patrick_steinhauer
 * @created 11.10.2016
 */
@Entity
@Table(name = "Bestellposition")
public class Bestellposition {

    @Id
    private long bestellnummer;
    private int artikelKomponente;
    private int menge;

    public Bestellposition() {

    }

    public long getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(long bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    public int getArtikelKomponente() {
        return artikelKomponente;
    }

    public void setArtikelKomponente(int artikelKomponente) {
        this.artikelKomponente = artikelKomponente;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestellposition)) return false;

        Bestellposition that = (Bestellposition) o;

        if (getBestellnummer() != that.getBestellnummer()) return false;
        if (getArtikelKomponente() != that.getArtikelKomponente()) return false;
        return getMenge() == that.getMenge();

    }

    @Override
    public int hashCode() {
        int result = (int) (getBestellnummer() ^ (getBestellnummer() >>> 32));
        result = 31 * result + getArtikelKomponente();
        result = 31 * result + getMenge();
        return result;
    }

    @Override
    public String toString() {
        return "Bestellposition{" +
                "bestellnummer=" + bestellnummer +
                ", artikelKomponente=" + artikelKomponente +
                ", menge=" + menge +
                '}';
    }
}
