package com.github.SakuraMatrix.BareMarket.userservice.domain;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table("balances")
public class Balance {
    @PrimaryKey
    private int id;
    private double balance;

    public Balance(int id, double balance) {
        this.id = id;
        this.balance = balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public int getId() {
        return id;
    }
    
    public double getBalance() {
        return balance;
    }
}
