public class Account {

    private float balance;
    private float initialDeposit;
    float overdraftLimit = 0;

    public Account(float initialDeposit) {
        this.initialDeposit = initialDeposit;
        balance = initialDeposit;
        setOverdraftLimit();
    }

    public float checkBalance() {
        return balance;
    }

    public void setOverdraftLimit() {
        if (initialDeposit >= 500) {
            overdraftLimit = (float) (initialDeposit * 0.5);
        } else if (initialDeposit < 500) {
            overdraftLimit = 50;
        }
    }
    public float checkOverDraftLimit() {
        return overdraftLimit;
    }

    public void addBalance(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        balance -= amount;
    }

    public void payBill(float amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.printf("Payment sucessful. New balance: %.2f%n", balance);
        } else {
            balance -= amount + (overdraftLimit * 0.2);
            System.out.printf("Insufficient balance. Overdraft used with 20%% fee. New balance: %.2f \n", balance);
        }
    }
}
