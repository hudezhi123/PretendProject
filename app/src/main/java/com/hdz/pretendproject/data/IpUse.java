package com.hdz.pretendproject.data;

public class IpUse {

    /**
     * id : 1
     * account : 17611569509
     * usableAmount : 10.5
     * frozenAmount : 0
     * currency : fil
     */

    private int id;
    private String account;
    private double usableAmount;
    private int frozenAmount;
    private String currency;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(double usableAmount) {
        this.usableAmount = usableAmount;
    }

    public int getFrozenAmount() {
        return frozenAmount;
    }

    public void setFrozenAmount(int frozenAmount) {
        this.frozenAmount = frozenAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
