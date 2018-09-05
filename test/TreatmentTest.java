import models.Animal;
import models.Client;
import models.Treatment;
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
        juan = new Vet("Juan");
        nick = new Animal(gui, "Nick", Animal.Sex.M, 5);
    }

    @Test
    public void testOneConsult() {
        juan.scheduleConsult(nick, new Treatment(nick), new Date(2018,8,21));
        //TODO: Pensar em como fazer o caso de teste
        //juan.listSymptoms(nick, "Dor na barriga", c);
        //juan.diagnose(nick, "Diarreia", c);
    }
}
