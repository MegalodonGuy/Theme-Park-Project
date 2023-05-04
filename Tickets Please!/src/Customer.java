import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Customer {
    private static String[] firstNames = new String[18239];
    private static String[] lastNames;
    private String firstName;
    private String lastName;
    private String idNum;
    private int age;
    private int moneyCharged;

    private static int fakeMoneyCharged = 100; // all liars will go for the lowest charge, other fake values will be
                                               // randomized like everything else
    private String fakeFirstName;
    private String fakeLastName;
    private String fakeIDNum;
    private int fakeAge;

    public Customer() {
        int ranFirstName = (int) (Math.random() * firstNames.length);
        this.firstName = firstNames[ranFirstName];
        int ranLastName = (int) (Math.random() * lastNames.length);
        this.lastName = lastNames[ranLastName];

        int ranFakeFirstName = (int) (Math.random() * firstNames.length);
        this.fakeFirstName = firstNames[ranFakeFirstName];
        int ranFakeLastName = (int) (Math.random() * lastNames.length);
        this.fakeLastName = lastNames[ranFakeLastName];

        this.idNum = ("" + ((int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10))); // gets random digit in thousands,
                                                                                  // hundreds, tens and ones
        this.fakeIDNum = ("" + ((int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10)));

        int ranCharge = (int) (Math.random() * 3);
        switch (ranCharge) {
            case 0:
                this.moneyCharged = 100;
                break;
            case 1:
                this.moneyCharged = 200;
                break;
            case 2:
                this.moneyCharged = 300;
                break;
        }

        this.age = (int) (Math.random() * 80) + 18;
        this.fakeAge = (int) (Math.random() * 80) + 18;

    }

    public String customerInfo() {
        int randLie = (int) (Math.random() * 6); // 1 in 6 chnce of a lie
        if (randLie == 0) {
            System.out.println("Name: " + this.firstName + " " + this.lastName + " Age: " + this.age + " Ticket ID: "
                    + this.idNum + " Initial Charge: " + this.moneyCharged);
            int randLie2 = (int) (Math.random() * 5); // randomizes which lie
            switch (randLie2) {
                case 1:
                    return ("Name: " + this.fakeFirstName + " " + this.lastName + " Age: " + this.age + " Ticket ID: "
                            + this.idNum + " Initial Charge: " + this.moneyCharged);
                case 2:
                    return ("Name: " + this.firstName + " " + this.fakeLastName + " Age: " + this.age + " Ticket ID: "
                            + this.idNum + " Initial Charge: " + this.moneyCharged);
                case 3:
                    return ("Name: " + this.firstName + " " + this.lastName + " Age: " + this.fakeAge + " Ticket ID: "
                            + this.idNum + " Initial Charge: " + this.moneyCharged);
                case 4:
                    return ("Name: " + this.firstName + " " + this.lastName + " Age: " + this.age + " Ticket ID: "
                            + this.fakeIDNum + " Initial Charge: " + this.moneyCharged);
                case 5:
                    return ("Name: " + this.firstName + " " + this.lastName + " Age: " + this.age + " Ticket ID: "
                            + this.idNum + " Initial Charge: " + fakeMoneyCharged);

            }
        }
        return ("Name: " + this.firstName + " " + this.lastName + " Age: " + this.age + " Ticket ID: " + this.idNum
                + " Initial Charge: " + this.moneyCharged); // if they don't lie
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

    public static int getFakeMoneyCharged() {
        return fakeMoneyCharged;
    }

    public static void setFirstNames() {
        try (Scanner keyboard = new Scanner(new File("Tickets Please!/src/Names.txt"))) {

            for (int i = 0; i < firstNames.length; i++) {
                firstNames[i] = keyboard.nextLine();
            }
            lastNames = firstNames;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
