package components.bankaccount;

import components.map.Map;
import components.map.Map1L;

public class BankAccountMap extends BankAccountSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Representation of {@code this.accounts}.
     */
    private Map<String, Account> accounts;

    /**
     * Representation of {@code this.size}.
     */
    private int size;

    /**
     * Creator of initial representation.
     */
    private void createNewRep() {
        this.accounts = new Map1L<String, Account>();
        this.size = 0;
    }

    /**
     * Constructor for BankAccountMap
     */
    public BankAccountMap() {
        this.createNewRep();
    }

    @Override
    public int addMoney(String account, int amount) {
        Account values = this.accounts.value(account);
        values.amount += amount;
        this.accounts.replaceValue(account, values);

        return values.amount;
    }

    @Override
    public int removeMoney(String account, int amount) {
        Account values = this.accounts.value(account);
        values.amount -= amount;

        if (values.amount < 0) {
            values.amount -= values.overdraft;
        }

        this.accounts.replaceValue(account, values);

        return values.amount;
    }

    @Override
    public double calculateInterest(String account) {
        Account values = this.accounts.value(account);
        double interest = values.interest;
        int amount = values.amount;

        return amount * interest;
    }

    @Override
    public int getAccountTotal(String account) {
        Account values = this.accounts.value(account);

        return values.amount;
    }

    @Override
    public double getAccountInterest(String account) {
        Account values = this.accounts.value(account);

        return values.interest;
    }

    @Override
    public String getAccountType(String account) {
        Account values = this.accounts.value(account);

        return values.type;
    }

    @Override
    public int getAccountOverdraft(String account) {
        Account values = this.accounts.value(account);

        return values.overdraft;
    }

    @Override
    public int getTotal() {
        int total = 0;

        for (Map.Pair<String, Account> account : this.accounts) {
            Account values = account.value();

            total += values.amount;
        }

        return total;
    }

    @Override
    public boolean hasAccount(String account) {
        boolean hasAccount = this.accounts.hasKey(account);

        return hasAccount;
    }

    @Override
    public int totalAccounts() {
        return this.size;
    }

    @Override
    public void changeAmountOfAccounts(int value) {
        this.size = value;
    }

    @Override
    public Map<String, Account> getAccounts() {
        return this.accounts;
    }

    @Override
    public void clear() {
        this.createNewRep();
    }

    @Override
    public BankAccount newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public void transferFrom(BankAccount source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof BankAccountMap : ""
                + "Violation of: source is of dynamic type BankAccountMap";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        BankAccountMap localSource = (BankAccountMap) source;
        this.accounts = localSource.accounts;
        this.size = localSource.size;
        localSource.createNewRep();
    }

}
