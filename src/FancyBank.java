import java.util.Scanner;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class FancyBank {

    /**
     * A Person enters our Fancy Bank
     */
    public void start() {

        System.out.println("Welcome to the Fancy Bank!");
        while (true) {
            System.out.println("Type 1 if you are a manager, Type 2 if you are a customer");
            Scanner scanner = new Scanner(System.in);
            int role = scanner.nextInt();

            if (role == 1) {
                this.managerOperations();
            }

            if (role == 2) {
                this.customerOperations();
            }
        }
    }

    public void managerOperations() {

    }

    public void customerOperations() {
        while (true) {
            System.out.println("Welcome, Customer!");
            System.out.println("Type 1 for opening a Checking Account with us");
            System.out.println("Type 2 for opening a Saving Account with us");
            System.out.println("Type 3 for requesting a Loan from us");
            System.out.println("Type 4 for viewing all transactions");
            System.out.println("Type 5 for viewing your balances");
            System.out.println("Type 6 for leaving the bank");
            Scanner scanner = new Scanner(System.in);
            int ops = scanner.nextInt();

            if (ops != 6) {
                Customer customer = this.registerCustomer(scanner);
                if (ops == 1) {
                    this.openChecking(customer, scanner);
                }
            } else {
                System.out.println("See ya!");
                break;
            }
        }
    }

    public void openChecking(Customer customer, Scanner scanner) {;
        System.out.println("How much do you want to deposit today? (less than 1 Million pls)");
        int depositAmount = scanner.nextInt();
        customer.openChecking(depositAmount);

    }

    public void openSaving() {

    }

    public Customer registerCustomer(Scanner scanner) {
        System.out.println("May I please have your name? (eg. Hang Xu)");
        String name = scanner.nextLine();
        String[] fullName = name.split("\\s+");
        String firstName = fullName[0], lastName = fullName[1];
        Name customerName = new Name(firstName, lastName);
        System.out.println("May I please have your 10 digit phone number? (eg. 1234567890)");
        long phoneNumber = scanner.nextLong();
        Customer customer = new Customer(customerName, phoneNumber);
        return customer;
    }

    public boolean isReturningCustomer(Customer customer) {
        return true;
    }
}
