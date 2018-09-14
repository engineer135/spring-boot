package com.engineer135.webservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.engineer135.webservice.domain.posts.PostsMainResponseDto;
import com.engineer135.webservice.domain.posts.PostsRepository;
import com.engineer135.webservice.domain.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
	private PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto dto) {
		return postsRepository.save(dto.toEntity()).getId();
	}
	
	@Transactional(readOnly=true)
	public List<PostsMainResponseDto> fildAllDesc(){
		// .map(PostsMainResponseDto::new)�� �����δ� .map(posts -> new PostsMainResponseDto(posts))�� �����ϴ�. 
		// repository ����� �Ѿ�� Posts�� Stream�� map�� ���� PostsMainResponseDto�� ��ȯ -> List�� ��ȯ�ϴ� �޼ҵ��Դϴ�.
		return postsRepository.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
}
