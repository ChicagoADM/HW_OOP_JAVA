public class Autotruck extends Automobile {
    private int numberOfSeats;
    private int carryingCapacity;

    public Autotruck(String number, int carryingCapacity) {
        super(number);
        this.carryingCapacity = carryingCapacity;
        numberOfSeats = 2;
    }

    @Override
    public void getInfo() {
        System.out.println(toString() + ", грузоподъемность: " + carryingCapacity
                + "т, пассажирских мест: " + numberOfSeats);
    }

}
