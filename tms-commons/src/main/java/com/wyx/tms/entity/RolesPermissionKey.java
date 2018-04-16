package com.wyx.tms.entity;

import java.io.Serializable;

/**
 * @author 
 */
public class RolesPermissionKey implements Serializable {
    /**
     * 角色ID
     */
    private Integer rolesId;

    /**
     * 权限ID
     */
    private Integer permissionId;

    private static final long serialVersionUID = 1L;

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}