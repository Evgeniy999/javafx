
public class Lecture extends Employment {
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
}
