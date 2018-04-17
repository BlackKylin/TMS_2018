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

    /**
     * 根据ID 查询Permission
     * @param id
     * @return
     */
    Permission findByPermissionAndId(Integer id);

    /**
     * 根据ID查询该Id权限的所有子权限
     * @param id
     * @return
     */
    List<Permission> findByIdAndPermissions(Integer id);

    /**
     * 修改权限
     * @param permission
     */
    void updatePermission(Permission permission);

    /**
     * 删除权限
     * @param id
     */
    void deletePermission(Integer id);
}
