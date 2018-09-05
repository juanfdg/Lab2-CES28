package models;

import java.util.Vector;

public class Vet{
    private String name;
    private Vector<Consult> consults;

    public String getName() {
        return name;
    }

    public Vector getConsults() {
        return consults;
    }

    public void setName(String name) {
        this.name = name;
    }
}
