/**** 3.A ****/
SELECT bpt.* FROM BESTELLUNG b, TABLE(b.BESTELLPOSITION) bpt WHERE b.BESTELLNUMMER=1;

/****  3.B ****/
SELECT bpt.* FROM BESTELLUNG b, TABLE(b.BESTELLPOSITION) bpt WHERE b.BESTELLNUMMER=1;

/****  3.C ****/
SELECT bpt.* FROM BESTELLUNG b, TABLE(b.BESTELLPOSITION) bpt WHERE b.BESTELLNUMMER=1 AND bpt.ARTIKELNUMMER=21;

/**** 3.D ****/
SELECT g.GESCHAEFTSPARTNERNUMMER, g.TELEFON_NUMMERN FROM GESCHAEFTSPARTNER g, LIEFERANT l WHERE l.GESCHAEFTSPARTNERNUMMER=g.GESCHAEFTSPARTNERNUMMER;