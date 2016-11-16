SELECT    SUM(bst.preis), kun.NACHNAME
FROM      Kunde kun
,         Bestellung bst
WHERE     bst.KUNDENNUMMER = kun.KUNDENNUMMER
AND       bst.PREIS > '0'
GROUP BY kun.NACHNAME

UNION

SELECT    0, kun.NACHNAME
FROM      Kunde kun
,         Bestellung bst
WHERE     kun.KUNDENNUMMER NOT IN bst.KUNDENNUMMER;