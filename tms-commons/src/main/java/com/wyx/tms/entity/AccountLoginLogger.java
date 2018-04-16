package com.wyx.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class AccountLoginLogger implements Serializable {
    private Integer id;

    /**
     * 登录的账户名
     */
    private String logName;

    /**
     * 创建时间
     */
    private Date logTime;

    /**
     * 登录的账户ID
     */
    private Integer accountId;

    /**
     * 账号登录的IP地址
     */
    private String requestId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public Date getLogTime() {
        return logTime;
    }

    public void setLogTime(Date logTime) {
        this.logTime = logTime;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @Override
    public String toString() {
        return "AccountLoginLogger{" +
                "id=" + id +
                ", logName='" + logName + '\'' +
                ", logTime=" + logTime +
                ", accountId=" + accountId +
                '}';
    }
}