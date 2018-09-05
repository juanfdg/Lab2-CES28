package models;

import java.util.Date;
import java.util.HashMap;

public class Vet{
    private String name;
    private HashMap<Date, Consult> consults;

    public Vet(String name) {
        this.name = name;
    }

    public String getName() { return name; }
    public HashMap<Date, Consult> getConsults() { return consults; }

    public void listSymptoms(String symptoms, Consult consult) {
        consult.setSymptoms(symptoms);
    }

    public void diagnose(String diagnosis, Consult consult) {
        consult.setDiagnosis(diagnosis);
    }

    public void scheduleConsult(Treatment treatment, Date date) {
        Consult consult = new Consult(treatment, this, date);
        treatment.addConsult(consult);
        consults.put(date, consult);
    }

    public Consult getConsult(Date date) {
        return consults.get(date);
    }
}
