package com.wyx.tms.controller;


import com.wyx.tms.entity.Account;
import com.wyx.tms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * 账号管理的控制器
 * @outhor wyx
 */
@Controller
public class AccountController {


    @Autowired
    private AccountService accountService;


    @GetMapping("/account/home")
    public String home(Model model){


        List<Account> accountList = accountService.selectByAccountAll();

        if(accountList != null && !accountList.isEmpty()){
            model.addAttribute("accountList",accountList);
        }

        return "account/home";
    }


}
