
import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class that can contain students and teachers.
 */
public class Class implements SchoolComponent {

    private String className;
    private List<SchoolComponent> members;

    public Class(String className) {
        this.className = className;
        this.members = new ArrayList<>();
    }

    public void addMember(SchoolComponent member) {
        members.add(member);
    }

    public void removeMember(SchoolComponent member) {
        members.remove(member);
    }

    @Override
    public void showDetails(String indent) {
        System.out.println(indent + "Class: " + className);
        for (SchoolComponent member : members) {
            member.showDetails(indent + "  ");
        }
    }

    @Override
    public String getName() {
        return className;
    }

    public List<SchoolComponent> getMembers() {
        return members;
    }
}
