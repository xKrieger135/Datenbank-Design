DROP TABLE Bestellposition CASCADE CONSTRAINTS;
DROP TABLE Unterartikel CASCADE CONSTRAINTS;
DROP TABLE Produktionsauftrag CASCADE CONSTRAINTS;
DROP TABLE Artikel CASCADE CONSTRAINTS;
DROP TABLE Kunde CASCADE CONSTRAINTS;
DROP TABLE Bestellung CASCADE CONSTRAINTS;
DROP TABLE LIEFERANT CASCADE CONSTRAINTS;

CREATE TABLE Kunde (
  Kundennummer    NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Vorname         VARCHAR2(255) NOT NULL,
  Nachname        VARCHAR2(255) NOT NULL,
  Adresse         VARCHAR2(255) NOT NULL,
  Hausnummer      VARCHAR2(255) NOT NULL,
  Stadt           VARCHAR2(255) NOT NULL,
  PLZ             INT NOT NULL,
  Email           VARCHAR2(255) NOT NULL
);

CREATE TABLE Bestellung (
  Bestellnummer     NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Kundennummer      NUMBER NOT NULL,
  Datum             DATE NOT NULL,
  Preis             FLOAT NOT NULL,
  Rechnungsadresse  VARCHAR2(255),
  Lieferadresse     VARCHAR2(255) NOT NULL,

  FOREIGN KEY(Kundennummer) REFERENCES Kunde(Kundennummer)
);

CREATE TABLE Artikel (
  Artikelnummer     NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  ArtikelName       VARCHAR2(255) NOT NULL,
  Typ               INT DEFAULT 0 NOT NULL,
  Bestand           NUMBER(10) DEFAULT 0 NOT NULL,
  Preis             FLOAT NOT NULL,
  Kategorie         VARCHAR2(255),
  BildURL           VARCHAR2(255),
  Beschreibung      VARCHAR2(255)
);

CREATE TABLE Unterartikel (
  Artikelnummer     NUMBER NOT NULL,   
  Artikelkomponente NUMBER NOT NULL,
  Menge				NUMBER NOT NULL,

  FOREIGN KEY(Artikelnummer) REFERENCES Artikel(Artikelnummer),
  FOREIGN KEY(Artikelkomponente) REFERENCES Artikel(Artikelnummer),
  CONSTRAINT unterartikelContraint PRIMARY KEY (Artikelnummer,Artikelkomponente) 
);

CREATE TABLE Bestellposition (
  Bestellnummer     NUMBER NOT NULL,
  Artikelnummer     NUMBER NOT NULL,
  Menge             NUMBER NOT NULL,
  
  FOREIGN KEY(Artikelnummer) REFERENCES Artikel(Artikelnummer),
  FOREIGN KEY(Bestellnummer) REFERENCES Bestellung(Bestellnummer),
  CONSTRAINT bestellpositionConstraint PRIMARY KEY (Artikelnummer,Bestellnummer) 
);


CREATE TABLE ProduktionsAuftrag (
  Auftragsnummer    NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Monat             VARCHAR(6) NOT NULL,
  Bestellnummer     NUMBER NOT NULL,
  
  FOREIGN KEY(Bestellnummer) REFERENCES Bestellung(Bestellnummer)
);

CREATE TABLE LIEFERANT (
  Lieferantennummer NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Lieferantenname   VARCHAR2(255) NOT NULL,
  Strasse          VARCHAR2(255) NOT NULL,
  Nummer           VARCHAR(255)  NOT NULL,
  Ort              VARCHAR(255)  NOT NULL,
  PLZ              INT           NOT NULL,
  Email            VARCHAR2(255) NOT NULL,
  IBAN             VARCHAR2(255) NOT NULL
);
