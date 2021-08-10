package wrapperClassTest;

import java.util.ArrayList;
import java.util.List;

import DTOTest.src.dto.Student;

public class NPETest {
    public static void main(String[] args) {
        String name = "ABC";

        Student student = new Student();
        if (student.getScore() > 0) {
            System.out.println("응 에러~");
        }

        try {
            if (student.getName().equals(name)) {
                System.out.println("yeah");
            }
        } catch (NullPointerException e) {
            System.out.println("That's not good Code");
        }

        if (name.equals(student.getName())) {
            System.out.println("yeah");
        } else {
            System.out.println("not good but OK");
        }
    }
}
