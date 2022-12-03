package com.thackathon.mim.thk.service;

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

    public List<Message> getMyMessages(Pageable pageable, Long addressee_id) {
        return messageRepository.findAll(QMessage.message.addressee.id.eq(addressee_id), pageable).getContent();
    }

    public Message getMessage(Long id) {
        return messageRepository.findOne(QMessage.message.id.eq(id)).orElseThrow(() -> new CustomException("Nenasla sa osoba s danym id."));
    }
}
