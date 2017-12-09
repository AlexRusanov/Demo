import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * Created by alexandrrusanov on 9/12/17.
 */
public class NotificationFactory {

    final static Map<String, Supplier<Notification>> map = new HashMap<>();
    static {
        map.put(String.valueOf(NotificationTemplate.ACTIVATE), Mail::new);
    }
    public Notification getNotification (String notificationType){
        Supplier<Notification> notification = map.get(notificationType);
        if (notification != null){
            return notification.get();
        }
        throw new IllegalArgumentException ("No such notification" + notificationType.toUpperCase());
    }
}
