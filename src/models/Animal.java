package models;

import java.util.Vector;

public class Animal {
    public enum  Sex{
        M, F, ND
    }

    private Client client;
    private String name;
    private Sex sex;
    private int age;
    private Vector<Treatment> treatments;

    public Animal(Client client, String name, Sex sex, int age) {
        this.client = client;
        this.client.addAnimal(this);
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.treatments = new Vector<>();
    }

    public Client getClient() {
        return client;
    }

    public String getName() {
        return name;
    }

    public Sex getSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Vector getTreatments(){
        return treatments;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void startTreatment(Consult consult){

    }
}
