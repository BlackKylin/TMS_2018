package com.wyx.tms.mapper;

import com.wyx.tms.entity.AccountPos;
import com.wyx.tms.entity.AccountPosExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountPosMapper {
    long countByExample(AccountPosExample example);

    int deleteByExample(AccountPosExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountPos record);

    int insertSelective(AccountPos record);

    List<AccountPos> selectByExample(AccountPosExample example);

    AccountPos selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountPos record, @Param("example") AccountPosExample example);

    int updateByExample(@Param("record") AccountPos record, @Param("example") AccountPosExample example);

    int updateByPrimaryKeySelective(AccountPos record);

    int updateByPrimaryKey(AccountPos record);
}