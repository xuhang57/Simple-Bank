import java.util.*;

/**
 * @author Hang Xu
 * @date Fall 2019
 */
public class FancyBank {
    /** use phone number to lookup a customer */
    private Map<Long, Customer> customers = new HashMap<>();
    /** use phone number to lookup accounts that a customer has */
    private Map<Long, List<Account>> accounts = new HashMap<>();
    /** use phone number to lookup transactions that a customer has */
    private Map<Long, List<Transaction>> transactions = new HashMap<>();

    /**
     * A Person enters our Fancy Bank
     */
    public void start() {
        System.out.println("Welcome to the Fancy Bank!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type 1 for GUI, Type 2 for Console, Type 3 to Leave");
        //int ops = scanner.nextInt();
        int ops = 1;
        if (ops == 1) {
            GUI gui = new GUI();
            gui.start();
        } else if (ops == 2) {
            while (true) {
                System.out.println("Type 1 if you are a manager, Type 2 if you are a customer, Type 3 to leave");
                int role = scanner.nextInt();
                if (role == 1) {
                    this.managerOperations(scanner);
                } else if (role == 2) {
                    this.customerOperations(scanner);
                } else if (role == 3) {
                    System.out.println("Have a nice day!");
                    break;
                } else {
                    System.out.println("Invalid Choice");
                }
            }
        } else {
            System.out.println("Hope to See you Soon!");
        }
    }

    /**
     *
     */
    public void managerOperations(Scanner scanner) {
        System.out.println("Welcome, Manager!");
        while(true) {
            System.out.println("Type 1 for generating a fully daily report");
            System.out.println("Type 2 for checking a specific customer transactions");
            System.out.println("Type 3 to leave the bank");
            int ops = scanner.nextInt();
            if (ops == 1) {
                this.generateReport();
            } else if (ops == 2) {
                System.out.println("What is the phone number of the customer?");
                long phoneNumber = scanner.nextInt();
                this.checkCustomer(phoneNumber);
            } else if (ops == 3) {
                System.out.println("See ya!");
                break;
            } else {
                System.out.println("Invalid Number");
            }
        }
    }

    /**
     *
     */
    public void customerOperations(Scanner scanner) {
        // Current customer in the count at our Bank
        Customer customer = this.registerCustomer(scanner);
        this.customers.put(customer.getPhoneNumber(), customer);
        while (true) {
            System.out.println("Welcome " + customer.getName() + "!");
            System.out.println("Type 1 for opening a Checking Account with us");
            System.out.println("Type 2 for opening a Saving Account with us");
            System.out.println("Type 3 for requesting a Loan from us");
            System.out.println("Type 4 for viewing all transactions");
            System.out.println("Type 5 for viewing your balances");
            System.out.println("Type 6 for leaving the bank");
            int ops = scanner.nextInt();

            if (ops != 6) {
                if (ops == 1) {
                    this.openChecking(customer, scanner);
                } else if (ops == 2) {
                    this.openSaving(customer, scanner);
                } else if (ops == 3) {
                    this.requestLoan(customer, scanner);
                } else if (ops == 4) {
                    this.viewTransactions(customer);
                } else if (ops == 5) {
                    this.viewBalances(customer);
                } else {
                    System.out.println("Invalid Options");
                }
            } else {
                System.out.println("See ya!");
                break;
            }
        }
    }

    /**
     * Open a new Checking Account for this given customer
     * @param customer: Customer
     * @param scanner: Scanner
     */
    public void openChecking(Customer customer, Scanner scanner) {
        System.out.println("How much do you want to deposit today? (less than 1 Million pls)");
        int depositAmount = scanner.nextInt();
        Account customerChecking = customer.openChecking(depositAmount);
        this.addTransaction(customer, customerChecking);
        this.addAccount(customer, customerChecking);
    }

    /**
     * Open a new Saving Account for this given customer
     * @param customer: Customer
     * @param scanner: Scanner
     */
    public void openSaving(Customer customer, Scanner scanner) {
        System.out.println("How much do you want to deposit today? (less than 1 Million pls)");
        int depositAmount = scanner.nextInt();
        Account customerSaving = customer.openSaving(depositAmount);
        this.addTransaction(customer, customerSaving);
        this.addAccount(customer, customerSaving);

    }

