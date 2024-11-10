import components.map.Map;

public abstract class BankAccountSecondary implements BankAccount {
    @Override
    public void addAccount(String account, int deposit, double interest,
            String type, int overdraft) {
        assert deposit >= 0 : "Deposit amount must be greater or equal to 0";
        assert interest >= 0
                && interest <= 1.0 : "Interest rate must be greater or equal to 0.0 and less than or equal to 1.0";
        assert !type
                .equals("") : "Account must have a type of a non empty string";
        assert overdraft >= 0 : "Overdraft fee must be greater or equal to 0";

        Map<String, Account> accounts = this.getAccounts();

        Account values = new Account();
        values.amount = deposit;
        values.interest = interest;
        values.type = type;
        values.overdraft = overdraft;

        accounts.add(account, values);
        this.changeAmountOfAccounts(this.totalAccounts() + 1);
    }

    @Override
    public int removeAccount(String account) {
        assert this.hasAccount(
                account) : "Must have account in accounts to remove";

        Map<String, Account> accounts = this.getAccounts();
        Map.Pair<String, Account> values = accounts.remove(account);
        Account info = values.value();
        this.changeAmountOfAccounts(this.totalAccounts() - 1);

        return info.amount;
    }

    @Override
    public String toString() {
        StringBuilder word = new StringBuilder("[Bank Account]");
        Map<String, Account> accounts = this.getAccounts();

        word.append("[Size: " + this.totalAccounts() + "]");

        for (Map.Pair<String, Account> i : accounts) {
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
        Map<String, Account> accounts = this.getAccounts();

        return (int) accounts.hashCode() * (this.totalAccounts() / 2);
    }

}
