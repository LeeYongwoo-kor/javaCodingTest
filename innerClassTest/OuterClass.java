package innerClassTest;

import java.util.HashMap;
import java.util.Map.Entry;

public class OuterClass {

    private String field1;
    private int field2;
    private HashMap<Integer, String> map;

    public void run() {
        OuterClass.InnerClassDto inner = this.new InnerClassDto();
        inner.setScore(30);
        inner.setStudent("LEE");

        map = new HashMap<>();
        map.put(1, "Hello");
        map.put(5, "Nihao");
        map.put(13, "Konnichiwa");

        inner.setMap(map);

        System.out.println(inner.getScore());
        System.out.println(inner.getStudent());

        for (Entry<Integer, String> entrySet : map.entrySet()) {
            System.out.println("member:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        for (Entry<Integer, String> entrySet : inner.getMap().entrySet()) {
            System.out.println("innerClass:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        System.out.println(map.hashCode());
        System.out.println(inner.getMap().hashCode());

        map.clear();

        // map = new HashMap<>();
        map.put(2, "Hello");
        map.put(6, "Nihao");

        OuterClass.InnerClassDto inner2 = this.new InnerClassDto();
        inner2.setScore(20);
        inner2.setStudent("KIM");
        inner2.setMap(map);

        for (Entry<Integer, String> entrySet : map.entrySet()) {
            System.out.println("member:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        for (Entry<Integer, String> entrySet : inner.getMap().entrySet()) {
            System.out.println("innerClass:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        for (Entry<Integer, String> entrySet : inner2.getMap().entrySet()) {
            System.out.println("innerClass:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        System.out.println(map.hashCode());
        System.out.println(inner.getMap().hashCode());
        System.out.println(inner2.getMap().hashCode());

        map.clear();

        for (Entry<Integer, String> entrySet : map.entrySet()) {
            System.out.println("member:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        for (Entry<Integer, String> entrySet : inner.getMap().entrySet()) {
            System.out.println("innerClass:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }

        for (Entry<Integer, String> entrySet : inner2.getMap().entrySet()) {
            System.out.println("innerClass:map=> " + entrySet.getKey() + " : " + entrySet.getValue());
        }
    }

    private class InnerClassDto {
        private String student;
        private int score;
        private HashMap<Integer, String> map;

        public void setScore(int score) {
            this.score = score;
        }

        public int getScore() {
            return score;
        }

        public void setStudent(String student) {
            this.student = student;
        }

        public String getStudent() {
            return student;
        }

        public void setMap(HashMap<Integer, String> map) {
            this.map = new HashMap<>();
            for (Entry<Integer, String> entry : map.entrySet()) {
                this.map.put(entry.getKey(), entry.getValue());
            }
        }

        public HashMap<Integer, String> getMap() {
            return map;
        }
    }
}