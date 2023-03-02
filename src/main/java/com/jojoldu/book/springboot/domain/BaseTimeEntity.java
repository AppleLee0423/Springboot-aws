package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
//이 클래스를 상속할 경우 필드들도 칼럼으로 인식
@MappedSuperclass
//Auditing 기능 포함
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseTimeEntity {
    
    //Entity가 생성되어 저장될 때 시간 자동 저장
    @CreatedDate
    private LocalDateTime createDate;
    
    //조회한 Entity의 값이 변경될 때 시간 자동 저장
    @LastModifiedDate
    private LocalDateTime modifiedDate;
}
