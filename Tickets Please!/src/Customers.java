public class Customers {
    private static String[] firstNames = {};
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
}
