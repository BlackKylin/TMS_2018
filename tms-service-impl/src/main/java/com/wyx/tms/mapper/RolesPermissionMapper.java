package com.wyx.tms.mapper;

import com.wyx.tms.entity.Permission;
import com.wyx.tms.entity.RolesPermissionExample;
import com.wyx.tms.entity.RolesPermissionKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolesPermissionMapper {
    long countByExample(RolesPermissionExample example);

    int deleteByExample(RolesPermissionExample example);

    int deleteByPrimaryKey(RolesPermissionKey key);

    int insert(RolesPermissionKey record);

    int insertSelective(RolesPermissionKey record);

    List<RolesPermissionKey> selectByExample(RolesPermissionExample example);

    int updateByExampleSelective(@Param("record") RolesPermissionKey record, @Param("example") RolesPermissionExample example);

    int updateByExample(@Param("record") RolesPermissionKey record, @Param("example") RolesPermissionExample example);

}