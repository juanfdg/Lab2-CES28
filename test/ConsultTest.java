import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ConsultTest {
    private Consult consult;
    private Animal nick;
    private Vet vet;
    private Client victor;
    private Treatment treatment;
    private Date date;

    @Before
    public void setUp() throws Exception {
        victor = new Client("Victor", 21, Client.Sex.M, "salesrvictor@gmail.com");
        nick =  new Animal(victor, "nick", Animal.Sex.M, 2);
        vet = new Vet("Vet");
        treatment = new Treatment(nick);
        consult = new Consult(treatment, vet, new Date(2018,8,21));
        date = new Date(2018,8,21);
    }

    @Test
    public void testConstructor() {
        assertEquals(treatment, consult.getTreatment());
        assertEquals(date, consult.getDate());
        assertNull(consult.getSymptoms());
        assertNull(consult.getDiagnosis());
    }
}
