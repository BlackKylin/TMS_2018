package com.wyx.tms.controller;

import com.wyx.tms.entity.NotFandException;
import com.wyx.tms.entity.Permission;
import com.wyx.tms.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 权限的控制器类
 */
@Controller
@RequestMapping("/manage/permission")
public class permissionController {

    @Autowired
    private PermissionService permissionService;

    /**
     * 调转到首页
     * @return
     */
    @GetMapping("/")
    public String home(Model model){

        List<Permission> permissionsList = permissionService.findPermissionAll();
        model.addAttribute("permissionList",permissionsList);

        return "manage/permission/home";
    }

    /**
     * 添加权限
     * @return
     */
    @GetMapping("/add")
    public String add(Model model){

        List<Permission> permissionList = permissionService.findByPermission(Permission.MENU_TYPR);

        model.addAttribute("permissionList",permissionList);

        return "manage/permission/add";
    }

    /**
     * 添加权限表单的提交
     * @param permission
     * @return
     */
    @PostMapping("/add")
    public String add(Permission permission, RedirectAttributes redirectAttributes){

        permissionService .savePermission(permission);

        redirectAttributes.addFlashAttribute("message","添加权限成功");

        return "redirect:/manage/permission/";
    }

    /**
     * 权限的修改
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/update")
    public String update(@PathVariable Integer id,Model model){

        Permission permission = permissionService.findByPermissionAndId(id);

        if(permission == null){
            throw new NotFandException();
        }

        model.addAttribute("permission",permission);

        return "manage/permission/update";
    }

    /**
     * 权限修改表单的提交
     * @param permission
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/{id:\\d+}/update")
    public String update(Permission permission,RedirectAttributes redirectAttributes){

        permissionService.updatePermission(permission);

        redirectAttributes.addFlashAttribute("message","修改成功");

        return "redirect:/manage/permission/";
    }

    /**
     * 删除权限
     * @param id
     * @param redirectAttributes
     * @return
     */
    @GetMapping("/{id:\\d+}/delete")
    public String del(@PathVariable Integer id,RedirectAttributes redirectAttributes){


        List<Permission> permissionList = permissionService.findByIdAndPermissions(id);

        //判断该权限是否拥有子权限，如果拥有则不能删除
        if(permissionList.size() == 0){

            permissionService.deletePermission(id);
            redirectAttributes.addFlashAttribute("message","删除成功");
            return "redirect:/manage/permission/";
        } else {
            redirectAttributes.addFlashAttribute("message","无法删除该权限");
            return "redirect:/manage/permission/";
        }
    }


}
