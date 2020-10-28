package com.hdz.pretendproject.data;

public class IpGet {  //提取明细

    /**
     * id : 1
     * account : 17611569509
     * extractNum : 1
     * publicKey : puljdflskjlkjfdlkjlkj
     * state : 0
     * remark : null
     * createTime : 1603012342000
     */

    private int id;
    private String account;
    private float extractNum;
    private String publicKey;
    private String state;
    private String remark;
    private long createTime;

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

    public float getExtractNum() {
        return extractNum;
    }

    public void setExtractNum(float extractNum) {
        this.extractNum = extractNum;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }
}
