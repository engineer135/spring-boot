package com.engineer135.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.engineer135.webservice.domain.posts.PostsRepository;
import com.engineer135.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController // RestController ������̼��� @ResponseBody�� ��� �޼ҵ忡�� �������ش�. hello �޼ҵ� ����� json ���·� ��ȯ�Ѵٴ� �̾߱�.
@AllArgsConstructor
public class WebRestController {
	
	// autowired�� ���� ����? ������ ���Թ������ �߱� ����.
	// ���������� �� ���� ����� autowired, setter, ������ �� ���߿� ���� �����ϴ� ����� ��������.
	// �Ʒ��� ���� �����ڸ� @AllArgsConstructor�� ��� ������ �� �Ŷ�� ���� ��.
	// �ٵ� �� �� ������̼��� �Ƚ�µ� �� �ڵ����� �����Ȱɱ�...???
	/*public WebRestController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }*/
	private PostsRepository postsRepository;
	
	@GetMapping("/hello")
	public String hello() {
		// �� ��û �����ϳ�...
		return "HelloWorld";
	}
	
	@PostMapping("/posts")
	public void savePosts(@RequestBody PostsSaveRequestDto dto) {
		postsRepository.save(dto.toEntity());
	}
}
