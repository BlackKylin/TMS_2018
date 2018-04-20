package com.wyx.tms.service.impl;

import com.wyx.tms.entity.Account;
import com.wyx.tms.entity.AccountExample;
import com.wyx.tms.mapper.AccountMapper;
import com.wyx.tms.service.AccountPosService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * 库存管理的业务实现类
 */
@Service
public class AccountPosServiceImpl implements AccountPosService {

    private Logger logger = LoggerFactory.getLogger(AccountPosServiceImpl.class);


    @Autowired
    private AccountMapper accountMapper ;


}
