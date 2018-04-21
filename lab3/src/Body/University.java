package Body;
import java.util.List;
import java.util.ArrayList;

/**
 * @author evgeniy
 */

public class University {
    /**
     * A List is an ordered collection of objects, represented by the java.util.List interface.
     * The objects in a List are called its elements, and duplicate elements can exist in the same List.
     */
    private List<Teacher> teacher = new ArrayList();
    private List<AbstractEmployment> employment = new ArrayList();

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
        Journal.getJournal().addStudent(person);
    }

    public void addTeacher(Teacher person) {
        teacher.add(person);
    }

    /**
     *
     * @param lectures
     */
    private void setSubjects(Lecture... lectures) {
        Lecture[] lk = lectures;

        for(int count = 0; count < lectures.length;++count) {
            Lecture lecture = lk[count];
            employment.add(lecture);
        }

    }

    /**
     *
     * @param lectures
     */
    public void getSetSubject(Lecture... lectures){
         setSubjects(lectures);
    }

    /**
     *
     * @return teacher
     */
    public List<Teacher> getTeachersList() {
        return this.teacher;
    }

    /**
     *
     * @return employment
     */
    public List<AbstractEmployment> getEmploymentList() {
        return this.employment;
    }


}

