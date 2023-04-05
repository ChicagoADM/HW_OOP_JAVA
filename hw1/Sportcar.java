import java.util.Random;

public class Sportcar {
    private String name;
    private static int number;
    private static Random r;

    static {
        Sportcar.number = 0;
        Sportcar.r = new Random();
    }

    Sportcar() {
        name = "Sportcare №" + (++Sportcar.number);
        System.out.println("Создан " + name);
    }

    public String getName() {
        return name;
    }

    private double pickUpSpeed() {
        return Sportcar.r.nextDouble(90);
    }

    private double keepSpeed() {
        return (Sportcar.r.nextDouble() * 100 + 100);
    }

    private double time(int length) {
        double t = (((0.333) * length) / pickUpSpeed()) + ((0.666 * length) / keepSpeed());
        return t;
    }

    public static void race(Sportcar firstCar, Sportcar secondCar, int distance) {
        double t1 = firstCar.time(distance);
        System.out.printf("Участник на %s проехал дистанцию за %.3f секунд\n", firstCar.getName(), t1);
        double t2 = secondCar.time(distance);
        System.out.printf("Участник на %s проехал дистанцию за %.3f секунд\n", secondCar.getName(), t2);
        if (t1 < t2) {
            System.out.println("Победил " + firstCar.getName());
        } else if (t2 < t1) {
            System.out.println("Победил " + secondCar.getName());
        } else {
            System.out.println("Ничья");
        }
    }
}
