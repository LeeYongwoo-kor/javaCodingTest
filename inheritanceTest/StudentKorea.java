package inheritanceTest;

public class StudentKorea extends Student {
    private static String area = "";

    public StudentKorea() {
    }

    public boolean setInfo(String name, String score) {
        this.name = name;
        this.score = score;
        area = "Seoul";

        return true;
    };

    public String getArea() {
        return area;
    }
}
