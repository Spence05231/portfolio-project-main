import java.util.Scanner;

import components.bankaccount.BankAccount;
import components.bankaccount.BankAccountMap;

class BankAccountDemo {
    public static void main(String[] args) {
        BankAccount accounts = new BankAccountMap();
        Scanner scanner = new Scanner(System.in);

        System.out.print(
                "Do you want to open a bank account? Y for Yes, and N for No: ");
        String response = scanner.next();

        while (response.toLowerCase().equals("y")) {
            System.out.print("Enter name of Bank Account: ");
            String accountName = scanner.next();

            while (accounts.hasAccount(accountName)) {
                System.out.println(
                        "Account Name Already Used, Please Use Another Name");
                System.out.print("Enter name of Bank Account: ");
                accountName = scanner.next();
            }

            System.out.print(
                    "Enter Inital Balance Greater Than or Equal To Zero: ");
            int accountAmount = scanner.nextInt();

            while (accountAmount < 0) {
                System.out.println("Invalid Account Balance");
                System.out.print(
                        "Enter Inital Balance Greater Than or Equal To Zero: ");
                accountAmount = scanner.nextInt();
            }

            System.out.print(
                    "Enter Account Interest Rate that is Greater Than or Equal to Zero and Less than or Equal to 1.00: ");
            double accountInterest = scanner.nextDouble();
            while (accountInterest < 0 || accountInterest > 1.00) {
                System.out.println("Invalid Interest Rate");
                System.out.print(
                        "Enter Account Interest Rate that is Greater Than or Equal to Zero and Less than or Equal to 1.00: ");
                accountInterest = scanner.nextDouble();
            }

            System.out.print("Enter Account Type: ");
            String accountType = scanner.next();

            System.out.print(
                    "Enter Overdraft Fee that is Greater Than or Equal To 0: ");
            int accountOverdraft = scanner.nextInt();
            while (accountOverdraft < 0) {
                System.out.println("Invalid Overdraft Fee");
                System.out.print(
                        "Enter Overdraft Fee that is Greater Than or Equal To 0: ");
                accountOverdraft = scanner.nextInt();
            }

            accounts.addAccount(accountName, accountAmount, accountInterest,
                    accountType, accountOverdraft);

            System.out.print(
                    "Do you want to open a bank account? Y for Yes, and N for No: ");
            response = scanner.next();

        }

        System.out.println(
                "1: Add Money, 2: Remove Money, 3: Calculate Interest, 4: Get Account Money, 5: Get Total in Accounts, 6: Remove Account");
        int num = scanner.nextInt();
        switch (num) {
            case 1: {
                System.out.print("Enter name of Bank Account: ");
                String name = scanner.next();

                while (!accounts.hasAccount(name)) {
                    System.out.println("Invalid Account Name");
                    System.out.print("Enter name of Bank Account: ");
                    name = scanner.next();
                }

                System.out.print("Amount of Money to Add: ");
                int amount = scanner.nextInt();
                accounts.addMoney(name, amount);
                break;
            }

            case 2: {
                System.out.print("Enter name of Bank Account: ");
                String name = scanner.next();

                while (!accounts.hasAccount(name)) {
                    System.out.println("Invalid Account Name");
                    System.out.print("Enter name of Bank Account: ");
                    name = scanner.next();
                }

                System.out.print("Amount of Money to Remove: ");
                int amount = scanner.nextInt();
                accounts.removeMoney(name, amount);
                break;
            }

            case 3: {
                System.out.print("Enter name of Bank Account: ");
                String name = scanner.next();

                while (!accounts.hasAccount(name)) {
                    System.out.println("Invalid Account Name");
                    System.out.print("Enter name of Bank Account: ");
                    name = scanner.next();
                }

                double interest = accounts.calculateInterest(name);
                System.out.println("Calculated Interest: " + interest);
                break;
            }

            case 4: {
                System.out.print("Enter name of Bank Account: ");
                String name = scanner.next();

                while (!accounts.hasAccount(name)) {
                    System.out.println("Invalid Account Name");
                    System.out.print("Enter name of Bank Account: ");
                    name = scanner.next();
                }

                int amount = accounts.getAccountTotal(name);
                System.out.println("Total in Account: " + amount);
                break;
            }

            case 5: {
                int amount = accounts.getTotal();
                System.out.println("Total in Accounts: " + amount);
                break;
            }

            case 6: {
                System.out.print("Enter name of Bank Account: ");
                String name = scanner.next();

                while (!accounts.hasAccount(name)) {
                    System.out.println("Invalid Account Name");
                    System.out.print("Enter name of Bank Account: ");
                    name = scanner.next();
                }

                accounts.removeAccount(name);
                break;
            }

            default: {
                System.out.println("Invalid Action");
                break;
            }
        }

        scanner.close();
    }
}
