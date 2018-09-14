package com.engineer135.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// 보통 Dao라고 불리는 DB Layer 접근자. 인터페이스 생성후 아래처럼 JpaRepository<Entity클래스, PK타입>를 상속하면 끝.
public interface PostsRepository extends JpaRepository<Posts, Long> {
	// Query 어노테이션 : SpringDataJpa에서 제공하지 않는 메소드의 경우 이렇게 쿼리를 직접 날려서 가져오는 것 가능하다.
	// 조회용 프레임웍을 쓰기도 함.
	@Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
