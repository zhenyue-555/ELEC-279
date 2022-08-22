package com.example.guessmaster;
//amanda yu 20093332
public class Singer extends Person{
    private String debutAlbum;
    private Date debutAlblumReleaseDate;
    public String getDebutAlbum() {
        return debutAlbum;
    }
    public void setDebutAlbum(String debutAlbum) {
        this.debutAlbum = debutAlbum;
    }
    public Date getDebutAlblumReleaseDate() {
        return debutAlblumReleaseDate;
    }
    public void setDebutAlblumReleaseDate(Date debutAlblumReleaseDate) {
        this.debutAlblumReleaseDate = debutAlblumReleaseDate;
    }
    //a copy constructor that initialize instance variables in parent class and its own class
    public Singer (Singer singer) {
        super(singer);
        debutAlbum = singer.debutAlbum;
        debutAlblumReleaseDate = singer.debutAlblumReleaseDate;
    }
    //create method for main method call and to create an object of singer
    public Singer (String name, Date birth, String gender,String debutAlbum,Date debutAlblumReleaseDate,double difficulty) {
        super(name, birth, gender, difficulty);
        this.debutAlbum = debutAlbum ;
        this.debutAlblumReleaseDate = debutAlblumReleaseDate;


    }
    public Singer clone() {
        return new Singer(this);
    }
    public String entityType() {
        return "Singer";
    }
    //overrides toString method
    public String toString(String name, Date born) {
        return "Name: "+ name +"\n" + "Born at: " + born.toString() +"\n" + "Gender: " + getGender() + "\n" + "debut Album: " + getDebutAlbum() +"\n" +"Release Date: "+ getDebutAlblumReleaseDate();
    }
}

