package com.wyx.tms.service.impl;

import com.wyx.tms.entity.Roles;
import com.wyx.tms.entity.RolesPermissionKey;
import com.wyx.tms.mapper.RolesMapper;
import com.wyx.tms.mapper.RolesPermissionMapper;
import com.wyx.tms.service.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 角色的业务实现类
 */
@Service
public class RolesServiceImpl implements RolesService {

    private Logger logger = LoggerFactory.getLogger(RolesServiceImpl.class);

    @Autowired
    private RolesMapper rolesMapper;

    @Autowired
    private RolesPermissionMapper rolesPermissionMapper;

    /**
     * 添加角色
     *
     * @param roles        角色的对象
     * @param permissionId 选择的权限ID
     * @return
     */
    @Override
    public void addRoles(Roles roles, Integer[] permissionId) {

        roles.setCreateTime(new Date());
        roles.setUpdateTime(new Date());
        rolesMapper.insertSelective(roles);

        System.out.println(roles.getId());

        //添加角色和权限的关系
        for(Integer id : permissionId) {
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setRolesId(roles.getId());
            rolesPermissionKey.setPermissionId(id);

            rolesPermissionMapper.insert(rolesPermissionKey);
        }

        logger.info("添加了{}角色",roles);
    }
}
