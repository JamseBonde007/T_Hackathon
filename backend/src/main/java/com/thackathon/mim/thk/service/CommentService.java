package com.thackathon.mim.thk.service;

import com.thackathon.mim.thk.entity.Comment;
import com.thackathon.mim.thk.entity.QComment;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.CommentRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentService(@NonNull final CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public List<Comment> getComments(Pageable pageable, Long post_id) {
        return commentRepository.findAll(QComment.comment.post.id.eq(post_id), pageable).getContent();
    }

    public Comment getComment(Long id) {
        return commentRepository.findOne(QComment.comment.id.eq(id)).orElseThrow(() -> new CustomException("Comment with id not found!"));
    }
}
