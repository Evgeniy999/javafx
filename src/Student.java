import java.util.*;

/**
 * Class student perform the role of a student:)
 */
public class Student {
    private List<Integer> marks = new ArrayList();
    private String name;
    private Lecture lecture;

    public List<Integer> getMarks() {
        return this.marks;
    }

    public void attendLecture(Lecture lecture) {
        this.lecture = lecture;
        this.marks.add(lecture.addMarks());
    }

    public Student(String name) {

        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Lecture getLecture() {
        return this.lecture;
    }

    public String marks() {
        String str = "Оценки: ";
        int mark;
        for(Iterator value = this.marks.iterator(); value.hasNext(); str = str + mark + " ") {
            mark = (Integer)value.next();
        }
        return str;
    }
}
