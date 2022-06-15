package com.jojoldu.book.springboot.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
//테스트를 진행할 때 Junit에 내장된 실행자 외에 다른 실행자를 실행히킨다.
//여기서는 SpringRunner라는 스프링 실행자를 사용한다.
//즉, 스프링 부트 테스트와 Junit 사이에 연결자 역할을 한다.
@RunWith(SpringRunner.class)
//여러 스프링 테스트 어너토에션 중, web에 집중할 수 있는 어노테이션
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {
    //스프링이 관리하는 빈을 주입 받는다
    @Autowired
    // 웹 api를 테스트할 때 사용한다.
    // 스프링 MVC 테스트의 시작점
    private MockMvc mvc;

    @Test
    public void hello() throws Exception{
        String hello = "hello";
        // MockMvc를 통해 /hello 주소로 Http get요청을 한다.
        mvc.perform(get("/hello"))
                //mvc.perform의 결과를 검증, http header의 status를 검증(200, 404,500 등의 상태를 검증)
                // 여기선 ok 즉, 200인지 아닌지를 검증
                .andExpect((status().isOk()))
                //mvc.perform의 결과를 검증, 응답 본문의 내용을 검증
                // controller에서 hello를 리턴하기 때문에 이 값이 맞는지 검증
                .andExpect(content().string(hello));
    }
    @Test
    public void helloDto가_리턴된다() throws  Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                        get("/hello/dto")
                                .param("name",name)
                                .param("amount",String.valueOf(amount))
                )
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name",is(name)))
                .andExpect(jsonPath("$.amount",is(amount)));
    }
}
