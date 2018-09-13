package com.engineer135.webservice.domain.posts;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access=AccessLevel.PROTECTED) // �Һ����� ����. �⺻�����ڸ� ������ְ�.. �⺻�������� ���ٱ����� protected�� ����. 
//Entity Ŭ������ ������Ʈ �ڵ�󿡼� �⺻�����ڷ� �����ϴ� ���� ����, JPA���� Entity Ŭ������ �����ϴ� ���� ����ϱ� ���� �߰��մϴ�.
@Getter // �Һ�. ��� �ʵ��� getter �޼ҵ带 �ڵ� ����!! �ε�!!
@Entity // ���̺��� ��ũ�� Ŭ�������� ����. ������ھ� ���̹����� �̸� ��Ī. myTable > my_table
public class Posts {
	
	@Id // �ش� ���̺��� PK �ʵ�
	@GeneratedValue // PK ������Ģ. �⺻���� auto, mysql�� auto_increment�� ����.
	private Long id;
	
	@Column(length=500, nullable=false) // �÷� ������̼���, �⺻�� �ܿ� �߰��� �ʿ��� �ɼ� �������� ���. �⺻������ �ʵ���� ��� �÷���.
	private String title;
	
	@Column(columnDefinition="TEXT", nullable=false)
	private String content;
	
	private String author;
	
	@Builder // �Һ�. �ش� Ŭ������ �������� Ŭ������ ����(������...?)
	// �����ڿ��� ���̴�, � �ʵ带 ä�����ϴ��� ��Ȯ������ ����.
	// new Posts("title","content"); ���⼭ Ÿ��Ʋ�� ����Ʈ ���� �ٲ㵵 ���� �߰��� �ȵȴٴ°� ����
	// ������
	// Posts.builder().title("title").content("content").build(); ó�� ��Ȯ�ϰ� ����� �����մϴ�.
	public Posts(String title, String content, String author) {
		this.title = title;
		this.content = content;
		this.author = author;
	}
}