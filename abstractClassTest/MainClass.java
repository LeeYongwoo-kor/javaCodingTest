package abstractClassTest;

public class MainClass {
    public static void main(String[] args) {
        String helloJava = "helloJava";

        AbstractTest aTest = new AbstractTest() {
            @Override
            public boolean test(boolean param) {
                return super.test(param);
            }

            @Override
            public void setGreet(String greet) {
                super.setGreet(greet);
            }
        };
        boolean testValue = aTest.test(true);

        System.out.println(testValue);
        aTest.setGreet(helloJava);
    }

}
