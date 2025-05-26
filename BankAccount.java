package bank;

public abstract class BankAccount {
    private String accountHolderName;
    private String accountNumber;
    protected double balance;

    public BankAccount(String accountHolderName, String accountNumber, double balance) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public abstract void withdraw(double amount) throws InsufficientBalanceException;
    public void deposit(double amount) {
        balance += amount;
    }

    public String getDetails() {
        return "Account Holder: " + accountHolderName + ", Account Number: " + accountNumber + ", Balance: " + balance;
    }

    public double getBalance() {
        return balance;
    }
}
