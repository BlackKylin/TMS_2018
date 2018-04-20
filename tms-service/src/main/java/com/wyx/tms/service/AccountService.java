package com.wyx.tms.service;


import com.wyx.tms.entity.Account;
import com.wyx.tms.entity.AccountLoginLogger;
import com.wyx.tms.entity.Roles;
import com.wyx.tms.exception.ServiceException;

import java.util.List;

/**
 * 登录的业务接口类
 */
public interface AccountService {

    /**
     * 查询所有的账户
     */
    List<Account> selectByAccountAll();


    /**
     * 添加账户
     * @param account
     * @param rolesIds
     */
    void saveAccount(Account account, Integer[] rolesIds);


    /**
     * 根据ID查找用户及拥有的角色
     * @param id
     * @return
     */
    Account findByIdAndAccount(Integer id);

    /**
     * 根据电话号码查询用户
     * @param accountNumber
     * @return
     */
    Account findByAccountNumber(String accountNumber);

    /**
     * 新增Account的登录日志
     * @param accountLoginLogger
     */
    void saveAccountLogger(AccountLoginLogger accountLoginLogger);

    /**
     * 修改账户
     * @param account
     * @param rolesIds
     */
    void updateAccount(Account account, Integer[] rolesIds);


    Account findAllWithRoles();

}
