package innerClassTest;

public class OuterClass {

    public void run() {
        InnerClassDto inner = new InnerClassDto();
        inner.setScore(30);
        inner.setStudent("LEE");

        System.out.println(inner.getScore());
        System.out.println(inner.getStudent());
    }

    private class InnerClassDto {
        private String student;
        private int score;

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
    }
}