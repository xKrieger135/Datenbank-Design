create or replace TRIGGER checkplz
BEFORE INSERT OR UPDATE ON KUNDE
FOR EACH ROW

DECLARE
  ANZAHL_PLZ    NUMBER;
  ANZAHL_STADT  NUMBER;
BEGIN
  
  IF :NEW.PLZ IS NOT NULL AND :NEW.STADT IS NOT NULL THEN
    SELECT COUNT(*) INTO ANZAHL_PLZ 
    FROM GERKEN.PLZVERZEICHNIS v 
    WHERE v.PLZ = :NEW.PLZ
    AND v.ORT = :NEW.STADT;
  
    IF (ANZAHL_PLZ = 0)
      THEN RAISE_APPLICATION_ERROR(-20001,'PLZ ODER Stadt ungueltig!');
    END IF;
  ELSE
    RAISE_APPLICATION_ERROR(-20001,'PLZ ODER Stadt duerfen nicht NULL sein!');
  END IF;  
END;