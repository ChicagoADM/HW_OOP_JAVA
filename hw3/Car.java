public class Car extends Automobile {
    private int numberOfSeats;

    public Car(String number) {
        super(number);
        numberOfSeats = 5;
    }

    @Override
    public void getInfo() {
        System.out.println(toString() + ", пассажирских мест: " + numberOfSeats);
    }

}
