package com.webservice.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Posts 클래스로 Database 를 접근하게 해 줄 JPA Repository
 * JpaRepository<Entity, PK>를 상속하면 기본적인 CRUD 메소드가 자동으로 생성
 * Entity 클래스와 Repository 인터페이스는 함께 위치해야 한다.
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
