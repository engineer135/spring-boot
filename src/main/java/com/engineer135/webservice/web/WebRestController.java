package com.engineer135.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController 어노테이션은 @ResponseBody를 모든 메소드에서 적용해준다. hello 메소드 결과는 json 형태로 반환한다는 이야기.
public class WebRestController {
	
	@GetMapping("/hello")
	public String hello() {
		// 와 엄청 간단하네...
		return "HelloWorld";
	}
}
