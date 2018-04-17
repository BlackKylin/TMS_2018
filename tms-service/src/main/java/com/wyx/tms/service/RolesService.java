package com.wyx.tms.service;

import com.wyx.tms.entity.Permission;
import com.wyx.tms.entity.Roles;
import com.wyx.tms.entity.RolesPermissionKey;

import java.util.List;

/**
 * 角色业务类
 */
public interface RolesService {
    /**
     * 添加角色
     * @param roles 角色的对象
     * @param permissionId  选择的权限ID
     * @return
     */
    void addRoles(Roles roles, Integer[] permissionId);

    /**
     * 查询全部角色
     * @return
     */
    List<Roles> findByRolesAll();

    /**
     * 查询全部权限
     * @return
     */
    List<Permission> findByPermission();

    /**
     * 查询角色拥有的权限
     * @return
     */
    List<RolesPermissionKey> findByRolesPermission();
}
