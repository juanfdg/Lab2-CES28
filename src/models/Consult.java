package models;

import java.util.Date;

public class Consult {
    private Treatment treatment;
    private Animal animal;
    private Vet vet;
    private Date date;
    private String symptoms;
    private String diagnosis;

    //First consult constructor
    public Consult(Animal animal, Vet vet,
                   Date date) {
        this.animal = animal;
        animal.startTreatment(this);
        this.treatment = animal.getTreatments().lastElement();
        this.vet = vet;
        vet.getConsults().add(this);
        this.date = date;
    }

    //Next consult construtor
    public Consult(Treatment treatment, Animal animal, Vet vet,
                   Date date) {
        this.animal = animal;
        animal.startTreatment(this);
        this.vet = vet;
        vet.getConsults().add(this);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
}
