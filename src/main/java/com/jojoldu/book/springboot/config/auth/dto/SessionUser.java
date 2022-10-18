/*
SessionUser에는 인증된 사용자의 정보만 필요하다. 그 외에 필요한 정보들이 없어서 name,email,picture만 필드로 선언한다.

User 클래스를 사용하면 안되는 이유
User클래스를 그대로 사용하면 User클래스를 세션에 저장하려고하여 직렬화를 구현하지 않았다는 의미의 에러가 발생한다.
User클래스는 엔티티이기 때문에 언제 다른 엔티티와의 관계가 형성될지 모른다.
그렇다면 직렬화 대상에 자식들까지 포함됨으로써 성능 이슈,부수 효과가 발생할 확률이 높다.
그래서 직렬화 기능을 가진 세션 Dto를 하나 추가로 많드는 것이 이후 운영 및 유지보수 때 많은 도움이 된다.
 */

package com.jojoldu.book.springboot.config.auth.dto;

import com.jojoldu.book.springboot.domain.user.User;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.name = user.getName();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}
