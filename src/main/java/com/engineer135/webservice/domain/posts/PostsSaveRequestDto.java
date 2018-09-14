package com.engineer135.webservice.domain.posts;

import com.engineer135.webservice.domain.posts.Posts.PostsBuilder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	// ���� Entity Ŭ������ Request/Response Ŭ������ ������� ����.
	// Entity Ŭ������ �ھ�! 
	// Contoller���� �� Dto�� Entity�� �̷��� �и��ؼ� ����ؾ� �Ѵ�!
	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder().title(title).content(content).author(author).build();
	}
	
	@Builder
	public PostsSaveRequestDto(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
