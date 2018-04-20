package com.wyx.tms.controller;

import com.google.common.collect.Maps;
import com.wyx.tms.entity.Permission;
import com.wyx.tms.entity.Roles;
import com.wyx.tms.entity.RolesPermissionKey;
import com.wyx.tms.service.PermissionService;
import com.wyx.tms.service.RolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Map;

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

        List<Roles> rolesList =  rolesService.findAllWithPermission();

        for(Roles roles : rolesList){
            System.out.println(roles);
        }

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

    /**
     * 添加角色的表单提交
     * @param roles
     * @param permissionId
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/add")
    public String add(Roles roles,Integer[] permissionId,RedirectAttributes redirectAttributes){

        rolesService.addRoles(roles,permissionId);
        redirectAttributes.addFlashAttribute("message","角色添加成功");

        return "redirect:/manage/roles/";

    }

    /**
     *修改权限
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/update")
    public String update(@PathVariable Integer id,Model model){

        Roles roles = rolesService.findByIdAndRoles(id);

        List<Permission> permissionList = permissionService.findPermissionAll();

        Map<Permission,Boolean> permissionBooleanMap = findByRolesPermission(permissionList,roles.getPermissionsList());

        model.addAttribute("permissionBooleanMap",permissionBooleanMap);
        model.addAttribute("roles",roles);

        return "manage/roles/update";

    }

    /**
     * 修改后表单的提交
     * @param roles
     * @param permissionId
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/{id:\\d+}/update")
    public String update(Roles roles,Integer[] permissionId,RedirectAttributes redirectAttributes){

        rolesService.updateRoles(roles,permissionId);

        redirectAttributes.addFlashAttribute("message","修改权限成功");

        return "redirect:/manage/roles/";
    }

     private Map<Permission,Boolean> findByRolesPermission(List<Permission> permissionList,List<Permission> permissionsRolesList){
        //声明一个Map集合，用来存储所有权限的集合和角色所拥有的权限的比对结果
        Map<Permission,Boolean> permissionBooleanMap = Maps.newLinkedHashMap();

        //循环输出所有权限
        for(Permission permission : permissionList){
            //声明有一个临时变量
            Boolean momentary = false;
            //循环输出角色所拥有的权限
            for(Permission rolesPermission : permissionsRolesList){

                if(permission.getId().equals(rolesPermission.getId())){
                    momentary = true;
                    break;
                }
            }
            permissionBooleanMap.put(permission,momentary);
        }
        return permissionBooleanMap;
    }


}
