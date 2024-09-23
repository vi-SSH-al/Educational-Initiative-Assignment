
/**
 * Observer interface for receiving task updates.
 */
public interface Observer {

    /**
     * Updates the observer with a notification message.
     *
     * @param message the notification message
     */
    void update(String message);
}
