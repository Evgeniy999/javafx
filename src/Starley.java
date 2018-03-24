
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Starosta(starley) check people on lecture
 */
public class Starley extends Student {
    private List<Student> studentsOfThisGroup = new ArrayList();

    public String checkPeople(Lecture lecture) {
        String endString = "";
        Iterator value = this.studentsOfThisGroup.iterator();

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

    public Starley(String name) {
        super(name);
    }

    public void setStudentsOfThisGroup(List<Student> studentsOfThisGroup) {
        this.studentsOfThisGroup = studentsOfThisGroup;
    }
}
