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
    List<Roles> findAllWithPermission();

    /**
     * 根据ID查找角色
     * @param id
     * @return
     */
    Roles findByIdAndRoles(Integer id);

    /**
     * 修改角色
     * @param roles
     * @param permissionId
     */
    void updateRoles(Roles roles, Integer[] permissionId);

    /**
     * 查询所有角色
     * @return
     */
    List<Roles> findRolesAll();

}
