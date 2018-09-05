import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class VetTest {
    private Vet juan;
    private Client victor;
    private Animal nick;
    private Date date;
    private Treatment treatment;

    @Before
    public void setUp() throws Exception {
        juan = new Vet("Juan");
        victor = new Client("Victor", 21, Client.Sex.M, "salesrvictor@gmail.com");
        nick = new Animal(victor, "nick", Animal.Sex.M, 2);
        date = new Date(2018,8,21);
        treatment = new Treatment(nick);
    }

    @Test
    public void testConstructor() {
        assertEquals("Juan", juan.getName());
    }

    @Test
    public void testScheduleConsult() {
        assertEquals(0, juan.getConsults().size());

        juan.scheduleConsult(treatment, date);
        assertEquals(1, juan.getConsults().size());

        Consult consult = juan.getConsult(date);
        assertNull(consult.getSymptoms());
        assertEquals(treatment, consult.getTreatment());
        assertEquals(date, consult.getDate());
        assertNull(consult.getDiagnosis());
    }

    @Test
    public void testListSymptom() {
        juan.scheduleConsult(treatment, date);

        Consult consult = juan.getConsult(date);
        juan.listSymptoms("Dor de barriga", consult);
        assertEquals("Dor de barriga", consult.getSymptoms());
    }

    @Test
    public void testDiagsone() {
        juan.scheduleConsult(treatment, date);

        Consult consult = juan.getConsult(date);
        juan.listSymptoms("Dor de barriga", consult);
        juan.diagnose("Diarreia", consult);
        assertEquals("Diarreia", consult.getDiagnosis());
    }
}
