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