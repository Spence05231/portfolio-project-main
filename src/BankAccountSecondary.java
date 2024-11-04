import components.map.Map;

public abstract class BankAccountSecondary implements BankAccount {
    /**
     * Total Accounts or Size of Map
     */
    int size;

    /**
     * Map with all user accounts
     */
    Map<String, Account> accounts;

    @Override
    public void addAccount(String account, int deposit, double interest,
            String type, int overdraft) {
        assert deposit >= 0 : "Deposit amount must be greater or equal to 0";
        assert interest >= 0
                && interest <= 1.0 : "Interest rate must be greater or equal to 0.0 and less than or equal to 1.0";
        assert !type
                .equals("") : "Account must have a type of a non empty string";
        assert overdraft >= 0 : "Overdraft fee must be greater or equal to 0";

        Account values = new Account();
        values.amount = deposit;
        values.interest = interest;
        values.type = type;
        values.overdraft = overdraft;

        this.accounts.add(account, values);
        this.size = this.size + 1;
    }

    @Override
    public int removeAccount(String account) {
        Map.Pair<String, Account> values = this.accounts.remove(account);
        Account info = values.value();
        this.size = this.size - 1;

        return info.amount;
    }

    @Override
    public boolean hasAccount(String account) {
        return this.accounts.hasKey(account);
    }

    @Override
    public int totalAccounts() {
        return this.size;
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder("[Bank Account]");

        word.append("[Size: " + this.size + "]");

        for (Map.Pair<String, Account> i : this.accounts) {
            Account values = i.value();

            word.append("[" + i.key() + ":");
            word.append("[Amount: " + values.amount + "]");
            word.append("[Interest: " + values.interest + "]");
            word.append("[Amount: " + values.overdraft + "]");
            word.append("[Type: " + values.type + "]");
            word.append("]");
        }

        return word.toString();
    }

    @Override
    public int hashCode() {
        return (int) this.accounts.hashCode() * (this.size / 2);
    }

}
