package networkArchitecture;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import computingModels.Computable;
import computingModels.Model;

public class Server {
    private DataOutputStream dataOutputStream;
    private DataInputStream dataInputStream;
    private Socket socket;
    private Computable computableModel = new Model();

    public Server(int port) {
        try (ServerSocket serverSocket = new ServerSocket(port);) {
            System.out.println("Сервер начал работу. Ожидает клиента...");
            socket = serverSocket.accept();
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            System.out.println("Клиент подключен");
            while (true) {
                String request = getData();
                System.out.println("Получен запрос от клиента, происходит обработка...");
                String result = computableModel.compute(request);
                System.out.println("Ответ получен и отправлен клиенту");
                if (request.equals("end")) {
                    closeServer();
                    break;
                }
                sendData("Ответ: " + result);
            }
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

    private void closeServer() {
        try {
            dataOutputStream.close();
            dataInputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}