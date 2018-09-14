package com.engineer135.webservice.domain.posts;

import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

// ���� Dao��� �Ҹ��� DB Layer ������. �������̽� ������ �Ʒ�ó�� JpaRepository<EntityŬ����, PKŸ��>�� ����ϸ� ��.
public interface PostsRepository extends JpaRepository<Posts, Long> {
	// Query ������̼� : SpringDataJpa���� �������� �ʴ� �޼ҵ��� ��� �̷��� ������ ���� ������ �������� �� �����ϴ�.
	// ��ȸ�� �����ӿ��� ���⵵ ��.
	@Query("SELECT p " +
            "FROM Posts p " +
            "ORDER BY p.id DESC")
    Stream<Posts> findAllDesc();
}
