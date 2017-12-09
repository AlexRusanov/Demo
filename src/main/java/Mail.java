import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by alexandrrusanov on 9/12/17.
 */
@Service
@EnableConfigurationProperties(MailProperties.class)
public class Mail implements Notification{

    private final MailProperties mailProperties;

    private final JavaMailSender emailSender;

    public void send(String to, String subject, String body) {
        try{
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailProperties.getFrom());
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);
            emailSender.send(message);
        }catch (MailException me){
            me.printStackTrace();
        }

    }
}
