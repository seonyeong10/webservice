package com.webservice.springboot.service.posts;

import com.webservice.springboot.domain.posts.Posts;
import com.webservice.springboot.domain.posts.PostsRepository;
import com.webservice.springboot.web.dto.PostsReponseDto;
import com.webservice.springboot.web.dto.PostsSaveRequestDto;
import com.webservice.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsReponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException(("해당 게시글이 없습니다. id=" + id)));

        return new PostsReponseDto(entity);
    }
}
