import java.util.Scanner;

public class AccountMain {
    public static void main(String[] args) {
        var scanner= new Scanner(System.in);
        float amount= 0;
        float bill= 0;

        System.out.println("How much you wish deposit in the bank!");
        float initialAmount = scanner.nextFloat();
        Account account= new Account(initialAmount);

        System.out.println("You wanna make a deposit? (y/n)");
        var verify= scanner.next().equalsIgnoreCase("y");
        if(verify){
            System.out.println("Please inform the amount");
            amount= scanner.nextFloat();
            account.addBalance(amount);
            if(amount <=0){
                throw new InvalidDepositException("Invalid amount");
        }
        }

        System.out.println("You have a bill for pay? (y/n)");
        var billVerify= scanner.next().equalsIgnoreCase("y");
            System.out.println("Please inform the amount");
            bill= scanner.nextFloat();
            account.payBill(bill);

        System.out.println(account.report());

    }

}
