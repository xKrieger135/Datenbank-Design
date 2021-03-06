CREATE OR REPLACE TYPE BESTELLPOSITION_TYPE AS OBJECT (BESTELLNUMMER NUMBER,
                                       ARTIKELNUMMER NUMBER,
                                       MENGE         NUMBER);
/

RENAME BESTELLUNG TO BST_TMP;
/

CREATE OR REPLACE TYPE BESTELLPOSITION_NESTED_TYPE AS TABLE OF BESTELLPOSITION_TYPE;
/

CREATE TABLE Bestellung (
  Bestellnummer     NUMBER GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  Kundennummer      NUMBER NOT NULL,
  Datum             DATE NOT NULL,
  Preis             FLOAT NOT NULL,
  Rechnungsadresse  VARCHAR2(255),
  Lieferadresse     VARCHAR2(255) NOT NULL,
  BESTELLPOSITION   BESTELLPOSITION_NESTED_TYPE,
  FOREIGN KEY(Kundennummer) REFERENCES Kunde(Kundennummer)
) NESTED TABLE BESTELLPOSITION STORE AS BESTELLPOSITION_NESTEDTABLE;
/

INSERT INTO BESTELLUNG(BESTELLNUMMER, KUNDENNUMMER, DATUM, PREIS, RECHNUNGSADRESSE, LIEFERADRESSE, BESTELLPOSITION)
(
    SELECT  B.BESTELLNUMMER, B.KUNDENNUMMER, B.DATUM, B.PREIS, B.RECHNUNGSADRESSE, B.LIEFERADRESSE, BESTELLPOSITION_NESTED_TYPE(BESTELLPOSITION_TYPE(BP.BESTELLNUMMER, BP.ARTIKELNUMMER, BP.MENGE))
    FROM    BST_TMP B,
            BESTELLPOSITION BP
);

commit;

DROP TABLE BST_TMP CASCADE CONSTRAINTS;