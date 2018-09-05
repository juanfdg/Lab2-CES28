package models;

import java.util.Date;

public class Consult {
    private Treatment treatment;
    private Animal animal;
    private Vet vet;
    private Date date;
    private String symptoms;
    private String diagnosis;

    public Consult(Treatment treatment, Vet vet,
                   Date date) {
        this.treatment = treatment;
        this.animal = treatment.getAnimal();
        this.vet = vet;
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
