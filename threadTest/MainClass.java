package threadTest;

public class MainClass {
    public static void main(String[] args) {
        Thread thread = new Thread();
        boolean test1 = thread.isAlive();
        System.out.println(test1);
        thread.run();
        boolean test2 = thread.isAlive();
        System.out.println(test2);
        thread.start();
        boolean test3 = thread.isAlive();
        System.out.println(test3);
    }
}