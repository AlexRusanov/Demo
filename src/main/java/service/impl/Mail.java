package service.impl;

import config.properties.MailProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import service.Notification;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * Created by alexandrrusanov on 9/12/17.
 */
@Service
@EnableConfigurationProperties(config.properties.MailProperties.class)
public class Mail implements Notification {

    private final MailProperties mailProperties;

    private final JavaMailSender emailSender;

    public Mail(MailProperties mailProperties, JavaMailSender emailSender) {
        this.mailProperties = mailProperties;
        this.emailSender = emailSender;
    }

    public void send(String to, String subject, String body) {
        try{
            MimeMessage message = emailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(mailProperties.getFrom());
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body);
            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
