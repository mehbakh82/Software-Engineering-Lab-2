package edu.sharif.selab.services;

import edu.sharif.selab.models.Message;

public class MessageServiceFactory {
    public static MessageService<? extends Message> getMessageService(String type) {
        if (type == null) {
            return null;
        }
        if (type.equalsIgnoreCase("SMS")) {
            return new SmsMessageService();
        } else if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailMessageService();
        } else if (type.equalsIgnoreCase("TELEGRAM")) {
            return new TelegramMessageService();
        }
        return null;
    }
}