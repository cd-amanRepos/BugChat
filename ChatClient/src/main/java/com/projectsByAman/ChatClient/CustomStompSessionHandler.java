package com.projectsByAman.ChatClient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.simp.stomp.*;

import java.lang.reflect.Type;
import java.util.logging.LogManager;

public class CustomStompSessionHandler extends StompSessionHandlerAdapter {
    Logger LOG = LoggerFactory.getLogger(CustomStompSessionHandler.class);


    public CustomStompSessionHandler() {
        super();
    }

    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Message.class;
    }


    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Message message = (Message)  payload;
        LOG.info("Message Received : " +message.getMessageText() +" From: "+message.getFrom());
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        LOG.info("New Connection Established :" +session.getSessionId());
        session.subscribe("/topic/interviews", this);
        LOG.info("Subscribed to :" +"Interviews");
        session.send("/app/interviews", getMessage());
        LOG.info("Message sent!!");
    }

    private Message getMessage() {
        Message message = new Message();
        message.setMessageText("Mera First Message");
        message.setFrom("AMAN KA BHOOOOOT");
        return message;

    }

    @Override
    public void handleException(StompSession session, StompCommand command, StompHeaders headers, byte[] payload, Throwable exception) {
        LOG.error("Exception Occured", exception);
    }
}
