package com.thackathon.mim.thk.service;

import com.thackathon.mim.thk.entity.Post;
import com.thackathon.mim.thk.entity.QPost;
import com.thackathon.mim.thk.repository.PostRepository;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(@NonNull final PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Page<Post> getPosts(Pageable page, boolean visibility) {
        return postRepository.findAll(QPost.post.visibility.eq(visibility), page);
    }
}
