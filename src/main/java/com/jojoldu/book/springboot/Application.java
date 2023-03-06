package com.jojoldu.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//JPA Auditing 활성화
//@EnableJpaAuditing

// 스프링부트 자동설정, Bean 읽기, 생성
// SpringBootApplication 어노테이션 위치부터 설정을 읽음. 프로젝트 최상단에 위치해야함.
@SpringBootApplication
public class Application {
    //프로젝트의 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}