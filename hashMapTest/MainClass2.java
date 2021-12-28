package hashMapTest;

import java.util.HashMap;
import java.util.Map;

public class MainClass2 {
    public static void main(String[] args) {
        HashMap<Integer, Student> map = new HashMap<>();

        Student student = new Student();
        student.setName("LEE");
        student.setScore(100);

        map.put(1, student);
        for (Map.Entry<Integer, Student> e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue().getName() + ", " + e.getValue().getScore());
        }

        map.get(1).setName("YONG");
        for (Map.Entry<Integer, Student> e : map.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue().getName() + ", " + e.getValue().getScore());
        }

    }
}