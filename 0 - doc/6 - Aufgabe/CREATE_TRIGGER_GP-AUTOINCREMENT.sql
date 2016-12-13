-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
-- CREATE TRIGGER FOR AUTOINCREMENT 
-- +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
CREATE OR REPLACE TRIGGER autoincrement_gp_new
BEFORE INSERT ON GESCHAEFTSPARTNER 
FOR EACH ROW

BEGIN
  SELECT geschaeftspartner_seq.NEXTVAL
  INTO   :NEW.GESCHAEFTSPARTNERNUMMER
  FROM   dual;
END;
/
