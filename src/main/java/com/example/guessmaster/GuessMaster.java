package com.example.guessmaster;
//amanda yu 20093332
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;

public class GuessMaster extends AppCompatActivity {
    private TextView entityName;
    private TextView ticketsum;
    private Button guessButton;
    private EditText userIn;
    private Button btnclearContent;
    private String user_input;
    private ImageView entityImage;
    String answer;

    private int numberOfCandidateEntities;
    private Entity[] entities;
    private int TotalTickets = 0;
    private int [] Tickets;
    private int numOfTickets = 0;
    String entName;
    int entityid = 0;
    int currentTicketWon = 0;

    public GuessMaster() {
        // for initialize attributes
        numberOfCandidateEntities = 0;
        entities = new Entity[5];
        Tickets = new int[100];// array[size]
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_activity);
        Politician trudeau = new Politician ("Justin Trudeau", new Date("December", 25, 1971),"Male", "Liberal", 0.25);
        Singer dion = new Singer ("Celine Dion",new Date("March", 30, 1961),"Female","La voix du bon Dieu",new Date("November", 6, 1981),0.5);
        Person myCreator = new Person ("myCreator",new Date("September", 1, 2000),"Female", 1.0);
        Country usa = new Country ("United States",new Date("July", 4, 1776), "Washinton D.C.", 0.1);
        guessButton = (Button)findViewById(R.id.btnguess);
        userIn = (EditText) findViewById(R.id.guessinput);
        ticketsum = (TextView) findViewById(R.id.ticket);
        entityName = (TextView) findViewById(R.id.entityName);
        entityImage  =(ImageView) findViewById(R.id.entityImage);
        btnclearContent = (Button) findViewById(R.id.btnclear);
        final GuessMaster gm = new GuessMaster();
        gm.addEntity(trudeau);
        gm.addEntity(dion);
        gm.addEntity(myCreator);
        gm.addEntity(usa);
        ticketsum.setText("Total Tickets: "+"0");
        this.numOfTickets = gm.numOfTickets;
        this.entities = gm.entities;
        ContinueGame();
        welcomeToGame(gm.entities[entityid]);
        btnclearContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeEntity();
            }
        });

        //OnClick Listener action for clear button
        btnclearContent.setOnClickListener (new View.OnClickListener (){
        @Override
            public void onClick (View v){
                changeEntity ();
            }
        });
        //OnClick Listener action for submit button
        guessButton . setOnClickListener (new View.OnClickListener (){
        @Override
            public void onClick (View v){
                //playing game
                  playGame ();
            }
        });

    }
    //Guessmaster constructor


    public void addEntity(Entity entity) {
        // take the object entity as input and place it into entities array
        entities[numberOfCandidateEntities] = entity.clone();
        // after place one object into the array, the index plus one
        numberOfCandidateEntities += 1;
    }
    public void playGame(final Entity entity) {
        //Name of the entity to be guessed in the entityName textview
        entityName.setText(entity.getName());

        // use the method getName() from Entity class
//        System.out.println("*********************************");
//        System.out.println(entity.welcomemessage());
//        System.out.println("you are guessing " + entity.getName() + " 's birthday ");
            answer = userIn.getText().toString();
            answer = answer.replace("\n", "").replace("\r","");
            Date date  =new Date(answer);
//            Date born2 = entity.getBorn(); // using getBorn() method from Entity to create another object born2

//            if (born1.equals(born2)) {
//                System.out.println("************BINGO!************");
//                System.out.println("You won " +entity.AwardedTicketNumber() + " tickets in this round.");
//                TotalTickets = TotalTickets + entity.AwardedTicketNumber();
//                System.out.println("The total number of your tickets is " + TotalTickets);
//                System.out.println(entity.closingmessage());
//                playGame();
//
//            }

//           if (born1.precedes(born2)) {
//               System.out.println("Incorrect, try a later date");
//            } else {
//                System.out.println("Incorrect, try a eariler date");
//            }


             if (date.precedes(entity.getBorn())){
                 AlertDialog.Builder Incorrectalert1 = new AlertDialog.Builder(GuessMaster.this);
                 Incorrectalert1.setTitle ("Incorrect");
                 Incorrectalert1.setMessage("Incorrect, try a later date");
                 Incorrectalert1.setCancelable(false);
                 Incorrectalert1.setNegativeButton ("Ok",new DialogInterface.OnClickListener () {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                     }
                 });
                 AlertDialog dialog = Incorrectalert1.create();
                 dialog.show();
             } else if(entity.getBorn().precedes(date)){
                 AlertDialog.Builder Incorrectalert2 = new AlertDialog.Builder(GuessMaster.this);
                 Incorrectalert2.setTitle ("Incorrect");
                 Incorrectalert2.setMessage("Incorrect, try a eariler date");
                 Incorrectalert2.setCancelable(false);
                 Incorrectalert2.setNegativeButton ("Ok",new DialogInterface.OnClickListener () {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                     }
                 });
                 AlertDialog dialog = Incorrectalert2.create();
                 dialog.show();
             }
             else{
                 Tickets[numOfTickets++] = entity.AwardedTicketNumber();
                 for (int i = 0;i<100;i++){
                     TotalTickets = TotalTickets + Tickets[i];
                 }
                 ticketsum.setText("Total Tickets: "+TotalTickets);
                 TotalTickets = 0;
                 AlertDialog.Builder wonalert = new AlertDialog.Builder(GuessMaster.this);
                 wonalert.setTitle ("You won");
                 wonalert.setMessage("BINGO" + entity.closingmessage());
                 wonalert.setCancelable(false);
                 wonalert.setNegativeButton ("Continue",new DialogInterface.OnClickListener () {
                     @Override
                     public void onClick(DialogInterface dialog, int which) {
                         Toast.makeText(getBaseContext(), "You won"+ entity.AwardedTicketNumber()+"The total tickets are", Toast.LENGTH_SHORT).show();
                         ContinueGame();
                     }
                 });
                 AlertDialog dialog = wonalert.create();
                 dialog.show();
             }

    }


    //put entityInd as input, and create entities[] as another input for the method public void playGame(Entity entity)
    public void playGame(int entityInd) {
        playGame(entities[entityInd]);
    }
    //get random number,call the method public void playGame(int entityInd)
    public void playGame() {
        playGame(entityid);
    }
    //choose a random entity
    public int genRandomEntityInd() {
        Random gen = new Random();
        int EntityInd = gen.nextInt(4);
        return EntityInd;
    }
    public void changeEntity() {
            userIn.getText().clear();
            ContinueGame();
    }
    //show the image of each entity
    public void ImageSetter() {
        if(entName.equals("Justin Trudeau")){
                entityImage.setImageResource(R.drawable.justint);
        }
        else if(entName.equals("Celine Dion")){
                entityImage.setImageResource(R.drawable.celidion);
        }
        else if(entName.equals("myCreator")){
                entityImage.setImageResource(R.drawable.bieber);
        }
        else if(entName.equals("United States")){
                entityImage.setImageResource(R.drawable.usaflag);
        }
    }
    public void welcomeToGame(Entity entity) {

        AlertDialog.Builder welcomealert = new AlertDialog.Builder(GuessMaster.this);
        //System . out . println (”(mm/dd/yyyy )”);
        welcomealert.setTitle ("GuessMaster_Game_v3");
        welcomealert.setMessage(entity.welcomemessage());
        welcomealert.setCancelable(false);
        //No Cancel Button
        welcomealert.setNegativeButton ("START GAME",new DialogInterface.OnClickListener () {
            @Override
            public void onClick(DialogInterface dialop, int which) {
                Toast.makeText(getBaseContext(), "Game is Starting...enjoy", Toast.LENGTH_SHORT).show();
            }
        });
        //show Dialog
                AlertDialog dialog = welcomealert.create();
                dialog.show();
            }
    public void ContinueGame(){
        entityid = genRandomEntityInd();
        Entity entity = entities [entityid] ;
        entName = entity.getName();
//Call the ImageSetter method \
        ImageSetter();
//Print the name of the entity to be guessed //in the entityName textview
        entityName.setText (entName);
        //Clear Previous Entry
        userIn.getText().clear();
    }

}

