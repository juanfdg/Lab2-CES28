package models;

import java.util.Date;
import java.util.Vector;

public class Vet{
    private String name;
    private Vector<Consult> consults;

    public Vet(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Vector getConsults() { return consults; }

    public void listSymptoms(Animal animal, String symptoms, Consult c) {

    }

    public void diagnose(Animal animal, String diagnostic, Consult c) {

    }

    public void scheduleConsult(Animal animal, Treatment treatment, Date date) {

    }
}
