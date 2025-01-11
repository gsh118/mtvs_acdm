package com.ohgiraffers.section01.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {


        //IOC 컨테이너
        ApplicationContext context =
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01.aop");

        MemberService memberService = (MemberService) context.getBean("memberService");

        System.out.println("findAllMembers ===================");
        System.out.println(memberService.findAllMembers());
        System.out.println("findAllMemberById ===================");
        System.out.println(memberService.findMemberById(3L));
    }
}
