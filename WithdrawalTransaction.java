public class WithdrawalTransaction implements Transaction {
    private double amount;

    public WithdrawalTransaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String getDescription() {
        return String.format("Withdrawal of $%.2f", amount);
    }
}