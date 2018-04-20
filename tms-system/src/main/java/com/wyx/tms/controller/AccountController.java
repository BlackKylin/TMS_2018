package com.wyx.tms.controller;


import com.google.common.collect.Maps;
import com.wyx.tms.entity.Account;
import com.wyx.tms.entity.Roles;
import com.wyx.tms.service.AccountService;
import com.wyx.tms.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

/**
 * 账号管理的控制器
 * @outhor wyx
 */
@Controller
public class AccountController {


    @Autowired
    private AccountService accountService;

    @Autowired
    private RolesService rolesService;

    /**
     * 跳转到账户管理的首页
     * @param model
     * @return
     */
    @GetMapping("/account/home")
    public String home(Model model){

/*
        List<Account> accountList = accountService.selectByAccountAll();

        if(accountList != null && !accountList.isEmpty()){
            model.addAttribute("accountList",accountList);
        }

        //查询所有的角色
        List<Roles> rolesList = rolesService.findAllWithPermission();
         model.addAttribute("rolesList",rolesList);
        model.addAttribute("accountList",accountList);
*/

        List<Account> accountList = accountService.selectByAccountAll();

        if(accountList != null && !accountList.isEmpty()){
            model.addAttribute("accountList",accountList);
        }

        Account account = accountService.findAllWithRoles();

        model.addAttribute("account",account);



        return "account/home";
    }

    /**
     * 跳转到添加账户页面
     * @param model
     * @return
     */
    @GetMapping("/account/add")
    public String add(Model model){

        List<Roles> rolesList = rolesService.findAllWithPermission();

        model.addAttribute("rolesList",rolesList);
        return "account/add";
    }

    /**
     * 添加账户表达的提交
     * @param account 账户对象
     * @param rolesIds  所拥有角色的ID数组
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/account/add")
    public String add(Account account, Integer[] rolesIds, RedirectAttributes redirectAttributes){

        accountService.saveAccount(account,rolesIds);

        redirectAttributes.addFlashAttribute("message","添加账户成功");

        return "redirect:/account/home";
    }

    /**
     * 修改账户
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/account/{id:\\d+}/update")
    public String update(@PathVariable Integer id,Model model){

        Account account = accountService.findByIdAndAccount(id);

        //查询所有角色
        List<Roles> rolesList = rolesService.findRolesAll();

        Map<Roles,Boolean> rolesBooleanMap = findByRolesAndAccount(rolesList,account.getRolesList());

        model.addAttribute("rolesBooleanMap",rolesBooleanMap);
        model.addAttribute("account",account);

        return "account/update";
    }

    @PostMapping("/account/{id:\\d+}/update")
    public String update(Account account,Integer[] rolesIds,RedirectAttributes redirectAttributes){
        accountService.updateAccount(account,rolesIds);

        redirectAttributes.addFlashAttribute("message","修改成功");
        return "redirect:/account/home";
    }


    private Map<Roles, Boolean> findByRolesAndAccount(List<Roles> rolesList, List<Roles> rolesList1) {

        Map<Roles,Boolean> rolesBooleanMap = Maps.newHashMap();

        for(Roles roles : rolesList){

            Boolean flag = false;

            for(Roles rolesAccount : rolesList1){

                if(rolesAccount.getId().equals(roles.getId())){
                    flag = true;
                    break;
                }
            }
            rolesBooleanMap.put(roles,flag);
        }
        return rolesBooleanMap;
    }

}
