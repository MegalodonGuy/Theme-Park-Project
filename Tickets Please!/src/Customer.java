import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Customer {
    private static String[] firstNames = new String[18239];
    private static String[] lastNames;
    private String firstName;
    private String lastName;
    private String idNum;
    private int age;
    private int moneyCharged;
    public Customer(){
        int ranFirstName = (int)(Math.random()*firstNames.length); 
        this.firstName = firstNames[ranFirstName];
        int ranLastName = (int)(Math.random()*lastNames.length); 
        this.lastName = lastNames[ranLastName];
        this.idNum=(""+((int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10))); // gets random digit in thousands, hundreds, tens and ones
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
    }

    public String customerInfo(){
        return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
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

    public static void setFirstNames(){
        try (Scanner keyboard = new Scanner(new File("Tickets Please!/src/Names.txt"))) {
            
            for (int i=0; i<firstNames.length;i++ ){
                firstNames[i] = keyboard.nextLine();
            }
            lastNames=firstNames;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
}
