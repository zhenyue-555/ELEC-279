package com.example.guessmaster;
//amanda yu 20093332
public abstract class Entity {
    private String name;
    private Date born;
    private double difficulty;

    public Entity(String a, Date b, double c) {
        setName(a);
        setBorn(b);
        setDifficulty(c);

    }

    //copy constructor
    public Entity(Entity entity) {
        name = entity.name;
        born = new Date(entity.born);
        difficulty = entity.difficulty;
    }

    //access and mutator
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBorn() {
        // avoid privacy leak
        return new Date(born);
    }

    public void setBorn(Date born) {
        this.born = born;
    }

    public double getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(double difficulty) {
        this.difficulty = difficulty;
    }

    //the toString method can create "name born on date"
    public String toString(String name, Date born) {
        return "Name: " + name + "\n" + "born at: " + born.toString();
    }

    //the method compare String name and Date born
    public boolean equals(Entity entity) {
        return name.equals(entity.name) && born.equals(entity.born);
    }

    public int AwardedTicketNumber() {
        return (int) (difficulty * 100);
    }

    public abstract String entityType();

    public abstract Entity clone();

    public String welcomemessage() {
        return "welcome! Let's start the game! This entity is a " + entityType() + "!";
    }

    public String closingmessage() {
        return "Congratudations! The detailed information of the entity you guess is:" + "\n" + toString(name, born);
    }
}
