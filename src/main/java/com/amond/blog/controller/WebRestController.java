package com.amond.blog.controller;

import com.amond.blog.repository.PostsRepository;
import com.amond.blog.domain.posts.PostsSaveRequestDto;
import com.amond.blog.service.PostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebRestController {

    @Autowired
    private PostsService postsService;

    @Autowired
    private PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello(){
        return "helloWorld";
    }

    @PostMapping("/posts")
    public Long savePosts(@RequestBody PostsSaveRequestDto dto) {
        return postsService.save(dto);
    }
}
