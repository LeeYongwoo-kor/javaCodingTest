package stringTest;

import java.util.Scanner;

/**
 * SubstringTest
 */
public class SubstringTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        if (input.length() < 8) {
            input = input.substring(0);
        } else {
            input = input.substring(0, 8);
        }
        System.out.println(input);
    }
}