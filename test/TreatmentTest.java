import models.Animal;
import models.Client;
import models.Consult;
import models.Vet;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

public class TreatmentTest {
    private Client gui;
    private Animal nick;
    private Vet juan;

    @Before
    public void setUp() {
        gui = new Client("Guilherme", 21, Client.Sex.M, "guipcleao@gmail.com");
        juan = new Vet("Juan", 21, Client.Sex.M, "juanfdg@gmail.com");
        nick = new Animal(gui, "Nick", Animal.Sex.M, 5);
    }

    @Test
    public void testOneConsult() {
        Consult c = new Consult(nick, juan, new Date(2018,8,21));

        juan.listSymptoms(nick, "Dor na barriga", c);
        juan.diagnose(nick, "Diarreia", c);
    }
}
