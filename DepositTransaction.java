public class DepositTransaction implements Transaction{
    private double amount;

        public DepositTransaction(double amount) {
            this.amount = amount;
        }

        public double getAmount() {
            return amount;
        }
        @Override
        public String getDescription() {
            return String.format("Deposit of $%.2f", amount);
        }
}
