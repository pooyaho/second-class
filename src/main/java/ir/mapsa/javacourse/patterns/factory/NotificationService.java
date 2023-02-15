package ir.mapsa.javacourse.patterns.factory;

public class NotificationService {
    public static void main(String[] args) {
        Notification notification = NotificationFactory.createNotification(NotificationType.SMS);
        notification.notifyUser();
    }
}
