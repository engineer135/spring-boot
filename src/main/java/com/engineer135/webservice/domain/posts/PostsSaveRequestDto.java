package com.engineer135.webservice.domain.posts;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {
	// 절대 Entity 클래스를 Request/Response 클래스로 사용하지 말것.
	// Entity 클래스는 코어! 
	// Contoller에서 쓸 Dto와 Entity는 이렇게 분리해서 사용해야 한다!
	private String title;
	private String content;
	private String author;
	
	public Posts toEntity() {
		return Posts.builder().title(title).content(content).author(author).build();
	}
}
