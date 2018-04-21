package Body;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author evgeniy
 * Class JournalString have students and method for add and set information
 */
public class JournalString {


    List<Student> students = new ArrayList<>();

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public String setResult(Lecture lecture, boolean isCheck)
    {
       String result = "";
        if (isCheck == true){
            result = "Проверял староста\n";
        }
        else if(isCheck == false){
            result = "Проверял препод\n";
        }
        Iterator value = this.students.iterator();
        while(value.hasNext()) {
            Student student = (Student)value.next();
            if(student.getLecture() == lecture)
                result += "Студент : " + student.getName() + " на лекции\n";
            else
                result += "Студент : " + student.getName() + " не на лекции\n";
        }

        return result;
    }

    public List<Student> getStudents() {
        return students;
    }
}
