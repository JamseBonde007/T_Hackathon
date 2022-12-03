package com.thackathon.mim.thk.service;

import com.thackathon.mim.thk.entity.Person;
import com.thackathon.mim.thk.entity.PersonPostLikes;
import com.thackathon.mim.thk.entity.Post;
import com.thackathon.mim.thk.entity.QPerson;
import com.thackathon.mim.thk.entity.QPost;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.PersonPostLikesRepository;
import com.thackathon.mim.thk.repository.PostRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final PersonService personService;
    private final PersonPostLikesRepository personPostLikesRepository;

    public PostService(@NonNull final PostRepository postRepository,
                       @NonNull final PersonService personService,
                       @NonNull final PersonPostLikesRepository personPostLikesRepository){
        this.postRepository = postRepository;
        this.personService = personService;
        this.personPostLikesRepository = personPostLikesRepository;
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
        PersonPostLikes ppl = new PersonPostLikes();
        ppl.setPost(post);
        ppl.setPerson(person);
        ppl.setCreatedDate(LocalDate.now());
        if (like){
            personPostLikesRepository.save(ppl);
        } else {
            PersonPostLikes existsPpl = personPostLikesRepository.findOne(QPost.post.id.eq(post_id).and(QPerson.person.id.eq(person_id))).orElse(null);
            if (existsPpl != null){
                personPostLikesRepository.delete(existsPpl);
            }
        }
    }
}
