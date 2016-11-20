//package de.haw.hamburg.productcomponent.dataaccesslayer.entities;
//
//import javax.persistence.*;
//
///**
// * Created by Patrick Steinhauer
// * On 17.Nov.2016
// */
//@Entity
//@Table(name = "Lieferant")
//public class Lieferant extends Geschaeftspartner {
//
//    @OneToOne
//    @JoinColumn(name = "Geschaeftspartner")
//    private long geschaeftspartnerNummer;
//    private String lieferantenName;
//
//    public Lieferant() {
//
//    }
//
//    public long getKundenNummer() {
//        return geschaeftspartnerNummer;
//    }
//
//    public void setKundenNummer(long geschaeftspartnerNummer) {
//        this.geschaeftspartnerNummer = geschaeftspartnerNummer;
//    }
//
//    public String getLieferantenName() {
//        return lieferantenName;
//    }
//
//    public void setLieferantenName(String lieferantenName) {
//        this.lieferantenName = lieferantenName;
//    }
//}
