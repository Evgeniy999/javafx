package Body;


/**
 * @author evgeniy
 * Teachers perform role the teacher, check people and read lecture
 */
public class Teacher {

    private String name;
    private Lecture subject;

    public void readLecture(Lecture lecture) {
        //throw new NumberFormatException();
      this.subject = lecture;
    }

    /**
     * @param lecture
     * @return journal
     */
    private String checkPeople(Lecture lecture)
    {
        return Journal.getJournal().setResult(lecture,false);
    }

    public Teacher(String name)
    {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public Lecture getSubject() {
        return this.subject;
    }

    /**
     * @param lecture
     * @return - method checkPeople
     */

    public String getCheckPeople(Lecture lecture){
        return checkPeople(lecture).toString();
    }
}
