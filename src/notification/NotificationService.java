package notification;

public class NotificationService implements  Subscriber{
    @Override
    public void update(Event event) {
        // Console-based notification (NO real sending)
        System.out.println("[NOTIFICATION] " + event.getMessage());
    }
}
