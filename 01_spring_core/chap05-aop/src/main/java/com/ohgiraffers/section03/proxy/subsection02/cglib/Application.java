package com.ohgiraffers.section03.proxy.subsection02.cglib;

import com.ohgiraffers.section03.proxy.common.OhgiraffersStudent;
import org.springframework.cglib.proxy.Enhancer;

public class Application {

    public static void main(String[] args) {
        Handler handler = new Handler(new OhgiraffersStudent());
        
        // cglib 프록시 방식이 더 간편하고 성능도 좋음
        OhgiraffersStudent proxy = (OhgiraffersStudent) Enhancer.create(OhgiraffersStudent.class, handler);

        proxy.study(20);
    }
}
