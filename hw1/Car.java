public class Car {
    private String model;
    private int year;
    private double price;
    private String color;
    private double power;
    private boolean status;

    Car(String model, int year, double price, String color, double power) {
        this.model = model;
        this.year = year;
        this.price = price;
        this.color = color;
        this.power = power;
        status = false;
    }

    public void getInfo() {
        System.out
                .println("Модель: " + model + ", год выпуска: " + year + ", цена: " + price + ", цвет: " + color
                        + ", объем двигателя: " + power);
    }

    public void startCar() {
        status = true;
        System.out.println("Автомобиль заведен");
    }

    public void drownOutCar() {
        status = false;
        System.out.println("Автомобиль заглушен");
    }

    public void road(String address) {
        if (status) {
            System.out.println("На машине " + model + " мы едеме по адресу: " + address);
        } else {
            System.out.println("Мне не можем поехать так как автомобиль не заведен");
        }
    }

}
