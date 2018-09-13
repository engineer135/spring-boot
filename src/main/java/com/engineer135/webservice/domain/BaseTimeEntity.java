package com.engineer135.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // �ش� Ŭ������ ����ϴ� ��ƼƼ Ŭ�������� createdDate, modifiedDate�� �÷����� �ν��ϵ��� ����
@EntityListeners(AuditingEntityListener.class) // Auditing ��� ����
public class BaseTimeEntity { // ��� ��ƼƼ���� ���� Ŭ������ �Ǿ� ��ƼƼ���� �Է½ð�/�����ð��� �ڵ����� �����ϴ� ������ ��
	
	@CreatedDate // ��ƼƼ�� �����Ǿ� ����ɶ� �ð��� �ڵ������
	private LocalDateTime createdDate;
	
	@LastModifiedDate // ��ȸ�� ��ƼƼ�� ���� �����Ҷ� �ð��� �ڵ������
	private LocalDateTime modifiedDate;

}
