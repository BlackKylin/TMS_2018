package com.wyx.tms.controller;

import com.wyx.tms.entity.Permission;
import com.wyx.tms.entity.Roles;
import com.wyx.tms.entity.RolesPermissionKey;
import com.wyx.tms.service.PermissionService;
import com.wyx.tms.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 角色的控制器类
 */
@Controller
@RequestMapping("/manage/roles")
public class RolesController {

    @Autowired
    private RolesService rolesService;
    @Autowired
    private PermissionService permissionService;



    @GetMapping("/")
    public String home(Model model){

        List<Roles> rolesList = rolesService.findByRolesAll();

        List<Permission> permissionList = rolesService.findByPermission();


        List<RolesPermissionKey> rolesPermissionKeyList = rolesService.findByRolesPermission();

        model.addAttribute("rolesPermissionKeyList",rolesPermissionKeyList);

        model.addAttribute("permissionList",permissionList);

        model.addAttribute("rolesList",rolesList);

        return "manage/roles/home";
    }

    /**
     * 添加角色
     * @return
     */
    @GetMapping("/add")
    public String add(Model model){
        List<Permission> permissionList = permissionService.findPermissionAll();
        model.addAttribute("permissionList",permissionList);
        return "manage/roles/add";
    }

    @PostMapping("/add")
    public String add(Roles roles,Integer[] permissionId,RedirectAttributes redirectAttributes){

        rolesService.addRoles(roles,permissionId);

        redirectAttributes.addFlashAttribute("message","角色添加成功");

        return "redirect:/manage/roles/";

    }



}
