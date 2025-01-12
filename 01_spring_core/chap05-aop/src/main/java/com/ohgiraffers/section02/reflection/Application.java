package com.ohgiraffers.section02.reflection;

import java.lang.reflect.*;

public class Application {

    public static void main(String [] args) {

        // reflect란?
        // 컴파일된 자바 코드에서 역으로 클래스를 불러 메소드 및 필드 정보를 구해오는 방법을 제공한다.
        // 반사, 투영 이라는 의미를 가진다.
        // 스프링, 마이바티스, 하이버네티으 등의 프레임워크를 만들 때 사용됨

        // 주의사항
        // 1. 오버헤드 발생 : 성능 저하를 발생할 수 있기 때문에 성능에 민감한 애플리케이션은 사용하지 않는다.
        // 2. 캡슐화 저해 : private 로 설정한 member에도 접근 가능하기 때문에 코드 기능이 저하되며 여러가지 문제를 야기한다.


        // 클래스명.class, method, constructor, field 같은 건 메타 정보를 담는 클래스고
        // 그것들을 모은 패키지가 reflect
        Class class1 = Account.class;
        System.out.println("class = " + class1);

        //인스턴스.getClass() 는 인스턴스를 구성하는 클래스의 메타 정보를 담는 Class 자료형 객체 반환
        Class class2 = new Account().getClass();
        System.out.println("class2 = " + class2);

        // forName함수는 패키지 경로를 통해 메타정보를 얻어옴, 해당이름의 클래스가 없다면 classNotFoundException 반환
        try {
            // 동적 로딩 (런타임 시 로딩)
            // 자바는 프로그램이 시작될때 클래스 로더를 통해 사용하는 클래스나 코드를 static 영역에 적재
            // 동적 로딩은 이런 클래스나 코드를 처음이 아니라 실제로 사용할 시점에 로딩
            Class class3 = Class.forName("com.ohgiraffers.section02.reflection.Account");
            System.out.println("class3 = " + class3);

            //double[] 을 자바에서 정의해놓은 클래스가 [D
            Class class4 = Class.forName("[D");
            System.out.println("class4 = " + class4);

            Class class5 = double[].class;
            System.out.println("class5 = " + class5);

            Class class6 = Class.forName("[Ljava.lang.String;");
            System.out.println("class6 = " + class6);

            Class class7 = String[].class;
            System.out.println("class7 = " + class7);

            Class superClass = class1.getSuperclass();
            System.out.println("superClass = " + superClass);


        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        // 필드 정보 반환
        Field[] fields = Account.class.getDeclaredFields();
        for(Field field : fields) {
            // getModifiers함수는 숫자로 반환함 Modifier.toString을 쓰면 문자로 접근제한자 볼 수 있음
            System.out.println("modifiers = " + Modifier.toString(field.getModifiers()));

            System.out.println("type = " + field.getType());
            System.out.println("name = " + field.getName());
        }

        // 생성자 정보 확인
        Constructor[] constructors = Account.class.getDeclaredConstructors();
        for(Constructor constructor : constructors) {
            System.out.println("name = " + constructor.getName());
            Class[] params = constructor.getParameterTypes();
            for(Class param : params) {
                System.out.println("paramType = " + param.getTypeName());

            }
        }

        try {
            // 생성자 실행, Object 타입으로 객체를 생성해서 반환함
            Account acc = (Account) constructors[0].newInstance("20", "110-123-456789", "1234", 10000);
            System.out.println(acc.getBalance());
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        // 메소드 정보에 접근
        Method[] methods = Account.class.getMethods();
        Method getBalanceMethod = null;

        for(Method method : methods) {
            System.out.println(Modifier.toString(method.getModifiers()) + " "
                    + method.getReturnType().getSimpleName() + " "
                    + method.getName());

            // method.getName()은 런타임 시점에서 null이 될 수 있어서 equals하면 npe가 나올 수 있음
            // 따라서 문자열 비교할 때 null이 아닌게 분명한 리터럴을 앞에 줌, 런타임 에러를 줄여서 안정성을 높일수 있어서
            //method.getName().equals("getBalance");
            if("getBalance".equals(method.getName())) {
                getBalanceMethod = method;
            }
        }

        try {

            // invoke는 파라미터로 지정한 인스턴스에서 주어진 메소드를 실행
            System.out.println(getBalanceMethod.invoke((Account)constructors[1].newInstance()));
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        }
    }
}
