package com.hdz.pretendproject.data;

public class IpProduce {  //矿机产出

    /**
     * id : 5
     * orderId : 1
     * custId :
     * account : 17611569509
     * amount : 2.5
     * operatorTime : 1603010173000
     * operator :
     * state : 0
     * isSuccess : 0
     * remark : 已发放成功
     */

    private int id;
    private int orderId;
    private String custId;
    private String account;
    private double amount;
    private long operatorTime;
    private String operator;
    private String state;
    private int isSuccess;
    private String remark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getCustId() {
        return custId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getOperatorTime() {
        return operatorTime;
    }

    public void setOperatorTime(long operatorTime) {
        this.operatorTime = operatorTime;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
