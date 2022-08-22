/*
user의 CRUD를 책임진다.
 */

package com.jojoldu.book.springboot.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    /*
    Optional<T> : null이 올 수 있는 값을 감싸는 Wrapper클래스로 참조하더라도 NullPointerException이 발생하지 않도록 도와준다.
    findByEmail : 소셜 로그인으로 반환되는 값 중 email을 통해 이미 생성된 사용자인지 처음 가입하는 사용자인지 판단하기 위한 메서드이다.
     */
    Optional<User> findByEmail(String email);
}
