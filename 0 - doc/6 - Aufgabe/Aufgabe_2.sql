DROP TABLE FILIALEN CASCADE CONSTRAINTS;

CREATE TABLE FILIALEN
(
  FILIALEN_NAME VARCHAR2(255) NOT NULL,
  STRASSE       VARCHAR2(255) NOT NULL,
  NUMMER        VARCHAR2(100) NOT NULL,
  PLZ           NUMBER NOT NULL,  
  ORT           VARCHAR2(255) NOT NULL,
  GEO_LOKATION  SDO_GEOMETRY
);


DELETE FROM USER_SDO_GEOM_METADATA WHERE TABLE_NAME='FILIALEN' AND COLUMN_NAME='GEO_LOKATION';

-- Add metadata to spatial VIEW USER_SDO_GEOM_METADATA --
INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) 
   VALUES ('FILIALEN', 'GEO_LOKATION', 
   SDO_DIM_ARRAY 
     (SDO_DIM_ELEMENT('LONG', -180.0, 180.0, 0.5), 
     SDO_DIM_ELEMENT('LAT', -90.0, 90.0, 0.5)), 
   4055 );

commit;
   
-- Create spatial index --
CREATE INDEX "IDX_FILIALEN" ON "FILIALEN" ("GEO_LOKATION") INDEXTYPE IS "MDSYS"."SPATIAL_INDEX";

/* beim Ausfuehren tritt immer wieder der Feheler auf:

Fehlerbericht -
SQL-Fehler: ORA-29855: Fehler bei Ausführung der Routine ODCIINDEXCREATE
ORA-13249: internal error in Spatial index: [mdidxrbd]
ORA-13249: Error in Spatial index: index build failed
ORA-13249: Error in spatial index: [mdrcrtxfergm]
ORA-13249: Error in spatial index: [mdpridxtxfergm]
ORA-13200: Interner Fehler [ROWID:AACKT4AAYAAATzVAAA] bei Spatial-Indizierung.
ORA-13206: Interner Fehler [] beim Erstellen von Spatial-Index
ORA-13365: Ebenen-SRID stimmt nicht mit Geometrie-SRID überein
ORA-06512: in "MDSYS.SDO_INDEX_METHOD_10I", Zeile 10
29855. 00000 -  "error occurred in the execution of ODCIINDEXCREATE routine"
*Cause:    Failed to successfully execute the ODCIIndexCreate routine.
*Action:   Check to see if the routine has been coded correctly.


*/


-- INSERT FILIALEN --
INSERT INTO FILIALEN (FILIALEN_NAME,STRASSE,NUMMER,PLZ,ORT,GEO_LOKATION) VALUES 
(
'IKEA Moebel  Einrichtungshaus Hamburg-Altona',
'Große Bergstraße',
'164',
22767,
'HAMBURG',
SDO_GEOMETRY(2001, 4055, 
     SDO_POINT_TYPE (53.551306, 9.941490,NULL),NULL,NULL)
);

INSERT INTO FILIALEN (FILIALEN_NAME,STRASSE,NUMMER,PLZ,ORT,GEO_LOKATION) VALUES 
(
'Bauhaus Hannover',
' Schulenburger Landstraße',
'125',
30165,
'Hannover-Hainholz',
SDO_GEOMETRY(2001, 4055, 
     SDO_POINT_TYPE (52.409659, 9.705166,NULL),NULL,NULL)
);

INSERT INTO FILIALEN (FILIALEN_NAME,STRASSE,NUMMER,PLZ,ORT,GEO_LOKATION) VALUES 
(
'Mediamarkt Lueneburg',
'Lüner Rennbahn',
'4',
21339,
'Lüneburg',
SDO_GEOMETRY(2001, 4055, 
     SDO_POINT_TYPE (53.272626, 10.426123,NULL),NULL,NULL)
);

commit;

-- Find the 3 closest customers to store_id = 101, and
-- order the results by distance.
 
SELECT
   (SELECT k.VORNAME FROM KUNDE k WHERE k.GESCHAEFTSPARTNERNUMMER = g.GESCHAEFTSPARTNERNUMMER) AS VORNAME,
   f.FILIALEN_NAME,
   f.ORT,
   sdo_nn_distance(1) as distance_in_KM
FROM FILIALEN f, 
   GESCHAEFTSPARTNER g
WHERE sdo_nn(f.GEO_LOKATION, g.ORT, 'sdo_num_res=3 unit=KM',1) = 'TRUE' ORDER BY distance_in_KM;
