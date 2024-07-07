package com.ohgiraffers.model.dao;

import com.ohgiraffers.model.dto.MenuDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.ohgiraffers.common.Template.close;

public class MenuDAO {

    public int insertMenu(Connection con, MenuDTO menu) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "INSERT INTO TBL_MENU(MENU_NAME, MENU_PRICE, CATEGORY_CODE, ORDERABLE_STATUS) "
                + "VALUES(?, ?, ?, ?)";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menu.getMenuName());
            pstmt.setDouble(2, menu.getMenuPrice());
            pstmt.setInt(3, menu.getCategoryCode());
            pstmt.setString(4, menu.getOrderableStatus());

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int updatePriceByName(Connection con, String menuName, int price) {

        PreparedStatement pstmt = null;
        int result = 0;

        String query = "UPDATE TBL_MENU " +
                "SET MENU_PRICE=? WHERE MENU_NAME=?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setDouble(1, price);
            pstmt.setString(2, menuName);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public int deleteMenu(Connection con, String menuName){
        PreparedStatement pstmt = null;
        int result = 0;

        String query = "DELETE FROM TBL_MENU WHERE MENU_NAME=?";

        try {
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);

            result = pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
        }

        return result;
    }

    public List<MenuDTO> selectMenu(Connection con, String menuName){
        PreparedStatement pstmt = null;
        List<MenuDTO> menuList = new ArrayList<>();
        ResultSet rset = null;

        String query = "SELECT FROM TBL_MENU WHERE MENU_NAME=?";

        try{
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, menuName);

            rset = pstmt.executeQuery();

            while(rset.next()){
                MenuDTO menu = new MenuDTO();
                menu.setMenuName(rset.getString("MENU_NAME"));
                menu.setMenuPrice(rset.getInt("MENU_PRICE"));
                menu.setMenuCode(rset.getInt("MENU_CODE"));
                menu.setCategoryCode(rset.getInt("CATEGORY_CODE"));
                menu.setOrderableStatus(rset.getString("ORDERABLE_STATUS"));

                menuList.add(menu);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            close(pstmt);
            close(rset);
        }

        return menuList;
    }

}
