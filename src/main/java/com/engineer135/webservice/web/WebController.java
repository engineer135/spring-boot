package com.engineer135.webservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.engineer135.webservice.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {
	PostsService postsService;
	
	@GetMapping("/")
	public String main(Model model) {
		model.addAttribute("posts", postsService.fildAllDesc());
		return "main";
	}
}
