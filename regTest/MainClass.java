package regTest;

import java.util.regex.Pattern;

public class MainClass {
    public static void main(String[] args) {
        String pattern = "(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])";
        String test = "11:13:52";

        if (Pattern.matches(pattern, test)) {
            System.out.println("Success");
        } else {
            System.out.println("Failed");
        }
    }
}