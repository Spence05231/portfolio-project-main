package components.bankaccount;

public interface BankAccount extends BankAccountKernel {
    /**
     * Updates {@code this.accounts.amount} to add money to account from
     * {@code int} amount
     *
     * @param account
     *            the {@code String} for account name
     * @param amount
     *            the {@code int} for the amount
     * @returns amount in account
     * @updates this.accounts.amount
     * @requires there exists account: this.accounts
     * @ensures this.accounts.amount = #this.accounts.amount + amount
     */
    public int addMoney(String account, int amount);

    /**
     * Updates {@code this.accounts.amount} to add remove to account from
     * {@code int} amount
     *
     * @param account
     *            the {@code String} for account name
     * @param amount
     *            the {@code int} for the amount
     * @returns amount in account
     * @updates this.accounts.amount
     * @requires there exists account: this.accounts
     * @ensures this.accounts.amount = #this.accounts.amount - amount
     */
    public int removeMoney(String account, int amount);

    /**
     * Returns value of {@code this.accounts.amount} multiplied by
     * {@code this.accounts.interest}
     *
     * @param account
     *            the {@code String} for account name
     * @returns calculated interest
     * @requires there exists account: this.accounts
     */
    public double calculateInterest(String account);

    /**
     * Returns value of {@code this.accounts.amount}
     *
     * @param account
     *            the {@code String} for account name
     * @returns account total
     * @requires there exists account: this.accounts
     */
    public int getAccountTotal(String account);

    /**
     * Returns value of {@code this.accounts.interest}
     *
     * @param account
     *            the {@code String} for account name
     * @returns account interest
     * @requires there exists account: this.accounts
     */
    public double getAccountInterest(String account);

    /**
     * Returns value of {@code this.accounts.type}
     *
     * @param account
     *            the {@code String} for account name
     * @returns account type
     * @requires there exists account: this.accounts
     */
    public String getAccountType(String account);

    /**
     * Returns value of {@code this.accounts.overdraft}
     *
     * @param account
     *            the {@code String} for account name
     * @returns account overdraft fee
     * @requires there exists account: this.accounts
     */
    public int getAccountOverdraft(String account);

    /**
     * Returns value of all {@code this.accounts.amount} summed
     *
     * @returns total amount in all accounts
     */
    public int getTotal();
}