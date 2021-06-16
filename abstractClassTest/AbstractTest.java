package abstractClassTest;

public abstract class AbstractTest {

    private boolean aValue = false;
    protected String greet = "hello";

    public void setGreet(String greet) {
        this.greet = greet;
        System.out.println(greet);
    }

    public boolean test(boolean param) {
        this.aValue = param;
        return aValue;
    }

    public void test2() {
        System.out.println("SCV");
    }
}
