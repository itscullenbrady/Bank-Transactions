import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BankAccount account = new BankAccount();
        SavingsAccount savingsAccount = new SavingsAccount(0.05);
        BankTransaction transaction = new BankTransaction();

        System.out.println("Welcome to the Banking Program!");
        System.out.println("1. Deposit to Bank Account");
        System.out.println("2. Withdraw from Savings Account");
        System.out.println("3. Transfer from Bank Account to Savings Account");

        System.out.print("Enter your choice (1, 2, or 3): ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter the amount to deposit to Bank Account: ");
                double depositAmount = scanner.nextDouble();
                transaction.execute(account, depositAmount);
                break;
            case 2:
                System.out.print("Enter the amount to withdraw from Savings Account: ");
                double withdrawalAmount = scanner.nextDouble();
                transaction.execute(savingsAccount, withdrawalAmount);
                break;
            case 3:
                System.out.print("Enter the amount to transfer from Bank Account to Savings Account: ");
                double transferAmount = scanner.nextDouble();
                transaction.transfer(account, savingsAccount, transferAmount);
                break;
            default:
                System.out.println("Invalid choice. Please choose 1, 2, or 3.");
        }

        System.out.println("Bank Account Balance: " + account.getBalance());
        System.out.println("Savings Account Balance: " + savingsAccount.getBalance());
        System.out.println("Savings Account Interest Rate: " + savingsAccount.getInterestRate());

        scanner.close();
    }
}
