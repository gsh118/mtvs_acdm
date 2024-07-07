package com.ohgiraffers.section01.select;

import com.ohgiraffers.model.dao.MenuDAO;
import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.util.List;

import static com.ohgiraffers.common.Template.*;
import static com.ohgiraffers.common.Template.close;

public class MenuReadService {
    public List<MenuDTO> findMenu(String menuName) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();

        List<MenuDTO> menuList = menuDAO.selectMenu(con,menuName);

        close(con);

        return menuList;
    }
}
