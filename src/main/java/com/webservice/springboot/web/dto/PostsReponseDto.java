package com.webservice.springboot.web.dto;

import com.webservice.springboot.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsReponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    public PostsReponseDto (Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
