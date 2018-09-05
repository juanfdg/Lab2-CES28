import models.*;
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
        Consult c = juan.getConsult(new Date(2018,8,21));
        juan.listSymptoms(nick, "Dor na barriga", c);
        juan.diagnose(nick, "Diarreia", c);
    }

    @Test
    public void testTwoConsults() {
        juan.scheduleConsult(nick, new Treatment(nick), new Date(2018,8,21));

        Consult c1 = juan.getConsult(new Date(2018,8,21));
        juan.listSymptoms(nick, "Dor na barriga", c1);
        juan.diagnose(nick, "Diarreia", c1);
        juan.scheduleConsult(nick, c1.getTreatment(), new Date(2018,8,22));

        Consult c2 = juan.getConsult(new Date(2018,8,22));
        juan.listSymptoms(nick, "Dor na orelha", c2);
        juan.diagnose(nick, "Olherite", c2);
    }
}
