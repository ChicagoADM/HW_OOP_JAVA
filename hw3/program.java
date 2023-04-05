import java.util.ArrayList;
import java.util.List;

public class program {
    public static void main(String[] args) {
        List<Transportable> listTransport = new ArrayList<>();
        Transportable automobile = new Automobile("М001УР");
        Transportable car = new Car("Х002МТ");
        Transportable autotrack = new Autotruck("Р003ВМ", 20);
        Transportable airplane = new Airplane("LA2853");

        listTransport.add(automobile);
        listTransport.add(car);
        listTransport.add(autotrack);
        listTransport.add(airplane);

        for (Transportable transportable : listTransport) {
            transportable.getInfo();
        }
    }
}
