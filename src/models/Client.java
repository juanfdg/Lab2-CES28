package models;

import java.util.Vector;

public class Client {
    public enum  Sex{
        M, F, ND;
    }

    private String name;
    private int age;
    private Sex sex;
    private String email;
    private Vector animals;

    public Client(String name, int age, Sex sex, String email) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.email = email;
        animals = new Vector();
    }

    public String getName(){
        return name;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex(){
        return sex;
    }

    public String getEmail() {
        return email;
    }

    public Vector getAnimals(){
        return animals;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAnimal(Animal animal){
        animals.add(animal);
    }
}
