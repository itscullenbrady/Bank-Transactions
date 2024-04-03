public interface Transaction {
    void execute(BankAccount account, double amount);
}