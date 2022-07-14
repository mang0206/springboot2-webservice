/*
Posts클래스로 Database 접근을 위한 인터페이스이다.
DB Layer접근자로서 JPA에서 Repository라고 부르며 인터페이스로 생성한다.
단순히 인터페이스를 생성한후 JpaRepository<Entity 클래스, PK 타입>을 상속하면
기본적인 CRUD메소드가 자동으로 생성된다.
 */
package com.jojoldu.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Posts,Long>{
}

/*
PostsRepository 인터페이스는 Posts 클래스로 Database 접근을 위한 인터페이스로
DB Layer접근자로서 JPA에서 Repository라고 부르며 인터페이스로 생성한다.
단순히 인터페이스를 생성한후 JpaRepository<Entity 클래스, PK 타입> 을 상속하면 기본적인 CRUD메소드가 자동으로 생성된다.

Entity 클래스와 기본 Entity Repository는 함께 위치해야 한다.
Entity 클래스는 기본 Repository없이는 제대로 역할을 할 수가 없다.
 */