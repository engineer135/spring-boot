package com.engineer135.webservice.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// ���� Dao��� �Ҹ��� DB Layer ������. �������̽� ������ �Ʒ�ó�� JpaRepository<EntityŬ����, PKŸ��>�� ����ϸ� ��.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
