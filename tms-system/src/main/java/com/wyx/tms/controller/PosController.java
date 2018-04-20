package com.wyx.tms.controller;


import com.wyx.tms.entity.Pos;
import com.wyx.tms.service.PosService;
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
 * 销售点控制器类
 */

@Controller
@RequestMapping("/manage/pos")
public class PosController {


    @Autowired
    private PosService posService;

    /**
     * 销售点管理的首页
     * @param model
     * @return
     */
    @GetMapping("/home")
    public String home(Model model){

        List<Pos> posList = posService.selectPos();
        model.addAttribute("posList",posList);
        return "manage/pos/home";
    }


    /**
     * 新增销售点
     * @return
     */
    @GetMapping("/add")
    public String add(){
        return "manage/pos/add";
    }

    @PostMapping("/add")
    public String add(Pos pos, RedirectAttributes redirectAttributes){

        posService.index(pos);

        redirectAttributes.addFlashAttribute("message","添加销售点成功");

        return "redirect:/home";
    }

    /**
     * 修改销售点信息
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id:\\d+}/update")
    public String update(@PathVariable Integer id,Model model){

        Pos pos = posService.selectById(id);
        model.addAttribute("pos",pos);

        return "manage/pos/update";
    }


    @PostMapping("/{id:\\d+}/update")
    public String update(Pos pos,RedirectAttributes redirectAttributes){

        posService.update(pos);

        redirectAttributes.addFlashAttribute("message","修改销售点信息成功");

        return "redirect:manage/pos/home";
    }

    @GetMapping("/{id:\\d+}/delete")
    public String del(@PathVariable Integer id,RedirectAttributes redirectAttributes){

        posService.deleteById(id);

        redirectAttributes.addFlashAttribute("message","删除销售点成功");
        return "manage/pos/home";
    }


}
