package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    // DAO = Repository(Interface)
    // Entity 클래스와 함께 위치해야 함

    // @Query를 사용하면 가독성이 좋다
    // 규모가 있는 데이터 조희는 querydsl 프레임워크를 사용할 수 있다. + Mybatis
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}