import edu.sharif.selab.models.EmailMessage;
import edu.sharif.selab.models.Message;
import edu.sharif.selab.models.SmsMessage;
import edu.sharif.selab.models.TelegramMessage;
import edu.sharif.selab.services.MessageService;
import edu.sharif.selab.services.MessageServiceFactory;

import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Hello and Welcome to SE Lab Messenger.");
        int userAnswer;

        do {
            System.out.println("In order to send Sms message enter 1");
            System.out.println("In order to send Email message enter 2");
            System.out.println("In order to send Telegram message enter 3");
            System.out.println("In order to Exit, Enter 0");

            userAnswer = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            if (userAnswer == 0) {
                break;
            }

            switch (userAnswer) {
                case 1:
                    handleSmsMessage();
                    break;
                case 2:
                    handleEmailMessage();
                    break;
                case 3:
                    handleTelegramMessage();
                    break;
            }

        } while (true);
    }

    private static void handleSmsMessage() {
        SmsMessage smsMessage = new SmsMessage();
        System.out.print("Enter source phone : ");
        smsMessage.setSourcePhoneNumber(scanner.nextLine());
        System.out.print("Enter target phone : ");
        smsMessage.setTargetPhoneNumber(scanner.nextLine());
        System.out.println("Write Your Message : ");
        smsMessage.setContent(scanner.nextLine());

        @SuppressWarnings("unchecked")
        MessageService<SmsMessage> service = (MessageService<SmsMessage>) MessageServiceFactory.getMessageService("SMS");
        if (service != null) {
            service.sendMessage(smsMessage);
        }
    }

    private static void handleEmailMessage() {
        EmailMessage emailMessage = new EmailMessage();
        System.out.print("Enter source email : ");
        emailMessage.setSourceEmailAddress(scanner.nextLine());
        System.out.print("Enter target email : ");
        emailMessage.setTargetEmailAddress(scanner.nextLine());
        System.out.println("Write Your Message : ");
        emailMessage.setContent(scanner.nextLine());

        @SuppressWarnings("unchecked")
        MessageService<EmailMessage> service = (MessageService<EmailMessage>) MessageServiceFactory.getMessageService("EMAIL");
        if (service != null) {
            service.sendMessage(emailMessage);
        }
    }

    private static void handleTelegramMessage() {
        TelegramMessage telegramMessage = new TelegramMessage();
        System.out.print("Enter source ID : ");
        telegramMessage.setSourceId(scanner.nextLine());
        System.out.print("Enter target ID : ");
        telegramMessage.setTargetId(scanner.nextLine());
        System.out.println("Write Your Message : ");
        telegramMessage.setContent(scanner.nextLine());

        @SuppressWarnings("unchecked")
        MessageService<TelegramMessage> service = (MessageService<TelegramMessage>) MessageServiceFactory.getMessageService("TELEGRAM");
        if (service != null) {
            service.sendMessage(telegramMessage);
        }
    }
}