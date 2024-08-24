package com.i5.springmybatiscrud.menu.controller;

import com.i5.springmybatiscrud.menu.model.dto.CategoryDTO;
import com.i5.springmybatiscrud.menu.model.dto.MenuDTO;
import com.i5.springmybatiscrud.menu.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.awt.*;
import java.util.List;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping("list")
    public String findAllMenu(Model model){

        List<MenuDTO> menuList = menuService.findAllMenu();

        model.addAttribute("menuList", menuList);


        return "menu/list";
    }

    @GetMapping("regist")
    public String registPage(Model model){

        List<CategoryDTO> categoryList = menuService.findAllCategory();
        model.addAttribute("categoryList", categoryList);

        return "menu/regist";
    }

    @PostMapping("regist")
    public String registMenu(@ModelAttribute MenuDTO menuDTO, RedirectAttributes rttr){
        menuService.registMenu(menuDTO);

        rttr.addFlashAttribute("successMessage", "메뉴 등록에 성공하셨습니다.");
        return "redirect:/menu/list";
    }


}
