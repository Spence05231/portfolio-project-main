package components.bankaccount;

/**
 * Customized JUnit test fixture for {@code BankAccount} using default
 * constructor.
 */
public class BankAccountMapTest extends BankAccountTesting {

    @Override
    protected final BankAccount constructorTest() {
        return new BankAccountMap();
    }

    @Override
    protected final BankAccount constructorRef() {
        return new BankAccountMap();
    }

}
