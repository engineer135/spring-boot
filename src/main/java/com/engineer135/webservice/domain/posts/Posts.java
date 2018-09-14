package com.engineer135.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.engineer135.webservice.domain.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED) // 롬복에서 제공. 기본생성자를 만들어주고.. 기본생성자의 접근권한을 protected로 제한. 
//Entity 클래스를 프로젝트 코드상에서 기본생성자로 생성하는 것은 막되, JPA에서 Entity 클래스를 생성하는 것을 허용하기 위해 추가합니다.
@Getter // 롬복. 모든 필드의 getter 메소드를 자동 생성!! 두둥!!
@Entity // 테이블과 링크될 클래스임을 명시. 언더스코어 네이밍으로 이름 매칭. myTable > my_table
public class Posts extends BaseTimeEntity {
	
	@Id // 해당 테이블의 PK 필드
	@GeneratedValue(strategy=GenerationType.IDENTITY)// PK 생성규칙. 기본값은 auto, mysql의 auto_increment와 동일.
	// 부트스트랩 2.0 이후부터 default 상태에서는 auto_increment 적용이 안돼서 strategy=GenerationType.IDENTITY를 추가했다.
	private Long id;
	
	@Column(length=500, nullable=false) // 컬럼 어노테이션은, 기본값 외에 추가로 필요한 옵션 있을때만 사용. 기본적으로 필드들은 모두 컬럼임.
	private String title;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String content;
	
	private String author;
	
	@Builder // 롬복. 해당 클래스의 빌더패턴 클래스를 생성(생성자...?)
	// 생성자와의 차이는, 어떤 필드를 채워야하는지 명확하지가 않음.
	// new Posts("title","content"); 여기서 타이틀과 컨텐트 순서 바꿔도 문제 발견이 안된다는게 문제
	// 빌더는
	// Posts.builder().title("title").content("content").build(); 처럼 명확하게 사용이 가능합니다.
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}
