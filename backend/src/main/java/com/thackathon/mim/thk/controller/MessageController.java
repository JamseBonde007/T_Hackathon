package com.thackathon.mim.thk.controller;

import com.thackathon.mim.thk.entity.Message;
import com.thackathon.mim.thk.service.MessageService;
import lombok.NonNull;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/message")
public class MessageController {

    private final MessageService messageService;

    public MessageController(@NonNull final MessageService messageService){
        this.messageService = messageService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Message> getMessage(@PathVariable Long id){
        return ResponseEntity.ok(messageService.getMessage(id));
    }

    @GetMapping("/list")
    public ResponseEntity<List<Message>> getMessages(Pageable page,
                                                     @RequestParam(required = false) Long addressee_id,
                                                     @RequestParam(required = false) Long recipient_id){
        return ResponseEntity.ok(messageService.getMessages(page, addressee_id, recipient_id));
    }

    @PostMapping("/send")
    public ResponseEntity<Void> sendMessage(@RequestBody String message){
        messageService.sendMessage(message);
        return ResponseEntity.ok().build();
    }
}
