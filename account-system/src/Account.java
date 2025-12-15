public class Account {

    private float balance;
    private float initialDeposit;
    private float overdraftLimit = 0;

    public Account(float initialDeposit) throws InvalidDepositException{

       if(initialDeposit <= 0){
           throw new InvalidDepositException("Invalid value!");
       }

        this.initialDeposit = initialDeposit;
        balance = initialDeposit;
        calculateOverdraftLimit();

    }

    public float getBalance() {
        return balance;
    }

    private void calculateOverdraftLimit() {
        if (initialDeposit >= 500) {
            overdraftLimit = (float) (initialDeposit * 0.5);
        } else if (initialDeposit < 500) {
            overdraftLimit = 50;
        }
    }
    public float getOverDraftLimit() {
        return overdraftLimit;
    }

    public void addBalance(float amount) {
        balance += amount;
    }

    public void withdraw(float amount) {
        balance -= amount;
    }

    public String payBill(float amount) {

        if(amount <=0){
            throw new InvalidDepositException("Invalid amount");
        }

        if (balance >= amount) {
            balance -= amount;
            return "Payment successful. New balance " + balance;
        } else if (balance < amount){
            balance -= amount + (overdraftLimit * 0.2);
            return "Insufficient balance. Overdraft used with 20% fee. New balance: " + balance;
        }
        throw new IllegalStateException("Unexpected payment state");
    }

    public String report(){
        return String.format("Balance:%.2f %nOverDraft limit: %.2f", balance, getOverDraftLimit());



    }
}
