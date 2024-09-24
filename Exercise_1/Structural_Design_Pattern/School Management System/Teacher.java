
/**
 * Represents a teacher in the school management system.
 */
public class Teacher implements SchoolComponent {

    private String name;
    private String subject;

    public Teacher(String name, String subject) {
        this.name = name;
        this.subject = subject;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Teacher: " + name + ", Subject: " + subject);
    }

    @Override
    public String getName() {
        return name;
    }
}
