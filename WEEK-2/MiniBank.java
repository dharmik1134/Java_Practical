public class MiniBank {

    public static void main(String[] args) {

        Customer c1 = new Customer("Dharmik Sonani", "dharmik@gmail.com", "9930030060");

        Account[] accounts = new Account[3];

        accounts[0] = new Account(c1.getName(), 5000);
        accounts[1] = new Account("Bhavy", 3000);
        accounts[2] = new Account("Manthan");

        accounts[0].deposit(1000);
        accounts[0].withdraw(2000);

        accounts[1].deposit(500);
        accounts[1].withdraw(1000);

        accounts[2].deposit(2000);
        accounts[2].withdraw(500);

        for (Account a : accounts) {
            System.out.println(a.getAccountNumber() + " " + a.getOwnerName() + " Balance: " + a.getBalance());
        }
    }
}

class Customer {

    private String name;
    private String email;
    private String mobile;
    private final String customerId;

    private static long customerCounter = 101;

    private static String generateCustomerId() {
        return "CUST" + customerCounter++;
    }

    public Customer(String name, String email, String mobile) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.customerId = generateCustomerId();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    public String getCustomerId() {
        return customerId;
    }
}

class Account {

    private final String accountNumber;
    private String ownerName;
    private long balance;
    private boolean active;

    private static int accountCounter = 1;

    private static String generateAccountNumber() {
        return String.format("AC%04d", accountCounter++);
    }

    public Account(String ownerName, long balance) {
        this.accountNumber = generateAccountNumber();
        this.ownerName = ownerName;
        this.balance = balance;
        this.active = true;
    }

    public Account(String ownerName) {
        this(ownerName, 0);
    }

    public void deposit(long amount) {
        if (amount < 0)
            return;
        balance += amount;
    }

    public boolean withdraw(long amount) {
        if (amount < 0)
            return false;

        if (balance >= amount) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public long getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }
}