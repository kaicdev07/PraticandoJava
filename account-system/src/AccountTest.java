import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AccountTest {
    @Test
   void validPayABill (){
        var account= new Account(500);
        account.payBill(750);
        Assertions.assertEquals(-300, account.getBalance(), 0.01);


    }

}
