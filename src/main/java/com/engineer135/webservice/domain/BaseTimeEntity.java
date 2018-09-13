package com.engineer135.webservice.domain;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@Getter
@MappedSuperclass // 해당 클래스를 상속하는 엔티티 클래스들이 createdDate, modifiedDate도 컬럼으로 인식하도록 설정
@EntityListeners(AuditingEntityListener.class) // Auditing 기능 포함
public class BaseTimeEntity { // 모든 엔티티들의 상위 클래스가 되어 엔티티들의 입력시간/수정시간을 자동으로 관리하는 역할을 함
	
	@CreatedDate // 엔티티가 생성되어 저장될때 시간이 자동저장됨
	private LocalDateTime createdDate;
	
	@LastModifiedDate // 조회한 엔티티의 값을 변경할때 시간이 자동저장됨
	private LocalDateTime modifiedDate;

}
