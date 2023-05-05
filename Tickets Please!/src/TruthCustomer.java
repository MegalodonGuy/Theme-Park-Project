import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TruthCustomer extends Liar{ // uses inheratance
    private String firstName;
    private String lastName;
    private String idNum;
    private int age;
    private int moneyCharged;
    public TruthCustomer(){
        int ranFirstName = (int)(Math.random()*names.length); 
        this.firstName = names[ranFirstName];
        int ranLastName = (int)(Math.random()*names.length); 
        this.lastName = names[ranLastName];

        this.idNum=(""+((int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10)+""+(int)(Math.random()*10)));

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

 @Override
 public String customerInfo(){
    return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
 }

}
