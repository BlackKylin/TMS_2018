package com.wyx.tms.controller;


import com.wyx.tms.service.AccountService;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.SavedRequest;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @outhor wyx
 */
@Controller
public class HomeController {

    @Autowired
    private AccountService accountService;

    /**
     * 去登录页面
     * @return
     */
    @GetMapping("/")
    public String login(){

        Subject subject = SecurityUtils.getSubject();

       if(subject.isAuthenticated()){
            subject.logout();
        }


     /*   if(subject.isRemembered()){
            return "redirect:/home";
        }*/

        return "login";
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
                        RedirectAttributes redirectAttributes){

        //创建Subject对象
        Subject subject = SecurityUtils.getSubject();
        //获取登录的IP地址
        String requestId = request.getRemoteAddr();
        //根据账号和密码进行登录
        UsernamePasswordToken usernamePasswordToken =
                new UsernamePasswordToken(accountNumber, DigestUtils.md5Hex(accountPassword),requestId);

        try{
            subject.login(usernamePasswordToken);

            SavedRequest savedRequest = WebUtils.getSavedRequest(request);
            String url = "/home";
            if(savedRequest != null){
                url = savedRequest.getRequestUrl();
            }

            return "redirect:"+url;
        } catch (UnknownAccountException | IncorrectCredentialsException ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","账号或密码错误");
        } catch (LockedAccountException ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","账号被锁定");
        } catch (AuthenticationException ex){
            ex.printStackTrace();
            redirectAttributes.addFlashAttribute("message","账号或密码异常");
        }

        return "redirect:/";

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
     *安全退出
     * @return
     */
    @GetMapping("/account/out")
    public String out(RedirectAttributes redirectAttributes) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        redirectAttributes.addFlashAttribute("message","你已安全推出系统");
        return "redirect:/";
    }


    @GetMapping("/401")
    public String error401(){
        return "error/401";
    }



}
