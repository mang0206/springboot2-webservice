package com.jojoldu.book.springboot.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
// JPA Entity 클래스는 모든 Entity의 상위 클래스가 되어 Entity들의
// createdDate, modifiedDate를 자동으로 관리하는 역할이다.
@MappedSuperclass
// BaseTimeEntity클래스에 Auditing 기능을 포함시킵니다.
@EntityListeners(AuditingEntityListener.class)
public class BaseTimeEntity {
    // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    @CreatedDate
    private LocalDateTime createdDate;
    // 조회한 Entity의 값을 변경할 때 시간이 자동 저장된다.
    @LastModifiedDate
    private LocalDateTime modifiedDate;

}
