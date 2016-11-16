CREATE OR REPLACE TRIGGER CHECK_BESTELLPOSITION 
BEFORE INSERT ON BESTELLPOSITION 
FOR EACH ROW

DECLARE
  ret   BOOLEAN;
BEGIN
  
  IF (getArtikelMenge(:NEW.ARTIKELNUMMER) >= :NEW.MENGE)
  	THEN
	  	ret := decreaseArt(:NEW.ARTIKELNUMMER, :NEW.MENGE);
	  	INSERT INTO LOG(DATUM,TABELLENAME,MESSAGE) VALUES(SYSTIMESTAMP,'BESTELLPOSITION','SUCCESSFULL');
      
      -- TODO SEND MAIL
      /*
      UTL_MAIL.SEND (
         'dimitri.meier@haw-hamburg.de',
         'dimitri.meier@haw-hamburg.de',
         'YOUR GOT A MAIL',
         'DEINE BESTELLUNG '
      );
      */
	 ELSE
	 	INSERT INTO LOG(DATUM,TABELLENAME,MESSAGE) VALUES(SYSTIMESTAMP,'BESTELLPOSITION','FAILED' || 'BESTELLPOSITION.MENGE > ARTIKEL.MENGE');
    commit;
    RAISE_APPLICATION_ERROR(-20001,'BESTELLPOSITION.MENGE > ARTIKEL.MENGE');
  END IF;
END;