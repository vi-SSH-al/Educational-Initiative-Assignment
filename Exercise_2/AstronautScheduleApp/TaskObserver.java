
/**
 * Observer implementation that handles task update notifications.
 */
public class TaskObserver implements Observer {

    @Override
    public void update(String message) {
        System.out.println("Notification: " + message);
    }
}
