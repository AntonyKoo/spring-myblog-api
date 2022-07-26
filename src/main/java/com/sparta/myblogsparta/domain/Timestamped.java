package com.sparta.myblogsparta.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass  // 상속 받는 자식 클래스가 아래 필드를 컬럼으로 인식
@EntityListeners(AuditingEntityListener.class)  // 본 클래스에 auditing 추가
public abstract class Timestamped {

    @CreatedDate
    private LocalDateTime createdAt;  // 생성 시간

    @LastModifiedDate
    private LocalDateTime modifiedAt;  // 수정 시간
}
