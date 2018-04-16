package com.wyx.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Account implements Serializable {


    public final String STATE_NORMAL = "正常";

    public final String STATE_OFF = "禁用";

    public final String STATE_LOCK = "锁定";
    private Integer id;

    /**
     * 账号 用电话号码来作为账号使用
     */
    private String accountNumber;

    /**
     * 账户密码
     */
    private String accountPassword;

    /**
     * 账户名
     */
    private String accountName;

    /**
     * 账户创建时间
     */
    private Date createTime;

    /**
     * 账户修改时间
     */
    private Date updateTime;

    /**
     * 账号状态：正常、禁用、锁定
     */
    private String accountState;

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

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getAccountState() {
        return accountState;
    }

    public void setAccountState(String accountState) {
        this.accountState = accountState;
    }
}