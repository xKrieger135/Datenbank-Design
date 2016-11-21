package de.haw.hamburg.productcomponent.accesslayer.view;

import de.haw.hamburg.productcomponent.accesslayer.model.Geschaeftspartner;

import java.util.List;

/**
 *
 * @author dima
 */
public interface IFrameController {
    
    boolean login(String username, String password);
    
    void logout();

    boolean deleteGeschaeftspartner(Number geschaeftspartnerNummer);

    List<Geschaeftspartner> searchGeschaeftspartner(String searchString);

    boolean updateGeschaeftspartner(Geschaeftspartner updatedG);

    void createGeschaeftspartner(Geschaeftspartner g);
    
}
