package wrapperClassTest;

import DTOTest.src.dto.Student;

public class MainClass {
    public static void main(String[] args) {
        Long a = 128L;
        Long b = (long) 128;

        if (128 == a) {
            System.out.println("128 응 같아~");
        }

        if (128L == a) {
            System.out.println("128 응 같아~");
        }

        String t = "128";

        if (a.equals(b)) {
            System.out.println("응 같아~");
        } else {
            System.out.println("응 아니야~");
        }

        a = Long.valueOf(128);
        b = (long) 128;

        if (a.equals(b)) {
            System.out.println("응 같아~");
        } else {
            System.out.println("응 아니야~");
        }

        long c = 128;
        long d = 128L;

        if (c == d) {
            System.out.println("응 같아~");
        } else {
            System.out.println("응 아니야~");
        }

        if (a == c) {
            System.out.println("응 같아~");
        } else {
            System.out.println("응 아니야~");
        }

        if (a == d) {
            System.out.println("응 같아~");
        } else {
            System.out.println("응 아니야~");
        }

        int number = 128;
        Student student = new Student();

        if (!"A".equals(student.getName())) {
            System.out.println("Hi");
        }
        if (number == student.getScore()) {
            System.out.println("이거 되나?");
        }
        if (number == (student.getSumScore() | 0)) {
            System.out.println("이거 되나?");
        }

    }
}