/**
 * This class represents a bank account. It demonstrates the OOP principle of
 * encapsulation
 * by keeping the balance private and providing public methods to manipulate it.
 */
class BankAccount {
    /**
     * The balance of the bank account.
     */
    private double balance;

    /**
     * Deposits the specified amount into the bank account.
     * 
     * @param amount the amount to deposit
     */
    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited: $" + amount);
    }

    /**
     * Withdraws the specified amount from the bank account if sufficient funds are
     * available.
     * 
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Insufficient funds");
        }
    }

    /**
     * Returns the current balance of the bank account.
     * 
     * @return the current balance
     */
    public double getBalance() {
        return balance;
    }
}

/**
 * This class represents a savings account. It extends BankAccount and
 * demonstrates the OOP principle of inheritance.
 * It adds an interest rate and the ability to apply interest to the balance.
 */
class SavingsAccount extends BankAccount {
    /**
     * The interest rate for the savings account.
     */
    private double interestRate;

    /**
     * Constructs a new SavingsAccount with the specified initial balance and
     * interest rate.
     * 
     * @param initialBalance the initial balance
     * @param interestRate   the interest rate
     */
    public SavingsAccount(double initialBalance, double interestRate) {
        this.deposit(initialBalance);
        this.interestRate = interestRate;
    }

    /**
     * Applies the interest to the balance of the savings account.
     */
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest applied: $" + interest);
    }
}

/**
 * This class represents a bank transaction. It demonstrates the OOP principle
 * of polymorphism
 * by having methods that accept both BankAccount and SavingsAccount objects.
 */
class BankTransaction {

    /**
     * Executes a deposit transaction on the specified bank account.
     * 
     * @param account the bank account
     * @param amount  the amount to deposit
     */
    public void executeTransaction(BankAccount account, double amount) {
        account.deposit(amount);
    }

    /**
     * Executes a deposit transaction on the specified savings account and applies
     * interest.
     * 
     * @param account the savings account
     * @param amount  the amount to deposit
     */
    public void executeTransaction(SavingsAccount account, double amount) {
        account.deposit(amount);
        account.applyInterest();
    }
}

/**
 * This interface represents a transaction. It demonstrates the OOP principle of
 * abstraction.
 */
interface Transaction {
    /**
     * Executes the transaction with the specified amount.
     * 
     * @param amount the amount for the transaction
     */
    void execute(double amount);
}

/**
 * This class represents a deposit transaction. It implements the Transaction
 * interface.
 */
class DepositTransaction implements Transaction {
    /**
     * The bank account on which the transaction is to be executed.
     */
    private BankAccount account;

    /**
     * Constructs a new DepositTransaction for the specified bank account.
     * 
     * @param account the bank account
     */
    public DepositTransaction(BankAccount account) {
        this.account = account;
    }

    /**
     * Executes the deposit transaction with the specified amount.
     * 
     * @param amount the amount to deposit
     */
    @Override
    public void execute(double amount) {
        account.deposit(amount);
    }
}

/**
 * This class represents a withdrawal transaction. It implements the Transaction
 * interface.
 */
class WithdrawalTransaction implements Transaction {
    /**
     * The bank account from which the transaction is to be executed.
     */
    private BankAccount account;

    /**
     * Constructs a new WithdrawalTransaction for the specified bank account.
     * 
     * @param account the bank account
     */
    public WithdrawalTransaction(BankAccount account) {
        this.account = account;
    }

    /**
     * Executes the withdrawal transaction with the specified amount.
     * 
     * @param amount the amount to withdraw
     */
    @Override
    public void execute(double amount) {
        account.withdraw(amount);
    }
}

/**
 * This is the main class where the execution starts.
 */
public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount();
        account.deposit(1000);
        account.withdraw(500);
        System.out.println("Balance: $" + account.getBalance());

        SavingsAccount savingsAccount = new SavingsAccount(2000, 0.05);
        savingsAccount.applyInterest();
        System.out.println("Savings Account Balance: $" + savingsAccount.getBalance());

        BankTransaction transaction = new BankTransaction();
        transaction.executeTransaction(account, 200);
        transaction.executeTransaction(savingsAccount, 300);

        Transaction depositTransaction = new DepositTransaction(account);
        depositTransaction.execute(150);
        Transaction withdrawalTransaction = new WithdrawalTransaction(account);
        withdrawalTransaction.execute(50);
        System.out.println("Final Balance: $" + account.getBalance());
    }
}