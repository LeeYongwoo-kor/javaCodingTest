package inheritanceTest;

public class MainClass {
    public static void main(String[] args) {
        Student student = new StudentKorea();
        boolean setInfo = student.setInfo("Lee", "100");

        if (setInfo) {
            System.out.println(student.getName());
            System.out.println(student.getScore());
            System.out.println(((StudentKorea) student).getArea());
        } else {
            System.out.println("ERROR");
        }

        abc obj = new abc();
        obj.data = "HI";
    }
}