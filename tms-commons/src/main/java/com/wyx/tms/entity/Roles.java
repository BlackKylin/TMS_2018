package com.wyx.tms.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 
 */
public class Roles implements Serializable {


    private Integer id;

    /**
     * 角色名称
     */
    private String rolesName;

    /**
     * 角色代号
     */
    private String rolesCode;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 角色拥有的权限
     */
    private Integer[] permissionsId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolesName() {
        return rolesName;
    }

    public void setRolesName(String rolesName) {
        this.rolesName = rolesName;
    }

    public String getRolesCode() {
        return rolesCode;
    }

    public void setRolesCode(String rolesCode) {
        this.rolesCode = rolesCode;
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

    public Integer[] getPermissionsId() {
        return permissionsId;
    }

    public void setPermissionsId(Integer[] permissionsId) {
        this.permissionsId = permissionsId;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", rolesName='" + rolesName + '\'' +
                ", rolesCode='" + rolesCode + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}