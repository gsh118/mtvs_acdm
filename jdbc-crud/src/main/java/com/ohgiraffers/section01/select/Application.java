package com.ohgiraffers.section01.select;

import com.ohgiraffers.model.dto.MenuDTO;

import java.util.List;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();

        MenuReadService menuReadService = new MenuReadService();

        List<MenuDTO> menuList = menuReadService.findMenu(menuName);
        System.out.println("찾은 메뉴 목록");
        menuList.forEach(System.out::println);
    }
}