    /**
     * Request a loan from the bank for this given user
     * @param customer: Customer
     * @param scanner: Scanner
     */
    public void requestLoan(Customer customer, Scanner scanner) {
        System.out.println("How much do you want to loan today? (less than 1 Million pls)");
        int loanAmount = scanner.nextInt();
        Loan customerLoan = customer.requestLoan(loanAmount);
        this.addTransaction(customer, customerLoan);
        this.addAccount(customer, customerLoan);
    }

    /**
     * View all transactions for this given customer
     * @param customer: Customer
     */
    public void viewTransactions(Customer customer) {
        long phoneNumber = customer.getPhoneNumber();
        if (this.transactions.containsKey(phoneNumber)) {
            List<Transaction> customerTrans = this.transactions.get(phoneNumber);
            for (Transaction trans: customerTrans) {
                System.out.println(trans);
            }
        } else {
            System.out.println("You have no transactions. How about requesting a loan?");
        }

    }

    /**
     * View the balances of all Accounts of a given Customer
     * @param customer: Customer
     */
    public void viewBalances(Customer customer) {
        long phoneNumber = customer.getPhoneNumber();
        if (this.accounts.containsKey(phoneNumber)) {
            List<Account> customerAccts = this.accounts.get(phoneNumber);
            for (Account acct: customerAccts) {
                System.out.println(acct);
            }
        } else {
            System.out.println("You have no accounts. How about opening one?");
        }
    }

    /**
     * Record a transaction to the Bank "Database"
     * @param customer: Customer
     * @param account: Account
     */
    public void addTransaction(Customer customer, Account account) {
        List<Transaction> customerTrans = this.transactions.getOrDefault(customer.getPhoneNumber(), new ArrayList<>());
        Transaction curTrans = new Transaction(customer, account);
        customerTrans.add(curTrans);
        this.transactions.put(customer.getPhoneNumber(), customerTrans);
    }

    /**
     * Record the account that a given customer just opened
     * @param customer: Customer
     * @param account: Account
     */
    public void addAccount(Customer customer, Account account) {
        List<Account> customerAccts = this.accounts.getOrDefault(customer.getPhoneNumber(), new ArrayList<>());
        customerAccts.add(account);
        this.accounts.put(customer.getPhoneNumber(), customerAccts);
    }

    /**
     * Return a customer either from database or newly registered one
     * @param scanner: Scanner
     * @return customer: Customer
     */
    public Customer registerCustomer(Scanner scanner) {
        System.out.println("May I please have your first name? (eg. Lucas)");
        String firstName = scanner.next();
        System.out.println("May I please have your last name? (eg. Xu)");
        String lastName = scanner.next();
        Name customerName = new Name(firstName, lastName);
        System.out.println("May I please have your 10 digit phone number? (eg. 1234567890)");
        long phoneNumber = scanner.nextLong();
        // if this is a returning customer
        if (isReturningCustomer(phoneNumber)) {
            return this.customers.get(phoneNumber);
        }
        // register a new customer in our database(RAM)
        return  new Customer(customerName, phoneNumber);
    }

    /**
     * Return whether this is a returning customer
     * @param phoneNumber: long
     * @return boolean
     */
    public boolean isReturningCustomer(long phoneNumber) {
        return this.customers.containsKey(phoneNumber);
    }

    /**
     * Generate a daily report for the Manager
     */
    public void generateReport() {
        Report report = new Report(this.transactions, this.customers);
        report.dailyReport();
    }

    /**
     * Check all transactions of a specific Customer, including Interests
     * @param phoneNumber: long
     */
    public void checkCustomer(long phoneNumber) {
        if (this.transactions.containsKey(phoneNumber)) {
            Customer customer = this.customers.get(phoneNumber);
            this.viewBalances(customer);
        } else {
            System.out.println("Customer does not have any transaction at the moment");
        }
    }
}
