import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private int pin;
    private String accountNumber;

   private List<Transaction> transactionHistory;

    public BankAccount(double initialBalance, int accountPin, String accountNumber) {
        this.balance = initialBalance;
        this.pin = accountPin;
        this.accountNumber = accountNumber;
        this.transactionHistory = new ArrayList<>();
    }
    public double getBalance() {
        return balance;
    }

    public boolean validateCredentials(String inputAccountNumber, int inputPin) {
        return this.accountNumber.equals(inputAccountNumber) && this.pin == inputPin;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction(new DepositTransaction(amount));
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0) {
            if (amount <= balance) {
                balance -= amount;
                addTransaction(new WithdrawalTransaction(amount));
                System.out.println("Withdrawal successful. New balance: $" + balance);
                return true;
            } else {
                System.out.println("Insufficient funds for withdrawal. Current balance: $" + balance);
            }
        } else {  System.out.println("Invalid withdrawal amount. Please enter a positive amount.");
    }
    return false;
}

public boolean transfer(BankAccount recipient, double amount) {
    if (amount > 0) {
        if (amount <= balance) {
            balance -= amount;
            recipient.balance += amount;
            addTransaction(new TransferTransaction(recipient.getAccountNumber(), amount));
            System.out.println("Transfer successful. New balance: $" + balance);
            return true;
        } else {
            System.out.println("Insufficient funds for transfer. Current balance: $" + balance);
        }
    } else {
        System.out.println("Invalid transfer amount. Please enter a positive amount.");
    }
    return false;
}

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }

    public void printTransactionHistory() {
        System.out.println("\nTransaction history:");
        for (int i = 0; i < transactionHistory.size(); i++) {
            Transaction transaction = transactionHistory.get(i);
            System.out.println((i + 1) + ". " + transaction.getDescription());
        }
    }
}