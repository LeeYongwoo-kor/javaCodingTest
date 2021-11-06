package stringTest;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.stream.Collectors;

/**
 * StringJoinerTest
 */
public class StringJoinerTest {

    public static void main(String[] args) {
        String strA = "I'M";
        String strB = "FINE";
        String strC = "THANK";
        String strD = "YOU";
        StringJoiner sj = new StringJoiner(" ");

        sj.add(strA);
        sj.add(strB);
        sj.add(strC);
        sj.add(strD);

        String strJoin1 = sj.toString();
        System.out.println(strJoin1);

        List<String> list = Arrays.asList(strA, strB, strC, strD);

        String strJoin2 = list.stream().collect(Collectors.joining(" "));
        System.out.println(strJoin2);

    }
}