package Body;

/**
 * @author evgeniy
 */

public class Journal {

    private static JournalString journal;

    private static void setJournal()
    {
        journal = new JournalString();
    }

    /**
     * @return journal
     */
    public static JournalString getJournal() {
        if(journal == null) setJournal();
        return journal;
    }
}
