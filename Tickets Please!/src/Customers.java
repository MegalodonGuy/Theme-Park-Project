import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Customers {
    private static String[] firstNames = new String[18239];
    private String firstName;
    private String lastName;
    private int IDnum;
    private int age;
    private int moneyCharged;
    public Customers(String firstName,String lastName, int IDnum, int moneyCharged, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.IDnum= IDnum;
        this.moneyCharged= moneyCharged; 
        this.age = age;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public int getIDnum() {
        return this.IDnum;
    }
    public String getLastName() {
        return this.lastName;
    }
    public int getMoneyCharged() {
        return this.moneyCharged;
    }
    public int getAge() {
        return this.age;
    }

    public static void setNames(){
        try (Scanner keyboard = new Scanner(new File("Tickets Please!/src/FirstNames.txt"))) {
            
            for (int i=0; i<firstNames.length;i++ ){
                firstNames[i] = keyboard.nextLine();
            }
            System.out.println(Arrays.toString(firstNames));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
    }
}
