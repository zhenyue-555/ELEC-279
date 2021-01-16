import java.util.Random;
import java.util.Scanner;
//student number: 20093332
//student name: Amanda Yu
public class GuessMaster {
	private int numberOfCandidateEntities;
	private Entity[] entities;
	private int TotalTickets = 0;

	public static void main(String[] args) {
		
		// The last parameter of the follow line is the difficulty score described above. Politician trudeau = new Politician(”Justin Trudeau”, new Date(”December”, 25, 1971), ”Male”, ”Liberal”, 0.25);
		/*The first Date parameter in the parameter in the following line is the birth date of the singer and the second Date parameter is the release date of the debut album.*/ 
		Politician trudeau = new Politician ("Justin Trudeau", new Date("December", 25, 1971),"Male", "Liberal", 0.25);
		trudeau.entityType();
		Singer dion = new Singer ("Celine Dion",new Date("March", 30, 1961),"Female","La voix du bon Dieu",new Date("November", 6, 1981),0.5);
		Person myCreator = new Person ("myCreator",new Date("September", 1, 2000),"Female", 1.0); 
		Country usa = new Country ("United States",new Date("July", 4, 1776), "Washinton D.C.", 0.1);
		GuessMaster gm = new GuessMaster(); 
		gm.addEntity(trudeau); 
		gm.addEntity(dion); 
    	gm.addEntity(myCreator); 
		gm.addEntity(usa);
		gm.playGame();


	}

	public GuessMaster() {
		// for initialize attributes
		numberOfCandidateEntities = 0;
		entities = new Entity[5]; // array[size]
	}

	public void addEntity(Entity entity) {
		// take the object entity as input and place it into entities array
		entities[numberOfCandidateEntities] = entity.clone();
		// after place one object into the array, the index plus one
		numberOfCandidateEntities += 1;
	}
	

//use object entity as the input, start play the game
	public void playGame(Entity entity) {
		// use scanner to obtain the input from player
		Scanner sc = new Scanner(System.in);
		// use the method getName() from Entity class
		System.out.println("*********************************");
		System.out.println(entity.welcomemessage());
		System.out.println("you are guessing " + entity.getName() + " 's birthday ");
		while (true) {
			String input = sc.nextLine();
			if (input.equals("quit")) { // player enter quit, then exits from while loop
				System.exit(0);
			}
			Date born1 = new Date(input); // create an object born1
			Date born2 = entity.getBorn(); // using getBorn() method from Entity to create another object born2

			if (born1.equals(born2)) {
				System.out.println("************BINGO!************");
				System.out.println("You won " +entity.AwardedTicketNumber() + " tickets in this round.");
				TotalTickets = TotalTickets + entity.AwardedTicketNumber();
				System.out.println("The total number of your tickets is " + TotalTickets);
				System.out.println(entity.closingmessage());
				playGame();
				
			}

			if (born1.precedes(born2)) {
				System.out.println("Incorrect, try a later date");
			} else {
				System.out.println("Incorrect, try a eariler date");
			}

		}
	}

//put entityInd as input, and create entities[] as another input for the method public void playGame(Entity entity)
	public void playGame(int entityInd) {
		playGame(entities[entityInd]);
	}
//get random number,call the method public void playGame(int entityInd) 
	public void playGame() {
		int randnum = genRandomEntityInd();
		playGame(randnum);
	}
//choose a random entity
	public int genRandomEntityInd() {
		Random gen = new Random();
		int EntityInd = gen.nextInt(3);
		return EntityInd;
	}

}
