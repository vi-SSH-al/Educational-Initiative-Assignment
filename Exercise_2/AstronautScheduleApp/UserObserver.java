// UserObserver.java

public class UserObserver implements Observer {

    private String name;

    public UserObserver(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received notification: " + message);
    }
}
