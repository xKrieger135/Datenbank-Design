package de.haw.hamburg.productcomponent.accesslayer.model;

/**
 *
 * @author dima
 */
public class Kunde extends Geschaeftspartner{

    private String vorname;
    private String nachname;
    
    public Kunde(Number geschaeftspartnerNummer, String strasse, String nummer, 
            String ort, int plz, String iban, String email, String vorname, String nachname) {
     
        super(geschaeftspartnerNummer, strasse, nummer, ort, plz, iban, email);
        
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }
}
