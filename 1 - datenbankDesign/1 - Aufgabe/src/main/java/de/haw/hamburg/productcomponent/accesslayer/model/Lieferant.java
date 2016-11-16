package de.haw.hamburg.productcomponent.accesslayer.model;

/**
 *
 * @author dima
 */
public class Lieferant extends Geschaeftspartner{
    
    private String lieferantenname;

    public Lieferant(Number geschaeftspartnerNummer, String strasse, String nummer, 
            String ort, int plz, String iban, String email, String lieferantenname) {
        
        super(geschaeftspartnerNummer, strasse, nummer, ort, plz, iban, email);
        this.lieferantenname = lieferantenname;
    }

    public String getLieferantenname() {
        return lieferantenname;
    }
    
}
