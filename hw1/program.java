public class program {
    public static void main(String[] args) 
    {
        Car someCar = new Car("Kio rio", 2016, 900000.0, "Carbon grey", 1.6);
        someCar.getInfo();
        someCar.road("город Москва");
        someCar.startCar();
        someCar.road("город Москва");
        someCar.drownOutCar();

        Sportcar first = new Sportcar();
        Sportcar second = new Sportcar();
        first.getName();
        second.getName();
        Sportcar.race(first, second, 500);
    }
}