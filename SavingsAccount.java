// SavingsAccount.java
public class SavingsAccount {
    private double interestRate;
    private double balance;

    public SavingsAccount(double interestRate) {
        this.interestRate = interestRate;
        this.balance = 0.00;
    }

    public SavingsAccount() {
        this.balance = 0.00;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= this.balance) {
            this.balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public double getBalance() {
        return this.balance;
    }
}
