import org.junit.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MoneyTest {
    @Test
    public void addMoneyInTheSameCurrency() throws Exception{
        Money price100PLN = new Money(100, "PLN" );
        Money expectedPrice = new Money( 200, "PLN" );
        assertThat( price100PLN.add(price100PLN), is( expectedPrice ) );
    }
}
