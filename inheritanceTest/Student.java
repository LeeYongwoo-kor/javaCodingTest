package inheritanceTest;

abstract public class Student {
    protected String name;
    protected String score;

    abstract protected boolean setInfo(String name, String score);

    public String getName() {
        return name;
    }

    public String getScore() {
        return score;
    }
}
