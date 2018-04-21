package Body;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author evgeniy
 */
public abstract class AbstractStudent {

    protected String name;
    protected boolean status;
    protected Lecture lecture;

    protected List<Integer> marks = new ArrayList<>();

    public List<Integer> getMarks() {
        return marks;
    }


    public void attendLecture(Lecture lecture)
    {
        this.lecture = lecture;
        marks.add(lecture.addMarks());
    }


    public String getName() {
        return name;
    }


    public Lecture getLecture() {
        return lecture;
    }


    public Boolean getStatus() {
        return status;
    }

    public String marks() {
        String str = "Оценки: ";
        int mark;
        for(Iterator value = this.marks.iterator(); value.hasNext(); str = str + mark + " ") {
            mark = (Integer)value.next();
        }
        return str;
    };

    public AbstractStudent(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

}