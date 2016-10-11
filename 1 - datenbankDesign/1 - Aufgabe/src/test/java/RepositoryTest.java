import de.haw.hamburg.productcomponent.dataaccesslayer.dtos.ArtikelDTO;
import de.haw.hamburg.productcomponent.dataaccesslayer.entities.Artikel;
import de.haw.hamburg.productcomponent.dataaccesslayer.repositories.ArtikelRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by patri on 11.10.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
public class RepositoryTest {

    @Autowired
    private ArtikelRepository artikelRepository;
    @Test
    public void saveKundeSuccess() {
        ArtikelDTO artikelDTO = new ArtikelDTO("Banane", 1, 22, 222.2f, "x", "weissnichtman", "asdasdasdasd", "testtest123");
        artikelRepository.save(artikelDTO.convertToArtikelEntity());
    }
}
