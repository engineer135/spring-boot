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
		// .map(PostsMainResponseDto::new)는 실제로는 .map(posts -> new PostsMainResponseDto(posts))와 같습니다. 
		// repository 결과로 넘어온 Posts의 Stream을 map을 통해 PostsMainResponseDto로 변환 -> List로 반환하는 메소드입니다.
		return postsRepository.findAllDesc().map(PostsMainResponseDto::new).collect(Collectors.toList());
	}
}
