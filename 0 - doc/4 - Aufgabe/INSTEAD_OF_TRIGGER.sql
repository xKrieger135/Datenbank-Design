CREATE OR REPLACE TRIGGER INSERT_ON_VIEW_TRIGGER 
INSTEAD OF INSERT ON GP_VIEW
BEGIN
  INSERT INTO GESCHAEFTSPARTNER
  VALUES (:NEW.GESCHAEFTSPARTNERNUMMER, :new.STRASSE, :new.NUMMER, :NEW.ORT, :new.PLZ, :new.IBAN, :new.EMAIL);
END;