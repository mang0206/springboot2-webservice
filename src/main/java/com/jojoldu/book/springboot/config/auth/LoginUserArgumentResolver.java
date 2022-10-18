/*
Login-UserArgumentResolver라는 HandlerMethodArgumentResolver 인터페이스를 구현한 클래스이다.
HandlerMethodArgumentResolver는 한가지 기능을 지원하는데 바로 조건에 맞는 경우
메소드거 있다면 HandlerMethodArgumentResolver의 구현체가 지정한 값으로 해당 메소드의
파라미터로 넘길 수 있다 .
 */
package com.jojoldu.book.springboot.config.auth;

import com.jojoldu.book.springboot.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class LoginUserArgumentResolver implements HandlerMethodArgumentResolver {
    private final HttpSession httpSession;

    @Override
    // supportsParameter -> 컨트롤러 메서드의 특정 마라미터를 지원하는지 판단
    //  여기서는 파라미터에 @LoginUser 어노테이션이 붙어 있고, 파라미터 클래스 타입이 SessionUser.class인 경우 True 반환
    public boolean supportsParameter(MethodParameter parameter){
        boolean isLoginUserAnnotation = parameter.getParameterAnnotation(LoginUser.class) != null;
        boolean isUserClass = SessionUser.class.equals(parameter.getParameterType());

        return isLoginUserAnnotation && isUserClass;
    }

    @Override
    // resolveArgument() -> 파라미터에 전달할 객체를 생성
    //      여기서는 세션에서 객체를 가져온다.
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                                  NativeWebRequest webRequest, WebDataBinderFactory
                                              binderFactory) throws Exception {
        return httpSession.getAttribute("user");
    }
}
