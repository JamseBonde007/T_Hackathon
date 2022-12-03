package com.thackathon.mim.thk.service;

import com.thackathon.mim.thk.entity.Post;
import com.thackathon.mim.thk.entity.QPost;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.PostRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;

    public PostService(@NonNull final PostRepository postRepository){
        this.postRepository = postRepository;
    }

    public Post getPost(Long id) {
        return postRepository.findOne(QPost.post.id.eq(id)).orElseThrow(() -> new CustomException("Nenasiel sa prispevok s danym id."));
    }
    public List<Post> getPosts(Pageable page, Boolean visibility) {
        if (visibility == null){
            return postRepository.findAll(page).getContent();
        }
        return postRepository.findAll(QPost.post.visibility.eq(visibility), page).getContent();
    }
}
