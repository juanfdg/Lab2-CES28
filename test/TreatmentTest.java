import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TreatmentTest {
    private Client gui;
    private Animal nick;
    private Vet juan;
    private Date date1;
    private Date date2;
    private Treatment treatment;

    @Before
    public void setUp() {
        gui = new Client("Guilherme", 21, Client.Sex.M, "guipcleao@gmail.com");
        juan = new Vet("Juan");
        nick = new Animal(gui, "Nick", Animal.Sex.M, 5);
        date1 = new Date(2018,8,21);
        date2 = new Date(2018,8,22);
        treatment = new Treatment(nick);
    }

    @Test
    public void testOneConsult() {
        assertEquals(0, treatment.getConsults().size());

        juan.scheduleConsult(treatment, date1);
        assertEquals(1, treatment.getConsults().size());

        Consult consult = juan.getConsult(date1);
        assertEquals(treatment.getConsults().elementAt(0), consult);

        juan.listSymptoms("Dor na barriga", consult);
        juan.diagnose("Diarreia", consult);
    }

    @Test
    public void testTwoConsults() {
        juan.scheduleConsult(treatment, date1);

        Consult consult1 = juan.getConsult(date1);
        juan.listSymptoms("Dor na barriga", consult1);
        juan.diagnose("Diarreia", consult1);
        juan.scheduleConsult(consult1.getTreatment(), date2);
        assertEquals(2, treatment.getConsults().size());

        Consult consult2 = juan.getConsult(date2);
        assertEquals(treatment.getConsults().elementAt(1), consult2);

        juan.listSymptoms("Dor na orelha", consult2);
        juan.diagnose("Olherite", consult2);
    }

    @Test
    public void testTwoTreatments_OneConsult() {
        assertEquals(0, nick.getTreatments().size());

        Treatment treatment1 = treatment;
        juan.scheduleConsult(treatment1, date1);
        assertEquals(1, nick.getTreatments().size());

        Consult consult1 = juan.getConsult(date1);
        assertEquals(nick.getTreatments().elementAt(0), treatment1);
        assertEquals(treatment1.getConsults().elementAt(0), consult1);

        juan.listSymptoms("Dor na barriga", consult1);
        juan.diagnose("Diarreia", consult1);

        Treatment treatment2 = new Treatment(nick);
        juan.scheduleConsult(treatment2, date2);
        assertEquals(2, nick.getTreatments().size());

        Consult consult2 = juan.getConsult(date2);
        assertEquals(nick.getTreatments().elementAt(1), treatment2);
        assertEquals(treatment2.getConsults().elementAt(0), consult2);

        juan.listSymptoms("Dor na orelha", consult2);
        juan.diagnose("Olherite", consult2);
    }
}
