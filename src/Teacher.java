import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Teachers perform role the teacher, check people and read lecture
 */
public class Teacher {
    private String name;
    private Employment subject;
    private List<Student> students = new ArrayList();

    public void readLecture(Lecture lecture) {

        this.subject = lecture;
    }

    public String checkPeople(Lecture lecture) {
        String endString = "";
        Iterator value = this.students.iterator();

        while(value.hasNext()) {
            Student student = (Student)value.next();
            if (student.getLecture() == lecture) {
                endString = endString + "Студент " + student.getName() + " на лекции\n";
            } else {
                endString = endString + "Студент " + student.getName() + " не на лекции\n";
            }
        }

        return endString;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Employment getSubject() {
        return this.subject;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
