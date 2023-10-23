import java.util.Scanner;

class BankAccount {
    protected String accountNumber;
    protected String accountHolderName;
    protected double balance;

    public BankAccount(String accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber; 
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds.");
            return false;
        }
        balance -= amount;
        return true;
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: $" + balance);
    }
}

class SavingsAccount extends BankAccount {
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolderName, double balance, double interestRate) {
        super(accountNumber, accountHolderName, balance);
        this.interestRate = interestRate;
    }

    public void addInterest() {
        double interest = balance * (interestRate / 100);
        balance += interest;
    }
}

class CheckingAccount extends BankAccount {
    private double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double balance, double overdraftLimit) {
        super(accountNumber, accountHolderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount > balance + overdraftLimit) {
            System.out.println("Withdrawal amount exceeds overdraft limit.");
            return false;
        }
        balance -= amount;
        return true;
    }
}

public class A7P2{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SavingsAccount savingsAccount = new SavingsAccount("SA123", "John Doe", 5000, 5.0);
        CheckingAccount checkingAccount = new CheckingAccount("CA456", "Jane Smith", 3000, 1000);

        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Deposit to Savings Account");
            System.out.println("2. Add Interest to Savings Account");
            System.out.println("3. Withdraw from Savings Account");
            System.out.println("4. Deposit to Checking Account");
            System.out.println("5. Withdraw from Checking Account");
            System.out.println("6. Display Savings Account Info");
            System.out.println("7. Display Checking Account Info");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: $");
                    double amount1 = scanner.nextDouble();
                    savingsAccount.deposit(amount1);
                    break;

                case 2:
                    savingsAccount.addInterest();
                    break;

                case 3:
                    System.out.print("Enter amount to withdraw: $");
                    double amount2 = scanner.nextDouble();
                    savingsAccount.withdraw(amount2);
                    break;

                case 4:
                    System.out.print("Enter amount to deposit: $");
                    double amount3 = scanner.nextDouble();
                    checkingAccount.deposit(amount3);
                    break;

                case 5:
                    System.out.print("Enter amount to withdraw: $");
                    double amount4 = scanner.nextDouble();
                    checkingAccount.withdraw(amount4);
                    break;

                case 6:
                    System.out.println("Savings Account Info:");
                    savingsAccount.displayInfo();
                    break;

                case 7:
                    System.out.println("Checking Account Info:");
                    checkingAccount.displayInfo();
                    break;

                case 8:
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 8);
    }
}