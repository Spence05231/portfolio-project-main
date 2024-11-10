import components.map.Map;
import components.standard.Standard;

public interface BankAccountKernel extends Standard<BankAccount> {
    /**
     * Updates {@code this.accounts} to add account with following parameters.
     *
     * @param account
     *            the {@code String} for account name
     * @param deposit
     *            the {@code int} for initial deposit amount
     * @param interest
     *            the {@code double} for decimal interest rate
     * @param type
     *            the {@code String} for the account type
     * @param overdraft
     *            the {@code int} for the overdraft fee
     * @updates this
     * @requires deposit >= 0
     * @requires interest >= 0.0 && interest <= 1.0
     * @requires overdraft >= 0
     * @requires type != ""
     * @ensures |this.accounts| = |this.accounts| + 1
     */
    public void addAccount(String account, int deposit, double interest,
            String type, int overdraft);

    /**
     * Updates {@code this.accounts} to remove account with account
     * {@code account} and reports to {@code int}.
     *
     * @param account
     *            the {@code String} for account name
     * @returns final amount in account
     * @updates this
     * @requires there exists account: this.accounts
     * @ensures |this.accounts| = |this.accounts| - 1
     */
    public int removeAccount(String account);

    /**
     * Reports {@code boolean} if there exists {@code String} in
     * {@code this.accounts}
     *
     * @param account
     *            the {@code String} for account name
     * @return if account exists
     * @updates this
     */
    public boolean hasAccount(String account);

    /**
     * Reports {@code int} of {@code this.size}
     *
     * @return total accounts
     * @ensures |this.accounts| == this.size
     */
    public int totalAccounts();

    /**
     * Reports {@code int} of {@code this.size}
     *
     * @param value
     *            the {@code int} for the number of accounts
     *
     * @requires value >= 0
     * @ensures |this.accounts| == value
     */
    public void changeAmountOfAccounts(int value);

    /**
     * Reports {@code Map<String, Account>} of {@code this.accounts}
     *
     * @return Map of all accounts
     */
    public Map<String, Account> getAccounts();
}