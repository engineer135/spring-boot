package com.engineer135.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineer135.webservice.domain.posts.PostsRepository;
import com.engineer135.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController // RestController 어노테이션은 @ResponseBody를 모든 메소드에서 적용해준다. hello 메소드 결과는 json 형태로 반환한다는 이야기.
@AllArgsConstructor
public class WebRestController {
	
	// autowired가 없는 이유? 생성자 주입방식으로 했기 때문.
	// 스프링에서 빈 주입 방식은 autowired, setter, 생성자 이 셋중에 가장 권장하는 방식은 생성자임.
	// 아래와 같은 생성자를 @AllArgsConstructor이 대신 생성해 준 거라고 보면 됨.
	// 근데 난 저 어노테이션을 안썼는데 왜 자동으로 생성된걸까...???
	/*public WebRestController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }*/
	private PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		// 와 엄청 간단하네...
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}
