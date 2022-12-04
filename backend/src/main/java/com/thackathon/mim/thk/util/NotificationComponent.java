package com.thackathon.mim.thk.util;

import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.service.PersonService;
import lombok.NonNull;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

@Component
public class NotificationComponent {

    private final PersonService personService;

    public NotificationComponent(@NonNull PersonService personService){
        this.personService = personService;
    }

    @JmsListener(destination = "${mq.notificationToPerson}", containerFactory = "jmsListenerContainerFactory")
    public void consumeSurvey(final Message<String> payload) throws CustomException {
        MessageHeaders headers = payload.getHeaders();
        System.out.println("headers = " + headers);

        String text = payload.getPayload();
        personService.processNotification(text);
    }
}
