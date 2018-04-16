package com.wyx.tms.service;


import com.wyx.tms.entity.Account;
import com.wyx.tms.exception.ServiceException;

import java.util.List;

/**
 * 登录的业务接口类
 */
public interface AccountService {

    /**
     * 系统登录方法
     * @param accountNumber
     * @param accountPassword
     * @param requestId
     * @return
     */
    Account login(String accountNumber, String accountPassword, String requestId) throws ServiceException;

    /**
     * 查询所有的账户
     */
    List<Account> selectByAccountAll();





}
