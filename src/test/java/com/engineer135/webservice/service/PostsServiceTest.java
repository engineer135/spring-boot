package com.engineer135.webservice.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThat;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.engineer135.webservice.domain.posts.PostsMainResponseDto;
import com.engineer135.webservice.domain.posts.PostsRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsServiceTest {
	@Autowired
	private PostsService postsService;
	
	@Autowired
	private PostsRepository postsRepository;
	
	@After
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	/*@Test
	public void dtoDataSave() {
		//given
		PostsSaveRequestDto dto = PostsSaveRequestDto.builder()
				.author("jojoldu@gmail.com")
                .content("테스트")
                .title("테스트 타이틀")
                .build();
		
		//when
		postsService.save(dto);
		
		//then
		Posts posts = postsRepository.findAll().get(0);
		assertThat(posts.getAuthor()).isEqualTo(dto.getAuthor());
        assertThat(posts.getContent()).isEqualTo(dto.getContent());
        assertThat(posts.getTitle()).isEqualTo(dto.getTitle());
		
	}*/
	
	@Test
	@Transactional(readOnly = true)
	public void getList() {
		//given
		
		//when
		List<PostsMainResponseDto> postsList = postsRepository.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());

		/*List<PostsMainResponseDto> postsList = Collections.emptyList();
		try (Stream<PostsMainResponseDto> stream = postsRepository.findAllDesc().map(PostsMainResponseDto::new)) {
			postsList = stream.collect(Collectors.toList());
		}*/
		
		//then
		int id = 2;
		for(PostsMainResponseDto posts : postsList) {
			assertThat(posts.getId()).isEqualTo(id);
			id--;
		}
	}
}
