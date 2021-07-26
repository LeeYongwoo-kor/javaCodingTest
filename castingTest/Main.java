package castingTest;

public class Main {
    public static void main(String[] args) {
        String stringNumber = "18.5";
        Long longNumber = 100L;
        Long longNumber2 = 7L;

        String result = Double.toString(Double.parseDouble(stringNumber) * longNumber2 / 10);
        System.out.println(result);

        Integer result2 = (int) (longNumber / 10);
        Integer result3 = (int) (longNumber % 10);
        System.out.println(result2);
        System.out.println(result3);

        String result4 = Double.toString(Math.floor(Double.parseDouble(stringNumber) * longNumber2) / 10.0);
        System.out.println(result4);

        String result5 = Double.toString(Math.floor(Double.parseDouble(stringNumber) * longNumber2) / 10.0);
        String sum = Double.toString(Double.parseDouble(result4) + Double.parseDouble(result5));

        System.out.println(sum);
    }
}
