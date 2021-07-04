package DTOTest.src.dto;

public class Homeless {
    private String name;
    private int age;
    private char thisIsNotString;
    private String isHome;

    public void setIsHome(String isHome) {
        this.isHome = isHome;
    }

    public String getIsHome() {
        return isHome;
    }

    public void setThisIsNotString(char thisIsNotString) {
        this.thisIsNotString = thisIsNotString;
    }

    public char getThisIsNotString() {
        return thisIsNotString;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }
}
