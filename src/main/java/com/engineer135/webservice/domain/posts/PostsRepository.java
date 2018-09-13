package com.engineer135.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// 보통 Dao라고 불리는 DB Layer 접근자. 인터페이스 생성후 아래처럼 JpaRepository<Entity클래스, PK타입>를 상속하면 끝.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
