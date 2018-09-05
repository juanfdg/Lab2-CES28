package models;

import java.util.Vector;

public class Treatment {
    private Animal animal;
    private String description;
    private Vector<Consult> consults;

    public Treatment(Animal animal){
        this.animal = animal;
    }

    public Animal getAnimal() { return animal; }
    public String getHistory() { return description; }
    public Vector<Consult> getConsults() { return consults; }

    public void setDescription(String description) { this.description = description; }
    public void addConsult(Consult consult){ consults.add(consult); }

}