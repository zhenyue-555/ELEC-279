package com.example.guessmaster;
//amanda yu 20093332
public class Person extends Entity{
    private String gender;
    //a copy constructor that initialize instance variables in parent class and its own class
    public Person (Person person){
        super(person);
        gender = person.gender;
    }
    ////create method for main method to call the method and create an object of a person
    public Person(String name, Date birth, String gender, double difficulty) {
        super(name,birth,difficulty);
        this.gender = gender;

    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    //clone method using copy method
    public Person clone() {
        return new Person(this);
    }
    public String entityType() {
        return " person";
    }
    //overrides toString method
    public String toString(String name, Date born) {
        return "Name: "+ name +"\n" + "Born at: " + born.toString() +"\n" + "Gender: " + getGender();
    }

}
