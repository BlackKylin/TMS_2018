package com.wyx.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class AccountPos implements Serializable {
    private Integer id;

    /**
     * 账号
     */
    private String accountNumber;

    /**
     * 账号名称
     */
    private String accountName;

    /**
     * 密码
     */
    private String accountPassword;

    /**
     * 状态
     */
    private String accountState;

    /**
     * 创建时间
     */
    private Date oblosleteTime;

    /**
     * 修改时间
     */
    private Date modificationTime;

    /**
     * 销售点ID
     */
    private Integer posId;

    private static final long serialVersionUID = 1L;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }

    public Date getOblosleteTime() {
        return oblosleteTime;
    }

    public void setOblosleteTime(Date oblosleteTime) {
        this.oblosleteTime = oblosleteTime;
    }

    public Date getModificationTime() {
        return modificationTime;
    }

    public void setModificationTime(Date modificationTime) {
        this.modificationTime = modificationTime;
    }

    public Integer getPosId() {
        return posId;
    }

    public void setPosId(Integer posId) {
        this.posId = posId;
    }
}