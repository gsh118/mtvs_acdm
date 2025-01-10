package com.ohgiraffers.section01.aop;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
//aop 활성화
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ContextConfiguration {

}
