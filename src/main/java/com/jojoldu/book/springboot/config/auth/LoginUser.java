package com.jojoldu.book.springboot.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//어노테이션이 생성될 수 있는 위치 지정, Parameter로 선언된 객체에서만 사용하도록
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
//@interface 어노테이션 클래스로 지정
public @interface LoginUser {
}
