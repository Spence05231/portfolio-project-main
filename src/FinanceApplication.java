import java.util.Random;

import components.bankaccount.BankAccount;
import components.bankaccount.BankAccountMap;

public class FinanceApplication {

    final int MAX_INT = 1000000000;

    private String firstName;

    private String lastName;

    private int age;

    private int accountNumber;

    private BankAccount account;

    public FinanceApplication(String firstName, String lastName, int age) {
        Random rand = new Random();

        this.account = new BankAccountMap();
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.accountNumber = rand.nextInt(0, this.MAX_INT);
    }

    public void createBank(String account, int amount, String type,
            double interest) {
        this.account.addAccount(account, amount, interest, type, amount);
    }

    public void remmoveBank(String account) {
        this.account.removeAccount(account);
    }

    public void addMoney(String account, int amount) {
        assert this.account.hasAccount(account) : "This account does not exist";
        assert this.account.getAccountTotal(account)
                + amount < this.MAX_INT : "Over integer limit";

        this.account.addMoney(account, amount);
    }

    public void removeMoney(String account, int amount) {
        assert this.account.hasAccount(account) : "This account does not exist";

        this.account.removeMoney(account, amount);
    }

    public int getAccountMoney(String account) {
        assert this.account.hasAccount(account) : "This account does not exist";

        return this.account.getAccountTotal(account);
    }

    public double calculateInterest(String account) {
        assert this.account.hasAccount(account) : "This account does not exist";

        return this.account.calculateInterest(account);
    }

    public String getAccountType(String account) {
        assert this.account.hasAccount(account) : "This account does not exist";

        return this.account.getAccountType(account);
    }

    public String getName() {
        return this.firstName + " " + this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

}

class FinanceApplicationMain {
    public static void main(String[] args) {
        FinanceApplication account = new FinanceApplication("John", "Doe", 30);

        account.createBank("Checking", 100, "Bank", 0.05);
        account.createBank("Savings", 100000, "Bank", 0.10);

        System.out.println("Checking Account Amount: "
                + account.getAccountMoney("Checking"));
        System.out.println("Savings Account Amount: "
                + account.getAccountMoney("Savings"));

        account.addMoney("Checking", 1000);
        account.addMoney("Savings", 1000);

        System.out.println("Checking Account Amount: "
                + account.getAccountMoney("Checking"));
        System.out.println("Savings Account Amount: "
                + account.getAccountMoney("Savings"));

        account.removeMoney("Checking", 1000);
        account.removeMoney("Savings", 1000);

        System.out.println("Checking Account Amount: "
                + account.getAccountMoney("Checking"));
        System.out.println("Savings Account Amount: "
                + account.getAccountMoney("Savings"));

        System.out.println("Checking Calculated Interest: "
                + account.calculateInterest("Checking"));
        System.out.println("Checking Calculated Interest: "
                + account.calculateInterest("Savings"));

        System.out.println(
                "Checking Account Type: " + account.getAccountType("Checking"));
        System.out.println(
                "Savings Account Type: " + account.getAccountType("Savings"));

        System.out.println("Account User Name: " + account.getName());
        System.out.println("Account User Age: " + account.getAge());
        System.out.println("Account Number: " + account.getAccountNumber());
    }
}
