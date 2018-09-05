import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConsultTest {
    private Consult c;
    private Animal nick;
    private Vet vet;
    private Client victor;
    private Treatment t;
    private Date date;

    @Before
    public void setUp() throws Exception {
        victor = new Client("Victor", 21, Client.Sex.M, "salesrvictor@gmail.com");
        nick =  new Animal(victor, "nick", Animal.Sex.M, 2);
        vet = new Vet("Vet");
        t = new Treatment(nick);
        c = new Consult(t, vet, new Date(2018,8,21));
        date = new Date(2018,8,21);
    }

    @Test
    public void testConstructor() {
        assertEquals(t, c.getTreatment());
        assertEquals(date, c.getDate());
        assertNull(c.getSymptoms());
        assertNull(c.getDiagnosis());
    }
}
