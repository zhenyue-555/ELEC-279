package com.example.guessmaster;
//amanda yu 20093332
public class Politician extends Person{
    private String party;
    //create method for main method call and to create an object of politician
    public Politician (String name, Date birth, String gender, String party,double difficulty) {
        super(name, birth, gender, difficulty);
        this.party = party;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }
    //a copy constructor that initialize instance variables in parent class and its own class
    public Politician (Politician politician){
        super(politician);
        party = politician.party;
    }
    //clone method using copy constructor
    public Politician clone() {
        return new Politician(this);
    }
    public String entityType() {
        return " Politician";
    }
    //overrides toString method
    public String toString(String name, Date born) {
        return "Name: "+ name +"\n" + "Born at: " + born.toString() +"\n" + "Gender: " + getGender() + "\n" + "Party: " + getParty();
    }
}
