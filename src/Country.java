//student number: 20093332
//student name: Amanda Yu
//create country as the subclass of the entity
public class Country extends Entity {
	private String capital;
	//a copy constructor that initialize instance variables in parent class and its own class
	public Country(Country country) {
		super(country);
		capital = country.capital;
		
	}
	//create method for main method call and to create an object of country
public Country(String name, Date birth, String capital, double difficulty) {
	super(name, birth, difficulty);
	this.capital = capital;
}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	//clone method using copy constructor
	public Country clone() {
		return new Country(this);
	}
	public String entityType() {
		return " country";
	}
	//overrides toString method
	public String toString(String name, Date born) {
		return "Name: "+ name +"\n" + "born at: " + born.toString() +"\n" + "Capital: " + getCapital();
	}
	

}
