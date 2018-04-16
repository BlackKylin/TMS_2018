package com.wyx.tms.service;

import com.wyx.tms.entity.Roles; /**
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
}
