package com.projectsByAman.terminalChat;

public class Message {
    private String from;
    private String messageText;
    Message() {}

    public String getFrom() {
        return from;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }

    public void setFrom(String from) {
        this.from = from;
    }
}
