import java.util.HashMap;

class Account {
    int amount;
    double interest;
    String type;
    int overdraft;
}

public class BankAccountInitial {

    // Private for Map of Stocks
    private HashMap<String, Account> accounts;
    private int size;

    private void createAccount() {
        this.accounts = new HashMap<String, Account>();
        this.size = 0;
    }

    public BankAccountInitial() {
        this.createAccount();
    }

    public final void addAccount(String account, int deposit, double interest,
            String type, int overdraft) {

        if (deposit >= 0 && interest >= 0) {
            Account values = new Account();
            values.amount = deposit;
            values.interest = interest;
            values.type = type;
            values.overdraft = overdraft;

            this.accounts.put(account, values);
            this.size = this.size + 1;
        }
    }

    public final int removeAccount(String account) {
        Account values = this.accounts.remove(account);
        this.size = this.size - 1;

        return values.amount;
    }

    public final boolean hasAccount(String account) {
        return this.accounts.containsKey(account);
    }

    public final int addMoney(String account, int amount) {
        Account values = this.accounts.get(account);
        values.amount += amount;
        this.accounts.replace(account, values);

        return values.amount;
    }

    public final int removeMoney(String account, int amount) {
        Account values = this.accounts.get(account);
        values.amount -= amount;
        if (values.amount < 0) {
            values.amount -= values.overdraft;
        }
        this.accounts.replace(account, values);

        return values.amount;
    }

    public final double calculateInterest(String account) {

        Account values = this.accounts.get(account);

        return values.interest * values.amount;
    }

    public final int getAccountTotal(String account) {
        Account values = this.accounts.get(account);

        return values.amount;
    }

    public final double getAccountInterest(String account) {
        Account values = this.accounts.get(account);

        return values.interest;
    }

    public final String getAccountType(String account) {
        Account values = this.accounts.get(account);

        return values.type;
    }

    public final int getAccountOverdraft(String account) {
        Account values = this.accounts.get(account);

        return values.overdraft;
    }

    public final int getTotal() {
        int total = 0;

        for (String key : this.accounts.keySet()) {
            Account value = this.accounts.get(key);

            total += value.amount;
        }

        return total;
    }

    public final int totalAccounts() {
        return this.size;
    }

}

class Main {
    public static void main(String[] args) {
        BankAccountInitial a = new BankAccountInitial();
        a.addAccount("Checking", 1000, 0.05, "Bank", 100);
        a.addAccount("Savings", 2500, 0.05, "Bank", 100);
        a.addAccount("Brokerage", 10000, 0, "Brokerage", 0);

        System.out.println(
                "Checking Account Total: " + a.getAccountTotal("Checking"));
        System.out.println("Checking Account Interest: "
                + a.getAccountInterest("Checking"));
        System.out.println(
                "Checking Account Type: " + a.getAccountType("Checking"));
        System.out.println("Checking Account Overdraft: "
                + a.getAccountOverdraft("Checking"));
        System.out.println(
                "Savings Account Total: " + a.getAccountTotal("Savings"));
        System.out.println(
                "Savings Account Interest: " + a.getAccountInterest("Savings"));
        System.out.println(
                "Savings Account Type: " + a.getAccountType("Savings"));
        System.out.println("Savings Account Overdraft: "
                + a.getAccountOverdraft("Savings"));
        System.out.println(
                "Brokerage Account Total: " + a.getAccountTotal("Brokerage"));
        System.out.println("Brokerage Account Interest: "
                + a.getAccountInterest("Brokerage"));
        System.out.println(
                "Brokerage Account Type: " + a.getAccountType("Brokerage"));
        System.out.println("Brokerage Account Type: "
                + a.getAccountOverdraft("Brokerage"));
        System.out.println("All Accounts Total: " + a.getTotal());

        a.addMoney("Checking", 100000);
        System.out.println(
                "Checking Account Total: " + a.getAccountTotal("Checking"));
        a.removeMoney("Checking", 100000);
        System.out.println(
                "Checking Account Total: " + a.getAccountTotal("Checking"));
        System.out.println("Has Account Mortgage: " + a.hasAccount("Mortgage"));
        System.out.println("Total Accounts: " + a.totalAccounts());
        a.removeAccount("Brokerage");
        System.out.println(
                "Total Accounts After Remove Brokerage: " + a.totalAccounts());
        System.out.println("Calculated Interest of Checking: "
                + a.calculateInterest("Checking"));
    }
}
