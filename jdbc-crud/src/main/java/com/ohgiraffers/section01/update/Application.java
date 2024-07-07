package com.ohgiraffers.section01.update;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("메뉴의 이름을 입력하세요 : ");
        String menuName = sc.nextLine();
        System.out.print("메뉴의 새로운 가격을 입력하세요 : ");
        int menuPrice = sc.nextInt();

        MenuUpdateService menuUpdateService = new MenuUpdateService();
        if(menuUpdateService.updatePrice(menuName, menuPrice)) {
            System.out.println("가격 변경에 성공하셨습니다!");
        } else {
            System.out.println("가격 변경에 실패하셨습니다.");
        }
    }
}
