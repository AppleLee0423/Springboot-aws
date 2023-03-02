package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long> {
    // DAO = Repository(Interface)
    // Entity 클래스와 함께 위치해야 함
}
