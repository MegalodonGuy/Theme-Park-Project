import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TruthCustomer extends Liar{ // uses inheratance
    public TruthCustomer(){
        
    }

 @Override
 public String customerInfo(){
    return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
 }

}
