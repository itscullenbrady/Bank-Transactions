public class BankAccount {
    private double balance;

    public BankAccount() {
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

    public double getBalance() {
        return this.balance;
    }
}
