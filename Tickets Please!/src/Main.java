public class Main {
    public static void main(String[] args) {
        // Create the app object.
        TicketsPlease app = new TicketsPlease();
        //get info from files
        Customer.setFirstNames();
        Customer customer = new Customer();
        System.out.println(customer.customerInfo()); 
    }
}
