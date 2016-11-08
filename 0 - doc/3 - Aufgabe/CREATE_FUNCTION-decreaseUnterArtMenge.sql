create or replace FUNCTION decreaseUnterArt(artikelID IN NUMBER, decrease IN NUMBER, menge IN NUMBER) RETURN BOOLEAN IS

-- variablen
countArt  NUMBER;
res       NUMBER;
ret       BOOLEAN;

BEGIN
  
  -- wenn kein artikel gefunden --
  SELECT COUNT(*) INTO countArt FROM ARTIKEL WHERE ARTIKEL.ARTIKELNUMMER = artikelID;
  IF (countArt = 0) THEN
    return FALSE;
  END IF;

  -- wenn es keine unterartikel gibt
  SELECT COUNT(*) INTO countArt FROM UNTERARTIKEL u WHERE u.ARTIKELNUMMER = artikelID;
  if (countArt = 0) then 
    SELECT ARTIKEL.BESTAND INTO res FROM ARTIKEL WHERE ARTIKEL.ARTIKELNUMMER = artikelID;
    UPDATE ARTIKEL SET ARTIKEL.BESTAND = (res - decrease) WHERE ARTIKEL.ARTIKELNUMMER = artikelID;
    return TRUE;
  end if;

  ret := true;
  for artObj in (SELECT * FROM UNTERARTIKEL u WHERE u.ARTIKELNUMMER = artikelID) LOOP
    ret := ret AND decreaseUnterArt( artObj.ARTIKELKOMPONENTE, decrease ,artObj.MENGE + menge );
  END LOOP;
  
  return ret;
  
END decreaseUnterArt;