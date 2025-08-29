package edu.sharif.selab.services;

import edu.sharif.selab.models.EmailMessage;
import java.util.regex.Pattern;

public class EmailMessageService implements MessageService<EmailMessage> {

    @Override
    public void sendMessage(EmailMessage message) {
        if (validateEmailAddress(message.getSourceEmailAddress()) && validateEmailAddress(message.getTargetEmailAddress())) {
            System.out.println("Sending an Email from " + message.getSourceEmailAddress() + " to " + message.getTargetEmailAddress() + " with content : " + message.getContent());
        } else {
            throw new IllegalArgumentException("Email Address is Not Correct!");
        }
    }

    private boolean validateEmailAddress(String email) {
        String emailRegex = "^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }
}