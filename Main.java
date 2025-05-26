package bank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Rural Bank of Nepal");
        System.out.print("Enter customer name: ");
        String customerName = sc.nextLine();

        // Create a customer
        Customer customer = new Customer(customerName);

        // Add one savings and one current account for the customer
        SavingsAccount savings = new SavingsAccount(customerName, "SAV001", 1000);
        CurrentAccount current = new CurrentAccount(customerName, "CUR001", 2000);

        customer.addAccount(savings);
        customer.addAccount(current);

        while (true) {
            System.out.println("\nChoose operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Add Interest (Savings Account Only)");
            System.out.println("4. View Accounts");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 5) {
                System.out.println("Thank you for banking with us!");
                break;
            }

            System.out.print("Select account (1: Savings, 2: Current): ");
            int accChoice = sc.nextInt();
            BankAccount selectedAccount;
            if (accChoice == 1) {
                selectedAccount = savings;
            } else if (accChoice == 2) {
                selectedAccount = current;
            } else {
                System.out.println("Invalid account selection.");
                continue;
            }

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter deposit amount: ");
                    double amount = sc.nextDouble();
                    selectedAccount.deposit(amount);
                    System.out.println("Deposit successful.");
                }
                case 2 -> {
                    System.out.print("Enter withdrawal amount: ");
                    double amount = sc.nextDouble();
                    try {
                        selectedAccount.withdraw(amount);
                        System.out.println("Withdrawal successful.");
                    } catch (InsufficientBalanceException e) {
                        System.out.println(e.getMessage());
                    }
                }
                case 3 -> {
                    if (selectedAccount instanceof SavingsAccount) {
                        ((SavingsAccount) selectedAccount).addInterest();
                        System.out.println("Interest added.");
                    } else {
                        System.out.println("Interest can only be added to savings accounts.");
                    }
                }
                case 4 -> {
                    System.out.println("\n--- Account Details ---");
                    System.out.println(savings.getDetails());
                    System.out.println(current.getDetails());
                }
                default -> System.out.println("Invalid option. Try again.");
            }
        }

        sc.close();
    }
}
