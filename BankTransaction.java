public class BankTransaction {
    public void execute(BankAccount account, double amount) {
        account.deposit(amount);
    }

    public void execute(SavingsAccount account, double amount) {
        account.deposit(amount);
    }

    public void transfer(BankAccount fromAccount, SavingsAccount toAccount, double amount) {
        if (fromAccount.getBalance() >= amount) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);
            System.out.println("Transfer successful!");
        } else {
            System.out.println("Insufficient funds for transfer!");
        }
    }
}
