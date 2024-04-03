public class WithdrawalTransaction implements Transaction {
    public void execute(BankAccount account, double amount) {
        account.withdraw(amount);
    }
}
