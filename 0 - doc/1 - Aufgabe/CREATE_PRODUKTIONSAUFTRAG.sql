--------------------------------------------------------
--  Datei erstellt -Montag-Oktober-24-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure CREATE_PRODUKTIONSAUFTRAEGE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE CREATE_PRODUKTIONSAUFTRAEGE AS

BEGIN
    INSERT INTO PRODUKTIONSAUFTRAG(BESTELLNUMMER, MONAT)
      SELECT BST.BESTELLNUMMER, to_char(BST.DATUM, 'yyyy')
      FROM BESTELLUNG BST,
           BESTELLPOSITION BSP
      WHERE BST.BESTELLNUMMER = BSP.BESTELLNUMMER
      AND   BST.DATUM < TRUNC(SYSDATE) + INTERVAL '23:59:59' HOUR TO SECOND
      AND   BST.BESTELLNUMMER not in (SELECT P.BESTELLNUMMER FROM PRODUKTIONSAUFTRAG P);    
END CREATE_PRODUKTIONSAUFTRAEGE;

/
