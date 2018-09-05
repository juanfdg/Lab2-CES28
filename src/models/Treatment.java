package models;

import java.util.Vector;

public class Treatment {
    private Animal animal;
    private String history;
    private Vector<Consult> consults;

    public Treatment(Animal animal){
        this.animal = animal;
    }

    public Animal getAnimal() { return animal; }
    public String getHistory() {
        return history;
    }
    public Vector<Consult> getConsults() {
        return consults;
    }

    public void setHistory(String history) { this.history = history; }
    public void addConsult(Consult consult){ consults.add(consult); }

}