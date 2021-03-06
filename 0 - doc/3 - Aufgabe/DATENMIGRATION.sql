-- CREATE GESCHAEFTSPARTNERTMP TABLE to add all relevant information also the 
-- primary keys from KUNDE and LIEFERANT
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

CREATE TABLE GESCHAEFTSPARTNERTMP(
    Geschaeftspartnernummer   NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    Kundennummer              NUMBER,
    Lieferantennummer         NUMBER,
    Strasse                   VARCHAR2(255) NOT NULL,
    Nummer                    VARCHAR2(255) NOT NULL,
    Ort                       VARCHAR2(255) NOT NULL,
    PLZ                       INT           NOT NULL,
    IBAN                      VARCHAR2(255) NOT NULL,
    Email                     VARCHAR2(255) NOT NULL
);

INSERT INTO GESCHAEFTSPARTNERTMP(KUNDENNUMMER, STRASSE, NUMMER, ORT, PLZ, IBAN, EMAIL)
SELECT   KUNDENNUMMER, ADRESSE, HAUSNUMMER, STADT, PLZ, IBAN, EMAIL
FROM     KUNDE;

INSERT INTO GESCHAEFTSPARTNERTMP(LIEFERANTENNUMMER, STRASSE, NUMMER, ORT, PLZ, IBAN, EMAIL)
SELECT   LIEFERANTENNUMMER, STRASSE, NUMMER, ORT, PLZ, IBAN, EMAIL
FROM     LIEFERANT;
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

-- RENAME KUNDE and LIEFERANT into TMP tables. After that create the correct
-- table definitions with data.
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
RENAME KUNDE TO KUNDETMP;
RENAME LIEFERANT TO LIEFERANTTMP;

CREATE TABLE KUNDE AS 
(SELECT GT.GESCHAEFTSPARTNERNUMMER, KT.VORNAME, KT.NACHNAME
 FROM KUNDETMP              KT,
      GESCHAEFTSPARTNERTMP  GT
 WHERE KT.KUNDENNUMMER = GT.KUNDENNUMMER
);

ALTER TABLE KUNDE
ADD KUNDENNUMMER NUMBER GENERATED ALWAYS AS IDENTITY;
ALTER TABLE KUNDE
ADD CONSTRAINT KUNDE_PK PRIMARY KEY (KUNDENNUMMER);

CREATE TABLE LIEFERANT AS
(
 SELECT   GT.GESCHAEFTSPARTNERNUMMER, LT.LIEFERANTENNAME
 FROM     LIEFERANTTMP LT,
          GESCHAEFTSPARTNERTMP GT
 WHERE    LT.LIEFERANTENNUMMER = GT.KUNDENNUMMER
);

ALTER TABLE LIEFERANT
ADD LIEFERANTENNUMMER NUMBER GENERATED ALWAYS AS IDENTITY;
ALTER TABLE LIEFERANT
ADD CONSTRAINT LIEFERANT_PK PRIMARY KEY (LIEFERANTENNUMMER);

-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- Create the correct GESCHAEFTSPARTNER Table with correct data
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
DROP TABLE GESCHAEFTSPARTNER;
CREATE TABLE GESCHAEFTSPARTNER AS
(SELECT   GESCHAEFTSPARTNERNUMMER, STRASSE, NUMMER, ORT ,PLZ, IBAN, EMAIL
 FROM     GESCHAEFTSPARTNERTMP
);

ALTER TABLE GESCHAEFTSPARTNER
ADD CONSTRAINT GESCHAEFTSPARTNER_PK PRIMARY KEY (GESCHAEFTSPARTNERNUMMER);


-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- CREATE SEQUENCE 
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
DROP SEQUENCE geschaeftspartner_seq;
declare
 ex     number;
 countN number;
begin
  select MAX(GESCHAEFTSPARTNER.GESCHAEFTSPARTNERNUMMER)  + 1 into ex from GESCHAEFTSPARTNER;
  execute immediate 'CREATE SEQUENCE geschaeftspartner_seq MINVALUE 0 START WITH '|| ex ||' INCREMENT BY 1 CACHE 20 ORDER';
end;
/

-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- CREATE TRIGGER FOR AUTOINCREMENT 
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
CREATE OR REPLACE TRIGGER autoincrement_gp
BEFORE INSERT ON GESCHAEFTSPARTNER 
FOR EACH ROW

BEGIN
  SELECT geschaeftspartner_seq.NEXTVAL
  INTO   :NEW.GESCHAEFTSPARTNERNUMMER
  FROM   dual;
END;
/

-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- REMOVE GARBAGE
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
DROP TABLE GESCHAEFTSPARTNERTMP CASCADE CONSTRAINTS;
DROP TABLE LIEFERANTTMP CASCADE CONSTRAINTS;
DROP TABLE KUNDETMP CASCADE CONSTRAINTS;


-- ADD the Foreignkeys to the specified tables and make sure that they are unique
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
ALTER TABLE KUNDE
ADD CONSTRAINT KUNDE_GP_UNIQUE UNIQUE (GESCHAEFTSPARTNERNUMMER);

ALTER TABLE KUNDE
ADD CONSTRAINT KUNDE_GP_FK FOREIGN KEY (GESCHAEFTSPARTNERNUMMER) REFERENCES GESCHAEFTSPARTNER (GESCHAEFTSPARTNERNUMMER) on delete cascade;

ALTER TABLE LIEFERANT
ADD CONSTRAINT LIEFERANT_GP_FK FOREIGN KEY (GESCHAEFTSPARTNERNUMMER) REFERENCES GESCHAEFTSPARTNER (GESCHAEFTSPARTNERNUMMER) on delete cascade;

ALTER TABLE LIEFERANT
ADD CONSTRAINT LIEFERANT_GP_UNIQUE UNIQUE (GESCHAEFTSPARTNERNUMMER);

-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
/*
DROP TABLE GESCHAEFTSPARTNER CASCADE CONSTRAINTS;
DROP TABLE KUNDETMP CASCADE CONSTRAINTS;
DROP TABLE LIEFERANTTMP CASCADE CONSTRAINTS;
*/
