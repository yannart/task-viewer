package com.gg.service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer implements MessageListener {

    @Autowired
    TaskService taskService;

    private Log log = LogFactory.getLog(Consumer.class);

    public void onMessage(Message message) {
        if (message instanceof TextMessage) {
            try {
                log.info("Received message: "
                        + ((TextMessage) message).getText());

                // On each message received, unvalidate the cache.
                taskService.tasksUpdated();
            } catch (JMSException ex) {
                throw new RuntimeException(ex);
            }
        } else {
            log.warn("Received unknown message.");
        }
    }

}