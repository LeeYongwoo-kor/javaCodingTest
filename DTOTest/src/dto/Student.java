package DTOTest.src.dto;

import DTOTest.src.main.Main;

public class Student {
    private String name;
    private String grade;
    private int score;
    private Long sumScore;

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

    public void setSumScore(Long sumScore) {
        this.sumScore = sumScore;
    }

    public Long getSumScore() {
        return sumScore;
    }
}
