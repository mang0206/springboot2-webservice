package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*lombok 어노테이션*/
//클래스 내 모든 필드의 Getter 메소드를 자동생성
@Getter
// 기본 생성자 자동 추가(public Posts(){}와 같은 효과)
@NoArgsConstructor
/**/
// jpa 어노테이션
// 테이블과 링크될 클래스임을 나타낸다
@Entity
public class Posts extends BaseTimeEntity {
    // 해당 테이블의 PK 필드를 나타낸다.
    @Id
    // PK의 생성 규칙을 나타낸다.
    // 스프링 부트 2.0에서는 GenerationType.IDENTITY 옵션을 추가해야만 auto increment가 된다.
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    // 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이 된다
    // 사용이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다.
    @Column(length = 500,nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT",nullable = false)
    private String content;

    private String author;
    // 해당 클래스의 빌더 패턴 클래스를 생성
    // 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    @Builder
    public Posts (String title,String content,String author){
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}

/*
생성자와 빌더 : 둘다 생성 시점에 값을 채워주는 역할은 똑같다.
다만, 생성자의 경우 지금 채워야 할 필드가 무엇인지 명확히 지정할 수 가 없다.
빌더를 사용하는 경우 어느 필드에 어떤 값을 채워야 할지 명확하게 인지 할 수 있다.
 */