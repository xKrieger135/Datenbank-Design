
/**
 *
 * @author dima
 */
public interface IFrameControler {
    
    public boolean saveArtikel(
            String artikelName,
            int typ,
            int bestand,
            float preis,
            String baugruppe,
            String kategorie,
            String bildURL,
            String beschreibung
            );
}
