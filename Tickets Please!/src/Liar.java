import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * uses encapsulation by fully encapsualting the idea of a liar, uses abstraction by hiding important instance variables so it doesn't get misused. 
 */
public class Liar {
    protected static String[] names = new String[18239];
    protected String firstName;
    protected String lastName;
    protected String idNum;
    protected int age;
    protected int moneyCharged;

    protected int fakeMoneyCharged = 100; //all liars will go for the lowest charge, other fake values will be randomized like everything else
    protected String fakeFirstName;
    protected String fakeLastName;
    protected String fakeIDNum;
    protected int fakeAge;

    protected String lie ="No lie";
    

    public Liar(){
        int ranFirstName = (int)(Math.random()*names.length); 
        this.firstName = names[ranFirstName];
        int ranLastName = (int)(Math.random()*names.length); 
        this.lastName = names[ranLastName];

        int ranFakeFirstName = (int)(Math.random()*names.length); 
        this.fakeFirstName = names[ranFakeFirstName];
        int ranFakeLastName = (int)(Math.random()*names.length); 
        this.fakeLastName = names[ranFakeLastName];

        this.idNum=(""+((int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10))); // gets random digit in thousands, hundreds, tens and ones
        this.fakeIDNum=(""+((int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10)));

        int ranCharge = (int)(Math.random()*3);
        switch (ranCharge) {
            case 0:
            this.moneyCharged=100;
            break;
            case 1:
            this.moneyCharged=200;
            break;
            case 2:
            this.moneyCharged=300;
            break;
        }

        this.age = (int)(Math.random()*80)+18;
        this.fakeAge = (int)(Math.random()*80)+18;


    }

    public String customerInfo(){
        //System.out.println("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged); //debug 
            int randLie= (int)(Math.random()*5); // randomizes which lie
            switch(randLie){
                case 0: 
                lie = "First Name";
                return ("Name: "+this.fakeFirstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
                case 1: 
                lie = "Last Name";
                return ("Name: "+this.firstName +" "+ this.fakeLastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
                case 2: 
                lie = "Age";
                return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.fakeAge + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
                case 3: 
                lie = "ID";
                return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.fakeIDNum + " Initial Charge: " + this.moneyCharged);
                case 4: 
                lie = "Money";
                return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + fakeMoneyCharged);
                
            
        }
        return ("This ticket doesn't even remotely look real");
    }

    

    public String getFirstName() {
        return this.firstName;
    }
    public int getAge() {
        return this.age;
    }
    public String getLastName() {
        return this.lastName;
    }
    public String getIDNum() {
        return this.idNum;
    }
    public int getMoneyCharged() {
        return this.moneyCharged;
    }

    public int getFakeAge() {
        return this.fakeAge;
    }
    public String getFakeFirstName() {
        return this.fakeFirstName;
    }
    public String getFakeIDNum() {
        return this.fakeIDNum;
    }
    public String getFakeLastName() {
        return this.fakeLastName;
    }
    public String getLie() {
        return lie;
    }

    public static void setNames(){
        try (Scanner keyboard = new Scanner(new File("Tickets Please!/src/Names.txt"))) {
            
            for (int i=0; i<names.length;i++ ){
                names[i] = keyboard.nextLine();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
}
