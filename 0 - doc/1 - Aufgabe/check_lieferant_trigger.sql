CREATE OR REPLACE TRIGGER CHECK_LIEFERANT 
BEFORE INSERT OR UPDATE ON LIEFERANT 
FOR EACH ROW

DECLARE
  ANZAHL    NUMBER;

BEGIN
  IF :NEW.ORT IS NOT NULL THEN
    SELECT COUNT(*) INTO ANZAHL
    FROM LIEFERANT l
    WHERE l.ORT = :NEW.ORT;
    
    IF (ANZAHL > 0)  
      THEN RAISE_APPLICATION_ERROR(-20001,'Lieferant mit dem ORT '|| :NEW.ORT || ' bereits vorhanden');
    END IF;
  END IF;  
    
END;
