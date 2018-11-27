package com.amond.blog.service;

import com.amond.blog.domain.posts.PostsMainResponseDto;
import com.amond.blog.repository.PostsRepository;
import com.amond.blog.domain.posts.PostsSaveRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostsService {

    @Autowired
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }

    @Transactional
    public List<PostsMainResponseDto> findAllDesc(){
        return postsRepository.findAllDesc()
                    .map(PostsMainResponseDto::new)
                    .collect(Collectors.toList());
    }

}
