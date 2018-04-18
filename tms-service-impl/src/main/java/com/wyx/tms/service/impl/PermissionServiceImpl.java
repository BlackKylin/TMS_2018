package com.wyx.tms.service.impl;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.wyx.tms.entity.Permission;
import com.wyx.tms.entity.PermissionExample;
import com.wyx.tms.mapper.PermissionMapper;
import com.wyx.tms.service.PermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 权限的业务实现类
 */
@Service
public class PermissionServiceImpl implements PermissionService {

    private Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Autowired
    private PermissionMapper permissionMapper;


    /**
     * 添加权限
     *
     * @param permission
     */
    @Override
    public void savePermission(Permission permission) {
        permission.setCreateTime(new Date());
        permission.setUpdateTime(new Date());
        permissionMapper.insertSelective(permission);
        logger.info("添加了{}权限",permission);
    }

    /**
     * 根据类型查询权限列表
     *
     * @param menuTypr
     * @return
     */
    @Override
    public List<Permission> findByPermission(String menuTypr) {

        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(menuTypr);

        return permissionMapper.selectByExample(permissionExample);
    }

    /**
     * 查询全部权限
     *
     * @return
     */
    @Override
    public List<Permission> findPermissionAll() {

        PermissionExample permissionExample = new PermissionExample();
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<Permission> list = new ArrayList<>();
        treeList(permissionList,list,0);
        return list;
    }

    /**
     * 根据ID 查询Permission
     *
     * @param id
     * @return
     */
    @Override
    public Permission findByPermissionAndId(Integer id) {
        Permission permission = permissionMapper.selectByPrimaryKey(id);
        return permission;
    }

    /**
     * 根据ID查询该Id权限的所有子权限
     *
     * @param id
     * @return
     */
    @Override
    public List<Permission> findByIdAndPermissions(Integer id) {

        PermissionExample permissionExample = new PermissionExample();
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        List<Permission> list = new ArrayList<>();
        treeList(permissionList,list,id);

        return list;
    }

    /**
     * 修改权限
     *
     * @param permission
     */
    @Override
    public void updatePermission(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    /**
     * 删除权限
     *
     * @param id
     */
    @Override
    public void deletePermission(Integer id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    private void treeList(List<Permission> permissionList, List<Permission> list, int parentId) {
        List<Permission> tempList = Lists.newArrayList(Collections2.filter(permissionList, permission -> permission.getParentId().equals(parentId)));
        for(Permission permission :tempList){
            list.add(permission);
            treeList(permissionList,list,permission.getId());
        }

    }


}
