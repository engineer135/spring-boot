package com.engineer135.webservice.domain;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.engineer135.webservice.domain.posts.Posts;
import com.engineer135.webservice.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	@Autowired
	PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		// �׽�Ʈ �޼ҵ� ���������� repository ��ü�� ���� �ڵ�. ���� �׽�Ʈ�� ���� ������!
		postsRepository.deleteAll();
	}
	
	@Test
	public void insertAndSelect() {
		//given
		postsRepository.save(Posts.builder()
				.title("�׽�Ʈ ����")
				.content("�׽�Ʈ ����")
				.author("�׽�Ʈ�۾���")
				.build()
				);
	
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle(), is("�׽�Ʈ ����"));
		assertThat(posts.getContent(), is("�׽�Ʈ ����"));
		
		//then
	}
	
	@Test
	public void BaseTimeEntityInsert() {
		//given
		LocalDateTime now = LocalDateTime.now();
		postsRepository.save(Posts.builder()
				.title("�׽�Ʈ ����")
				.content("�׽�Ʈ ����")
				.author("�׽�Ʈ�۾���")
				.build()
				);
		//when
		List<Posts> postsList = postsRepository.findAll();
		
		//then
		Posts posts = postsList.get(0);
		assertTrue(posts.getCreatedDate().isAfter(now));
		assertTrue(posts.getModifiedDate().isAfter(now));
	}
}
