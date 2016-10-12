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
@Table(name = "Produktionsauftrag")
public class Produktionsauftrag {

    @Id
    private long auftragsnummer;
    private String monat;
    private long bestellnummer;

    public Produktionsauftrag() {

    }

    public long getAuftragsnummer() {
        return auftragsnummer;
    }

    public void setAuftragsnummer(long auftragsnummer) {
        this.auftragsnummer = auftragsnummer;
    }

    public String getMonat() {
        return monat;
    }

    public void setMonat(String monat) {
        this.monat = monat;
    }

    public long getBestellnummer() {
        return bestellnummer;
    }

    public void setBestellnummer(long bestellnummer) {
        this.bestellnummer = bestellnummer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produktionsauftrag)) return false;

        Produktionsauftrag that = (Produktionsauftrag) o;

        if (getAuftragsnummer() != that.getAuftragsnummer()) return false;
        if (getBestellnummer() != that.getBestellnummer()) return false;
        return getMonat().equals(that.getMonat());

    }

    @Override
    public int hashCode() {
        int result = (int) (getAuftragsnummer() ^ (getAuftragsnummer() >>> 32));
        result = 31 * result + getMonat().hashCode();
        result = 31 * result + (int) (getBestellnummer() ^ (getBestellnummer() >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Produktionsauftrag{" +
                "auftragsnummer=" + auftragsnummer +
                ", monat='" + monat + '\'' +
                ", bestellnummer=" + bestellnummer +
                '}';
    }
}
