package com.wyx.tms.mapper;

import com.wyx.tms.entity.AccountLoginLogger;
import com.wyx.tms.entity.AccountLoginLoggerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountLoginLoggerMapper {
    long countByExample(AccountLoginLoggerExample example);

    int deleteByExample(AccountLoginLoggerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AccountLoginLogger record);

    int insertSelective(AccountLoginLogger record);

    List<AccountLoginLogger> selectByExample(AccountLoginLoggerExample example);

    AccountLoginLogger selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AccountLoginLogger record, @Param("example") AccountLoginLoggerExample example);

    int updateByExample(@Param("record") AccountLoginLogger record, @Param("example") AccountLoginLoggerExample example);

    int updateByPrimaryKeySelective(AccountLoginLogger record);

    int updateByPrimaryKey(AccountLoginLogger record);
}