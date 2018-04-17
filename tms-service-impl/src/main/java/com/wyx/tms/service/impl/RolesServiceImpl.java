package com.wyx.tms.service.impl;

import com.wyx.tms.entity.*;
import com.wyx.tms.mapper.PermissionMapper;
import com.wyx.tms.mapper.RolesMapper;
import com.wyx.tms.mapper.RolesPermissionMapper;
import com.wyx.tms.service.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 添加角色
     *
     * @param roles        角色的对象
     * @param permissionId 选择的权限ID
     * @return
     */
    @Override
    @Transactional(value="dataSourceTransactionManager")
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

    /**
     * 查询全部角色
     *
     * @return
     */
    @Override
    public List<Roles> findByRolesAll() {

        RolesExample rolesExample = new RolesExample();
        List<Roles> rolesList = rolesMapper.selectByExample(rolesExample);

        return rolesList;
    }

    /**
     * 查询全部权限
     *
     * @return
     */
    @Override
    public List<Permission> findByPermission() {

        PermissionExample permissionExample = new PermissionExample();

        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

        return permissionList;
    }

    /**
     * 查询角色拥有的权限
     *
     * @return
     */
    @Override
    public List<RolesPermissionKey> findByRolesPermission() {

        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();

        List<RolesPermissionKey> rolesPermissionKeyList = rolesPermissionMapper.selectByExample(rolesPermissionExample);

        return rolesPermissionKeyList;
    }
}
