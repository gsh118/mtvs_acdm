package com.ohgiraffers.section03.proxy.subsection01.dynamic;

// reflect를 이용
import com.ohgiraffers.section03.proxy.common.Student;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class Handler implements InvocationHandler {
    
    private Student student;
    
    public Handler(Student student){
        this.student = student;
    }
    
    
    //프록시의 동작 방식을 설정 (invoke 앞뒤에 추가 로직을 작성할 수 있음)
    // reflect를 이용하는 이 런타임 프록시 방식을 jdk dynamic proxy라고 부름
    // 이 방식은 타겟 object를 인터페이스 타입만 지정 가능함, 따라서 과거 스프링에서도 aop를 쓸 때 인터페이스를 만들어야 했음
    // 현재는 스프링에서 CGLIB을 이용한 프록시를 사용해서 클래스도 프록시 대상으로 지정 가능
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // method가 target object의 메소드

        System.out.println("====== 공부가 너무 하고 싶습니다. ======");
        System.out.println("호출 대상 메소드 : " + method);
        for (Object arg:args) {
            System.out.println("전달된 인자 : " + arg);
        }
        

        // studnet 인스턴스는 invoke함수로 받을 수 없으니 Handler 생성자로 전달받음
        method.invoke(student, args);

        System.out.println("====== 공부를 마치고 수면학습을 시작합니다. ======");
        
        return proxy;
    }
}
