INSERT INTO Bestellung(Kundennummer, Datum, Preis, Rechnungsadresse, Lieferadresse)
VALUES(13, TO_DATE('2016/10/18', 'yyyy/mm/dd'), 2000.00, 'Sandhausen 123', 'BoBaBoboBiBa 60');

INSERT INTO BESTELLPOSITION(BESTELLNUMMER, ARTIKELNUMMER, MENGE)
VALUES(1, 21, 5);