package com.i5.springmybatiscrud.menu.service;

import com.i5.springmybatiscrud.menu.model.dao.MenuMapper;
import com.i5.springmybatiscrud.menu.model.dto.CategoryDTO;
import com.i5.springmybatiscrud.menu.model.dto.MenuDTO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MenuService {

    private MenuMapper menuMapper;

    public MenuService(MenuMapper menuMapper) {
        this.menuMapper = menuMapper;
    }

    public List<MenuDTO> findAllMenu() {
        return menuMapper.findAllMenu();
    }

    public List<CategoryDTO> findAllCategory() {
        return menuMapper.findAllCategory();
    }

    @Transactional
    public void registMenu(MenuDTO menuDTO) {
        menuMapper.registMenu(menuDTO);
    }
}
