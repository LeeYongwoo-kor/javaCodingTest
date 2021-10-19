package hashMapTest;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainClass {
    public static void main(String[] args) {
        HashMap<Integer, int[][]> map1 = new HashMap<>();
        HashMap<Integer, int[][]> map2 = new HashMap<>();
        HashMap<Integer, int[][]> map3 = null;
        HashMap<Integer, int[][]> map4 = new HashMap<>(); // empty
        int[][] dimArr = new int[3][3];

        dimArr[1][2] = 4;
        dimArr[0][2] = 5;
        dimArr[2][1] = 6;
        map1.put(12, dimArr);

        dimArr = new int[3][3];
        dimArr[1][2] = 40;
        dimArr[0][2] = 50;
        dimArr[2][1] = 60;
        map2.put(10, dimArr);

        dimArr = map2.get(10);
        dimArr[1][2] += 50;
        map2.put(10, dimArr);

        dimArr = map1.get(12);
        dimArr[1][2] += 6;
        map1.put(12, dimArr);

        int[][] dimArr2 = map1.get(12).clone();

        dimArr = new int[3][3];
        for (int value[] : dimArr) {
            for (int value2 : value) {
                System.out.print(value2);
            }
        }
        System.out.println();
        for (int value[] : dimArr2) {
            for (int value2 : value) {
                System.out.print(value2);
            }
        }
        System.out.println();

        System.out.println(map1.get(12)[1][2] + " " + map1.get(12)[0][2] + " " + map1.get(12)[2][1]);
        System.out.println(map2.get(10)[1][2] + " " + map2.get(10)[0][2] + " " + map2.get(10)[2][1]);

        if (map4.isEmpty()) {
            map4.putAll(map2);
        }

        map1.clear();
        map2.clear();

        dimArr[0][0] = 30;

        dimArr = new int[3][3];
        dimArr[0][0] = 30;
        map1.put(1, dimArr);

        dimArr = new int[3][3];
        dimArr[0][1] = 40;
        map1.put(10, dimArr);

        dimArr = new int[3][3];
        dimArr[1][0] = 50;
        map2.put(1, dimArr);

        dimArr = new int[3][3];
        dimArr[2][0] = 60;
        map2.put(12, dimArr);

        dimArr = new int[3][3];
        dimArr[0][1] = 40;
        map2.put(10, dimArr);

        for (Map.Entry<Integer, int[][]> e : map1.entrySet()) {
            if (!map2.containsKey(e.getKey())) {
                map2.put(e.getKey(), e.getValue());
            } else {
                int[][] array = map2.get(e.getKey()).clone();
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (e.getValue()[i][j] == 0) {
                            continue;
                        }
                        array[i][j] += e.getValue()[i][j];
                    }
                }
                map2.put(e.getKey(), array);
            }
        }

        for (Map.Entry<Integer, int[][]> e : map2.entrySet()) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.println(
                            "INDEX: " + i + "" + j + ", KEY: " + e.getKey() + ", VALUE: " + e.getValue()[i][j]);
                }
            }
        }

    }
}