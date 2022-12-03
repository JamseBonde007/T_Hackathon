package com.thackathon.mim.thk.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.thackathon.mim.thk.entity.Message;
import com.thackathon.mim.thk.entity.QMessage;
import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.repository.MessageRepository;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageService {

    private final MessageRepository messageRepository;

    public MessageService(@NonNull final MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }

    public List<Message> getMessages(Pageable pageable, Long addressee_id, Long recipient_id) {
        BooleanExpression predicate;
        if (addressee_id != null && recipient_id != null) {
            throw new CustomException("Mismatch messages!");
        } else if (addressee_id != null){
            predicate = QMessage.message.addressee.id.eq(addressee_id);
        } else if (recipient_id != null){
            predicate = QMessage.message.recipient.id.eq(recipient_id);
        } else {
            return messageRepository.findAll(pageable).getContent();
        }
        return messageRepository.findAll(predicate, pageable).getContent();
    }

    public Message getMessage(Long id) {
        return messageRepository.findOne(QMessage.message.id.eq(id)).orElseThrow(() -> new CustomException("Message with id not found!"));
    }
}
