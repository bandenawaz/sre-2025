package com.example.banking;

public class BankAccount {
    private double balance;

    //constructor
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }

    //get balance
    public double getBalance() {
        return balance;
    }

    //deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        balance += amount;
    }


    //withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be positive.");
        }
        if (balance < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }
        balance -= amount;

    }
}
