package com.wyx.tms.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class AccountRolesKey implements Serializable {
    /**
     * 用户ID
     */
    private Integer accountId;

    /**
     * 角色ID
     */
    private Integer rolesId;

    private static final long serialVersionUID = 1L;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }
}