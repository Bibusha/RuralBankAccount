package bank;

public class SavingsAccount extends BankAccount {
    private double interestRate = 0.04; // 4% interest

    public SavingsAccount(String name, String number, double balance) {
        super(name, number, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > balance) {
            throw new InsufficientBalanceException("Withdrawal failed: Insufficient balance!");
        }
        balance -= amount;
    }

    public void addInterest() {
        balance += balance * interestRate;
    }
}

