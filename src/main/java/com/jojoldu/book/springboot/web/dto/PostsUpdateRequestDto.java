package com.jojoldu.book.springboot.web.dto;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Getter;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title,String content){
        this.title = title;
        this.content = content;
    }
}

/*
update 기능에서는 데이터베이스에 쿼리를 날리는 부분이 없다.
이것이 가능한 이유는 JPA 영속성 컨텍스트 때문이다.
영속성 컨텍스트란, 엔티티를 영구 저장하는 환경이다. 일종의 놀리적 개념이라고 보면 되며,
JPA의 핵심 내용은 엔티티가 영속성 컨텍스트에 포함되어있냐 아니냐로 갈린다.

JPA의 엔티티 메니저가 활성화된 상태로(Spring Data Jpa를 쓴다면 기본 옵션) 트랜잭션 안에서
데이터베이스에서 데이터를 가져오면 이 데이터는 영속성 컨텍스트가 유지된 상태이다.
이 상태에서 해당 데이터의 값을 변경하면 트랜잭션이 끝나는 시점에 해당 테이블에 변경분을 반영한다.
즉, Entity 객체의 값만 변경하면 별도로 Update 쿼리를 날릴 필요가 없다.
 */