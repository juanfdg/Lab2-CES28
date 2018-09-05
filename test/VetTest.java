import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class VetTest {
    private Vet juan;
    private Client victor;
    private Animal nick;
    private Date date;

    @Before
    public void setUp() throws Exception {
        juan = new Vet("Juan");
        victor = new Client("Victor", 21, Client.Sex.M, "salesrvictor@gmail.com");
        nick = new Animal(victor, "nick", Animal.Sex.M, 2);
        date = new Date(2018,8,21);
    }

    @Test
    public void testConstructor() {
        assertEquals("Juan", juan.getName());
    }

    @Test
    public void testScheduleConsult() {
        assertEquals(0, juan.getConsults().size());

        juan.scheduleConsult(new Treatment(nick), date);
        assertEquals(1, juan.getConsults().size());

        Consult c = juan.getConsult(date);
        assertNull(c.getSymptoms());
        assertNotNull(c.getTreatment());
        assertEquals(date, c.getDate());
        assertNull(c.getDiagnosis());
    }
}
