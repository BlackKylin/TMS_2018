package com.wyx.tms.service.impl;

import com.wyx.tms.entity.*;
import com.wyx.tms.exception.ServiceException;
import com.wyx.tms.mapper.AccountLoginLoggerMapper;
import com.wyx.tms.mapper.AccountMapper;
import com.wyx.tms.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 登录的业务实现类
 */
@Service
public class AccountServiceImpl implements AccountService {

    private Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Autowired
    private AccountMapper accountMapper;

    @Autowired
    private AccountLoginLoggerMapper accountLoginLoggerMapper;


    /**
     * 系统登录方法
     *
     * @param accountNumber
     * @param accountPassword
     * @param requestId
     * @return
     */
    @Override
    public Account login(String accountNumber, String accountPassword, String requestId) throws ServiceException {

        //根据用户账户查找用户
        AccountExample accountExample = new AccountExample();
        accountExample.createCriteria().andAccountNumberEqualTo(accountNumber);

        List<Account> accountList = accountMapper.selectByExample(accountExample);
        Account account= null;
        if(accountList != null && !accountList.isEmpty()){
            account = accountList.get(0);
        } else {
            throw new ServiceException("账户或密码错误");
        }

        //匹配密码
        if(account.getAccountPassword().equals(accountPassword)){

            //判断账户的状态
            if(account.getAccountState().equals(account.STATE_OFF)){
                throw new ServiceException("该账户已被禁用");
            }else if (account.getAccountState().equals(account.STATE_LOCK)){
                throw new ServiceException("该账户被锁定");
            }else {

                //添加登录日志
                AccountLoginLogger accountLoginLogger = new AccountLoginLogger();
                accountLoginLogger.setAccountId(account.getId());
                accountLoginLogger.setLogName(account.getAccountName());
                accountLoginLogger.setRequestId(requestId);
                accountLoginLogger.setLogTime(new Date());

                accountLoginLoggerMapper.insert(accountLoginLogger);

                logger.info("{} 登录系统",account);
                return account;
            }
        } else {
            throw new ServiceException("账户或密码错误");
        }
    }

    /**
     * 查询所有的账户
     */
    @Override
    public List<Account> selectByAccountAll() {

        AccountExample accountExample = new AccountExample();

        return accountMapper.selectByExample(accountExample);
    }


}
