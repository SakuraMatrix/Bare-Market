package com.github.SakuraMatrix.BareMarket.usergateway.domain;

public class Balance {
    private int id;
    private double balance;

    public Balance() {
        
    }

    public Balance(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
    
    public double getBalance() {
        return balance;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
