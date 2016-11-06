--------------------------------------------------------
--  Datei erstellt -Sonntag-November-06-2016   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Procedure RECURSIVESQL
--------------------------------------------------------
set define off;

  CREATE OR REPLACE EDITIONABLE PROCEDURE "ABQ295"."RECURSIVESQL" (
                                     OA OUT UNTERARTIKEL.ARTIKELNUMMER%TYPE,
                                     UA OUT UNTERARTIKEL.ARTIKELKOMPONENTE%TYPE,
                                     NA OUT ARTIKEL.ARTIKELNAME%TYPE) AS
                                     
    CURSOR csr is SELECT       UART.ARTIKELNUMMER, 
                               UART.ARTIKELKOMPONENTE,
                               (SELECT ART.ARTIKELNAME
                                FROM ARTIKEL ART
                                WHERE ART.ARTIKELNUMMER = UART.ARTIKELNUMMER
                               )
                               --INTO         OA, UA, NA
                               FROM         UNTERARTIKEL UART  
                               --WHERE        UART.ARTIKELNUMMER = 21
                               START WITH   UART.ARTIKELNUMMER = 21
                               CONNECT BY   PRIOR UART.ARTIKELKOMPONENTE = UART.ARTIKELNUMMER;                                    
BEGIN

  open csr;
    loop
      fetch csr into OA, UA, NA;
      exit when csr%notfound;
      DBMS_OUTPUT.put_line(OA || ' , ' || UA || ' , ' || NA);
    end loop;
  close csr;

  /*SELECT       UART.ARTIKELNUMMER, 
               UART.ARTIKELKOMPONENTE,
               (SELECT ART.ARTIKELNAME
                FROM ARTIKEL ART
                WHERE ART.ARTIKELNUMMER = UART.ARTIKELNUMMER
                )
  INTO         OA, UA, NA
  FROM         UNTERARTIKEL UART  
  WHERE        UART.ARTIKELNUMMER = 21
  START WITH   UART.ARTIKELNUMMER = 21
  CONNECT BY   PRIOR UART.ARTIKELKOMPONENTE = UART.ARTIKELNUMMER;*/
END RECURSIVESQL;

/
