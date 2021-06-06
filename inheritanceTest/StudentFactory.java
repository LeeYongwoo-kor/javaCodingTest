package inheritanceTest;

public class StudentFactory {
    private static StudentFactory instance = new StudentFactory();

    private StudentFactory() {
    }

    public static StudentFactory getInstance() {
        return instance;
    }

    public Student getStudent(String className) {
        Student student = null;
        try {
            student = (Student) Class.forName(className).newInstance();
        } catch (Exception e) {
            return null;
        }

        return student;
    }
}
