CREATE OR REPLACE
FUNCTION getUnterartikelMenge(artikelID IN NUMBER, menge IN NUMBER) RETURN INTEGER IS

count_unterart  NUMBER;
art_menge       INTEGER;

BEGIN
  
  count_unterart := 0;
  art_menge := 999999;
  
  SELECT COUNT(*) INTO count_unterart FROM UNTERARTIKEL u WHERE u.ARTIKELNUMMER = artikelID;
  
  IF (count_unterart = 0) THEN 
      art_menge := 0;
      SELECT art.BESTAND INTO art_menge FROM ARTIKEL art WHERE art.ARTIKELNUMMER = artikelID;
      RETURN art_menge;
  END IF;
  
  
  FOR artObj IN (SELECT * FROM UNTERARTIKEL u WHERE u.ARTIKELNUMMER = artikelID) LOOP
    art_menge := LEAST( art_menge , (getUnterartikelMenge(artObj.ARTIKELKOMPONENTE, (artObj.MENGE)) / (menge * artObj.MENGE)) );
  END LOOP;
  
  return CEIL(art_menge);
  
END getUnterartikelMenge;
/
