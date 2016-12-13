@'fill_test-data.sql';

ALTER TABLE GESCHAEFTSPARTNER
DROP COLUMN ORT;

ALTER TABLE GESCHAEFTSPARTNER
ADD ORT SDO_GEOMETRY;


-- recompile procedures --
@'CREATE_PROCEDURE-INSERT-KUNDE.sql';
@'CREATE_PROCEDURE-INSERT-LIEFERANT.sql';

INSERT INTO USER_SDO_GEOM_METADATA (TABLE_NAME, COLUMN_NAME, DIMINFO, SRID) 
   VALUES ('GESCHAEFTSPARTNER', 'ORT', 
      SDO_DIM_ARRAY 
        (SDO_DIM_ELEMENT('LONG', -180.0, 180.0, 0.5), 
      SDO_DIM_ELEMENT('LAT', -90.0, 90.0, 0.5)), 
      4055 );

commit;

CREATE INDEX "IDX_GESCHAEFTSPARTNER" ON "GESCHAEFTSPARTNER" ("ORT")
INDEXTYPE IS "MDSYS"."SPATIAL_INDEX" ;
/

execute INSERT_KUNDE('HANS','PETER','irgendwo','1a',MDSYS.SDO_GEOMETRY(2001,4055 ,MDSYS.SDO_POINT_TYPE(53.58163,9.988361,NULL),NULL,NULL),1234,'asdbIBAN','email',telefon_nummern('053934893223', '0173/59341', '04937477538383'));


execute INSERT_KUNDE('Franz','Mannfred','irgendwo','1a',MDSYS.SDO_GEOMETRY(2001,4055 ,MDSYS.SDO_POINT_TYPE(53.552262,9.934844,NULL),NULL,NULL),1234,'asdbIBAN','email',null);
execute INSERT_KUNDE('Lutz','Sufrud','irgendwo','1a',MDSYS.SDO_GEOMETRY(2001,4055 ,MDSYS.SDO_POINT_TYPE(53.556158,10.022125,NULL),NULL,NULL),1234,'asdbIBAN','email',null);
execute INSERT_KUNDE('Chris','Dada','irgendwo','1a',MDSYS.SDO_GEOMETRY(2001,4055 ,MDSYS.SDO_POINT_TYPE(53.550383,9.992385,NULL),NULL,NULL),1234,'asdbIBAN','email',null);
execute INSERT_KUNDE('Felix','Hierundda','irgendwo','1a',MDSYS.SDO_GEOMETRY(2001,4055 ,MDSYS.SDO_POINT_TYPE(53.553831,10.083741,NULL),NULL,NULL),1234,'asdbIBAN','email',null);
commit;
