package com.wyx.tms.shiro;


import com.wyx.tms.entity.Account;
import com.wyx.tms.entity.AccountLoginLogger;
import com.wyx.tms.service.AccountPosService;
import com.wyx.tms.service.AccountService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class ShiroRealm extends AuthorizingRealm{


    private Logger logger = LoggerFactory.getLogger(ShiroRealm.class);


    @Autowired
    private AccountService accountService;

    /**
     * 判断角色和权限的
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /**
     * 判断登录
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;

        String accountNumber = usernamePasswordToken.getUsername();

        if(accountNumber != null){

            Account account = accountService.findByAccountNumber(accountNumber);
            if(account == null){
                throw new UnknownAccountException("找不到该账号"+accountNumber);
            } else {
                if(Account.STATE_NORMAL.equals(account.getAccountState())){

                    logger.info("{}登录成功{}",account,usernamePasswordToken.getHost());

                    //保存登录日志
                    AccountLoginLogger accountLoginLogger = new AccountLoginLogger();
                    accountLoginLogger.setAccountId(account.getId());
                    accountLoginLogger.setLogName(account.getAccountName());
                    accountLoginLogger.setLogTime(new Date());
                    accountLoginLogger.setRequestId(usernamePasswordToken.getHost());

                    accountService.saveAccountLogger(accountLoginLogger);

                    return new SimpleAuthenticationInfo(account,account.getAccountPassword(),getName());
                } else {
                    throw new LockedAccountException("账号被禁用或锁定"+account.getAccountState());
                }
            }
        }
        return null;
    }
}
