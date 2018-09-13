package com.engineer135.webservice.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // RestController ������̼��� @ResponseBody�� ��� �޼ҵ忡�� �������ش�. hello �޼ҵ� ����� json ���·� ��ȯ�Ѵٴ� �̾߱�.
public class WebRestController {
	
	@GetMapping("/hello")
	public String hello() {
		// �� ��û �����ϳ�...
		return "HelloWorld";
	}
}