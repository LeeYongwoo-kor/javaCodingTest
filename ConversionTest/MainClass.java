package ConversionTest;

import java.lang.reflect.Field;

import DTOTest.src.dto.Person;
import DTOTest.src.dto.Student;

public class MainClass {
    public static void main(String[] args) {
        String text = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY0123456789!\"#$%&'()*+,-./:;<=>?@[]\\^_`{|}~";
        String text2 = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXY0123456789!\"#$%&'()*+,-./:;<=>?@[]\\^_`{|}~";

        long start = System.nanoTime();
        text = getZenkaku(text);
        long end = System.nanoTime();
        System.out.println("process : " + (end - start));
        System.out.println(text);

        start = System.nanoTime();
        text2 = getZenkaku2(text2);
        end = System.nanoTime();
        System.out.println("process : " + (end - start));
        System.out.println(text2);

        Student student = new Student();
        Person person = new Person();

        student.setName("ABCDEFGHIJKLMN");
        student.setGrade("ZXCVZXCVZXCV");
        student.setScore(100);
        student.setSumScore(50000L);
        person.setIsHome("HOMEHOMEHOME");
        person.setName("QWERQWERQWER");

        start = System.nanoTime();
        getDtoValue(student);
        end = System.nanoTime();
        System.out.println("process : " + (end - start));
        System.out.println(student.getName());
        System.out.println(student.getGrade());
        System.out.println(student.getScore());
        System.out.println(student.getSumScore());

    }

    private static String getZenkaku(String strHana) {
        String strZenkaku = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strHana.length(); i++) {
            char c = strHana.charAt(i);
            if ('!' <= c && c <= '~') {
                c = (char) (c - '!' + '！');
            }
            // } else if ('A' <= c && c <= 'Z') {
            // c = (char) (c - 'A' + 'Ａ');
            // } else if ('0' <= c && c <= '9') {
            // c = (char) (c - '0' + '０');
            // }
            sb.append(c);
        }
        strZenkaku = sb.toString();
        return strZenkaku;
    }

    private static String getZenkaku2(String strHana) {
        StringBuilder sb = new StringBuilder(strHana);
        for (int i = 0; i < sb.length(); i++) {
            int c = (int) sb.charAt(i);
            if (0x21 <= c && c <= 0x7E) {
                sb.setCharAt(i, (char) (c + 0xFFE0));
            }
        }
        return sb.toString();
    }

    public static <T> void getDtoValue(T obj) {
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                if (field.get(obj) instanceof String) {
                    String value = getZenkaku((String) field.get(obj));
                    field.set(obj, value);
                }
            }
        } catch (Exception e) {
        }
    }
}