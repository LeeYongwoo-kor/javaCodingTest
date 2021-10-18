package enumTest;

public class MainClass {
    public static void main(String[] args) {
        int distance = 255;
        System.out.println(Transportation.BUS.BASIC_FARE);
        System.out.println(Transportation.BUS.getBasicFare());
        System.out.println(Transportation.TRAIN.getBasicFare());
        System.out.println(Transportation.SHIP.getBasicFare());
        System.out.println(Transportation.AIRPLANE.getBasicFare());
        System.out.println(Transportation.BUS.fare(distance));
        System.out.println(Transportation.TRAIN.fare(distance));
        System.out.println(Transportation.SHIP.fare(distance));
        System.out.println(Transportation.AIRPLANE.fare(distance));
    }
}