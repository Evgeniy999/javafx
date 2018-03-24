
import java.util.List;
import java.util.ArrayList;

public class University {
    /**
     * A List is an ordered collection of objects, represented by the java.util.List interface.
     * The objects in a List are called its elements, and duplicate elements can exist in the same List.
     */
    private List<Teacher> teacher = new ArrayList();
    private List<Student> student = new ArrayList();
    private List<Employment> employment = new ArrayList();

    /**
     * Constructor
     */
    public University() {
    }

    /**
     * main function
     * @param person - argument
     */
    public void addStudent(Student person) {
        if (person.getClass() == Starley.class) {
            ((Starley)person).setStudentsOfThisGroup(student);
        }
        student.add(person);
    }

    public void addTeacher(Teacher person) {
        person.setStudents(student);
        teacher.add(person);
    }

    public void setSubjectsPlane(Lecture... lectures) {
        Lecture[] lk = lectures;

        for(int count = 0; count < lectures.length;++count) {
            Lecture lecture = lk[count];
            employment.add(lecture);
        }

    }

    public List<Teacher> getTeachersList() {
        return this.teacher;
    }

    public List<Employment> getEmploymentList() {
        return this.employment;
    }

    public List<Student> getStudentsList() {
        return this.student;
    }
}

