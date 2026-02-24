package Java;

import java.util.*;

class Bank {

    private Map<String, Double> accountBalances;

    public Bank(String accountNumber) {
        this.accountBalances = new HashMap<>();
        accountBalances.put(accountNumber, 0.0);
        System.out.println("Account created successfully.");
    }

    public void deposit(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber) && amount > 0) {
            double currentBalance = accountBalances.get(accountNumber);
            accountBalances.put(accountNumber, currentBalance + amount);
            System.out.println("Deposited Rs. " + amount + " into account " + accountNumber);
        } else {
            System.out.println("Invalid account number or deposit amount.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        if (accountBalances.containsKey(accountNumber) && amount > 0) {
            double currentBalance = accountBalances.get(accountNumber);
            if (currentBalance >= amount) {
                accountBalances.put(accountNumber, currentBalance - amount);
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Invalid account number or withdrawal amount.");
        }
    }

    public void checkBalance(String accountNumber) {
        if (accountBalances.containsKey(accountNumber)) {
            double balance = accountBalances.get(accountNumber);
            System.out.println("Account Number: " + accountNumber);
            System.out.println("Balance: $" + balance);
        } else {
            System.out.println("Invalid account number.");
        }
    }
}

public class Ass1Q2 {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("Enter initial account number: ");
        String initialAccountNumber = kb.next();
        Bank bank = new Bank(initialAccountNumber);
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = kb.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the account number: ");
                    String depositAccountNumber = kb.next();
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = kb.nextDouble();
                    bank.deposit(depositAccountNumber, depositAmount);
                    break;
                case 2:
                    System.out.print("Enter the account number: ");
                    String withdrawAccountNumber = kb.next();
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawAmount = kb.nextDouble();
                    bank.withdraw(withdrawAccountNumber, withdrawAmount);
                    break;
                case 3:
                    System.out.print("Enter the account number: ");
                    String checkBalanceAccountNumber = kb.next();
                    bank.checkBalance(checkBalanceAccountNumber);
                    break;
                case 4:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    kb.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
