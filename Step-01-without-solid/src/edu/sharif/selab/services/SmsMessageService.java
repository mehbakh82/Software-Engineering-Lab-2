package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage; // Import the new class

public class SmsMessageService implements MessageService {
    @Override
    public void sendSmsMessage(SmsMessage smsMessage) {
        if (validatePhoneNumber(smsMessage.getSourcePhoneNumber()) && validatePhoneNumber(smsMessage.getTargetPhoneNumber())) {
            System.out.println("Sending a SMS from " + smsMessage.getSourcePhoneNumber() + " to " + smsMessage.getTargetPhoneNumber() + " with content : " + smsMessage.getContent());
        } else {
            throw new IllegalArgumentException("Phone Number is Not Correct!");
        }
    }

    @Override
    public void sendEmailMessage(EmailMessage emailMessage) {
        //Empty Body!
    }

    @Override
    public void sendTelegramMessage(TelegramMessage telegramMessage) {
        //Empty Body!
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() != 11) {
            return false;
        }
        for (char c : phoneNumber.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }
}

