package com.ohgiraffers.section01.update;

import com.ohgiraffers.model.dao.MenuDAO;

import java.sql.Connection;

import static com.ohgiraffers.common.Template.*;

public class MenuUpdateService {

    public boolean updatePrice(String menuName, int price) {

        Connection con = getConnection();

        MenuDAO menuDAO = new MenuDAO();
        int result = menuDAO.updatePriceByName(con, menuName, price);

        if(result > 0) {
            commit(con);
        } else {
            rollback(con);
        }

        close(con);

        return result > 0;
    }
}
