package Body;

/**
 * @author evgeniy
 */
public class Lecture extends AbstractEmployment {
    /**
     * super () calls the parent constructor with no arguments.
     * @param name- argument
     */
    public Lecture(String name) {

        super(name);
    }

    public int addMarks() {

        return (int)(Math.random() * 10.0D);
    }

    public String toString() {
        return this.name;
    }

    /**
     *
     * @param lecture
     * @return journal
     */
    public String showPeople(Lecture lecture){
        return Journal.getJournal().setResult(lecture,false);
    }
}
