import models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class TreatmentTest {
    private Client client;
    private Animal animal;
    private Vet vet;
    private Date date1;
    private Date date2;
    private Treatment treatment;

    @Before
    public void setUp() {
        client = new Client("Guilherme", 21, Client.Sex.M, "guipcleao@gmail.com");
        vet = new Vet("Juan");
        animal = new Animal(client, "Nick", Animal.Sex.M, 5);
        date1 = new Date(2018,8,21);
        date2 = new Date(2018,8,22);
        treatment = vet.startTreatment(animal);
    }

    @Test
    public void testOneConsult() {
        assertEquals(0, treatment.getConsults().size());

        vet.scheduleConsult(treatment, date1);
        assertEquals(1, treatment.getConsults().size());

        Consult consult = vet.getConsult(date1);
        assertEquals(treatment.getConsults().elementAt(0), consult);

        vet.listSymptoms("Dor na barriga", consult);
        vet.diagnose("Diarreia", consult);
    }

    @Test
    public void testTwoConsults() {
        vet.scheduleConsult(treatment, date1);

        Consult consult1 = vet.getConsult(date1);
        vet.listSymptoms("Dor na barriga", consult1);
        vet.diagnose("Diarreia", consult1);
        vet.scheduleConsult(consult1.getTreatment(), date2);
        assertEquals(2, treatment.getConsults().size());

        Consult consult2 = vet.getConsult(date2);
        assertEquals(treatment.getConsults().elementAt(1), consult2);

        vet.listSymptoms("Dor na orelha", consult2);
        vet.diagnose("Olherite", consult2);
    }

    @Test
    public void testTwoTreatments_OneConsult() {
        assertEquals(1, animal.getTreatments().size());

        Treatment treatment1 = treatment;
        vet.scheduleConsult(treatment1, date1);
        assertEquals(1, animal.getTreatments().size());

        Consult consult1 = vet.getConsult(date1);
        assertEquals(animal.getTreatments().elementAt(0), treatment1);
        assertEquals(treatment1.getConsults().elementAt(0), consult1);

        vet.listSymptoms("Dor na barriga", consult1);
        vet.diagnose("Diarreia", consult1);

        Treatment treatment2 = vet.startTreatment(animal);
        vet.scheduleConsult(treatment2, date2);
        assertEquals(2, animal.getTreatments().size());

        Consult consult2 = vet.getConsult(date2);
        assertEquals(animal.getTreatments().elementAt(1), treatment2);
        assertEquals(treatment2.getConsults().elementAt(0), consult2);

        vet.listSymptoms("Dor na orelha", consult2);
        vet.diagnose("Olherite", consult2);
    }
}
