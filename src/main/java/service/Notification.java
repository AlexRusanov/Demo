package service;

/**
 * Created by alexandrrusanov on 9/12/17.
 */
public interface Notification {
    void send(String to, String subject, String body);
}
