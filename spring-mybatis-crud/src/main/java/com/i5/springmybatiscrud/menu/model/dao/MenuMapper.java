package com.i5.springmybatiscrud.menu.model.dao;

import com.i5.springmybatiscrud.menu.model.dto.CategoryDTO;
import com.i5.springmybatiscrud.menu.model.dto.MenuDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuMapper {
    List<MenuDTO> findAllMenu();

    List<CategoryDTO> findAllCategory();

    void registMenu(MenuDTO newMenu);
}
