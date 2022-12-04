package com.thackathon.mim.thk.util;

import javax.jms.JMSException;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import com.thackathon.mim.thk.entity.Message;
import lombok.NonNull;
import org.apache.activemq.command.ActiveMQMessage;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class NotificationSender {

    private final JmsTemplate jmsTemplate;

    public NotificationSender(@NonNull final JmsTemplate jmsTemplate){
        this.jmsTemplate = jmsTemplate;
    }
    public void sendMessage(String message) {

        jmsTemplate.send(new MessageCreator() {
            public ActiveMQMessage createMessage(Session session) throws JMSException {
                ActiveMQMessage objectMessage = new ActiveMQMessage();
                objectMessage.setStringProperty("payload", message);
                return objectMessage;
            }
        });
    }

}
