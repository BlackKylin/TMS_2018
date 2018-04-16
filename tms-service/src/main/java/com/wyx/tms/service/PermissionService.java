package com.wyx.tms.service;


import com.wyx.tms.entity.Permission;

import java.util.List;

/**
 * 权限的业务类
 */
public interface PermissionService {

    /**
     * 添加权限
     * @param permission
     */
    void savePermission(Permission permission);

    /**
     * 根据类型查询权限列表
     * @param menuTypr
     * @return
     */
    List<Permission> findByPermission(String menuTypr);

    /**
     * 查询全部权限
     * @return
     */
    List<Permission> findPermissionAll();

}
