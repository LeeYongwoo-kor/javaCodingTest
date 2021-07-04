package DTOTest.src.dto;

public class StudentIn {
    private String name;
    private String grade;
    private int score;

    public StudentIn() {
    }

    public StudentIn(String name, String grade, int score) {
        this.name = name;
        this.grade = grade;
        this.score = score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getGrade() {
        return grade;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
