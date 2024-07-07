package com.ohgiraffers.section01.delete;

import com.ohgiraffers.model.dao.MenuDAO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

public class MenuDeleteService {

    public boolean deletePrice(String menuName) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.deleteMenu(con, menuName);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }
}
