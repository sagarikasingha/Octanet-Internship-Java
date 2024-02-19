public class TransferTransaction implements Transaction {
    private String recipientAccountNumber;
    private double amount;

    public TransferTransaction(String recipientAccountNumber, double amount) {
        this.recipientAccountNumber = recipientAccountNumber;
        this.amount = amount;
    }

    public String getRecipientAccountNumber() {
        return recipientAccountNumber;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String getDescription() {
        return String.format("Transfer of $%.2f to account %s", amount, recipientAccountNumber);
    }
}