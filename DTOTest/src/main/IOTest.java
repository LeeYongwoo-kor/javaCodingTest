package DTOTest.src.main;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;

import DTOTest.src.dto.Giants;
import DTOTest.src.dto.StudentIn;
import DTOTest.src.dto.StudentOut;

/**
 * IOTest
 */
public class IOTest {
    public static void main(String[] args) {
        Giants giants = new Giants();

        String player = "LEE DAE HO";
        String a = "1";

        final Giants reciever = this;
        HashMap<String, Runnable> m = new HashMap<String, Runnable> {{
            put("a", new Runnable() {
                @Override
                public void run() {
                    reciever.a();
                }
            });
        }};
        m.get("a").run();
    }
}