package de.haw.hamburg.productcomponent.accesslayer.model;

/**
 *
 * @author dima
 */
public abstract class Geschaeftspartner {
    
    private Number geschaeftspartnerNummer;
    private String strasse;
    private String nummer;
    private String ort;
    private int plz;
    private String iban;
    private String email;

    public Geschaeftspartner(Number geschaeftspartnerNummer, String strasse, 
                    String nummer, String ort, int plz, String iban, String email) {
        this.geschaeftspartnerNummer = geschaeftspartnerNummer;
        this.strasse = strasse;
        this.nummer = nummer;
        this.ort = ort;
        this.plz = plz;
        this.iban = iban;
        this.email = email;
    }

    public Number getGeschaeftspartnerNummer() {
        return geschaeftspartnerNummer;
    }

    public String getStrasse() {
        return strasse;
    }

    public String getNummer() {
        return nummer;
    }

    public String getOrt() {
        return ort;
    }

    public int getPlz() {
        return plz;
    }

    public String getIBAN() {
        return iban;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return " [0] " + geschaeftspartnerNummer + "\t [1] " + strasse + "\t [2] " + nummer + "\t [3] " + ort + "\t [4] "+plz+"\t [5]" + iban + "\t [6]" + email;
    }
    
    public static String getToStringDescription(){
        return "|    ID \t    |    strasse\t    |    nummber\t    |    ort\t    |    plz\t    |    iban\t    |    email\t    |";
    }

    public void setGeschaeftspartnerNummer(Number geschaeftspartnerNummer) {
        this.geschaeftspartnerNummer = geschaeftspartnerNummer;
    }
    
}
