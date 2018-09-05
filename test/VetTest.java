import models.Animal;
import models.Client;
import models.Treatment;
import models.Vet;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class VetTest {
    private Vet juan;
    private Client victor;
    private Animal nick;

    @Before
    public void setUp() throws Exception {
        juan = new Vet("Juan");
        victor = new Client("Victor", 21, Client.Sex.M, "salesrvictor@gmail.com");
        nick = new Animal(victor, "nick", Animal.Sex.M, 2);
    }

    @Test
    public void testConstructor() {
        assertEquals(juan.getName(), "Juan");
    }

    @Test
    public void testScheduleConsult() {
        assertEquals(juan.getConsults().size(), 0);

        juan.scheduleConsult(nick, new Treatment(nick), new Date(2018,8,21));
        assertEquals(juan.getConsults().size(), 1);

        //TODO: Continue
    }
}
