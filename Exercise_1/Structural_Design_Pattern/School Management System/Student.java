
/**
 * Represents a student in the school management system.
 */
public class Student implements SchoolComponent {

    private String name;
    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Student ID: " + id + ", Name: " + name);
    }

    @Override
    public String getName() {
        return name;
    }
}
