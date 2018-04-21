package Body;

/**
 * @author evgeniy
 * Starosta(starley) check people on lecture
 */
public class Starley extends Student {

    private String checkPeople(Lecture lecture){
        return Journal.getJournal().setResult(lecture,true);
    }

    public Starley(String name,boolean status) {
        super(name,status);// не обез
    }

    public String getCheckPeople(Lecture lecture){
        return checkPeople(lecture).toString();
    }
}

