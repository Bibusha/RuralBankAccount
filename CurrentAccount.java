package bank;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit = 5000;

    public CurrentAccount(String name, String number, double balance) {
        super(name, number, balance);
    }

    @Override
    public void withdraw(double amount) throws InsufficientBalanceException {
        if (amount > (balance + overdraftLimit)) {
            throw new InsufficientBalanceException("Withdrawal failed: Overdraft limit exceeded!");
        }
        balance -= amount;
    }
}


