package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import com.ohgiraffers.section03.proxy.common.Student;
import org.springframework.cglib.proxy.InvocationHandler;

import java.lang.reflect.Method;

public class Handler implements InvocationHandler {

    //cglib을 이용한 프록시방식에서는 인터페이스 말고도 일반적인 클래스를 사용가능
    private final OhgiraffersStudent student;

    public Handler(OhgiraffersStudent student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("공부가 너무 하고 싶어요");
        method.invoke(student, args);

        System.out.println("왜 벌써 자려구요? 나렙에 잠이오니.");

        return proxy;
    }
}
