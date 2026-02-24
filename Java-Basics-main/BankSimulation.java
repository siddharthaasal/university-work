package Java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BankAccount {
    private int accountNumber;
    private double balance;
    private Lock lock = new ReentrantLock();

    public BankAccount(int accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        lock.lock();
        try {
            balance += amount;
            System.out.println("Deposited $" + amount + " to account " + accountNumber + ". New balance: $" + balance);
        } finally {
            lock.unlock();
        }
    }

    public void withdraw(double amount) {
        lock.lock();
        try {
            if (balance >= amount) {
                balance -= amount;
                System.out.println("Withdrawn $" + amount + " from account " + accountNumber + ". New balance: $" + balance);
            } else {
                System.out.println("Insufficient funds in account " + accountNumber);
            }
        } finally {
            lock.unlock();
        }
    }

    public double getBalance() {
        return balance;
    }
}

class BankThread extends Thread {
    private BankAccount account;
    private boolean isDeposit;
    private double amount;

    public BankThread(BankAccount account, boolean isDeposit, double amount) {
        this.account = account;
        this.isDeposit = isDeposit;
        this.amount = amount;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}

public class BankSimulation {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1, 1000.0);
        BankAccount account2 = new BankAccount(2, 2000.0);

        BankThread thread1 = new BankThread(account1, true, 500.0); // Deposit
        BankThread thread2 = new BankThread(account1, false, 300.0); // Withdraw
        BankThread thread3 = new BankThread(account2, true, 1000.0); // Deposit
        BankThread thread4 = new BankThread(account2, false, 700.0); // Withdraw

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}

