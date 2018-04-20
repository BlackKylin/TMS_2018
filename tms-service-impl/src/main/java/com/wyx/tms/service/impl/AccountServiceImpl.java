package com.wyx.tms.service.impl;

import com.wyx.tms.entity.*;
import com.wyx.tms.mapper.AccountLoginLoggerMapper;
import com.wyx.tms.mapper.AccountMapper;
import com.wyx.tms.mapper.AccountRolesMapper;
import com.wyx.tms.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private AccountRolesMapper accountRolesMapper;

    /**
     * 查询所有的账户
     */
    @Override
    public List<Account> selectByAccountAll() {

        AccountExample accountExample = new AccountExample();

        return accountMapper.selectByExample(accountExample);
    }

    /**
     * 添加账户
     * @param account
     * @param rolesIds
     */
    @Override
    @Transactional(value = "dataSourceTransactionManager")
    public void saveAccount(Account account, Integer[] rolesIds) {

        //设置账户默认密码为：000000
        account.setAccountPassword("000000");
        //设置账户的账户状态默认为：正常
        account.setAccountState(account.STATE_NORMAL);
        //设置账户的创建时间和修改时间
        account.setCreateTime(new Date());
        account.setUpdateTime(new Date());
        accountMapper.insertSelective(account);
        //添加对应关系
        insertAccountByRoles(account,rolesIds);

        logger.info("添加了{}账户",account);
    }

    /**
     * 根据ID查找用户及其拥有的角色
     *
     * @param id
     * @return
     */
    @Override
    public Account findByIdAndAccount(Integer id) {

        return accountMapper.fandByIdAccount(id);
    }

    /**
     * 根据电话号码查询用户
     *
     * @param accountNumber
     * @return
     */
    @Override
    public Account findByAccountNumber(String accountNumber) {

        AccountExample accountExample = new AccountExample();

        accountExample.createCriteria().andAccountNumberEqualTo(accountNumber);

        List<Account> accountList = accountMapper.selectByExample(accountExample);

        if(accountList != null && !accountList.isEmpty()){
            return accountList.get(0);
        }
        return null;
    }

    /**
     * 新增Account的登录日志
     *
     * @param accountLoginLogger
     */
    @Override
    public void saveAccountLogger(AccountLoginLogger accountLoginLogger) {
        accountLoginLoggerMapper.insertSelective(accountLoginLogger);
    }

    /**
     * 修改账户
     *
     * @param account
     * @param rolesIds
     */
    @Override
    @Transactional(value = "dataSourceTransactionManager")
    public void updateAccount(Account account, Integer[] rolesIds) {

        //查询关联关系表，删除其中的关联关系
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        accountRolesExample.createCriteria().andAccountIdEqualTo(account.getId());

        accountRolesMapper.deleteByExample(accountRolesExample);
        //添加对应关系
        insertAccountByRoles(account,rolesIds);

        accountMapper.updateByPrimaryKeySelective(account);
        logger.info("修改了{}账户",account);
    }

    @Override
    public Account findAllWithRoles() {
        return accountMapper.findAllWithRoles();
    }

    private void insertAccountByRoles(Account account, Integer[] rolesIds) {

        //添加角色和账户的关系
        for(Integer rolesId : rolesIds){

            AccountRolesKey accountRolesKey = new AccountRolesKey();

            accountRolesKey.setAccountId(account.getId());
            accountRolesKey.setRolesId(rolesId);
            accountRolesMapper.insert(accountRolesKey);
        }
    }


}