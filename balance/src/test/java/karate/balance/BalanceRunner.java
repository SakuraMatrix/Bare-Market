package karate.balance;

import com.intuit.karate.junit5.Karate;

public class BalanceRunner {
    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
