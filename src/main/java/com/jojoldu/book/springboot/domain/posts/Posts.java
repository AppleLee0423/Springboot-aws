package com.jojoldu.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

// Entity에서는 Setter를 만들지 않는다. 생성자 or Builder를 통해서 값을 받음
@Getter
// 기본 생성자 자동 추가
@NoArgsConstructor
// 테이블과 링크될 클래스라는 걸 표시, SalesManager.java -> sales_manager table
@Entity
// 주요 어노테이션을 클래스와 가까이 두면 마이그레이션 시 롬복 쉽게 삭제 가능
public class Posts {

    // 해당 테이블의 PK
    // Long 타입의 auto increment를 추천, 주민번호, 복합키 등은 유니크 키로 별도 추가 권장
    @Id
    // 생성 규칙
    // GenerationType.IDENTITY -> auto increment
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 컬럼 표시
    // length = varchar 기본값이 255인데 500으로 변경
    @Column(length = 500, nullable = false)
    private String title;

    // 타입을 TEXT로 변경
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    // 빌더 패턴 클래스 생성
    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
}