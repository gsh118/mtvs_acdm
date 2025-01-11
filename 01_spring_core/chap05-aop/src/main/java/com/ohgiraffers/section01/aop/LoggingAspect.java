package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    // @PointCut : 여러 조인포인트를 매치하기 위해 지정한 표현식(Join Point의 집합)
    // execution([수식어] 리턴타입 [클래스이름].이름(파라미터))
    // 수식어 생략 가능 (public, private protected, default)

    // 포인트컷 표현식 예시 : execution(* com.ohgiraffers.section01.aop.*Service.*(..))
    // *Service는 Service로 끝나는 이름을 대상, *는 임의의 대상 , ..은 임의의 매개변수
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointCut() {}


    //포인트컷의 이름은 pointcut 어노테이션을 단 메소드의 이름
    @Before("logPointCut()")
    public void logBefore(JoinPoint joinPoint){
        // advice 작성 규칙
        // return type이 void, 첫번째 매개변수는 JoinPoint 타입,
        // join point는 타겟에 대한 정보가 들어감

        //target : 대상 객체, signature 대상 메소드
        
        System.out.println("Before joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length>0) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointCut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length>0) {
            System.out.println("Before joinPoint.getArgs()[0] : " + joinPoint.getArgs()[0]);
        }
    }

    // advice 어노테이션은 pointcut이 default 속성이라 생략 가능, 하지만 여러개 속성을 쓴다면 default도 이름을 지정함
    // returing은 타겟 메소드에서 반환될 객체의 이름, advice의 두번째 매개변수 이름과 같아야함
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result){
        System.out.println("AfterReturing result : " + result);

        if(result !=null && result instanceof Map){
            //반환되는 값을 조작 가능
            ((Map<Long, MemberDTO>)result).put(100L, new MemberDTO(100L, "반환값 가공"));
        }
    }

    // returing과 비슷하게 두번째 예외를 나타내는 인자의 이름이 어노테이션 throwing 속성과 같아야함
    // 오류가 나는 경우 적용되고, after returning보다 자주 사용됨
    // 에러가 날 때 어느 상황에서 났는지 exception log를 수집해서 모니터링 용도로 사용
    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(JoinPoint joinPoint, Exception exception){
        System.out.println("AfterThrowing exception : " + exception);
    }

    @Around("logPointCut()")
    //반환형이 Object, JoinPoint를 상속받아 확장한 ProceedingJoinPoint를 사용
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable{

        // 사전

        // 타겟 메소드의 이름
        System.out.println("Around Before : " + joinPoint.getSignature().getName());

        // 원본 조인 포인트를 실행한다.
        Object result = joinPoint.proceed();
        
        // 사후

        System.out.println("Around After : " + joinPoint.getSignature().getName());

        return result;
    }

    //9:50
}
