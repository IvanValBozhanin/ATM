package com.company;

import java.util.Date;

public class Account {
    private int id = 0;
    private static int numberOfAccounts;
    private double balance = 0;
    private static double yearInterestRate = 0;
    private Date dateCreated;

    public Account() {
        ++numberOfAccounts;
        dateCreated = new Date();
    }

    public Account(int id, double balance) {
        this.id = id;
        this.balance = balance;
        ++numberOfAccounts;
        dateCreated = new Date();
    }

    public static int getNumberOfAccounts(){
        return numberOfAccounts;
    }

    public void deposit(double sum){
        balance += sum;
        System.out.println("Current balance " + balance);
    }

    public void withdraw(double sum){
        if(sum < balance){
            System.out.println("Withdrawn " + sum);
            balance -= sum;
            System.out.println("Current balance " + balance);
        } else {
            System.out.println("Cannot withdraw more than the balance!");
        }
    }

    public double getMonthlyInterest(){
        return balance*getMonthlyInterestRate();
    }

    public double getMonthlyInterestRate(){
        return yearInterestRate / 12;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getYearInterestRate() {
        return yearInterestRate;
    }

    public static void setYearInterestRate(double yearInterestRate) {
        Account.yearInterestRate = yearInterestRate/100;
    }

    public Date getDateCreated() {
        return dateCreated;
    }
}
