package nullExceptionTest;

public class NullETest {

    public static void main(String[] args) {
        TestVo testVo = new TestVo();

        testVo.setName("");
        // testVo.setName(null);

        // if (!testVo.getName().equals("000")) {
        //     System.out.println("muyaho");;
        // }

        if (!("000").equals(testVo.getName())) {
            System.out.println("muyaho");
        }

        if (!("000").equals(testVo.getName().replace("m", ""))) {
            System.out.println("muyaho");
        }
    }
}