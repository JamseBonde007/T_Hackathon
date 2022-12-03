package com.thackathon.mim.thk.service;

import com.thackathon.mim.thk.entity.Person;
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
    private final PersonService personService;

    public PostService(@NonNull final PostRepository postRepository,
                       @NonNull final PersonService personService){
        this.postRepository = postRepository;
        this.personService = personService;
    }

    public Post getPost(Long id) {
        return postRepository.findOne(QPost.post.id.eq(id)).orElseThrow(() -> new CustomException("Post with id not found!."));
    }
    public List<Post> getPosts(Pageable page, Boolean visibility) {
        if (visibility == null){
            return postRepository.findAll(page).getContent();
        }
        return postRepository.findAll(QPost.post.visibility.eq(visibility), page).getContent();
    }

    public void likePost(Long person_id, Long post_id, boolean like) {
        Person person = personService.getPerson(person_id);
        Post post = getPost(post_id);
        if (like){
            person.getLikedPosts().add(post);
        } else {
            person.getLikedPosts().forEach(lp -> {
                if (lp.getId().equals(post_id)){
                    person.getLikedPosts().remove(post);
                }
            });
        }
        personService.savePerson(person);
    }
}
