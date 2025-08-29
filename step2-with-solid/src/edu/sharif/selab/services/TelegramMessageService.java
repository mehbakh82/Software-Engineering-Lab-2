package edu.sharif.selab.services;

import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService<TelegramMessage> {

    @Override
    public void sendMessage(TelegramMessage message) {
        if (validateTelegramId(message.getSourceId()) && validateTelegramId(message.getTargetId())) {
            System.out.println("Sending a Telegram message from " + message.getSourceId() + " to " + message.getTargetId() + " with content: " + message.getContent());
        } else {
            throw new IllegalArgumentException("Telegram ID is not correct!");
        }
    }

    private boolean validateTelegramId(String id) {
        return id != null && id.startsWith("@") && id.length() >= 5;
    }
}