
import SchoolException;
import Class;
import SchoolComponent;
import Student;
import Teacher;

import java.util.logging.Logger;

/**
 * Service class that handles operations for the School Management System.
 */
public class SchoolService {

    private static final Logger logger = Logger.getLogger(SchoolService.class.getName());
    private Class schoolClass;

    public SchoolService(String className) {
        this.schoolClass = new Class(className);
    }

    public void addStudent(String name, int id) throws SchoolException {
        if (name == null || name.isEmpty()) {
            logger.warning("Invalid student name provided.");
            throw new SchoolException("Student name cannot be empty.");
        }
        Student student = new Student(name, id);
        schoolClass.addMember(student);
        logger.info("Student " + name + " added.");
    }

    public void addTeacher(String name, String subject) throws SchoolException {
        if (name == null || name.isEmpty() || subject == null || subject.isEmpty()) {
            logger.warning("Invalid teacher details provided.");
            throw new SchoolException("Teacher name and subject cannot be empty.");
        }
        Teacher teacher = new Teacher(name, subject);
        schoolClass.addMember(teacher);
        logger.info("Teacher " + name + " added.");
    }

    public void showSchoolStructure() {
        logger.info("Displaying school structure:");
        schoolClass.showDetails("");
    }
}
