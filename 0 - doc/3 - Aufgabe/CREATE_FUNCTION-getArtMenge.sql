CREATE OR REPLACE 
FUNCTION getArtikelMenge(artikelID IN NUMBER) RETURN NUMBER IS

res       NUMBER;
countArt  NUMBER;
best      NUMBER;

BEGIN
  res := 999999;  
  best := 0;
  
  -- wenn kein artikel gefunden --
  SELECT COUNT(*) INTO countArt FROM ARTIKEL WHERE ARTIKEL.ARTIKELNUMMER = artikelID;
  IF ( countArt IS NULL OR countArt = 0) THEN
    return 0;
  END IF;

  -- wenn es keine unterartikel gibt
  SELECT COUNT(*) INTO countArt FROM UNTERARTIKEL u WHERE u.ARTIKELNUMMER = artikelID;
  if (countArt = 0) then 
    SELECT art.BESTAND into best FROM ARTIKEL art WHERE art.artikelnummer = artikelID;
    return best;
  end if;

  
  for artObj in (SELECT * FROM UNTERARTIKEL u WHERE u.ARTIKELNUMMER = artikelID) LOOP
    res := LEAST( res , getUnterartikelMenge(artObj.ARTIKELKOMPONENTE, artObj.MENGE));
  END LOOP;
  
  RETURN res;
  
END getArtikelMenge;
/