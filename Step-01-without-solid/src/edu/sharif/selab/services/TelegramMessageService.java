package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;

public class TelegramMessageService implements MessageService {

    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        // Empty Body
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        // Empty Body
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        if (validateTelegramId(telegramMessage.getSourceId()) && validateTelegramId(telegramMessage.getTargetId())) {
            System.out.println("Sending a Telegram message from " + telegramMessage.getSourceId() + " to " + telegramMessage.getTargetId() + " with content: " + telegramMessage.getContent());
        } else {
            throw new IllegalArgumentException("Telegram ID is not correct!");
        }
    }

    private boolean validateTelegramId(String id) {
        // A simple validation for Telegram ID: starts with '@' and has at least 5 characters.
        // Or it could be a phone number (reusing the logic is a thought, but let's keep it simple).
        return id != null && id.startsWith("@") && id.length() >= 5;
    }
}

