DROP TABLE Bestellposition CASCADE CONSTRAINTS;
DROP TABLE Unterartikel CASCADE CONSTRAINTS;
DROP TABLE Auftrag CASCADE CONSTRAINTS;
DROP TABLE Artikel CASCADE CONSTRAINTS;
DROP TABLE Kunde CASCADE CONSTRAINTS;
DROP TABLE Bestellung CASCADE CONSTRAINTS;

CREATE TABLE Kunde (
  Kundennummer    NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Vorname         VARCHAR2(255) NOT NULL,
  Nachname        VARCHAR2(255) NOT NULL,
  Adresse         VARCHAR2(255) NOT NULL,
  Hausnummer      VARCHAR2(255) NOT NULL,
  Stadt           VARCHAR2(255) NOT NULL,
  PLZ             INT NOT NULL
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
  Baugruppe         VARCHAR2(255),
  Kategorie         VARCHAR2(255),
  BildURL           VARCHAR2(255),
  Beschreibung      VARCHAR2(255)
);

CREATE TABLE Unterartikel (
  Artikelnummer     NUMBER NOT NULL,   
  Artikelkomponente NUMBER NOT NULL,

  FOREIGN KEY(Artikelnummer) REFERENCES Artikel(Artikelnummer),
  FOREIGN KEY(Artikelkomponente) REFERENCES Artikel(Artikelnummer),
  CONSTRAINT unterartikelContraint UNIQUE (Artikelnummer,Artikelkomponente) 
);

CREATE TABLE Bestellposition (
  Bestellnummer     NUMBER NOT NULL,
  Artikelnummer     NUMBER NOT NULL,
  Menge             NUMBER NOT NULL,
  
  FOREIGN KEY(Artikelnummer) REFERENCES Artikel(Artikelnummer),
  FOREIGN KEY(Bestellnummer) REFERENCES Bestellung(Bestellnummer),
  CONSTRAINT bestellpositionConstraint UNIQUE (Artikelnummer,Bestellnummer) 
);


CREATE TABLE Auftrag (
  Auftragsnummer    NUMBER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
  Datum             DATE NOT NULL,
  Bestellnummer     NUMBER NOT NULL,
  
  FOREIGN KEY(Bestellnummer) REFERENCES Bestellung(Bestellnummer)
);
--CREATE TABLE Lieferant();
