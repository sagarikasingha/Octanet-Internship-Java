import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    private BankAccount bankAccount;
    private HashMap<String, BankAccount> accountMap;

    public ATM(BankAccount bankAccount, HashMap<String, BankAccount> accountMap) {
        this.bankAccount = bankAccount;
        this.accountMap = accountMap;
    }

    public void displayMenu() {
        System.out.println("ATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. Transaction History");
        System.out.println("6. Exit");
    }

    public void run() {
        try (Scanner scanner = new Scanner(System.in)) {
            BankAccount recipientAccount = null;

            while (true) {
                displayMenu();
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Current balance: $" + bankAccount.getBalance());
                        break;
                    case 2:
                        System.out.print("Enter the deposit amount: $");
                        double depositAmount = scanner.nextDouble();
                        bankAccount.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter the withdrawal amount: $");
                        double withdrawalAmount = scanner.nextDouble();
                        boolean withdrawSuccess = bankAccount.withdraw(withdrawalAmount);
                        if (withdrawSuccess) {
                            System.out.println("Withdrawal successful.");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the recipient's account number: ");
                        String recipientAccountNumber = scanner.next();
                        recipientAccount = accountMap.get(recipientAccountNumber);
                        if (recipientAccount == null) {
                            System.out.println("Invalid recipient account number.");
                        } else {
                            System.out.print("Enter the transfer amount: $");
                            double transferAmount = scanner.nextDouble();
                            boolean transferSuccess = bankAccount.transfer(recipientAccount, transferAmount);
                            if (transferSuccess) {
                                System.out.println("Transfer successful.");
                            }
                        }
                    break;
                case 5:
                    bankAccount.printTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
   }
        }
    
    }
}
