public class Airplane implements Transportable {
    private String boardNumber;
    private int numberOfSeats;

    public Airplane(String boardNumber) {
        this.boardNumber = boardNumber;
        numberOfSeats = 400;
        System.out.println("Создан " + toString());
    }

    @Override
    public String toString() {
        return "Самолет с борт.номером " + boardNumber;
    }

    @Override
    public void getInfo() {
        System.out.println(toString() + " , пассажирских мест: " + numberOfSeats);
    }

}
