package DTOTest.src.main;

import DTOTest.src.dto.Homeless;
import DTOTest.src.dto.Student;
import DTOTest.src.dto.StudentIn;
import DTOTest.src.dto.StudentOut;

/**
 * IOTest
 */
public class IOTest {
    public static void main(String[] args) {
        run();
    }

    public static void run() {
        StudentIn studentIn = new StudentIn();

        studentIn.setName("fuck");
        studentIn.setGrade("A");
        studentIn.setScore(100);

        StudentOut studentOut = new StudentOut(studentIn);

        System.out.println(studentOut.getName());
        System.out.println(studentOut.getGrade());
        System.out.println(studentOut.getScore());

    }
}