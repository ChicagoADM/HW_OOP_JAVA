import java.io.IOException;
import java.util.Scanner;

public class UserInterfaceView {
    private Controller controller = new Controller();

    public void runInterface() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введите 1 для получения погоды на сегодня; " +
                    "Введите 5 для прогноза на 5 дней; Для выхода введите 0:");
            String command = scanner.nextLine();
            if (command.equals("0")) {
                scanner.close();
                break;
            }

            System.out.println("Введите название города: ");
            String city = scanner.nextLine();

            try {
                controller.getWeather(command, city);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
