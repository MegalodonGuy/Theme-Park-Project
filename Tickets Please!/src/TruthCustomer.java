import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *  uses inheratance by using many values and methods in the liar class and saves code by using a mian class
 * uses encapsualtion by encapsualting a sinlge idea between the diffent types of customers
 */
public class TruthCustomer extends Liar{ 

 @Override
 public String customerInfo(){ //overides the customer info method in liar so it runs differently than just called normally, this is an example of polymorphism
    return ("Name: "+this.firstName +" "+ this.lastName +" Age: " + this.age + " Ticket ID: " + this.idNum + " Initial Charge: " + this.moneyCharged);
 }

}
