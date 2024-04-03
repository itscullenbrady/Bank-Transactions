public class DepositTransaction implements Transaction {
    public void execute(BankAccount account, double amount) {
        account.deposit(amount);
    }
}