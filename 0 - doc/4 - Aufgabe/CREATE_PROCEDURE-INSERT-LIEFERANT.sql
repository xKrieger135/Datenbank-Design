CREATE OR REPLACE PROCEDURE INSERT_LIEFERANT
(
lieferantenname IN VARCHAR2,
strasse         IN VARCHAR2,
nummer          IN VARCHAR2,
ort             IN VARCHAR2,
plz             IN NUMBER,
iban            IN VARCHAR2,
email           IN VARCHAR2
)
AS
BEGIN
  -- CREATE GESCHAEFTSPARTNER --
  INSERT INTO GESCHAEFTSPARTNER (STRASSE, NUMMER, ORT, PLZ, IBAN, EMAIL) 
  VALUES (strasse, nummer, ort, plz, iban, email);

  -- CREATE LIEFERANT --
  INSERT INTO LIEFERANT (GESCHAEFTSPARTNERNUMMER, LIEFERANTENNAME)
  VALUES (GESCHAEFTSPARTNER_SEQ.CURRVAL, lieferantenname);
  commit;
  

END INSERT_LIEFERANT;