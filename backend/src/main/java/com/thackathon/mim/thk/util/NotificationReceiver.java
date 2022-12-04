package com.thackathon.mim.thk.util;

import com.thackathon.mim.thk.exception.CustomException;
import com.thackathon.mim.thk.service.PersonService;
import lombok.NonNull;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import java.util.Map;

@Component
public class NotificationReceiver {

    private final JmsTemplate jmsTemplate;

    private final PersonService personService;

    public NotificationReceiver(@NonNull PersonService personService,
                                @NonNull JmsTemplate jmsTemplate){
        this.personService = personService;
        this.jmsTemplate = jmsTemplate;
    }

    @JmsListener(destination = "${mq.notificationToPerson}", containerFactory = "jmsListenerContainerFactory")
    public void consumeSurvey(final Message<ActiveMQMessage> message) throws JMSException {
        MessageHeaders headers = message.getHeaders();
        System.out.println("headers = " + headers);

        String messageObj = message.getPayload().getStringProperty("payload");
        personService.processNotification(messageObj);
    }
}
