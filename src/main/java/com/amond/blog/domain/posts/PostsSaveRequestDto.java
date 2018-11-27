package com.amond.blog.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔
    기본생성자 + set메소드를 통해서만 값이 할당 됨.
    Entity클래스와 Controller에서 쓸 DTO는 꼭 분리해서 사용할 것!
 */

@Getter
@Setter
@NoArgsConstructor
public class PostsSaveRequestDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity(){
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
