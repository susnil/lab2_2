import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MoneyTest {
    @Test
    public void addMoneyInTheSameCurrency() throws Exception{
        Money price100PLN = new Money(100, "PLN" );
        Money price50PLN = new Money(50, "PLN" );
        Money expectedPrice = new Money( 150, "PLN" );
        assertThat( price100PLN.add(price50PLN), is( expectedPrice ) );
    }
    @Test
    public void addMoneyWithoutCurrency() throws Exception{
        Money price100PLN = new Money(100);
        Money price50PLN = new Money(50);
        Money expectedPrice = new Money( 150);
        assertThat( price100PLN.add(price50PLN), is( expectedPrice ) );
    }

    @Test(expected = IllegalArgumentException.class)
    public void addMoneyInTheDifferentCurrency() throws Exception{
        Money price100PLN = new Money(100, "PLN" );
        Money price100USD = new Money(100, "USD" );
        Money expectedPrice = new Money( 200, "PLN" );
        assertThat( price100PLN.add(price100USD), is( expectedPrice ) );
    }
    @Test
    public void subtractMoneyInTheSameCurrency() throws Exception{
        Money price200PLN = new Money(200, "PLN" );
        Money price150PLN = new Money(150, "PLN" );
        Money expectedPrice = new Money( 50, "PLN" );
        assertThat( price200PLN.subtract(price150PLN), is( expectedPrice ) );
    }
    @Test
    public void subtractMoneyWithoutCurrency() throws Exception{
        Money price200PLN = new Money(200);
        Money price150PLN = new Money(150);
        Money expectedPrice = new Money( 50);
        assertThat( price200PLN.subtract(price150PLN), is( expectedPrice ) );
    }
    @Test(expected = IllegalArgumentException.class)
    public void subtractMoneyInTheDifferentCurrency() throws Exception{
        Money price200PLN = new Money(200, "PLN" );
        Money price150PLN = new Money(150, "USD" );
        Money expectedPrice = new Money( 50, "PLN" );
        assertThat( price200PLN.subtract(price150PLN), is( expectedPrice ) );
    }
}
