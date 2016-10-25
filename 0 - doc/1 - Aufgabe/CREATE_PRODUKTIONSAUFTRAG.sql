--------------------------------------------------------
--  Datei erstellt -Montag-Oktober-24-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure CREATE_PRODUKTIONSAUFTRAEGE
--------------------------------------------------------
set define off;

  CREATE OR REPLACE PROCEDURE CREATE_PRODUKTIONSAUFTRAEGE AS

BEGIN
  --if SYSTIMESTAMP = '23:59:59' then

    INSERT INTO PRODUKTIONSAUFTRAG(BESTELLNUMMER, MONAT)
      SELECT BST.BESTELLNUMMER, to_char(BST.DATUM, 'yyyy')
      FROM BESTELLUNG BST,
           BESTELLPOSITION BSP
      WHERE BST.BESTELLNUMMER = BSP.BESTELLNUMMER
      AND   BST.DATUM < TRUNC(SYSDATE) + INTERVAL '23:59:59' HOUR TO SECOND
      AND   BST.BESTELLNUMMER not in (SELECT P.BESTELLNUMMER FROM PRODUKTIONSAUFTRAG P);
    
/*      SELECT * 
  FROM BESTELLUNG BST, 
       BESTELLPOSITION BSP
  WHERE BST.BESTELLNUMMER = BSP.BESTELLNUMMER
  AND   BST.DATUM < TRUNC(SYSDATE) + INTERVAL '23:59:59' HOUR TO SECOND;
    */
    
  --end if;
END CREATE_PRODUKTIONSAUFTRAEGE;

/
