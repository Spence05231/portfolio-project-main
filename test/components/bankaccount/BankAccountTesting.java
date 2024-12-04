package components.bankaccount;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * JUnit test fixture for {@code BankAccount}'s constructor, kernel, and
 * secondary methods.
 *
 * @author Carson Spencer
 *
 */
public abstract class BankAccountTesting {
        /**
         * Invokes the appropriate {@code BankAccount} constructor for the
         * implementation under test and returns the result.
         *
         * @return the new bank account
         * @ensures constructorTest = {}
         */
        protected abstract BankAccount constructorTest();

        /**
         * Invokes the appropriate {@code BankAccount} constructor for the
         * reference implementation and returns the result.
         *
         * @return the new bank account
         * @ensures constructorRef = {}
         */
        protected abstract BankAccount constructorRef();

        @Test
        public final void testConstructor() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                int expectedAccounts = 0;

                assertEquals(accountExpected, account);
                assertEquals(expectedAccounts, account.totalAccounts());
        }

        @Test
        public final void testAddAccount1() {
                BankAccount account = this.constructorTest();

                String expectedAccountName = "Savings";
                int expectedAmount = 1000;
                double expectedInterest = 0.05;
                String expectedType = "Bank";
                int expectedOverdraft = 100;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                assertEquals(true, account.hasAccount(expectedAccountName));
                assertEquals(expectedAmount,
                                account.getAccountTotal(expectedAccountName));
                assertEquals(expectedType,
                                account.getAccountType(expectedAccountName));
                assertEquals(expectedOverdraft, account
                                .getAccountOverdraft(expectedAccountName));
        }

        @Test
        public final void testAddAccount2() {
                BankAccount account = this.constructorTest();

                String expectedAccountName = "Checking";
                int expectedAmount = 0;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                assertEquals(true, account.hasAccount(expectedAccountName));
                assertEquals(expectedAmount,
                                account.getAccountTotal(expectedAccountName));
                assertEquals(expectedType,
                                account.getAccountType(expectedAccountName));
                assertEquals(expectedOverdraft, account
                                .getAccountOverdraft(expectedAccountName));
        }

        @Test
        public final void testRemoveAccount1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 0;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int removedAmount = account.removeAccount(expectedAccountName);

                assertEquals(accountExpected, account);
                assertEquals(expectedAmount, removedAmount);
        }

        @Test
        public final void testRemoveAccount2() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                String expectedAccountName2 = "Savings";
                int expectedAmount2 = 500;
                double expectedInterest2 = 0.0;
                String expectedType2 = "Bank";
                int expectedOverdraft2 = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                account.addAccount(expectedAccountName2, expectedAmount2,
                                expectedInterest2, expectedType2,
                                expectedOverdraft2);
                accountExpected.addAccount(expectedAccountName2,
                                expectedAmount2, expectedInterest2,
                                expectedType2, expectedOverdraft2);

                int removedAmount = account.removeAccount(expectedAccountName);

                assertEquals(accountExpected, account);
                assertEquals(expectedAmount, removedAmount);
        }

        @Test
        public final void testHasAccount1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                boolean hasAccountExpected = false;
                boolean hasAccount = account.hasAccount("Checking");

                assertEquals(hasAccountExpected, hasAccount);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testHasAccount2() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                boolean hasAccountExpected = true;
                boolean hasAccount = account.hasAccount(expectedAccountName);

                assertEquals(hasAccountExpected, hasAccount);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testHasAccount3() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                boolean hasAccountExpected = false;
                boolean hasAccount = account.hasAccount("Savings");

                assertEquals(hasAccountExpected, hasAccount);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testTotalAccounts1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                int expectedAccounts = 0;
                int totalAccounts = account.totalAccounts();

                assertEquals(expectedAccounts, totalAccounts);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testTotalAccounts2() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int expectedAccounts = 1;
                int totalAccounts = account.totalAccounts();

                assertEquals(expectedAccounts, totalAccounts);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testTotalAccounts3() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                String expectedAccountName2 = "Savings";
                int expectedAmount2 = 500;
                double expectedInterest2 = 0.0;
                String expectedType2 = "Bank";
                int expectedOverdraft2 = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                account.addAccount(expectedAccountName2, expectedAmount2,
                                expectedInterest2, expectedType2,
                                expectedOverdraft2);
                accountExpected.addAccount(expectedAccountName2,
                                expectedAmount2, expectedInterest2,
                                expectedType2, expectedOverdraft2);

                int expectedAccounts = 2;
                int totalAccounts = account.totalAccounts();

                assertEquals(expectedAccounts, totalAccounts);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testAddMoney1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int accountAmount = account.addMoney(expectedAccountName,
                                expectedAmount);
                accountExpected.addMoney(expectedAccountName, expectedAmount);

                int expectedTotal = 1000;

                assertEquals(expectedTotal, accountAmount);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testAddMoney2() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                account.addMoney(expectedAccountName, expectedAmount);
                int accountAmount = account.addMoney(expectedAccountName,
                                expectedAmount);
                accountExpected.addMoney(expectedAccountName, expectedAmount);
                accountExpected.addMoney(expectedAccountName, expectedAmount);

                int expectedTotal = 1500;

                assertEquals(expectedTotal, accountAmount);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testRemoveMoney1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int accountAmount = account.removeMoney(expectedAccountName,
                                expectedAmount);
                accountExpected.removeMoney(expectedAccountName,
                                expectedAmount);

                int expectedTotal = 0;

                assertEquals(expectedTotal, accountAmount);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testCalculateInterest1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.1;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int accountInterest = (int) account
                                .calculateInterest(expectedAccountName);

                int expectedInterestAmount = 50;

                assertEquals(expectedInterestAmount, accountInterest);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void getAccountTotal1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.1;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int accountTotal = account.getAccountTotal(expectedAccountName);

                assertEquals(expectedAmount, accountTotal);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testAccountInterest1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.1;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                double accountInterest = account
                                .getAccountInterest(expectedAccountName);

                assertEquals(Math.abs(
                                accountInterest - expectedInterest) < 0.0001,
                                true);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testAccountType1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.1;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                String accountType = account
                                .getAccountType(expectedAccountName);

                assertEquals(expectedType, accountType);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testAccountOverdraft1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.1;
                String expectedType = "Bank";
                int expectedOverdraft = 100;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);

                int accountType = account
                                .getAccountOverdraft(expectedAccountName);

                assertEquals(expectedOverdraft, accountType);
                assertEquals(accountExpected, account);
        }

        @Test
        public final void testAccountTotals1() {
                BankAccount account = this.constructorTest();
                BankAccount accountExpected = this.constructorRef();

                String expectedAccountName = "Checking";
                int expectedAmount = 500;
                double expectedInterest = 0.0;
                String expectedType = "Bank";
                int expectedOverdraft = 0;

                String expectedAccountName2 = "Savings";
                int expectedAmount2 = 500;
                double expectedInterest2 = 0.0;
                String expectedType2 = "Bank";
                int expectedOverdraft2 = 0;

                account.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                accountExpected.addAccount(expectedAccountName, expectedAmount,
                                expectedInterest, expectedType,
                                expectedOverdraft);
                account.addAccount(expectedAccountName2, expectedAmount2,
                                expectedInterest2, expectedType2,
                                expectedOverdraft2);
                accountExpected.addAccount(expectedAccountName2,
                                expectedAmount2, expectedInterest2,
                                expectedType2, expectedOverdraft2);

                int expectedAccountsTotal = 1000;
                int accountsTotal = account.getTotal();

                assertEquals(expectedAccountsTotal, accountsTotal);
                assertEquals(accountExpected, account);
        }
}