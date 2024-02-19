import java.util.HashMap;
import java.util.Scanner;

public class BankingSystem {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("\n\nWelcome to the bank!");

            HashMap<String, BankAccount> accountMap = new HashMap<>();
            accountMap.put("123456", new BankAccount(5000, 123, "123456"));
            System.out.println("\n\nAccount Opened: Account Number: 123456 || Balance:5000 ");
            accountMap.put("234567", new BankAccount(10000, 234, "234567"));
            System.out.println("\n\nAccount Opened: Account Number: 234567 || Balance:10000 ");

            System.out.print("Enter your Account Number: ");
            String accountNumber = scanner.next();

            System.out.print("Enter your PIN: ");
            int pin = scanner.nextInt();

            BankAccount currentAccount = null;
            for (BankAccount account : accountMap.values()) {
                if (account.getBalance() > 0 && account.validateCredentials(accountNumber, pin)) {
                    currentAccount = account;
                    break;
                }
            }

            if (currentAccount == null) {
                System.out.println("\nInvalid account number or PIN. Exiting the system.");
                System.exit(0);
            }

            System.out.println("\n\nWorking on Account Number: " + accountNumber);
            ATM atm = new ATM(currentAccount, accountMap);
            atm.run();
        };
    }
}