//package de.haw.hamburg.productcomponent.dataaccesslayer.entities;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import java.util.Date;
//
///**
// * Description...
// *
// * @author patrick_steinhauer
// * @created 11.10.2016
// */
//@Entity
//@Table(name = "Bestellung")
//public class Bestellung {
//
//    @Id
//    private long bestellnummer;
//    private long kundennummer;
//    private Date datum;
//    private float preis;
//    private String rechnugsadresse;
//    private String lieferadresse;
//
//    public Bestellung() {
//
//    }
//
//    public long getBestellnummer() {
//        return bestellnummer;
//    }
//
//    public void setBestellnummer(long bestellnummer) {
//        this.bestellnummer = bestellnummer;
//    }
//
//    public long getKundennummer() {
//        return kundennummer;
//    }
//
//    public void setKundennummer(long kundennummer) {
//        this.kundennummer = kundennummer;
//    }
//
//    public Date getDatum() {
//        return datum;
//    }
//
//    public void setDatum(Date datum) {
//        this.datum = datum;
//    }
//
//    public float getPreis() {
//        return preis;
//    }
//
//    public void setPreis(float preis) {
//        this.preis = preis;
//    }
//
//    public String getRechnugsadresse() {
//        return rechnugsadresse;
//    }
//
//    public void setRechnugsadresse(String rechnugsadresse) {
//        this.rechnugsadresse = rechnugsadresse;
//    }
//
//    public String getLieferadresse() {
//        return lieferadresse;
//    }
//
//    public void setLieferadresse(String lieferadresse) {
//        this.lieferadresse = lieferadresse;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof Bestellung)) return false;
//
//        Bestellung that = (Bestellung) o;
//
//        if (getBestellnummer() != that.getBestellnummer()) return false;
//        if (getKundennummer() != that.getKundennummer()) return false;
//        if (Float.compare(that.getPreis(), getPreis()) != 0) return false;
//        if (!getDatum().equals(that.getDatum())) return false;
//        if (getRechnugsadresse() != null ? !getRechnugsadresse().equals(that.getRechnugsadresse()) : that.getRechnugsadresse() != null)
//            return false;
//        return getLieferadresse().equals(that.getLieferadresse());
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (getBestellnummer() ^ (getBestellnummer() >>> 32));
//        result = 31 * result + (int) (getKundennummer() ^ (getKundennummer() >>> 32));
//        result = 31 * result + getDatum().hashCode();
//        result = 31 * result + (getPreis() != +0.0f ? Float.floatToIntBits(getPreis()) : 0);
//        result = 31 * result + (getRechnugsadresse() != null ? getRechnugsadresse().hashCode() : 0);
//        result = 31 * result + getLieferadresse().hashCode();
//        return result;
//    }
//
//    @Override
//    public String toString() {
//        return "Bestellung{" +
//                "bestellnummer=" + bestellnummer +
//                ", kundennummer=" + kundennummer +
//                ", datum=" + datum +
//                ", preis=" + preis +
//                ", rechnugsadresse='" + rechnugsadresse + '\'' +
//                ", lieferadresse='" + lieferadresse + '\'' +
//                '}';
//    }
//}
