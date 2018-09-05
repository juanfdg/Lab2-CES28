package models;

import java.util.Date;
import java.util.Map;

public class Vet{
    private String name;
    private Map<Date, Consult> consults;

    public Vet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Map<Date, Consult> getConsults() { return consults; }

    public void listSymptoms(String symptoms, Consult consult) {

    }

    public void diagnose(String diagnostic, Consult c) {

    }

    public void scheduleConsult(Treatment treatment, Date date) {

    }

    public Consult getConsult(Date date) {
        return null;
    }
}
