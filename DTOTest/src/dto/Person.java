package DTOTest.src.dto;

public class Person {
    private String name;
    private int age;
    private int property;
    private String isHome;

    public void setIsHome(String isHome) {
        this.isHome = isHome;
    }

    public String getIsHome() {
        return isHome;
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

    public void setProperty(int property) {
        this.property = property;
    }

    public int getProperty() {
        return property;
    }
}
