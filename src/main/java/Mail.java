/**
 * Created by alexandrrusanov on 9/12/17.
 */
public class Mail implements Notification{

    public String to;

    public String from;

    public String subject;

    public NotificationTemplate template;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public NotificationTemplate getTemplate() {
        return template;
    }

    public void setTemplate(NotificationTemplate template) {
        this.template = template;
    }

    public void send() {

    }
}
