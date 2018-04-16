package com.wyx.tms.controller;


import com.wyx.tms.entity.Account;
import com.wyx.tms.exception.ServiceException;
import com.wyx.tms.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @outhor wyx
 */
@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    /**
     * 去登录页面
     * @return
     */
    @GetMapping("/")
    public String login(){
        return "login";
    }

    /**
     * 跳转到首页
     * @return
     */
    @GetMapping("/home")
    public String home(){
        return "home";
    }

    /**
     * 登录的表单提交
     * @param accountNumber 账号
     * @param accountPassword 密码
     * @return
     */
    @PostMapping("/")
    public String login(String accountNumber, String accountPassword,
                        HttpServletRequest request,
                        HttpSession httpSession,
                        RedirectAttributes redirectAttributes){
        //获取登录地址
        String requestId = request.getRemoteAddr();
        try {
            Account account = accountService.login(accountNumber,accountPassword,requestId);
            httpSession.setAttribute("current_account",account);

            return "redirect:/home";
        } catch (ServiceException ex){
            redirectAttributes.addFlashAttribute("message",ex.getMessage());
            return "redirect:/";
        }
    }

    /**
     * 跳转到账号管理的列表页
     * @return
     */
    @GetMapping("account/home")
    public String accountHome(Model model){

        List<Account> accountList = accountService.selectByAccountAll();
        model.addAttribute("accountList",accountList);
        return "account/home";
    }


    /**
     * 安全退出
     * @param httpSession
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/account/out")
    public String out( HttpSession httpSession,RedirectAttributes redirectAttributes){

        httpSession.invalidate();

        redirectAttributes.addFlashAttribute("message","你已安全推出系统");

        return "redirect:/";
    }



}
