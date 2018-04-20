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

        //添加角色和权限的关系
        insertRolesPermission(roles,permissionId);

        logger.info("添加了{}角色",roles);
    }

    /**
     * 查询全部角色和所拥有的权限
     *
     * @return
     */
    @Override
    public List<Roles> findAllWithPermission() {
        return rolesMapper.findAllWithPermission();
    }


    /**
     * 修改角色
     *
     * @param id
     * @return
     */
    @Override
    public Roles findByIdAndRoles(Integer id) {

        Roles roles = rolesMapper.findByIdWithPermission(id);
        return roles;
    }

    /**
     * 修改角色
     *
     * @param roles
     * @param permissionId
     */
    @Override
    public void updateRoles(Roles roles, Integer[] permissionId) {

        //将角色原有和权限的对应关系删除
        RolesPermissionExample rolesPermissionExample = new RolesPermissionExample();
        rolesPermissionExample.createCriteria().andRolesIdEqualTo(roles.getId());

        rolesPermissionMapper.deleteByExample(rolesPermissionExample);

        //添加角色和权限的关系
        insertRolesPermission(roles,permissionId);

        //修改角色对象
        rolesMapper.updateByPrimaryKeySelective(roles);

        logger.info("修改角色 {}",roles);
    }

    /**
     * 查询所有角色
     *
     * @return
     */
    @Override
    public List<Roles> findRolesAll() {

        RolesExample rolesExample = new RolesExample();

        List<Roles> rolesList = rolesMapper.selectByExample(rolesExample);

        return rolesList;
    }


    private void insertRolesPermission(Roles roles,Integer[] permissionId){
        //重建角色和权限的对应关系
        for(Integer perId : permissionId) {
            RolesPermissionKey rolesPermissionKey = new RolesPermissionKey();
            rolesPermissionKey.setRolesId(roles.getId());
            rolesPermissionKey.setPermissionId(perId);
            rolesPermissionMapper.insert(rolesPermissionKey);
        }
    }
}
