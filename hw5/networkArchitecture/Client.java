package networkArchitecture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private DataInputStream dataInputStream;
    private DataOutputStream dataOutputStream;
    private Socket socket;

    public Client(String host, int port) {
        Scanner scanner = new Scanner(System.in);
        try {
            socket = new Socket(host, port);
            System.out.println("Подключение к серверу...");
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true) {
                System.out.println("Введите данные: ");
                String request = scanner.nextLine();
                sendData(request);
                if (request.equals("end")) {
                    scanner.close();
                    closeClien();
                    break;
                }
                String response = getData();
                System.out.println(response);
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        try {
            return dataInputStream.readUTF();
        } catch (IOException e) {
            return e.getMessage();
        }
    }

    public void sendData(String data) {
        try {
            dataOutputStream.writeUTF(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void closeClien() {
        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}