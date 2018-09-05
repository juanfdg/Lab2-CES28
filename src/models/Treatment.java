package models;

import java.util.Vector;

public class Treatment {
    private String history;
    private Vector<Consult> consults;

    public Treatment(Consult consults) {
        this.consults.add(Consult);
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }
}